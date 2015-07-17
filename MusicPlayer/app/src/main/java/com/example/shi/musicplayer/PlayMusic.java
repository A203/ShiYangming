package com.example.shi.musicplayer;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.provider.MediaStore;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class PlayMusic{

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

    ArrayList<String> getGeDan(ArrayList<String> A){
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

