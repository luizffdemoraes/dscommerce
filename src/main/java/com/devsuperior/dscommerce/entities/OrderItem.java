package com.devsuperior.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public record OrderItem(@EmbeddedId
                        OrderItemPK id,
                        Integer quantity,
                        Double price) {

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this(new OrderItemPK(order, product), quantity, price);
    }

    public Order order() {
        return id.order();
    }

    public Product product() {
        return id.product();
    }
}


