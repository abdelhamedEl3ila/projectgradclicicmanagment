package com.example.clinicmangmentsystem.model;

public class FristAid {
    String fristaidtext;
    int imageview;

    public FristAid(String fristaidtext, int imageview) {
        this.fristaidtext = fristaidtext;
        this.imageview = imageview;
    }

    public String getFristaidtext() {
        return fristaidtext;
    }

    public void setFristaidtext(String fristaidtext) {
        this.fristaidtext = fristaidtext;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }
}
