package com.test_api.hello_workd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User User){
        return service.addUser(User);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.findAllUsers();
    }


    @GetMapping("/{UserId}")
    public User getUser(@PathVariable String UserId){
        return service.getUserByUserId(UserId);
    }

    

    @PutMapping
    public User modifyUser(@RequestBody User User){
        return service.updateUser(User);
    }

    @DeleteMapping("/{UserId}")
    public String deleteUser(@PathVariable String UserId){
        return service.deleteUser(UserId);
    }
}
