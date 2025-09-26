package com.example.jobapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.jobapp.entities.User;
import com.example.jobapp.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("${api.prefix}/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}