package com.example.clinicmangmentsystem.model;

public class DoctorModel {
    String email;
    String name;
    String adress;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorModel(int id) {
        this.id = id;
    }

    public DoctorModel(String email, String name, String adress) {
        this.email = email;
        this.name = name;
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
