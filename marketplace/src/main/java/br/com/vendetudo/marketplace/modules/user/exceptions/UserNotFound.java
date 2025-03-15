package br.com.vendetudo.marketplace.modules.user.exceptions;

public class UserNotFound extends RuntimeException {
  public UserNotFound(String message) {
    super(message);
  }
}
