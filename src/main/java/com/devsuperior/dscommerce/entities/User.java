package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_user")
public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        String email,
        String phone,
        LocalDate birthDate,
        String password) {
}
