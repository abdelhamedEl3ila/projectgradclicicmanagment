package com.example.clinicmangmentsystem.model;

public class Schdulepat {
    String NameDoctor;
    int imageView ;
    String Specialties;
    String Reservation;

    public Schdulepat(String nameDoctor, int imageView, String specialties, String reservation) {
        NameDoctor = nameDoctor;
        this.imageView = imageView;
        Specialties = specialties;
        Reservation = reservation;
    }

    public String getNameDoctor() {
        return NameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        NameDoctor = nameDoctor;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getSpecialties() {
        return Specialties;
    }

    public void setSpecialties(String specialties) {
        Specialties = specialties;
    }

    public String getReservation() {
        return Reservation;
    }

    public void setReservation(String reservation) {
        Reservation = reservation;
    }
}
