package com.cityzen.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class ForgotPasswordRequest {
    @Email
    @NotBlank
    private String email;
    public String getEmail() {
        return email; // Return the actual email
    }
    public void setEmail(String email) {
        this.email = email;
    }
}