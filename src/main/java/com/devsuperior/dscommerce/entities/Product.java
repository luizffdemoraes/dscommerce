package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public record Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        @Column(columnDefinition = "TEXT")
        String description,
        Double price,
        String imgUrl,
        @ManyToMany
        @JoinTable(name = "tb_product_category",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
        Set<Category> categories,
        @OneToMany(mappedBy = "id.product")
        Set<OrderItem> items) {

    public Product(Long id, String name, String description, Double price, String imgUrl, Set<Category> categories, Set<OrderItem> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = categories;
        this.items = items;
    }

    public List<Order> getOrders() {
        return items.stream().map(OrderItem::order).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
