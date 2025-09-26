package com.example.jobapp.services;

import com.example.jobapp.dtos.requests.RequestCreateUserDTO;
import com.example.jobapp.entities.User;

public interface UserService {
    User createUser(RequestCreateUserDTO user);
}
