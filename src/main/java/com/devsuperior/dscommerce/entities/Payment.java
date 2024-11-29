package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public record Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        Instant moment,

        @OneToOne
        @MapsId
        Order order) {
}
