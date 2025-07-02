package com.example.demo.service;


import com.example.demo.Entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<CategoryEntity> getAll(){
        return repository.findAll();
    }

    public CategoryEntity saveCategory(CategoryEntity entity){
        return repository.save(entity);
    }

    public List<CategoryEntity> searchByName(String name){
        return repository.findByCategoryNameContainingIgnoreCase(name);
    }

    public CategoryEntity findByName(String categoryName){
        return repository.findByCategoryName(categoryName);
    }
}
