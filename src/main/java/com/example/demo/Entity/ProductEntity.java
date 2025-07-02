package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class ProductEntity {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer Id;
    private String name;
    private String description;

    public ProductEntity(Integer id, String name, String description, Integer price) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    private Integer price;

    public ProductEntity(){

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
