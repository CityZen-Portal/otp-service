package com.cityzen.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class SignInRequest {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private boolean rememberMe;
    // Getters and Setters
    public String getEmail() {
        return email; // Return the actual email
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password; // Return the actual password
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isRememberMe() {
        return rememberMe;
    }
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}