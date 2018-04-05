package com.example.android.mymusicapp;


import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * @param context The current context. Used to inflate the layout file.
     * @param songs A List of song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
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
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        /**
         * Get the object located at this position in the list
         */
        Song currentSong = getItem(position);

        /**
         * Find the TextView in the list_item.xml layout
         */
        TextView song = (TextView) listItemView.findViewById(R.id.song);

        /**
         * Get the song title from the current Song object and set this text on the song TextView
         */
        song.setText(currentSong.getSongTitle());

        /**
         * Find the TextView in the list_item.xml layout
         */
        TextView artist = (TextView) listItemView.findViewById(R.id.artist);

        /**
         * Get the artist name from the current Song object and set this text on the artist TextView
         */
        artist.setText(currentSong.getArtistName());


        /**
         * Find the ImageView in the list_item.xml layout
         */
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.song_image);

        /**
         * Get the image resource Id from the current Song object and set this image on the ImageView
         */

        imageView.setImageResource(currentSong.getImageResourceId());


        /**
         * Find the ImageView in the list_item.xml layout
         */

        ImageView icon = (ImageView) listItemView.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.note);


        return listItemView;
    }

    }
