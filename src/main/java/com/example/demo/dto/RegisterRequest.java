package com.example.demo.dto;

import java.util.Set;

public class RegisterRequest {

    private String email;
    private String password;
    private Set<String> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {   // ✅ REQUIRED
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {  // ✅ REQUIRED
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {  // ✅ REQUIRED BY TEST
        this.roles = roles;
    }
}
