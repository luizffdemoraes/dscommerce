package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;

                Payment payment = (Payment) o;
                return Objects.equals(id, payment.id);
        }

        @Override
        public int hashCode() {
                return Objects.hashCode(id);
        }
}
