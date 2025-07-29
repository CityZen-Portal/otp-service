package com.cityzen.auth.dto;
import jakarta.validation.constraints.NotBlank;
public class ResetPasswordRequest {
    @NotBlank
    private String token;
    private String newPassword;
    @NotBlank
    public String getToken() {
        return token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}