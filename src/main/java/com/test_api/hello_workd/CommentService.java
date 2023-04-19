package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Comment addComment(Comment Comment) {
        Comment.setCommentId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Comment);
    }

    public List<Comment> findAllComments() {
        return repository.findAll();
    }

    public Comment getCommentByCommentId(String CommentId){
        return repository.findById(CommentId).get();
    }


    public Comment updateComment(Comment CommentRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Comment existingComment = repository.findById(CommentRequest.getCommentId()).get();
        existingComment.setComment(CommentRequest.getComment());
       
        return repository.save(existingComment);
    }

    public String deleteComment(String CommentId){
        repository.deleteById(CommentId);
        return CommentId+" Comment deleted from dashboard ";
    }
}