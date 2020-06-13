package com.philipstudio.storyapp;

public class Image {
    private String name;
    private int image;

    public Image(String name, int image){
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
