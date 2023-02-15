package com.julian.baseproject.error;

public class ErrorBadUser extends ErrorBase {
  public ErrorBadUser(Long userId) {
    super("User does not exist","401", String.format("The user with id %d does not exist", userId));
  }
}
