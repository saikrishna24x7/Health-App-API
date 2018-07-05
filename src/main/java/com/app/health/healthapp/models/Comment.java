package com.app.health.healthapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Column(name = "commentor")
    private String commentorName;

    @Column(name = "comment")
    private String comment;

    @Column(name = "patientId")
    private String patientId;

    public Comment() {
    }

    public Comment(String commentorName, String comment, String patientId) {
        this.commentorName = commentorName;
        this.comment = comment;
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentorName() {
        return commentorName;
    }

    public void setCommentorName(String commentorName) {
        this.commentorName = commentorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}