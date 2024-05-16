package com.example.demo.controllers;

import com.example.demo.mappers.UserMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.repositories.IUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

	private final IUserRepository userRepository;

	@CrossOrigin("*")
  @GetMapping("get-first-name")
	public String getFirstName() {
		return "Jovan";
	}

	@GetMapping("get-first-name-list")
	public List<UserModel> getFirstNameList() {
		return UserMapper.toModelList(userRepository.findAll());
	}

	@GetMapping("get-user-list")
  public List<UserModel> getUserList() {
    return UserMapper.toModelList(userRepository.findAll());
  }

	@GetMapping("get-user-page-list")
	public UserPageModel getUserPageList(Integer pageNumber, Integer pageSize) {
			return UserMapper.toModelPaginatedList(userRepository.findAll(PageRequest.of(pageNumber, pageSize)));
	}

	// ovaj primer instancira usera unutar funkcije
	// @PostMapping("create-user")
	// public boolean createUser(String firstName, String lastName) {
	// 	UserModel user = new UserModel();

	// 	user.setFirstName("Jovan");
	// 	user.setLastName("Simonovic");

	// 	return user;
	// }

	// ovde se user automatski instancira
	@PostMapping("create-user-body")
	public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		var entity = UserMapper.toEntity(userModel);
		
		userRepository.save(entity);

		return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
	}
}
