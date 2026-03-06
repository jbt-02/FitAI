package com.fitai.fitai.repository;

import com.fitai.fitai.model.User;

import java.util.Optional;
import java.lang.String;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByEmail(String email);

  @Override
  Optional<User> findById(UUID id);

}
