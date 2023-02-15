package com.julian.baseproject.model;

import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {
  private static final long serialVersionUID = 1L;
  private final String username;
  private final Collection<? extends GrantedAuthority> authorities;
  private final DecodedJWT token;

  public JwtUser(String username, Collection<? extends GrantedAuthority> authorities, DecodedJWT token) {
    this.username = username;
    this.authorities = authorities;
    this.token = token;
  }

  public String getUsername() {
    return this.username;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  public String getPassword() {
    return null;
  }

  public boolean isAccountNonExpired() {
    return true;
  }

  public boolean isAccountNonLocked() {
    return true;
  }

  public boolean isCredentialsNonExpired() {
    return true;
  }

  public boolean isEnabled() {
    return true;
  }

  public DecodedJWT getToken() {
    return this.token;
  }
}
