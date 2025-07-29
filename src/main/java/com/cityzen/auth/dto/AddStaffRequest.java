package com.cityzen.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class AddStaffRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    // Getters and Setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}