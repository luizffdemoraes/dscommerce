package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Set;

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
        User client,

        @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
        Payment payment,

        @OneToMany(mappedBy = "id.order")
        Set<OrderItem> items) {
}
