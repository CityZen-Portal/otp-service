package com.cityzen.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class ChangePasswordRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String currentPassword;

    @NotBlank
    private String newPassword;

//    @NotBlank
//    private String confirmPassword;

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
}
