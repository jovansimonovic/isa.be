package com.example.demo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;

public class UserMapper {
  public static User toEntity(UserModel model) {
    User user = new User();

    user.setId(model.getId());
    user.setFirstName(model.getFirstName());
    user.setLastName(model.getLastName());
    user.setEmail(model.getEmail());

    return user;
  }

  public static UserModel toModel(User entity) {
    return UserModel.builder()
            .id(entity.getId())
            .email(entity.getEmail())
            .firstName(entity.getFirstName())
            .lastName(entity.getLastName()).build();
}

  public static List<UserModel> toModelList(List<User> entities) {
    var list = new ArrayList<UserModel>();
    for (var entity : entities) {
      list.add(toModel(entity));
    }
    return list;
  }

  public static UserPageModel toModelPaginatedList(Page<User> pageEntity) {
    return UserPageModel.builder()
      .Users(toModelList(pageEntity.getContent()))
      .totalPages(pageEntity.getTotalPages())
      .totalElements(pageEntity.getTotalElements())
      .build();
  }
}
