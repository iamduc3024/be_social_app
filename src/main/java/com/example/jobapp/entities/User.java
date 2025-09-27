package com.example.jobapp.entities;

import java.util.Date;

import com.example.jobapp.constants.UserRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Schema(description = "Full name")
    @Column(name = "name")
    private String name;

    @Schema(description = "Email")
    @Column(name = "email")
    private String email;

    @Schema(description = "Avatar URL")
    @Column(name = "avatar_url")
    private String avatarURL;

    @Schema(description = "Provider (GOOGLE, FACEBOOK, ...)")
    @Column(name = "privider")
    private String provider;

    @Schema(description = "Provider ID")
    @Column(name = "provider_id")
    private String providerId;

    @Schema(description = "Role (ADMIN, USER)")
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
