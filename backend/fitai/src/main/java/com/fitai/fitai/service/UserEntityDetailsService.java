package com.fitai.fitai.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fitai.fitai.auth.UserEntityDetails;
import com.fitai.fitai.repository.UserRepository;

@Service
public class UserEntityDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  public UserEntityDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email)
        .map(UserEntityDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
