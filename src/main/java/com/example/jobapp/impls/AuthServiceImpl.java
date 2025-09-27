package com.example.jobapp.impls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.example.jobapp.constants.ProviderConstants;
import com.example.jobapp.constants.UserRole;
import com.example.jobapp.dtos.commons.AuthResponse;
import com.example.jobapp.entities.User;
import com.example.jobapp.repositories.UserRepository;
import com.example.jobapp.services.AuthService;
import com.example.jobapp.services.JwtService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthServiceImpl implements AuthService {

  @Value("${google.client.id}")
  private String clientId;

  @Value("${google.client.secret}")
  private String clientSecret;

  @Value("${google.redirect.uri}")
  private String redirectUri;

  private final UserRepository userRepository;
  private final JwtService jwtService;

  private final RestTemplate restTemplate = new RestTemplate();
  private final ObjectMapper objectMapper = new ObjectMapper();

  public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
    this.userRepository = userRepository;
    this.jwtService = jwtService;
  }

  @Override
  public String generateGoogleLoginUrl() {
    return "https://accounts.google.com/o/oauth2/v2/auth"
        + "?client_id=" + clientId
        + "&redirect_uri=" + redirectUri
        + "&response_type=code"
        + "&scope=openid%20email%20profile";
  }

  @Override
  public AuthResponse handleGoogleCallback(String code) {
    String tokenUrl = "https://oauth2.googleapis.com/token";
    Map<String, String> params = new HashMap<>();
    params.put("code", code);
    params.put("client_id", clientId);
    params.put("client_secret", clientSecret);
    params.put("redirect_uri", redirectUri);
    params.put("grant_type", "authorization_code");

    JsonNode tokenResponse = restTemplate.postForObject(tokenUrl, params, JsonNode.class);
    String idToken = tokenResponse.get("id_token").asText();

    // Google Auth
    String googleApi = "https://oauth2.googleapis.com/tokeninfo?id_token=" + idToken;
    JsonNode userInfo = restTemplate.getForObject(googleApi, JsonNode.class);

    String googleId = userInfo.get("sub").asText();
    String email = userInfo.get("email").asText();
    String fullName = userInfo.get("name").asText();
    String avatarUrl = userInfo.get("picture").asText();

    // Save user
    User user = userRepository.findByEmail(email)
        .orElseGet(() -> new User());
    user.setProvider(ProviderConstants.GOOGLE);
    user.setProviderId(googleId);
    user.setEmail(email);
    user.setName(fullName);
    user.setAvatarURL(avatarUrl);
    user.setRole(UserRole.USER);
    userRepository.save(user);

    // Generate JWT
    String jwt = jwtService.generateToken(user);

    AuthResponse response = new AuthResponse();
    response.setJwtToken(jwt);
    response.setUserId(user.getId());
    response.setEmail(user.getEmail());
    response.setFullName(user.getName());
    response.setAvatarUrl(user.getAvatarURL());
    return response;
  }

}