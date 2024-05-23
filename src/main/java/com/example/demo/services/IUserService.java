package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;

public interface IUserService {
  List<UserModel> findAll();
  UserPageModel findPaginatedList(PageRequest pageRequest);
  List<UserProductsModel> findUserProductsAll();
  UserModel create(UserModel model);
  UserModel update(UserModel model);
}
