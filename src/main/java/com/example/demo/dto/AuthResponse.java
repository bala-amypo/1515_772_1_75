package com.example.demo.dto;

import java.util.Set;

public class AuthResponse {

    private String token;
    private String email;
    private Set<String> roles;

    // Constructor used in UserServiceImpl
    public AuthResponse(String token, String email, Set<String> roles) {
        this.token = token;
        this.email = email;
        this.roles = roles;
    }

    // Optional: keep single-arg constructor if needed
    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
