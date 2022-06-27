package com.example.clinicmangmentsystem.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Showbooking {
    private List<Schdulepat> bookedAppointments ;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Schdulepat> getBookedAppointments() {
        return bookedAppointments;
    }

    public void setBookedAppointments(List<Schdulepat> bookedAppointments) {
        this.bookedAppointments = bookedAppointments;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
