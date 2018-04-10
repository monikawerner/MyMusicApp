package com.example.android.mymusicapp;


public class Artist {

    /**
     * Artist name
     */
    private String mArtistName;

    /**
     * Photo
     */
    private int mImageResourceId;

    /**
     * Description
     */
    private int mArtistDescription;


    /**
     * Create a new Artist object.
     *
     * @param artistName        is the artist name
     * @param imageResourceId   is the photo representing the artist
     * @param artistDescription is description of artist
     */
    public Artist(String artistName, int imageResourceId, int artistDescription) {
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mArtistDescription = artistDescription;
    }

    /**
     * Get the artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the photo.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the artist description.
     */
    public int getArtistDescription() {
        return mArtistDescription;
    }

}
