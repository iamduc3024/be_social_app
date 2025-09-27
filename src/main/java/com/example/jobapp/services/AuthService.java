package com.example.jobapp.services;

import com.example.jobapp.dtos.commons.AuthResponse;

public interface AuthService {
  String generateGoogleLoginUrl();

  AuthResponse handleGoogleCallback(String code);
}
