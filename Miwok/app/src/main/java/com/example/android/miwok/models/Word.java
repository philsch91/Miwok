package com.example.android.miwok.models;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by A4938 on 12.04.2018.
 */

public class Word extends Object {

    private String miwok="";
    private String english="";
    //private Image image=null;
    //private Bitmap bitmap=null;
    private int imagePath=0;
    public int color=0;

    public Word(){}

    public Word(String miwok, String english){
        this.setMiwok(miwok);
        this.setEnglish(english);
    }


    public String getMiwok() {
        return miwok;
    }

    public void setMiwok(String miwok) {
        this.miwok = miwok;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    /*
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    */

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }
}
