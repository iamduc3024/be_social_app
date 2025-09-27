package com.example.jobapp.services;

import com.example.jobapp.entities.User;

public interface JwtService {
  String generateToken(User user);

  boolean validateToken(String token);

  String extractEmail(String token);
  
}
