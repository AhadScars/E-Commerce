package com.example.demo.repository;

import com.example.demo.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    List<CategoryEntity> findByCategoryNameContainingIgnoreCase(String CategoryName);
    CategoryEntity findByCategoryName(String CategoryName);
}
