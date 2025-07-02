package com.example.demo.Controller;


import com.example.demo.Entity.CategoryEntity;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/all")
    public List<CategoryEntity> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public CategoryEntity saveCategory(@RequestBody CategoryEntity entity){
        return service.saveCategory(entity);
    }

    @GetMapping("/{category}")
    public CategoryEntity findByName(@PathVariable String category){
        return service.findByName(category);
    }

    @GetMapping("/search/{category}")
    public List<CategoryEntity> searchCategory(@PathVariable String category){
        return service.searchByName(category);
    }
}
