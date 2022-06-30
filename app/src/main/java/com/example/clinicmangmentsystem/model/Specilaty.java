package com.example.clinicmangmentsystem.model;

import android.widget.ImageView;

public class Specilaty {
    int imageView;
    String SpecialtyName;

    public Specilaty(int imageView, String specialtyName) {
        this.imageView = imageView;
        SpecialtyName = specialtyName;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getSpecialtyName() {
        return SpecialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        SpecialtyName = specialtyName;
    }
}
