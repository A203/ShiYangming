package com.example.shi.intentapp;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)(findViewById(R.id.btn));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent(MainActivity.this,OtherActivity.class);
                Intent intent =new Intent();
//                ComponentName componentName = new ComponentName(MainActivity.this,OtherActivity.class);
//                ComponentName componentName =new ComponentName(MainActivity.this,"com.example.shi.intentapp.OtherActivity");
                ComponentName componentName = new ComponentName("com.example.shi.intentapp",
                                                        "com.example.shi.intentapp.OtherActivity");
                intent.setComponent(componentName);

                intent.putExtra("name", "施炀明");

                Bundle bundle =new Bundle();
                bundle.putInt("age",20);
                bundle.putString("sex","男");
                intent.putExtras(bundle);

                startActivity(intent);


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
