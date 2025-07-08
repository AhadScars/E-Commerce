package com.example.demo.service;


import com.example.demo.Entity.CartEntity;
import com.example.demo.Entity.ProductEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartEntity> getMyCart() {
        return repository.findAll();
    }


    public CartEntity add(CartEntity entity) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByUsername(username);
        entity.setUser(user);


        Integer productId = entity.getProduct().getId();
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        entity.setProduct(product);

        return repository.save(entity);
    }
}
