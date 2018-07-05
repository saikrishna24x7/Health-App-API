package com.app.health.healthapp.repositories;

import com.app.health.healthapp.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comment, Long> {
}
