package com.example.shi.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {
    Button btn;
    String str;
    String s;
    boolean flag = false;
    //    private TabHost host;
    PhoneNumberAddressAndAgent zs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                EditText edit =(EditText) findViewById(R.id.et);
                str = edit.getText().toString();
                    flag = false;
                new Thread(){
                    @Override
                    public void run()
                    {
                        try {
                            zs = new PhoneNumberAddressAndAgent(str);
                            s =zs.getAddress()+":"+zs.getAgent();
                        } catch (IOException e) {
                            s="世上最遥远的距离就是没网。";
                        }
                        flag = true;
                    }
                }.start();
                    while(!flag){}
                    if(s.equals(null+":"+null)){
                        s = "您输入的号码有误，请重新输入！";
                    }
                    Toast toast=Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT);
                toast.show();
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
