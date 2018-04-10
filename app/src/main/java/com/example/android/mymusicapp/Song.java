package com.example.android.mymusicapp;


public class Song {

    /**
     * Artist name
     */
    private String mArtistName;

    /**
     * Song title
     */
    private String mSongTitle;

    /**
     * Image
     */
    private int mImageResourceId;

    /**
     * Icon
     */
    private int mIcon;

    /**
     * Create a new Song object.
     *
     * @param artistName      is the artist name
     * @param songTitle       is the title of the song
     * @param imageResourceId is the image representing the song
     */
    public Song(String artistName, String songTitle, int imageResourceId, int icon) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mImageResourceId = imageResourceId;
        mIcon = icon;
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

    /**
     * Get the image.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getIcon() {
        return mIcon;
    }
}
