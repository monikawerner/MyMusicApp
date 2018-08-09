package com.example.android.mymusicapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    String songPlaying;
    String artistPlaying;
    int imagePlaying;
    int audioPlaying;

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
        setContentView(R.layout.activity_now_playing);

        mediaPlayer = MediaPlayer.create(this, R.raw.thunder);
        ImageView play = (ImageView) findViewById(R.id.play);
        ImageView pause = (ImageView) findViewById(R.id.pause);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();

            }
        });


        /**
         * get data from LibraryActivity and display them
         */

        songPlaying = getIntent().getStringExtra("CLICKED_ITEM_SONG");
        artistPlaying = getIntent().getStringExtra("CLICKED_ITEM_ARTIST");
        imagePlaying = getIntent().getIntExtra("CLICKED_ITEM_IMAGE", R.drawable.thunder);
        audioPlaying = getIntent().getIntExtra("CLICKED_ITEM_AUDIO", R.raw.thunder);

        TextView nowPlayingSong = findViewById(R.id.now_playing_song);
        nowPlayingSong.setText(songPlaying);
        TextView nowPlayingArtist = findViewById(R.id.now_playing_artist);
        nowPlayingArtist.setText(artistPlaying);
        ImageView nowPlayingImage = findViewById(R.id.now_playing_image);
        nowPlayingImage.setImageResource(imagePlaying);




        /**
         * find the View that shows library and set a click listener on it
         */
        TextView library = findViewById(R.id.library);
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

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
