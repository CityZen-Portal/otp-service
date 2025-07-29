package com.cityzen.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class
SignUpRequest {
    @NotBlank
    private String userName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String aadhaar; // Assuming this is the Aadhaar number
    // Getters and Setters
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
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
    public String getAadhaar() {
        return aadhaar;
    }
    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
    // Method to validate password
    public boolean isValidPassword() {
        return password != null && password.length() >= 8 &&
                password.matches(".*[A-Z].*") && // At least one uppercase letter
                password.matches(".*[a-z].*") && // At least one lowercase letter
                password.matches(".*[0-9].*") && // At least one digit
                password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"); // At least one special character
    }
}