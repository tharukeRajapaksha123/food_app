package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepositary repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public User addUser(User User) {
        User.setUserId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(User);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserByUserId(String UserId){
        return repository.findById(UserId).get();
    }


    public User updateUser(User UserRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        User existingUser = repository.findById(UserRequest.getUserId()).get();
        existingUser.setAddress(UserRequest.getAddress());
        existingUser.setImageUrl(UserRequest.getImageUrl());
        existingUser.setName(UserRequest.getName());
        return repository.save(existingUser);
    }

    public String deleteUser(String UserId){
        repository.deleteById(UserId);
        return UserId+" User deleted from dashboard ";
    }
}