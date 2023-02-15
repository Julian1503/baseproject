package com.julian.baseproject.controller;

import com.julian.baseproject.model.LoginRequest;
import com.julian.baseproject.service.ISecurityService;
import java.util.Map;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

  private final ISecurityService securityService;
  private final AuthenticationManager authorizationManager;

  @Autowired
  public LoginController(ISecurityService securityService,
      AuthenticationManager authorizationManager) {
    this.securityService = securityService;
    this.authorizationManager = authorizationManager;
  }

  @PostMapping("/token")
  public String token(@RequestBody LoginRequest loginRequest) {
    Authentication authentication = authorizationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),loginRequest.password()));
    Consumer<Map<String, Object>> claims = securityService.getClaims();
    return securityService.generateToken(authentication, claims);
  }
}
