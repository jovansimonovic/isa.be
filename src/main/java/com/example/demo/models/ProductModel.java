package com.example.demo.models;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
  private int id;
  @NotBlank
  private String name;
  private int user_id;
  @NotBlank
  private BigDecimal price;
}
