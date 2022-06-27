package com.example.clinicmangmentsystem.model;

import java.util.HashMap;
import java.util.Map;

public class ReviewModel {

    private String rate;
    private String content;
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

