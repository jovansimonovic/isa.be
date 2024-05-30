package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.user.UserAlreadyExistsException;
import com.example.demo.exceptions.user.UserException;
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
  private final BCryptPasswordEncoder passwordEncoder;

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
    var user = UserMapper.toEntity(model, passwordEncoder);
    var existingUser = userRepository.findByEmail(model.getEmail());
    
    if (existingUser.isPresent()) {
      throw new UserAlreadyExistsException("User with email "
        + model.getEmail() + " already exists");
    }

    var savedUser = userRepository.save(user);

    return UserMapper.toModel(savedUser);
  }

  @Override
  public UserModel update(UserModel model) {
    var entity = UserMapper.toEntity(model, passwordEncoder);

    try {
      var result = userRepository.save(entity);
      return UserMapper.toModel(result);
    } catch (Exception e) {
      throw new UserException(e.getMessage());
    }
  }

  @Override
  public List<UserProductsModel> findUserProductsAll() {
    return UserProductsMapper.toModelList(userProductsRepository.findAll());
  }

  @Override
  public void delete(Integer userId) {
    var entity = userRepository.findById(userId)
      .orElseThrow(() -> new UserException("User not found"));
    userRepository.delete(entity);
  }
}
