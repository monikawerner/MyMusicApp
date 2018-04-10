package com.example.android.mymusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistDescriptionActivity extends AppCompatActivity {

    String descriptionArtistName;
    int descriptionArtistImage;
    int descriptionArtistDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_description);

        descriptionArtistName = getIntent().getStringExtra("CLICKED_ARTIST_NAME");
        descriptionArtistImage = getIntent().getIntExtra("CLICKED_ARTIST_IMAGE", R.drawable.imagine_dragons);
        descriptionArtistDescription = getIntent().getIntExtra("CLICKED_ARTIST_DESCRIPTION", R.string.imagine_dragons);

        TextView artistNameDescription = (TextView) findViewById(R.id.artist_name_description);
        artistNameDescription.setText(descriptionArtistName);
        ImageView artistPhoto = (ImageView) findViewById(R.id.artist_photo);
        artistPhoto.setImageResource(descriptionArtistImage);
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(descriptionArtistDescription);

        /**
         * find the View that shows library and set a click listener on it
         */
        TextView library = (TextView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(ArtistDescriptionActivity.this, LibraryActivity.class);
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
                Intent artistsIntent = new Intent(ArtistDescriptionActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        /**
         * find the View that shows play the music and set a click listener on it
         */
        TextView playTheMusic = (TextView) findViewById(R.id.play_the_music);
        playTheMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playTheMusicIntent = new Intent(ArtistDescriptionActivity.this, NowPlayingActivity.class);
                startActivity(playTheMusicIntent);
            }
        });
    }
}