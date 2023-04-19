package com.test_api.hello_workd;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepositary extends MongoRepository<User,String> {

}