package com.example.demo.services;

import java.util.List;

import com.example.demo.models.ProductModel;

public interface IProductService {
  List<ProductModel> findAll();
}
