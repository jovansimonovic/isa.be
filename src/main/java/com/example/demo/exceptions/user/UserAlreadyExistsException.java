package com.example.demo.exceptions.user;

import com.example.demo.exceptions.BaseException;

public class UserAlreadyExistsException extends BaseException {
  public UserAlreadyExistsException(String message) {
    super(message);
  }
}
