package com.example.shi.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import java.io.IOException;
import java.util.ArrayList;


public class MusicService extends Service {
    boolean flag=false;
    int index=0;
    ArrayList<String> arr=null, name=null;
    MyBind myBind =new MyBind();
    final static int PLAY = 1;
    final static int PAUSE = 2;
    final static  int STOP = 3;
    int State = STOP;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        if(flag==false) {
            Bundle bundle = intent.getExtras();
            index = bundle.getInt("index");
            arr = bundle.getStringArrayList("arr");
            name = bundle.getStringArrayList("name");
        }
        flag=true;
        return myBind;
    }



    public class MyBind extends Binder{
        MainActivity mainAc = null;

        public void setMainAc(MainActivity mainAc) {
            this.mainAc = mainAc;
        }
        void startMusic(String path){
            start(path);
        }
        void playMusic(String path){play(path);};
        void nextMusic(ArrayList<String> arr,int i){next(arr, i);}
        void preMusic(ArrayList<String> arr,int i){pre(arr, i);}
        void playClickMusic(ArrayList<String> arr,int i){
            playClick(arr, i);
        }
        int  getServiceState(){return getState();}
        void getMusicIndex(int index){
            getIndex(index);
        }
        void getMusicArr(ArrayList<String> arr){
            getArr(arr);
        }
        void getMusicName(ArrayList<String> name){
            getName(arr);
        }
        int getTime(){return time();};
        int getCurrentTime(){return currentTime();}
        void setMusicPlay(int i){setPlay(i);}

    }



    MediaPlayer mPlayer =new MediaPlayer();
    public MediaPlayer getmPlayer() {
        return mPlayer;
    }
    public void start(String path){
        mPlayer.reset();
        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
        } catch (Exception e) {
            myBind.mainAc.btn3Click();
        }
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mPlayer.start();
            }
        });
        State=PLAY;
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                myBind.mainAc.btn3Click();
            }
        });

    }
    public void pause(){
        mPlayer.pause();
        State=PAUSE;
    }
    public void stop(){
        mPlayer.stop();
        State=STOP;
    }
    public void play(String path){
        if(State==PLAY){
            pause();
        }else if(State==PAUSE){
            mPlayer.start();
            State=PLAY;
        }else if(State==STOP)
            start(path);
    }
    public int time(){
        return mPlayer.getDuration();
    }
    public int currentTime(){
        return mPlayer.getCurrentPosition();
    }
    public void next(ArrayList<String> arr,int i){
        String path =arr.get((i+1)%arr.size());
        start(path);
    }
    public void pre(ArrayList<String> arr,int i){
        String path =arr.get((i-1+arr.size())%arr.size());
        start(path);
    }
    public void playClick(ArrayList<String> arr,int i){
        String path =arr.get(i);
        start(path);
    }
    public int getState(){
        return State;
    }
    public void setPlay(int i){mPlayer.seekTo(i);}


    void getIndex(int index){
        this.index=index;
    }
    void getArr(ArrayList<String> arr){
        this.arr=arr;
    }
    void getName(ArrayList<String> name){
        this.name=name;
    }

}
