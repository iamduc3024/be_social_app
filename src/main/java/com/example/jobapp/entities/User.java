package com.example.jobapp.entities;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Schema(description = "Phone number")
    @Column(name = "phone")
    private String phone;

    @Schema(description = "Email")
    @Column(name = "email")
    private String email;

    @Schema(description = "Password")
    @Column(name = "password")
    private String password;

    @Schema(description = "Birth Date")
    @Column(name = "birth_date")
    private Date birthDate;
}
