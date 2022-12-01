package com.example.demo.repository;

import com.example.demo.classes.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoductRepositry extends JpaRepository<product,Integer> {
}
