package com.example.jobapp.dtos.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
  private String jwtToken;
  private Long userId;
  private String email;
  private String fullName;
  private String avatarUrl;
}
