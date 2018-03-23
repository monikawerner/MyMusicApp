package com.example.android.mymusicapp;


public class Song {

    /** Artist name */
    private String mArtistName;

    /** Song title */
    private String mSongTitle;

    /**
     * Create a new Song object.
     *
     * @param artistName is the artist name
     * @param songTitle is the title of the song
     */
    public Song(String artistName, String songTitle) {
        mArtistName = artistName;
        mSongTitle = songTitle;
    }

    /**
     * Get the artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the song title.
     */
    public String getSongTitle() {
        return mSongTitle;
    }
}
