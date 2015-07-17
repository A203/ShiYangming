package com.example.shi.musicplayer;
import android.app.TabActivity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.view.View.OnClickListener;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends TabActivity {
    public static MainActivity ma;
    static boolean flag =false;
    Intent intent;
    static int index;
    private TabHost host;
    private static  Button button1, button2, button3,button4;
    final static int PLAY = 1;
    final static int PAUSE = 2;
    final static int STOP = 3;
    static int State = STOP;
    static ListView listView;
    static ArrayList<String> arr=null, name=null;
    MusicService.MyBind bind;
    PlayMusic playMusic =new PlayMusic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBind();
        host = getTabHost();
        TabHost.TabSpec s1 = host.newTabSpec("one");
        s1.setIndicator("默认列表");
        s1.setContent(R.id.lv1);
        host.addTab(s1);
        TabHost.TabSpec s2 = host.newTabSpec("two");
        s2.setIndicator("我的歌单");
        s2.setContent(R.id.lv2);
        host.addTab(s2);
        for(int i=0;i<getTabWidget().getChildCount();i++){
            TextView tv = (TextView)getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextSize(20);
            tv.setTextColor(Color.rgb(255, 255, 255));

        }


        listView = (ListView) findViewById(R.id.lv1);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        getList();
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Click();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2Click();
            }

        });
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3Click();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listViewClick(position);
            }
        });
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4Click();
            }
        });
        ma=this;

    }

    public void myBind() {
        intent =new Intent();
        intent.setClass(this,MusicService.class);
        Bundle bundle =new Bundle();
        bundle.putInt("index",index);
        bundle.putStringArrayList("arr", arr);
        bundle.putStringArrayList("name",name);
        intent.putExtras(bundle);
        startService(intent);
        bindService(intent, sc, BIND_AUTO_CREATE);
    }

    private ServiceConnection sc =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //System.out.println("Connected");
            bind=(MusicService.MyBind)service;
            bind.setMainAc(MainActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            //System.out.println("Disconnected");
        }

    };

    void playButton(String path){bind.playMusic(path);}
    void nextButton(ArrayList<String> arr,int i){bind.nextMusic(arr, i);}
    void preButton(ArrayList<String> arr,int i){bind.preMusic(arr, i);}
    void playClick(ArrayList<String> arr,int i){bind.playClickMusic(arr, i);}
    void setState() {
        State  = bind.getServiceState();    }
    int[] getCurrent(){
        int[] time =new int[2];
        int t = bind.getCurrentTime();
        time[0]=t/60000;
        time[1]=(t-time[0]*60000)/1000;
        return time;
    }
    int[] getTime(){
        int[] time =new int[2];
        int t = bind.getTime();
        time[0]=t/60000;
        time[1]=(t-time[0]*60000)/1000;
        return time;
    }

    void setBackground(){
        if(State==PLAY)
            button1.setBackgroundResource(R.drawable.pause);
        else if(State==PAUSE||State==STOP)
            button1.setBackgroundResource(R.drawable.play);
    }
    void btn1Click(){
        if (listView.getCount() != 0) {
            button4.setText(name.get(index));
            playButton(arr.get(index));
            setState();
            setBackground();
        } else
            Toast.makeText(MainActivity.this, "当前列表无音乐", Toast.LENGTH_SHORT).show();
    }
    void btn2Click(){
        new Thread() {
            public void run() {
                String path = "/sdcard";
                File war = new File(path);
                arr = playMusic.findTxtFileCount(war, "mp3");
                name = playMusic.getGeDan(arr);
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name));
                        Toast.makeText(MainActivity.this, "列表已更新", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();
    }
    void btn3Click(){
        if (listView.getCount() != 0) {
            button4.setText(name.get((index + 1) % listView.getCount()));
            nextButton(arr, index);
            index = (index+1)%name.size();
            setState();
            setBackground();
        } else {
            Toast.makeText(MainActivity.this, "当前列表无音乐", Toast.LENGTH_SHORT).show();
        }
    }
    void btn4Click(){
        intent = new Intent(MainActivity.this,OtherActivity.class);
        if(!button4.getText().equals("播放音乐")) {
            if(button4.getText().equals(name.get(0))&&!flag){
                bind.startMusic(arr.get(index));
                setState();
                setBackground();
                flag =true;
            }
            startActivity(intent);
        }



    }
    void btn6Click(){
        if (listView.getCount() != 0) {
            button4.setText(name.get((index - 1 + listView.getCount()) % listView.getCount()));
            preButton(arr, index);
            index= (index+arr.size()-1)%arr.size();
            setState();
            setBackground();
        } else {
            Toast.makeText(MainActivity.this, "当前列表无音乐", Toast.LENGTH_SHORT).show();
        }
    }
    void listViewClick(int position){
        intent = new Intent(MainActivity.this,OtherActivity.class);
        Bundle bundle =new Bundle();
        bundle.putInt("index",index);
        bundle.putStringArrayList("arr",arr);
        bundle.putInt("State",PLAY);
        intent.putExtras(bundle);
        startActivity(intent);
        button4.setText(name.get(position));
        playClick(arr, position);
        setState();
        index = position;
        setBackground();
    }
    void getList(){
        new Thread() {
            public void run() {
            String path = "/sdcard";
            File war = new File(path);
            if(arr==null) {
                arr = playMusic.findTxtFileCount(war, "mp3");
                name = playMusic.getGeDan(arr);
            }

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if(name.size()!=0) {
                        button4.setText(name.get(index));
                        setState();
                        setBackground();
                    }
                    listView = (ListView) findViewById(R.id.lv1);
                    listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name));
                }
            });
        }
    }.start();
    }

    @Override
    protected void onDestroy() {
        bind.getMusicArr(arr);
        bind.getMusicIndex(index);
        bind.getMusicName(name);
        unbindService(sc);
        super.onDestroy();
    }

}






