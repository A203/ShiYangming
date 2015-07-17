package com.example.shi.myapplication;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends TabActivity {
    Button btn;
    private TabHost host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        host =getTabHost();
        TabHost.TabSpec s1 = host.newTabSpec("one");
        s1.setIndicator("s1");
        s1.setContent(R.id.tv1);
        host.addTab(s1);

        TabHost.TabSpec s2 = host.newTabSpec("two");
        s2.setIndicator("s2");
        s2.setContent(R.id.tv2);
        host.addTab(s2);
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
