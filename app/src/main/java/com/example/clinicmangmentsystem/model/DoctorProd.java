package com.example.clinicmangmentsystem.model;

import java.util.HashMap;
import java.util.Map;

public class DoctorProd {

    private Integer id;
    private String name;
    private String email;
    private Object emailVerifiedAt;
    private String speciality;
    private String governorate;
    private String gender;
    private String mobileNumber;
    private String photo;
    private String chinicPhoto1;
    private String chinicPhoto2;
    private String chinicPhoto3;
    private String chinicBill1;
    private String chinicBill2;
    private String latitude;
    private String longitude;
    private String examinationPrice;
    private String waitTime;
    private Object about;
    private Object country;
    private Object year;
    private Object uni;
    private Object degree;
    private String createdAt;
    private String updatedAt;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    public Object getUni() {
        return uni;
    }

    public void setUni(Object uni) {
        this.uni = uni;
    }

    public Object getDegree() {
        return degree;
    }

    public void setDegree(Object degree) {
        this.degree = degree;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public String getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(String examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getChinicPhoto1() {
        return chinicPhoto1;
    }

    public void setChinicPhoto1(String chinicPhoto1) {
        this.chinicPhoto1 = chinicPhoto1;
    }

    public String getChinicPhoto2() {
        return chinicPhoto2;
    }

    public void setChinicPhoto2(String chinicPhoto2) {
        this.chinicPhoto2 = chinicPhoto2;
    }

    public String getChinicPhoto3() {
        return chinicPhoto3;
    }

    public void setChinicPhoto3(String chinicPhoto3) {
        this.chinicPhoto3 = chinicPhoto3;
    }

    public String getChinicBill1() {
        return chinicBill1;
    }

    public void setChinicBill1(String chinicBill1) {
        this.chinicBill1 = chinicBill1;
    }

    public String getChinicBill2() {
        return chinicBill2;
    }

    public void setChinicBill2(String chinicBill2) {
        this.chinicBill2 = chinicBill2;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
