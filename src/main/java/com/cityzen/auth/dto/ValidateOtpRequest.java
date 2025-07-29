package com.cityzen.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class ValidateOtpRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String otp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
