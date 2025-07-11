package com.tusistema.auth_service.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
