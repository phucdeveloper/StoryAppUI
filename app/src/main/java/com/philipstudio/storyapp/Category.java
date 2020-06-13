package com.philipstudio.storyapp;

import java.util.ArrayList;

public class Category {
    private String nameCategory;
    private ArrayList<Image> arrayList;
    private int type;

    public Category(String nameCategory, ArrayList<Image> arrayList, int type){
        this.nameCategory = nameCategory;
        this.arrayList = arrayList;
        this.type = type;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public ArrayList<Image> getArrayList() {
        return arrayList;
    }

    public int getType() {
        return type;
    }
}
