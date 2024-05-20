package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "user_id")
  private Integer user_id;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "product_categories",
    joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
  @JsonManagedReference
  private List<Category> categories;
}
