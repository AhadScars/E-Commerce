package com.example.demo.service;


import com.example.demo.Entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserEntity> getAll (){
        return repository.findAll();
    }

    public UserEntity addUser(UserEntity entity){
    entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return repository.save(entity);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
