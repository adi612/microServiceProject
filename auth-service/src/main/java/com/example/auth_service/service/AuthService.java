package com.example.auth_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth_service.entity.User;
import com.example.auth_service.repository.UserRepository;
import com.example.auth_service.security.JwtUtil;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public User signup(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        logger.info("Encoding password and saving user: {}", user.getUsername());
        return repo.save(user);
    }

    public String login(String username, String password) {
        User user = repo.findByUsername(username);
        if (user == null) {
            logger.warn("Login failed: User {} not found", username);
            throw new RuntimeException("User not found");
        }

        if (encoder.matches(password, user.getPassword())) {
            logger.info("Login successful for user: {}", username);
            return JwtUtil.generateToken(user.getUsername(), user.getRole());
        } else {
            logger.warn("Login failed: Incorrect password for user {}", username);
            throw new RuntimeException("Incorrect password");
        }
    }
}
