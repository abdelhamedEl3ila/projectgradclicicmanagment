package com.example.clinicmangmentsystem.nanonets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prediction {
    private String id;
    private String label;
    private Integer xmin;
    private Integer ymin;
    private Integer xmax;
    private Integer ymax;
    private Integer score;
    private String ocrText;
    private String type;
    private List<Cell> cells = null;
    private String status;
    private Integer pageNo;
    private String labelId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getXmin() {
        return xmin;
    }

    public void setXmin(Integer xmin) {
        this.xmin = xmin;
    }

    public Integer getYmin() {
        return ymin;
    }

    public void setYmin(Integer ymin) {
        this.ymin = ymin;
    }

    public Integer getXmax() {
        return xmax;
    }

    public void setXmax(Integer xmax) {
        this.xmax = xmax;
    }

    public Integer getYmax() {
        return ymax;
    }

    public void setYmax(Integer ymax) {
        this.ymax = ymax;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getOcrText() {
        return ocrText;
    }

    public void setOcrText(String ocrText) {
        this.ocrText = ocrText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
