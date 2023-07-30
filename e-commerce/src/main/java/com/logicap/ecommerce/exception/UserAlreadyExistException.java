package com.logicap.ecommerce.exception;

public class UserAlreadyExistException extends RuntimeException {

  public UserAlreadyExistException() {
    super("Email is already in use.");
  }

}
