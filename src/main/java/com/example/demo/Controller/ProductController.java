package com.example.demo.Controller;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/showall")
    public Page<ProductEntity> getAll(@RequestParam (defaultValue = "0") int page,
                                      @RequestParam (defaultValue = "5")int size){
        Pageable pageable = PageRequest.of(page, size);
        return service.getall(pageable);
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
