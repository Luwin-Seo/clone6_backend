package com.example.clone6_backend.repository;

import com.example.clone6_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
   User findByNickname(String nickname);
}
