package com.example.demo.Controller;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/showall")
    public List<ProductEntity> getAll(){
        return service.getall();
    }
    @PostMapping("/add")
    public ProductEntity addProduct(@RequestBody ProductEntity entity){
        return service.saveAll(entity);
    }

    @GetMapping("/show/{name}")
    public List<ProductEntity> ShowByName(@PathVariable String name){
        return service.findByName(name);
    }

}
