package com.example.demo.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole())   // ✅ FIX HERE
                .build();
    }
}