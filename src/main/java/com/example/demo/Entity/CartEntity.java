package com.example.demo.Entity;

import jakarta.persistence.*;


@Entity
public class CartEntity {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer Id;

    private int quantity;

    @ManyToOne
  private UserEntity user;


  @ManyToOne
  private ProductEntity product;

    public CartEntity(Integer id, int quantity, UserEntity user, ProductEntity product) {
        this.Id = id;
        this.quantity = quantity;
        this.user = user;
        this.product = product;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CartEntity() {
    }
}
