package com.github.cleyto_orocha.library_system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.cleyto_orocha.library_system.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<UserDetails> findByLogin(String login);
    Boolean existsByLogin(String login);
}
