package com.cartManagement.demo.repo;

import com.cartManagement.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
    
}
