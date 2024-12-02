package com.devsuperior.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public record OrderItemPK(@ManyToOne
                          @JoinColumn(name = "order_id")
                          Order order,

                          @ManyToOne
                          @JoinColumn(name = "product_id")
                          Product product) implements Serializable {

    // Sobrescreva equals e hashCode para garantir o funcionamento correto
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}