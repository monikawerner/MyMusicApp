package com.example.android.mymusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_list);


        /**
         * Create a list of artists

*/
        final ArrayList<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("Imagine Dragons", R.drawable.thunder));
        artists.add(new Artist("Green Day", R.drawable.basket_case));
        artists.add(new Artist("Metallica", R.drawable.nothing_else_matters));
        artists.add(new Artist("Mozart", R.drawable.eine_kleine_nachtmusic));
        artists.add(new Artist("Chopin", R.drawable.funeral_march));
        artists.add(new Artist("Justin Timberlake", R.drawable.my_love));
        artists.add(new Artist("David Guetta", R.drawable.titanium));

                ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);

        final ListView artistListView = (ListView) findViewById(R.id.artist_list);
        artistListView.setAdapter(artistAdapter);

        }}

                /**
         artists.add(new Artist("Nicky Minaj", "Starships", R.drawable.starships, R.drawable.note));
         artists.add(new Artist("Flo Rida feat.Sia", "Wild ones", R.drawable.wild_ones, R.drawable.note));
         artists.add(new Artist("Pitbull feat. Ne-Yo", "Time of Our Lives", R.drawable.time_of_our_lives, R.drawable.note));
         artists.add(new Artist("The Wanted", "Glad You Came", R.drawable.glad_you_came, R.drawable.note));
         artists.add(new Artist("Eminem feat. Rihanna", " The Monster", R.drawable.the_monster, R.drawable.note));
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

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
*/