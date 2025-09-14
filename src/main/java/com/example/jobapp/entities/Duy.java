package com.example.jobapp.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DUY")
public class Duy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "duy_seq")
    @SequenceGenerator(name = "duy_seq", sequenceName = "duy_seq", allocationSize = 1)
    private Long id;

    @Schema(description = "Full name")
    @Column(name = "name")
    private String name;

    @Schema(description = "Phone number")
    @Column(name = "phone")
    private String phone;
}
