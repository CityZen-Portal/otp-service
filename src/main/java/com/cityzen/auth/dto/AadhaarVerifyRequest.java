package com.cityzen.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class AadhaarVerifyRequest {
    @NotBlank
    private String aadhaar;
    @Email
    @NotBlank
    private String email; // Add email field
    // Getters and Setters
    public String getAadhaar() {
        return aadhaar; // Return the actual Aadhaar number
    }
    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
}
