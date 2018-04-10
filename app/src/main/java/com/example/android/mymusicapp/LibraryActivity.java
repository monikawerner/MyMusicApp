package com.example.android.mymusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);


        /**
         * Create a list of songs
         */

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Imagine Dragons", "Thunder", R.drawable.thunder, R.drawable.note));
        songs.add(new Song("Green Day", "Basket Case", R.drawable.basket_case, R.drawable.note));
        songs.add(new Song("Luis Fonsi feat. Daddy Yankee", "Despacito", R.drawable.despacito, R.drawable.note));
        songs.add(new Song("Metallica", "Nothing Else Matters", R.drawable.nothing_else_matters, R.drawable.note));
        songs.add(new Song("Mozart", "Eine Kleine Nachtmusik", R.drawable.eine_kleine_nachtmusic, R.drawable.note));
        songs.add(new Song("Chopin", "Funeral March", R.drawable.funeral_march, R.drawable.note));
        songs.add(new Song("Justin Timberlake", "My love", R.drawable.my_love, R.drawable.note));
        songs.add(new Song("David Guetta feat. Sia", "Titanium", R.drawable.titanium, R.drawable.note));
        songs.add(new Song("Nicky Minaj", "Starships", R.drawable.starships, R.drawable.note));
        songs.add(new Song("Flo Rida feat.Sia", "Wild ones", R.drawable.wild_ones, R.drawable.note));
        songs.add(new Song("Pitbull feat. Ne-Yo", "Time of Our Lives", R.drawable.time_of_our_lives, R.drawable.note));
        songs.add(new Song("The Wanted", "Glad You Came", R.drawable.glad_you_came, R.drawable.note));
        songs.add(new Song("Eminem feat. Rihanna", " The Monster", R.drawable.the_monster, R.drawable.note));
        songs.add(new Song("Maroon 5", "Maps", R.drawable.maps, R.drawable.note));
        songs.add(new Song("Taylor Swift", "I Knew You Were Trouble", R.drawable.knew_you_were_trouble, R.drawable.note));
        songs.add(new Song("One Republic", "Counting Stars", R.drawable.counting_stars, R.drawable.note));
        songs.add(new Song("Kesha", "TiK ToK", R.drawable.tik_tok, R.drawable.note));
        songs.add(new Song("AC DC", "Thunderstruck", R.drawable.thunderstruck, R.drawable.note));
        songs.add(new Song("The Clash", "Should I stay or should I go", R.drawable.should_istay_or_should_igo, R.drawable.note));
        songs.add(new Song("Nirvana", "Smells Like Teen Spirit", R.drawable.smells_like_teen_spirit, R.drawable.note));
        songs.add(new Song("Oasis", "Wonderwall", R.drawable.wonderwall, R.drawable.note));
        songs.add(new Song("Iggy Pop", "The Passenger", R.drawable.the_passenger, R.drawable.note));
        songs.add(new Song("The Cranberries", "Zombie", R.drawable.zombie, R.drawable.note));
        songs.add(new Song("Metallica", "Whiskey in the Jar", R.drawable.whiskey_in_the_jar, R.drawable.note));
        songs.add(new Song("Queen", "We Will Rock You", R.drawable.we_will_rock_you, R.drawable.note));
        songs.add(new Song("Sade", "No Ordinary Love", R.drawable.no_ordinary_love, R.drawable.note));
        songs.add(new Song("Bruno Mars", "Treasure", R.drawable.treasure, R.drawable.note));
        songs.add(new Song("Alicia Keys feat. Usher", "If I Ain't Got You", R.drawable.if_iaint_got_you, R.drawable.note));
        songs.add(new Song("Craig David", "7 Days", R.drawable.seven_days, R.drawable.note));
        songs.add(new Song("Erykah Badu", "Phone Down", R.drawable.phone_down, R.drawable.note));

        SongAdapter adapter = new SongAdapter(this, songs);

        final ListView songListView = (ListView) findViewById(R.id.list);
        songListView.setAdapter(adapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent playerIntent = new Intent(LibraryActivity.this, NowPlayingActivity.class);
                String songTitle = songs.get(position).getSongTitle();
                String artistName = songs.get(position).getArtistName();
                int songImage = songs.get(position).getImageResourceId();
                playerIntent.putExtra("CLICKED_ITEM_SONG", songTitle);
                playerIntent.putExtra("CLICKED_ITEM_ARTIST", artistName);
                playerIntent.putExtra("CLICKED_ITEM_IMAGE", songImage);
                startActivity(playerIntent);

            }
        });


    }
}
