package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.UserMapper;
import com.example.demo.mappers.UserProductsMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
  private final IUserRepository userRepository;
  private final IUserProductsRepository userProductsRepository;

  @Override
  public List<UserModel> findAll() {
    return UserMapper.toModelList(userRepository.findAll());
  }

  @Override
  public UserPageModel findPaginatedList(PageRequest pageRequest) {
    return UserMapper.toModelPaginatedList(userRepository.findAll(pageRequest));
  }

  @Override
  public UserModel create(UserModel model) {
    return UserMapper.toModel(userRepository.save(UserMapper.toEntity(model)));
  }

  @Override
  public UserModel update(UserModel model) {
    return UserMapper.toModel(userRepository.save(UserMapper.toEntity(model)));
  }

  @Override
  public List<UserProductsModel> findUserProductsAll() {
    return UserProductsMapper.toModelList(userProductsRepository.findAll());
  }
}
