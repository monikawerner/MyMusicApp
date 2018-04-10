package com.example.android.mymusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        artists.add(new Artist("Imagine Dragons", R.drawable.imagine_dragons, R.string.imagine_dragons));
        artists.add(new Artist("Green Day", R.drawable.green_day, R.string.green_day));
        artists.add(new Artist("Metallica", R.drawable.metallica, R.string.metallica));
        artists.add(new Artist("Mozart", R.drawable.eine_kleine_nachtmusic, R.string.mozart));
        artists.add(new Artist("Chopin", R.drawable.funeral_march, R.string.chopin));
        artists.add(new Artist("Justin Timberlake", R.drawable.justin_timberlake, R.string.justin_timberlake));
        artists.add(new Artist("Eminem", R.drawable.eminem, R.string.eminem));
        artists.add(new Artist("Maroon 5", R.drawable.maroon_five, R.string.maroon_five));
        artists.add(new Artist("Taylor Swift", R.drawable.taylor_swift, R.string.taylor_swift));
        artists.add(new Artist("One Republic", R.drawable.one_republic, R.string.one_republic));
        artists.add(new Artist("AC/DC", R.drawable.acdc, R.string.acdc));
        artists.add(new Artist("The Clash", R.drawable.the_clash, R.string.the_clash));
        artists.add(new Artist("Nirvana", R.drawable.nirvana, R.string.nirvana));
        artists.add(new Artist("Oasis", R.drawable.oasis, R.string.oasis));


        ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);

        final ListView artistListView = (ListView) findViewById(R.id.artist_list);
        artistListView.setAdapter(artistAdapter);
        artistListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent descriptionIntent = new Intent(ArtistsActivity.this, ArtistDescriptionActivity.class);
                String artistName = artists.get(position).getArtistName();
                int artistImage = artists.get(position).getImageResourceId();
                int artistDescription = artists.get(position).getArtistDescription();
                descriptionIntent.putExtra("CLICKED_ARTIST_NAME", artistName);
                descriptionIntent.putExtra("CLICKED_ARTIST_IMAGE", artistImage);
                descriptionIntent.putExtra("CLICKED_ARTIST_DESCRIPTION", artistDescription);
                startActivity(descriptionIntent);
            }
        });
    }
}


