package com.app.health.healthapp.controllers;

import com.app.health.healthapp.models.Comment;
import com.app.health.healthapp.models.HealthApiResponse;
import com.app.health.healthapp.services.CommentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private CommentSerivce commentSerivce;

    @Autowired
    public CommentsController(CommentSerivce commentSerivce) {
        this.commentSerivce = commentSerivce;
    }

    @RequestMapping(value = "test")
    public Comment test() {
        return new Comment();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HealthApiResponse addComment(@RequestBody Comment comment) {
        return this.commentSerivce.addComment(comment);
    }

    @RequestMapping(value = "get")
    public HealthApiResponse getComments() {
        return this.commentSerivce.getComments();
    }
}
