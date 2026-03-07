package com.fitai.fitai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitai.fitai.model.DTOs.RegistrationInfoDTO;
import com.fitai.fitai.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody RegistrationInfoDTO registrationData,
      HttpServletResponse response) {
    if (registrationData == null) {
      return new ResponseEntity<String>("Invalid Registration Info", HttpStatus.BAD_REQUEST);
    }
    return userService.registerUser(registrationData, response);
  }
}
