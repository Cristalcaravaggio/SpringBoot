package com.b2b.spring.boot.demo.controller;

import com.b2b.spring.boot.demo.controller.api.AuthenticationAPI;
import com.b2b.spring.boot.demo.service.implementation.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationAPI {

  private final AuthenticationServiceImpl authenticationService;

  @Override
  public String login(String username, String password) {

    return this.authenticationService.login(username, password);
  }

  @Override
  public ResponseEntity<String> admin() {
    return ResponseEntity.ok("Endopoint ADMIN works!");
  }

  @Override
  public ResponseEntity<String> user() {
    return ResponseEntity.ok("Endopoint USER works!");
  }


}
