package com.example.demo.dto;

import java.util.Set;

public class AuthResponse {

    private String token;
    private String email;
    private Set<String> roles;

    // ✅ Mandatory no-args constructor (Jackson + tests)
    public AuthResponse() {
    }

    // ✅ Used in UserServiceImpl
    public AuthResponse(String token, String email, Set<String> roles) {
        this.token = token;
        this.email = email;
        this.roles = roles;
    }

    // Optional single-arg constructor
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    // ✅ Setters REQUIRED for tests
    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
