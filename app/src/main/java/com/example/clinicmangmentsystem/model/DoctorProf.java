package com.example.clinicmangmentsystem.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorProf {
    private DoctorProd doctor;
    private List<Doctortime> doctorTime = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DoctorProd getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorProd doctor) {
        this.doctor = doctor;
    }

    public List<Doctortime> getDoctorTime() {
        return doctorTime;
    }

    public void setDoctorTime(List<Doctortime> doctorTime) {
        this.doctorTime = doctorTime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
