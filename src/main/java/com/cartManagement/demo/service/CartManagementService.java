package com.cartManagement.demo.service;

import com.cartManagement.demo.entity.Cart;
import com.cartManagement.demo.entity.Product;
import com.cartManagement.demo.entity.User;
import com.cartManagement.demo.exceptions.NotFound;
import com.cartManagement.demo.repo.CartRepo;
import com.cartManagement.demo.repo.ProductRepo;
import com.cartManagement.demo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class CartManagementService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    public ArrayList<Product> getAllProducts(){
        return new ArrayList<>(productRepo.findAll());
    }

    public Cart getUserCart(Long id){
        User user = userRepo.findById(id).orElse(null);
        if(user == null) throw new NotFound("User not found");
        return user.getCart();
    }

    public String addProductToCart(Product product, Long cartID){
        Cart cart = cartRepo.findById(cartID).orElse(null);
        if(cart == null) throw new NotFound("Cart doesn't exist");

        cart.getProductsList().add(product);
        cartRepo.save(cart);
        log.info(String.format("Product %s added to cart %d successfully",product.getName(),cart.getId()));
        return String.format("Product %s added to cart %d successfully",product.getName(),cart.getId());
    }

    public String removeProductFromCart(Product product, Long cartID){
        Cart cart = cartRepo.findById(cartID).orElse(null);
        if(cart == null) throw new NotFound("Cart doesn't exist");

        cart.getProductsList().remove(product);
        cartRepo.save(cart);
        log.info(String.format("Product %s removed from cart %d successfully",product.getName(),cart.getId()));
        return String.format("Product %s removed from cart %d successfully",product.getName(),cart.getId());
    }







}
