package com.example.demo.repository;

import com.example.demo.classes.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineReprositry extends JpaRepository<ProductLine,Integer> {
}
