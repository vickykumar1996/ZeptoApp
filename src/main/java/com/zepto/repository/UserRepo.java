package com.zepto.repository;

import com.zepto.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String Username);
    Optional<User>findByemail(String email);
}
