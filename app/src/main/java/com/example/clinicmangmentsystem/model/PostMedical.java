package com.example.clinicmangmentsystem.model;

public class PostMedical {
    int patient_id;
    String height;
    String weight;
    String bloodType;
    String relationshipState;
    String diseases;
    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRelationshipState() {
        return relationshipState;
    }

    public void setRelationshipState(String relationshipState) {
        this.relationshipState = relationshipState;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
}
