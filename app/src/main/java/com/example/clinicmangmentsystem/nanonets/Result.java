package com.example.clinicmangmentsystem.nanonets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private String message;
    private String input;
    private List<Prediction> prediction = null;
    private Integer page;
    private String requestFileId;
    private String filepath;
    private String id;
    private Integer rotation;
    private String fileUrl;
    private String requestMetadata;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<Prediction> getPrediction() {
        return prediction;
    }

    public void setPrediction(List<Prediction> prediction) {
        this.prediction = prediction;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getRequestFileId() {
        return requestFileId;
    }

    public void setRequestFileId(String requestFileId) {
        this.requestFileId = requestFileId;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRotation() {
        return rotation;
    }

    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRequestMetadata() {
        return requestMetadata;
    }

    public void setRequestMetadata(String requestMetadata) {
        this.requestMetadata = requestMetadata;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
