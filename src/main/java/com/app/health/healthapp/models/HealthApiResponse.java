package com.app.health.healthapp.models;

import java.util.List;

public class HealthApiResponse {
    private boolean responseStatus;
    private String responseMessage;
    private String username;
    private List<String> patientData;

    public HealthApiResponse() {
        super();
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPatientData() {
        return patientData;
    }

    public void setPatientData(List<String> patientData) {
        this.patientData = patientData;
    }
}