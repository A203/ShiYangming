package com.example.shi.musicplayer;
import android.app.Activity;
import android.app.TabActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends TabActivity{
    private TabHost host;
    private Button button1,button2;
    private static int ZT = 0;
    PlayMusic playMusic =new PlayMusic();
    ListView listView;
    static ArrayList<String> arr,name;


    //0表示停止
    //1表示正在播放
    //2表示暂停
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        host = getTabHost();
        TabHost.TabSpec s1 = host.newTabSpec("one");
        s1.setIndicator("默认列表");
        s1.setContent(R.id.lv1);
        host.addTab(s1);


        TabHost.TabSpec s2 = host.newTabSpec("two");
        s2.setIndicator("我的歌单");

        s2.setContent(R.id.tv2);
        host.addTab(s2);

        TabHost.TabSpec s3 = host.newTabSpec("three");
        s3.setIndicator("在线音乐");
        s3.setContent(R.id.tv3);
        host.addTab(s3);

        String path = "/sdcard/";
        File war = new File(path);
        arr = playMusic.findTxtFileCount(war, "mp3");
        name=playMusic.geDan(arr);
         listView = (ListView) findViewById(R.id.lv1);



        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ZT=playMusic.startNew(arr.get(position),ZT);
            }
        });

        button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZT = playMusic.start(arr.get(1), ZT);
            }
        });


        button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = "/sdcard/";
                File war = new File(path);
                arr = playMusic.findTxtFileCount(war, "mp3");
                listView = (ListView) findViewById(R.id.lv1);
                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name));
            }
        });

    }




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
