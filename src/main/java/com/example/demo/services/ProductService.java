package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
  private final IProductRepository productRepository;

  @Override
  public List<ProductModel> findAll() {
    return ProductMapper.toModelList(productRepository.findAll());
  }
}
