package com.julian.baseproject.model;

import com.julian.baseproject.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
  private User user;

  public UserPrincipal(User user) {
    this.user = user;
  }
}
