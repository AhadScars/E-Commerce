package com.example.demo.service;


import com.example.demo.Entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Page<ProductEntity> getall(Pageable pageable){
        return repository.findAll(pageable);
    }

    public ProductEntity saveAll(ProductEntity entity){
        return repository.save(entity);
    }

    public List<ProductEntity> findByName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<ProductEntity> findByPrice(Integer price){
        return repository.findByPrice(price);
    }
}
