package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
   

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
       user.setPassword(request.getPassword());
        

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!request.getPassword().equals(user.getPassword()))
        {
                 throw new RuntimeException("Invalid password");
        }


        // JWT placeholder
        String token = "JWT_TOKEN";

        return new AuthResponse(token);
    }

    @Override
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
