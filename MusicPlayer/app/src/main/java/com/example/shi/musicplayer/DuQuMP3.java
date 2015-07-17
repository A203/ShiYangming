package com.example.shi.musicplayer;
import android.app.Service;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.View;

import java.util.ArrayList;

    public class DuQuMP3{
        static ArrayList<String> marr,mtitle,msinger;

        public ArrayList<String> getMarr() {
            return marr;
        }

        public ArrayList<String> getMtitle() {
            return mtitle;
        }

        public ArrayList<String> getMsinger() {
            return msinger;
        }

        void queryMusics(Context context) {
            ContentResolver cr = context.getContentResolver();
            Cursor musics = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    new String[]{
                            MediaStore.Audio.Media.TITLE,
                            MediaStore.Audio.Media.ARTIST,
                            MediaStore.Audio.Media.DATA,
                    },
                    MediaStore.Audio.Media.IS_MUSIC + " = 1 AND "
                            + MediaStore.Audio.Media.DURATION + " > 10000",
                    null,
                    MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
            musics.moveToFirst();
            while (!musics.isAfterLast()) {
                String title=musics.getString(musics.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String singer=musics.getString(musics.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String arr = musics.getString(musics.getColumnIndex(MediaStore.Audio.Media.DATA));
                marr.add(arr);
                msinger.add(singer);
                mtitle.add(title);
                musics.moveToNext();
            }
            musics.close();
        }



    }