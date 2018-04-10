package com.example.android.mymusicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    /**
     * @param context The current context. Used to inflate the layout file.
     * @param artists A List of artist objects to display in a list
     */
    public ArtistAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    /**
     * Provides a view for an AdapterView
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * Check if the existing view is being reused, otherwise inflate the view
         */
        View artistListItemView = convertView;
        if (artistListItemView == null) {
            artistListItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_list_item, parent, false);
        }

        /**
         * Get the object located at this position in the list
         */
        Artist currentArtist = getItem(position);

        /**
         * Find the TextView in the artist_list_item.xml layout
         */
        TextView artistName = (TextView) artistListItemView.findViewById(R.id.artist_name);

        /**
         * Get the artist name from the current Artist object and set this text on the artist_name TextView
         */
        artistName.setText(currentArtist.getArtistName());


        /**
         * Find the ImageView in the artist_list_item.xml layout
         */
        ImageView artistImage = (ImageView) artistListItemView.findViewById(R.id.artist_image);

        /**
         * Get the image resource Id from the current Artist object and set this image on the ImageView
         */

        artistImage.setImageResource(currentArtist.getImageResourceId());

        /**
         * Find the TextView in the artist_list_item.xml layout
         */
        TextView artistDescription = (TextView) artistListItemView.findViewById(R.id.description);

        /**
         * Get the artist description from the current Artist object and set this text on the description TextView
         */
        artistDescription.setText(currentArtist.getArtistDescription());

        return artistListItemView;
    }

}


