package com.zeronone.android.udacityapp.models;

/**
 * Created by zeronone on 12/18/14.
 */
public class Instructor {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String bio;
    private String image;


}
