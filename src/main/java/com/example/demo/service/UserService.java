package com.example.demo.service;


import com.example.demo.Entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    JWTService jwTservice;
    @Autowired
    AuthenticationManager authenticationManager;
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


    public String verify(UserEntity user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwTservice.generateToken(user.getUsername());
        }
        return "invalid Token";
    }
}
