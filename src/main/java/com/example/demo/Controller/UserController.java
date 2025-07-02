package com.example.demo.Controller;


import com.example.demo.Entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amazon")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/getall")
    public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @PostMapping("/saveuser")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userService.addUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
        return userService.verify(user);
    }
}
