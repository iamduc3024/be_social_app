package com.example.jobapp.impls;

import com.example.jobapp.dtos.requests.RequestCreateUserDTO;
import com.example.jobapp.mappers.MapperUtils;
import com.example.jobapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobapp.services.UserService;
import com.example.jobapp.entities.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(RequestCreateUserDTO user) {
        User newUser = MapperUtils.map(user, User.class);
        return userRepository.save(newUser);
    }
}
