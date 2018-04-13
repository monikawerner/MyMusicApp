package com.example.android.mymusicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);



        /**
         * Create a list of songs
         */

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Imagine Dragons", "Thunder", R.drawable.thunder, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Green Day", "Basket Case", R.drawable.basket_case, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Luis Fonsi feat. Daddy Yankee", "Despacito", R.drawable.despacito, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Metallica", "Nothing Else Matters", R.drawable.nothing_else_matters, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Mozart", "Eine Kleine Nachtmusik", R.drawable.eine_kleine_nachtmusic, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Chopin", "Funeral March", R.drawable.funeral_march, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Justin Timberlake", "My love", R.drawable.my_love, R.drawable.note, R.raw.thunder));
        songs.add(new Song("David Guetta feat. Sia", "Titanium", R.drawable.titanium, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Nicky Minaj", "Starships", R.drawable.starships, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Flo Rida feat.Sia", "Wild ones", R.drawable.wild_ones, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Pitbull feat. Ne-Yo", "Time of Our Lives", R.drawable.time_of_our_lives, R.drawable.note, R.raw.thunder));
        songs.add(new Song("The Wanted", "Glad You Came", R.drawable.glad_you_came, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Eminem feat. Rihanna", " The Monster", R.drawable.the_monster, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Maroon 5", "Maps", R.drawable.maps, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Taylor Swift", "I Knew You Were Trouble", R.drawable.knew_you_were_trouble, R.drawable.note, R.raw.thunder));
        songs.add(new Song("One Republic", "Counting Stars", R.drawable.counting_stars, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Kesha", "TiK ToK", R.drawable.tik_tok, R.drawable.note, R.raw.thunder));
        songs.add(new Song("AC DC", "Thunderstruck", R.drawable.thunderstruck, R.drawable.note, R.raw.thunder));
        songs.add(new Song("The Clash", "Should I stay or should I go", R.drawable.should_istay_or_should_igo, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Nirvana", "Smells Like Teen Spirit", R.drawable.smells_like_teen_spirit, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Oasis", "Wonderwall", R.drawable.wonderwall, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Iggy Pop", "The Passenger", R.drawable.the_passenger, R.drawable.note, R.raw.thunder));
        songs.add(new Song("The Cranberries", "Zombie", R.drawable.zombie, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Metallica", "Whiskey in the Jar", R.drawable.whiskey_in_the_jar, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Queen", "We Will Rock You", R.drawable.we_will_rock_you, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Sade", "No Ordinary Love", R.drawable.no_ordinary_love, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Bruno Mars", "Treasure", R.drawable.treasure, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Alicia Keys feat. Usher", "If I Ain't Got You", R.drawable.if_iaint_got_you, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Craig David", "7 Days", R.drawable.seven_days, R.drawable.note, R.raw.thunder));
        songs.add(new Song("Erykah Badu", "Phone Down", R.drawable.phone_down, R.drawable.note, R.raw.thunder));

        SongAdapter adapter = new SongAdapter(this, songs);

        final ListView songListView = (ListView) findViewById(R.id.list);
        songListView.setAdapter(adapter);


        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Song song = songs.get(position);
                mMediaPlayer = MediaPlayer.create(LibraryActivity.this, song.getAudioResourceId());
                // Start the audio file
                mMediaPlayer.start();
                // Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                Intent playerIntent = new Intent(LibraryActivity.this, NowPlayingActivity.class);
                String songTitle = songs.get(position).getSongTitle();
                String artistName = songs.get(position).getArtistName();
                int songImage = songs.get(position).getImageResourceId();
                int songAudio = songs.get(position).getAudioResourceId();
                playerIntent.putExtra("CLICKED_ITEM_SONG", songTitle);
                playerIntent.putExtra("CLICKED_ITEM_ARTIST", artistName);
                playerIntent.putExtra("CLICKED_ITEM_IMAGE", songImage);
                playerIntent.putExtra("CLICKED_ITEM_AUDIO", songAudio);
                startActivity(playerIntent);

            }
        });


    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
