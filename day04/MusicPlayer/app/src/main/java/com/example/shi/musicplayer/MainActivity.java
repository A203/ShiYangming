package com.example.shi.musicplayer;
import android.app.TabActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.view.View.OnClickListener;
import android.widget.TextView;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends TabActivity {
    private TabHost host;
    private Button button1, button2,button3;
    private static int ZT = 0,temp=0,aa;
    PlayMusic playMusic = new PlayMusic();
    ListView listView;
    TextView  textView;
    static ArrayList<String> arr, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        host=getTabHost();
        TabHost.TabSpec s1 = host.newTabSpec("one");
        s1.setIndicator("默认列表");
        s1.setContent(R.id.lv1);
        host.addTab(s1);

        TabHost.TabSpec s2 = host.newTabSpec("two");
        s2.setIndicator("我的歌单");
        s2.setContent(R.id.tv2);
        host.addTab(s2);

        listView = (ListView) findViewById(R.id.lv1);
        listView.setOnItemClickListener(new ItemClickListener());
        textView=(TextView)findViewById(R.id.tv1);

        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button1.setOnClickListener(new StartButtonListener());
        button2.setOnClickListener(new SeekButtonListener());
        button3.setOnClickListener(new NextButtonListener());

        playMusic.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ZT = playMusic.nextMusic(arr, temp, ZT);
                temp++;
            }
        });

    }
    class NextButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            handler.post(next);
        }
    }
    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            aa=position;
            handler.post(itemClick);
        }
    }
    Runnable next =new Runnable(){
        @Override
        public void run() {
            button1.setBackgroundResource(R.drawable.pause);
            if(temp==name.size()-1)
                textView.setText(name.get(0));
            else
                textView.setText(name.get(temp+1));
            ZT=playMusic.nextMusic(arr,temp++,ZT);

        }
    };
    Runnable itemClick=new Runnable() {
        public void run() {
            temp=aa;
            textView.setText(name.get(temp));
            button1.setBackgroundResource(R.drawable.pause);
            ZT = playMusic.startNew(arr.get(temp), ZT);

        }
    };

    class StartButtonListener implements  OnClickListener{
        @Override
        public void onClick(View v) {
            handler.post(start);
        }
    }
    class SeekButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            handler.post(seek);
        }
    }

    Handler handler = new Handler();

    Runnable start =new Runnable() {
        @Override
        public void run() {
            textView.setText(name.get(temp));
            ZT = playMusic.start(arr.get(temp), ZT);

            if(ZT==0||ZT==2){
                button1.setBackgroundResource(R.drawable.play);
                System.out.println(ZT);
            }
            else if(ZT==1){
                button1.setBackgroundResource(R.drawable.pause);
                System.out.println(ZT);
            }
        }
    };

    Runnable seek = new Runnable() {
        @Override
        public void run() {
            String path = "/sdcard";
            File war = new File(path);
            arr = playMusic.findTxtFileCount(war, "mp3");
            name=playMusic.geDan(arr);
            listView = (ListView) findViewById(R.id.lv1);
            listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name));
        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
