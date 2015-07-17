package com.example.shi.musicplayer;
import android.media.MediaPlayer;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Shi on 2015/7/13.
 */

public class PlayMusic{

    MediaPlayer mediaPlayer =new MediaPlayer();
    int startNew(String path,int i){
        if(i==0){
            i=start(path,i);
        }else if(i==1||i==2){
            mediaPlayer.reset();
            i=0;
            i=start(path,i);
        }
        return i;
    }

    int start( String path,int i){
        if(i==0){
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            i=1;
        }
        else if(i==1){
            mediaPlayer.pause();
            i=2;
        }
        else if(i==2){
            mediaPlayer.start();
            i=1;
        }
        return i;
    }

    int nextMusic(ArrayList<String> arr ,int i,int j){
        String path;
        if(i==arr.size()-1){
            i=0;
            path =arr.get(i);
        }else
            path = arr.get(++i);
        return(startNew(path,j));
    }
    public ArrayList<String> findTxtFileCount(File allList, String endName) {
        ArrayList<String> arr =new ArrayList<String>();
        File[] fileArray = allList.listFiles();

        if (null == fileArray) {
            return arr;
        }
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].isDirectory()) {
                arr.addAll(findTxtFileCount(fileArray[i].getAbsoluteFile(),
                        endName));
            } else if (fileArray[i].isFile()) {
                if (fileArray[i].getName().endsWith(endName)) {
                    arr.add(fileArray[i].getAbsolutePath());
                }
            }
        }
        return arr;
    }

    ArrayList<String> geDan(ArrayList<String> A){
        ArrayList<String> B=new ArrayList<String>();
          for(int i= 0 ;i<A.size();i++){
              String temp= A.get(i);
              int s = temp.lastIndexOf("/");
              int e = temp.lastIndexOf(".");
              temp=temp.substring(s+1,e);
              B.add(i,temp);
          }
        return B;
    }
}

