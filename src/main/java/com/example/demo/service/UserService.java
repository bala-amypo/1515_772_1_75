package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.UserEntity;

public interface UserService {

    UserEntity register(RegisterRequest request);

    AuthResponse login(AuthRequest request);

    UserEntity getByEmail(String email);
}
