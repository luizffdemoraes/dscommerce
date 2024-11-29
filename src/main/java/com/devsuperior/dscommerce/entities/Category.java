package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public record Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        @ManyToMany(mappedBy = "categories")
        Set<Product> products) {
    public Category(
            Long id, String name,
            Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = new HashSet<>();
    }
}