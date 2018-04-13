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
     * Audio resource Id
     * */
    private int mAudioResourceId;

    /**
     * Create a new Song object.
     *
     * @param artistName      is the artist name
     * @param songTitle       is the title of the song
     * @param imageResourceId is the image representing the song
     * @param icon is the icon
     * @param audioResourceId is the audio representing the song
     */
    public Song(String artistName, String songTitle, int imageResourceId, int icon, int audioResourceId) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mImageResourceId = imageResourceId;
        mIcon = icon;
        mAudioResourceId = audioResourceId;
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

    /**
     * Get the icon.
     */
    public int getIcon() {
        return mIcon;
    }

    /**
     * Get the audio.
     */
    public int getAudioResourceId() {return mAudioResourceId; }
}
