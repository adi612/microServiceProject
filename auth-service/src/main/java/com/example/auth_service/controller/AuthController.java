package com.example.auth_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auth_service.entity.User;
import com.example.auth_service.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Endpoints for user registration and login")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "Sign Up", description = "Register a new user and return the user object.")
    public ResponseEntity<User> signup(@RequestBody User user) {
        logger.info("Signup attempt for user: {}", user.getUsername());
        User registeredUser = authService.signup(user);
        logger.info("User registered successfully: {}", registeredUser.getUsername());
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    @Operation(summary = "Log In", description = "Authenticate user and return a JWT token.")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        logger.info("Login attempt for username: {}", username);

        String token = authService.login(username, password);

        logger.info("Token issued successfully for user: {}", username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
