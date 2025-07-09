package com.example.demo.Controller;


import com.example.demo.Entity.CartEntity;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @GetMapping("/show")
    public ResponseEntity<?> getAll(){
        List<CartEntity> showAll = service.getMyCart();
        if (showAll.isEmpty()){
            return new ResponseEntity<>("your Cart is empty please add ", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showAll,HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addCart(@RequestBody CartEntity entity){
        CartEntity addCart = service.add(entity);
        return new ResponseEntity<>("item added in Cart",HttpStatus.CREATED);
    }
}
