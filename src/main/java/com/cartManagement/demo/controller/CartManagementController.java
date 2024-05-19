package com.cartManagement.demo.controller;

import com.cartManagement.demo.entity.Cart;
import com.cartManagement.demo.entity.Product;
import com.cartManagement.demo.service.CartManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cartManagement")
@CrossOrigin(origins = "*")
public class CartManagementController {
    @Autowired
    CartManagementService service;

    @GetMapping("/getAllProducts")
    public ResponseEntity<ArrayList<Product>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/getcart/{userID}")
    public ResponseEntity<Cart> getCartByUser(@PathVariable Long userID){
        return ResponseEntity.ok(service.getUserCart(userID));
    }

    @PutMapping("/addToCart/{cartID}")
    public ResponseEntity<String> addToCart(@PathVariable Long cartID, @RequestBody Product product){
        return ResponseEntity.ok(service.addProductToCart(product,cartID));
    }

    @PutMapping("/removeFromCart/{cartID}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartID, @RequestBody Product product){
        return ResponseEntity.ok(service.removeProductFromCart(product,cartID));
    }

}
