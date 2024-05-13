package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;

import jakarta.validation.Valid;


@RestController
@RequestMapping("user")
public class UserController {

  @GetMapping("get-first-name")
	public String getFirstName() {
		return "Jovan";
	}

	@GetMapping("get-first-name-list")
	public List<String> getFirstNameList() {
		return List.of("Petar", "John");
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

		return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
	}
}
