package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public record Order(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        Instant moment,
        OrderStatus status,
        @ManyToOne
        @JoinColumn(name = "client_id")
        User client) {
}
