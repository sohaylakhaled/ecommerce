package com.example.demo.repository;

import com.example.demo.classes.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartReprositry  extends JpaRepository<Cart,Integer> {
}
