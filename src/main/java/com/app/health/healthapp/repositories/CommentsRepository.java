package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentsRepository extends CrudRepository<Comment, Long> {
    List<Comment> findCommentsByPatientId(String patientId);
}
