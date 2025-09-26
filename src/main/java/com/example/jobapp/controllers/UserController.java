package com.example.jobapp.controllers;

import com.example.jobapp.dtos.requests.RequestCreateUserDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.jobapp.entities.User;
import com.example.jobapp.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("${api.prefix}/user")
@Tag(name = "User Controller", description = "APIs for managing users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    @Operation(summary = "Create a new user", description = "Creates a new user with the provided details")
    public User createUser(@RequestBody RequestCreateUserDTO user) {
        return userService.createUser(user);
    }
}