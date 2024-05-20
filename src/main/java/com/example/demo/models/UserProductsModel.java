package com.example.demo.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProductsModel {
  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private String contactNumber;
  private List<ProductModel> products;
}
