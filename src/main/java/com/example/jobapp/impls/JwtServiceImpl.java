package com.example.jobapp.impls;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.jobapp.entities.User;
import com.example.jobapp.services.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

  private final Key key;
  private final long jwtExpirationMs;

  public JwtServiceImpl(
      @Value("${jwt.secret}") String secret,
      @Value("${jwt.expiration}") long jwtExpirationMs) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.jwtExpirationMs = jwtExpirationMs;
  }

  @Override
  public String generateToken(User user) {
    return Jwts.builder()
        .setSubject(user.getEmail())
        .claim("userId", user.getId())
        .claim("name", user.getName())
        .claim("avatar_url", user.getAvatarURL())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  @Override
  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }

  @Override
  public String extractEmail(String token) {
    Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
        .parseClaimsJws(token)
        .getBody();
    return claims.getSubject();
  }

  @Override
  public String generateRefreshToken(User user) {
    // Refresh token valid for 7 days
    long refreshTokenExpirationMs = 7 * 24 * 60 * 60 * 1000;
    return Jwts.builder()
        .setSubject(user.getEmail())
        .claim("userId", user.getId())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpirationMs))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

}
