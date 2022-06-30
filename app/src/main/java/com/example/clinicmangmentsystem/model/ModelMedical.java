package com.example.clinicmangmentsystem.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelMedical {
    private Getmedical data ;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Getmedical getData() {
        return data;
    }

    public void setData(Getmedical data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
