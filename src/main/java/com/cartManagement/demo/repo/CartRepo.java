package com.cartManagement.demo.repo;

import com.cartManagement.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepo extends JpaRepository<Cart,Long> {
}
