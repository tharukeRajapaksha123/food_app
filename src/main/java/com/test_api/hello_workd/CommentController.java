package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment Comment){
        return service.addComment(Comment);
    }

    @GetMapping
    public List<Comment> getComments() {
        return service.findAllComments();
    }


    @GetMapping("/{CommentId}")
    public Comment getComment(@PathVariable String CommentId){
        return service.getCommentByCommentId(CommentId);
    }

    

    @PutMapping
    public Comment modifyComment(@RequestBody Comment Comment){
        return service.updateComment(Comment);
    }

    @DeleteMapping("/{CommentId}")
    public String deleteComment(@PathVariable String CommentId){
        return service.deleteComment(CommentId);
    }
}
