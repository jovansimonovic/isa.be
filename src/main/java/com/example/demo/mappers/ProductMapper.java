package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;

public class ProductMapper {
  public static ProductModel toModel(Product entity) {
    return ProductModel.builder().name(entity.getName()).build();
  }

  public static List<ProductModel> toModelList(List<Product> entities) {
    var list = new ArrayList<ProductModel>();
    for (var entity : entities) {
      list.add(toModel(entity));
    }
    return list;
  }
}
