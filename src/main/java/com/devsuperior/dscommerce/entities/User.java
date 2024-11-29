package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public record User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        @Column(unique = true)
        String email,
        String phone,
        LocalDate birthDate,
        String password,
        @OneToMany(mappedBy = "client")
        List<Order> orders) {

    public User(Long id, String name, String email, String phone, LocalDate birthDate, String password, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
        this.orders = new ArrayList<>();
    }
}
