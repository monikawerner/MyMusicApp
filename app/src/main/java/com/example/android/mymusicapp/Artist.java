package com.example.android.mymusicapp;


public class Artist {

    /** Artist name */
    private String mArtistName;

    /** Photo */
    private int mPhotoResourceId;


    /**
     * Create a new Artist object.
     *
     * @param artistName is the artist name
     * @param photoResourceId is the photo representing the artist

     */
    public Artist(String artistName, int photoResourceId) {
        mArtistName = artistName;
        mPhotoResourceId = photoResourceId;
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
        public int getPhotoResourceId() {
            return mPhotoResourceId;
        }

    }
