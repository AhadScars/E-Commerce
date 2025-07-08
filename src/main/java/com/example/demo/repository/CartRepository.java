package com.example.demo.repository;

import com.example.demo.Entity.CartEntity;
import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity , Integer> {
}
