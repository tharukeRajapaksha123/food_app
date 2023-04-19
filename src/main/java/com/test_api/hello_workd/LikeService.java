package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    private LikeRepositary repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Like addLike(Like Like) {
        Like.setLikeId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Like);
    }

    public List<Like> findAllLikes() {
        return repository.findAll();
    }

    public Like getLikeByLikeId(String LikeId){
        return repository.findById(LikeId).get();
    }


    public String deleteLike(String LikeId){
        repository.deleteById(LikeId);
        return LikeId+" Like deleted from dashboard ";
    }
}