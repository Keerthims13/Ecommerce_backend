package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin // Optional: allows cross-origin requests
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Sign-up endpoint
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Email already exists!"));
        }

        userRepository.save(user);  // Save user to DB
        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully!"));
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(Collections.singletonMap("message", "Login successful!"));
        } else {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Invalid email or password"));
        }
    }
}


