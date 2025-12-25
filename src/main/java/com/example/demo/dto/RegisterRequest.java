package com.example.demo.dto;

public class RegisterRequest {

    private String email;
    private String password;

    // ✅ Mandatory no-args constructor
    public RegisterRequest() {
    }

    // Optional all-args constructor
    public RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // ✅ Setters REQUIRED for tests & JSON binding
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
