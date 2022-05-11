package com.example.clinicmangmentsystem.model;

public class Search {
    String namespecialty;
    int imagespecialty;


    public Search(String namespecialty, int imagespecialty) {
        this.namespecialty = namespecialty;
        this.imagespecialty = imagespecialty;
    }

    public String getNamespecialty() {
        return namespecialty;
    }

    public void setNamespecialty(String namespecialty) {
        this.namespecialty = namespecialty;
    }

    public int getImagespecialty() {
        return imagespecialty;
    }

    public void setImagespecialty(int imagespecialty) {
        this.imagespecialty = imagespecialty;
    }
}


