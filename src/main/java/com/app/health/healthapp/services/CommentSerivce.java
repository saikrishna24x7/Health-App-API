package com.app.health.healthapp.services;

import com.app.health.healthapp.models.Comment;
import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentSerivce {

    private CommentsRepository commentsRepository;

    public CommentSerivce(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public HealthApiResponse getComments() {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<Comment> comments = new ArrayList<>();
        this.commentsRepository.findAll().forEach(comments::add);
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        healthApiResponse.setComments(comments);
        return healthApiResponse;
    }

    public HealthApiResponse addComment(Comment comment) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        this.commentsRepository.save(comment);
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        return healthApiResponse;
    }

    public HealthApiResponse getCommentsForPatient(Comment comment) {
        HealthApiResponse healthApiResponse = new HealthApiResponse();
        List<Comment> comments = new ArrayList<>();
        this.commentsRepository.findCommentsByPatientId(comment.getPatientId()).forEach(comments::add);
        healthApiResponse.setResponseStatus(true);
        healthApiResponse.setResponseMessage("Success");
        healthApiResponse.setComments(comments);
        return healthApiResponse;
    }

}
