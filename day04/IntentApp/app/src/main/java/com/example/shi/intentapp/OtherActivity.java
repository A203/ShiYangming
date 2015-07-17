package com.example.shi.intentapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Created by Shi on 2015/7/11.
 */
public class OtherActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent intent = getIntent();
        String name=intent.getStringExtra("name");
        Bundle bundle =intent.getExtras();
        int age = bundle.getInt("age",0);
        String sex =bundle.getString("sex");

        Toast.makeText(this,"name"+name+"age"+age+"sex"+sex,Toast.LENGTH_SHORT).show();



    }
}
