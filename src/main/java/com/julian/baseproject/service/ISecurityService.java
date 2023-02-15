package com.julian.baseproject.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.Map;
import java.util.function.Consumer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface ISecurityService {
  String generateToken(Authentication authentication, Consumer<Map<String, Object>> claims);

  Consumer<Map<String, Object>> getClaims();

  Date getExpirationDateFromToken(String token);

  DecodedJWT stripFrontAndDecode(String authorizationHeader);

  UserDetails getUserDetails(String authToken);

  boolean validateToken(String token);
}
