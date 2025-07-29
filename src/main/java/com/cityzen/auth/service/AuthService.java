package com.cityzen.auth.service;

import com.cityzen.auth.dto.*;

import org.springframework.security.core.Authentication;

public interface AuthService {
    boolean verifyAadhaar(String aadhaar);
    void signup(SignUpRequest request);
    JwtResponse signin(SignInRequest request);
    JwtResponse generateJwtResponse(Authentication authentication);
    void forgotPassword(ForgotPasswordRequest request);
    void resetPassword(ResetPasswordRequest request);
    void changePassword(ChangePasswordRequest request);

    // Already added:
   // boolean validateOtp(String email, String otp);
}
