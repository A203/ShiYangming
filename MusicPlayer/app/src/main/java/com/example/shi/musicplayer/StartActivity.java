package com.example.shi.musicplayer;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shi on 2015/7/13.
 */public class StartActivity extends Activity {
    ArrayList<String> arr=null,name=null,singer=null,titlelist=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                Bundle bundle =new Bundle();

                bundle.putStringArrayList("arr",arr);
                bundle.putStringArrayList("titlelist",titlelist);
                bundle.putStringArrayList("siner",singer);
                intent.putExtras(bundle);
                startActivity(intent);
                StartActivity.this.finish();
            }

        }, 1500);

    }
}
