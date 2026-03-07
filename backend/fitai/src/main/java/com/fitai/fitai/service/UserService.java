package com.fitai.fitai.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitai.fitai.model.User;
import com.fitai.fitai.model.DTOs.RegistrationInfoDTO;
import com.fitai.fitai.repository.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder encoder;

  public UserService(UserRepository userRepository, JwtService jwtService, PasswordEncoder encoder) {
    this.userRepository = userRepository;
    this.jwtService = jwtService;
    this.encoder = encoder;
  }

  public ResponseEntity<?> registerUser(RegistrationInfoDTO registrationData, HttpServletResponse response) {
    if (userRepository.existsByEmail(registrationData.email())) {
      return new ResponseEntity<>("Email already in use", HttpStatus.CONFLICT);
    }

    User newUser = new User();

    newUser.setFname(registrationData.firstName());
    newUser.setLname(registrationData.lastName());
    newUser.setEmail(registrationData.email());
    newUser.setPassword(encoder.encode(registrationData.password()));
    newUser.setAge(registrationData.age());
    newUser.setSex(registrationData.sex());
    try {
      userRepository.save(newUser);
      String token = jwtService.generateToken(newUser.getEmail());

      Cookie cookie = new Cookie("jwt", token);
      cookie.setHttpOnly(true);
      cookie.setSecure(true);
      cookie.setPath("/");
      cookie.setMaxAge(86400);
      response.addCookie(cookie);

      return new ResponseEntity<>(Map.of("token", token), HttpStatus.CREATED);
    } catch (DataAccessException e) {
      return new ResponseEntity<String>("Database error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
