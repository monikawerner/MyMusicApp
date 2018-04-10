package com.example.android.mymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    String songPlaying;
    String artistPlaying;
    int imagePlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        /**
         * get data from LibraryActivity and display them
         */

        songPlaying = getIntent().getStringExtra("CLICKED_ITEM_SONG");
        artistPlaying = getIntent().getStringExtra("CLICKED_ITEM_ARTIST");
        imagePlaying = getIntent().getIntExtra("CLICKED_ITEM_IMAGE", R.drawable.thunder);

        TextView nowPlayingSong = (TextView) findViewById(R.id.now_playing_song);
        nowPlayingSong.setText(songPlaying);
        TextView nowPlayingArtist = (TextView) findViewById(R.id.now_playing_artist);
        nowPlayingArtist.setText(artistPlaying);
        ImageView nowPlayingImage = (ImageView) findViewById(R.id.now_playing_image);
        nowPlayingImage.setImageResource(imagePlaying);

        /**
         * find the View that shows library and set a click listener on it
         */
        TextView library = (TextView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(NowPlayingActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });

        /**
         * find the View that shows library and set a click listener on it
         */
        TextView artists = (TextView) findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(NowPlayingActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

    }
}
