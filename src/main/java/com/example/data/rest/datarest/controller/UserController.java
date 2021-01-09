package com.example.data.rest.datarest.controller;

import com.example.data.rest.datarest.pojo.User;
import com.example.data.rest.datarest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam String name) {
        return service.getUser(name);
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }
}
