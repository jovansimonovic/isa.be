package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
  @Query(nativeQuery = true, value = "SELECT * FROM products")
  List<Product> findAll();
}
