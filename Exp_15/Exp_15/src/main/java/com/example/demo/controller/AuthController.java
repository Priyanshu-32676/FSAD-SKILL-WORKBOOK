package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.security.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username) {

        // 🔥 Fetch user from DB
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 PASS ROLE ALSO
        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}