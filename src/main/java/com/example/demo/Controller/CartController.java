package com.example.demo.Controller;


import com.example.demo.Entity.CartEntity;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @GetMapping("/show")
    List<CartEntity> getAll(){
        return service.getMyCart();
    }


    @PostMapping("/add")
    public CartEntity addCart(@RequestBody CartEntity entity){
        return service.add(entity);
    }
}
