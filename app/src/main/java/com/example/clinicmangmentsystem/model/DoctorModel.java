package com.example.clinicmangmentsystem.model;

public class DoctorModel {
    String Specalityname;
    int Specalityicon;
    String Doctorname;
    String location;
    String price;
    int Doctorimage;
    String  waitingtime;
    String timeclinic;
    int rating;

    public DoctorModel(String specalityname, int specalityicon, String doctorname, String location, String price, int doctorimage, String waitingtime, String timeclinic, int rating) {
        Specalityname = specalityname;
        Specalityicon = specalityicon;
        Doctorname = doctorname;
        this.location = location;
        this.price = price;
        Doctorimage = doctorimage;
        this.waitingtime = waitingtime;
        this.timeclinic = timeclinic;
        this.rating = rating;
    }

    public String getSpecalityname() {
        return Specalityname;
    }

    public void setSpecalityname(String specalityname) {
        Specalityname = specalityname;
    }

    public int getSpecalityicon() {
        return Specalityicon;
    }

    public void setSpecalityicon(int specalityicon) {
        Specalityicon = specalityicon;
    }

    public String getDoctorname() {
        return Doctorname;
    }

    public void setDoctorname(String doctorname) {
        Doctorname = doctorname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDoctorimage() {
        return Doctorimage;
    }

    public void setDoctorimage(int doctorimage) {
        Doctorimage = doctorimage;
    }

    public String getWaitingtime() {
        return waitingtime;
    }

    public void setWaitingtime(String waitingtime) {
        this.waitingtime = waitingtime;
    }

    public String getTimeclinic() {
        return timeclinic;
    }

    public void setTimeclinic(String timeclinic) {
        this.timeclinic = timeclinic;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
