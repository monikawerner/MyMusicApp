package com.example.android.mymusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        /**
         * Create a list of songs
         */

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Imagine Dragons", "Thunder"));
        songs.add(new Song("Green Day", "Basket Case"));
        songs.add(new Song("Luis Fonsi feat. Daddy Yankee", "Despacito"));
        songs.add(new Song("Metallica", "Nothing Else Matters"));
        songs.add(new Song("Mozart", "Eine Kleine Nachtmusik"));
        songs.add(new Song("Chopin", "Funeral Marches"));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


    }
}
