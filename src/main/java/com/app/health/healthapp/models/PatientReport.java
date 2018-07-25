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

    @Column(name = "specialist_name")
    private String specialistName;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "image1", columnDefinition = "longblob")
    private byte[] image1;

    @Lob
    @Column(name = "image2", columnDefinition = "longblob")
    private byte[] image2;

    @Lob
    @Column(name = "image3", columnDefinition = "longblob")
    private byte[] image3;

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

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public byte[] getImage3() {
        return image3;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
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
