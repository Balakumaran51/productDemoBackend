package com.cartManagement.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    Cart cart;
}
