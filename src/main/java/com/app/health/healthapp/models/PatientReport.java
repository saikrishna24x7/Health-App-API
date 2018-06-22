package com.app.health.healthapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patientreport")
public class PatientReport {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Column(name = "patient_id")
    private String patientID;

    @Column(name = "patient_data")
    private String patientData;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "image", columnDefinition = "longblob")
    private byte[] image;

    @Column(name = "height")
    private long height;

    @Column(name = "width")
    private long width;

    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public PatientReport() {
        super();
    }

    public PatientReport(String patientID, String patientData, String doctorName, String status, byte[] image, long height, long width, LocalDateTime createdAt) {
        super();
        this.patientID = patientID;
        this.patientData = patientData;
        this.doctorName = doctorName;
        this.status = status;
        this.image = image;
        this.height = height;
        this.width = width;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientData() {
        return patientData;
    }

    public void setPatientData(String patientData) {
        this.patientData = patientData;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
