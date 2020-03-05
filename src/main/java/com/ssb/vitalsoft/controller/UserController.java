package com.ssb.vitalsoft.controller;

import com.ssb.vitalsoft.model.User;
import com.ssb.vitalsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(produces = "application/json")
    public List<User> getUsers() {
        return (List)userService.getUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(value = "/user/{id}",produces = "application/json")
    public Optional<User> getUserById(@PathVariable String id) {
        Optional<User> user=userService.findById(id);
        return user;
    }
}
