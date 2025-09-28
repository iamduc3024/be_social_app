package com.example.jobapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobapp.dtos.commons.AuthResponse;
import com.example.jobapp.services.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("${api.prefix}/auth")
@Tag(name = "Auth Controller", description = "APIs for managing authentication and authorization")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @GetMapping("/login")
  public String login() {
    return authService.generateGoogleLoginUrl();
  }

  @GetMapping("/callback")
  public AuthResponse callback(@RequestParam("code") String code) {
    return authService.handleGoogleCallback(code);
  }

}
