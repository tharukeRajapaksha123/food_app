package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adevertisement")
public class AdvertisementController {

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


    @GetMapping("/{advertisementId}")
    public Comment getComment(@PathVariable String advertisementId){
        return service.getCommentByCommentId(advertisementId);
    }

    

    @PutMapping
    public Comment modifyComment(@RequestBody Comment Comment){
        return service.updateComment(Comment);
    }

    @DeleteMapping("/{advertisementId}")
    public String deleteComment(@PathVariable String advertisementId){
        return service.deleteComment(advertisementId);
    }
}
