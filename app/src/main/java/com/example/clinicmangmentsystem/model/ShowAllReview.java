package com.example.clinicmangmentsystem.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowAllReview {

    private List<ReviewModel> reviews = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<ReviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
