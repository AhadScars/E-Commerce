package com.example.demo.Controller;


import com.example.demo.Entity.CartEntity;
import com.example.demo.Entity.CategoryEntity;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<CategoryEntity> getAll = service.getAll();
         if (getAll.isEmpty()){
             return new ResponseEntity<>("List is Empty" , HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> AddCart(@RequestBody CategoryEntity entity){
        CategoryEntity addCart = service.saveCategory(entity);
        return new ResponseEntity<>("saved category " , HttpStatus.CREATED);
    }

    @GetMapping("/search/{category}")
    public ResponseEntity<?> searchCategory(@PathVariable String category){
        List<CategoryEntity> searchCategory = service.searchByName(category);
        if (searchCategory.isEmpty()){
            return new ResponseEntity<>(category + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchCategory , HttpStatus.FOUND);
    }
}
