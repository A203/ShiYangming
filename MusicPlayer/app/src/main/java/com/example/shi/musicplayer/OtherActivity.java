package com.example.shi.musicplayer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Shi on 2015/7/15.
 */
public class OtherActivity extends Activity{
    int State = STOP;
    final static int PLAY = 1;
    final static int PAUSE = 2;
    final static int STOP = 3;
    String title = "歌名",singer="歌手";
    TextView textView1,textView2,textView3;
    Button button5,button6,button7,button8;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        textView1 = (TextView)findViewById(R.id.gm);
        textView2 = (TextView)findViewById(R.id.cur);
        textView3 = (TextView)findViewById(R.id.end);

        button5 = (Button)findViewById(R.id.btn5);
        button6 = (Button)findViewById(R.id.btn6);
        button7 = (Button)findViewById(R.id.btn7);
        button8 = (Button)findViewById(R.id.btn8);
        seekBar = (SeekBar)findViewById(R.id.sb);
        textView1.setText(title);
        qiDong();
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5Click();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn6Click();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn7Click();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn8Click();
            }
        });

    }
    Handler handler = new Handler();

    Runnable updateThread = new Runnable(){
        public void run() {
            seekBar.setProgress(MainActivity.ma.bind.getCurrentTime());
            setPlayTime();
            handler.postDelayed(updateThread, 1000);
        }
    };
    void setState() {State = MainActivity.ma.State;}
    void setBackground(){
        if(State==PLAY)
            button5.setBackgroundResource(R.drawable.pause);
        else if(State==PAUSE||State==STOP)
            button5.setBackgroundResource(R.drawable.play);
    }
    void btn5Click(){
        MainActivity.ma.btn1Click();
        setState();
        setBackground();
        setTime();
    }
    void btn6Click(){
        MainActivity.ma.btn6Click();
        setState();
        setBackground();
        setText();
        setTime();
    }
    void btn7Click(){
        MainActivity.ma.btn3Click();
        setState();
        setBackground();
        setText();
        setTime();
    }
    void btn8Click(){
        finish();
    }
    void setText(){
        if(MainActivity.ma.name!=null) {
            textView1.setText(MainActivity.ma.name.get(MainActivity.ma.index));
        }
    }
    void qiDong() {
        setState();
        setBackground();
        setText();
        setTime();
        handler.post(updateThread);
        seekBar.setMax(MainActivity.ma.bind.getTime());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser==true){
                    MainActivity.ma.bind.setMusicPlay(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    void setPlayTime(){
        int[] time = MainActivity.ma.getCurrent();
        textView2.setText((time[0] < 10 ? ("0" + time[0]) : time[0]) + ":" + (time[1] < 10 ? ("0" + time[1]) : time[1]));
    }
    void setTime(){
        int[] time = MainActivity.ma.getTime();
        textView3.setText((time[0]<10?("0"+time[0]):time[0]) + ":" + (time[1]<10?("0"+time[1]):time[1]));
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}

