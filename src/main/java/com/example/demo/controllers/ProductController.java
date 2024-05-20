package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.repositories.IProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
  private final IProductRepository productRepository;

  @GetMapping("get-list")
  public List<Product> getList() {
      return productRepository.findAll();
  }
  
}
