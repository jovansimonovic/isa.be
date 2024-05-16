package com.example.demo.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPageModel {
  private List<UserModel> Users;
  private int totalPages;
  private Long totalElements;
}
