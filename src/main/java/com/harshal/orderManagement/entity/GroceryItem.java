package com.harshal.orderManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grocery_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String category;

    @ManyToMany(mappedBy = "groceryItems")
    private List<Order> orders = new ArrayList<>();


}
