package com.example.music;


/**
 * {@link Amiwo} represents a musical composition.
 * It contains the name of the composer and his opus.
 */
public class Amiwo {

    // The name of composer.
    private String mNameOfComposer;

    // The Amiwo.
    private String mAmiwo;

    /**
     * Create a new Opus object.
     *
     * @param nameOfComposer is the name of composer (in English).
     * @param amiwo          is the name of amiwo.
     */
    public Amiwo(String nameOfComposer, String amiwo) {
        mNameOfComposer = nameOfComposer;
        mAmiwo = amiwo;
    }


    // Get the name of composer.
    public String getNameOfComposer() {
        return mNameOfComposer;
    }

    // Get the name of opus.
    public String getAmiwo() {
        return mAmiwo;
    }
}
