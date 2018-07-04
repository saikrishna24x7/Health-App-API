package com.app.health.healthapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devicedata")
public class DeviceData {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Column(name = "data")
    private String data;

    @Column(name = "patient")
    private String patientId;

    @Column(name = "data_time")
    @CreationTimestamp
    private LocalDateTime dataTime;

    public DeviceData() {
        super();
    }

    public DeviceData(String patientId, String data, LocalDateTime dataTime) {
        this.patientId = patientId;
        this.data = data;
        this.dataTime = dataTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }
}
