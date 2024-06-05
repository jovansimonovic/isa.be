package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;

public class ProductMapper {
  public static Product toEntity(ProductModel model) {
    Product product = new Product();

    product.setId(model.getId());
    product.setName(model.getName());
    product.setUserId(model.getUser_id());
    product.setPrice(model.getPrice());

    return product;
  }
  public static ProductModel toModel(Product entity) {
    return ProductModel.builder()
            .id(entity.getId())
            .name(entity.getName())
            .user_id(entity.getUserId())
            .price(entity.getPrice())
            .build();
  }

  public static List<ProductModel> toModelList(List<Product> entities) {
    var list = new ArrayList<ProductModel>();
    for (var entity : entities) {
      list.add(toModel(entity));
    }
    return list;
  }
}
