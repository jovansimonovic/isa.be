package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.services.IUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
	private final IUserService userService;

	@GetMapping("get-list")
  public List<UserModel> getList() {
    return userService.findAll();
  }

	@GetMapping("get-user-products-list")
	public List<UserProductsModel> gUserProductsList() {
		return userService.findUserProductsAll();
	}
	

	@GetMapping("get-page-list")
	public UserPageModel getPageList(Integer pageNumber, Integer pageSize) {
		return userService.findPaginatedList(PageRequest.of(pageNumber, pageSize));
	}
	
	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
		return ResponseEntity.ok(userService.update(userModel));
	}
}
