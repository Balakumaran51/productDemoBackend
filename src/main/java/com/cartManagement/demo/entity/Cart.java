package com.cartManagement.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double totalPrice;

    @OneToOne()
    private User user;

    @OneToMany(cascade =CascadeType.ALL)
    private List<Product> productsList;
}
