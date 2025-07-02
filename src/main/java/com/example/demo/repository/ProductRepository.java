package com.example.demo.repository;

import com.example.demo.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {

    List<ProductEntity> findByNameContainingIgnoreCase(String name);
    List<ProductEntity> findByPrice(Integer price);
}
