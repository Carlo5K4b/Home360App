package com.pragma.home360.domain.exceptions;

public class EmptyFieldException extends RuntimeException {
  public EmptyFieldException(String message) {
    super(message);
  }
}
