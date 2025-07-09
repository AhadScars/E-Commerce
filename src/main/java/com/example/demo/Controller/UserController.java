package com.example.demo.Controller;


import com.example.demo.Entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amazon")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        List<UserEntity> user = userService.getAll();
        if (user.isEmpty()){
            return new ResponseEntity<>("Data is Empty", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user){
        UserEntity User = userService.addUser(user);
        return new ResponseEntity<>("User save Succesfully in database", HttpStatus.CREATED );

    }
    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
        return userService.verify(user);
    }
}
