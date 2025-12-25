package com.example.demo.dto;

public class AuthRequest {

    private String email;
    private String password;

    // ✅ Mandatory no-args constructor (tests use it)
    public AuthRequest() {
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // ✅ Setters REQUIRED for tests
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
