package com.cityzen.auth.service;

import com.cityzen.auth.dto.*;
import com.cityzen.auth.entity.ForgotPasswordToken;
import com.cityzen.auth.entity.User;
import com.cityzen.auth.enums.Role;
import com.cityzen.auth.exception.CustomException;
import com.cityzen.auth.repository.AadhaarRegistryRepository;
import com.cityzen.auth.repository.ForgotPasswordTokenRepository;
import com.cityzen.auth.repository.UserRepository;
import com.cityzen.auth.util.JwtUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ForgotPasswordTokenRepository forgotPasswordTokenRepository;

    @Autowired
    private AadhaarRegistryRepository aadhaarRegistryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmailService emailService;

    private boolean isValidPassword(String password) {
        return password != null &&
                password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&]).{8,}$");
    }

    @Override
    public boolean verifyAadhaar(String aadhaar) {
        return aadhaarRegistryRepository.findByAadhaarNumber(aadhaar).isPresent();
    }

    @Override
    public void signup(SignUpRequest request) {
        if (!isValidPassword(request.getPassword())) {
            throw new CustomException("Password must be at least 8 characters long and contain uppercase, lowercase, digit, and special character", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException("Email already in use", HttpStatus.CONFLICT);
        }

        if (userRepository.findByAadhaar(request.getAadhaar()).isPresent()) {
            throw new CustomException("Aadhaar already registered", HttpStatus.CONFLICT);
        }

        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAadhaar(request.getAadhaar());
        user.setRole(Role.CITIZEN);

        userRepository.save(user);
    }

    @Override
    public JwtResponse signin(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("User not found with email: " + request.getEmail(), HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException("Invalid password", HttpStatus.UNAUTHORIZED);
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new JwtResponse(
                token,
                user.getRole().name(),
                user.getEmail(),
                System.currentTimeMillis() + 3600000
        );
    }

    @Override
    public JwtResponse generateJwtResponse(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("User not found with email: " + email, HttpStatus.NOT_FOUND));

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new JwtResponse(
                token,
                user.getRole().name(),
                user.getEmail(),
                System.currentTimeMillis() + 3600000
        );
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("User not found with email: " + request.getEmail(), HttpStatus.NOT_FOUND));

        String token = UUID.randomUUID().toString();

        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
        forgotPasswordToken.setEmail(user.getEmail());
        forgotPasswordToken.setToken(token);
        forgotPasswordToken.setExpiryDate(LocalDateTime.now().plusHours(1));

        forgotPasswordTokenRepository.save(forgotPasswordToken);
        emailService.sendPasswordResetEmail(user.getEmail(), token);
    }

    @Override
    @Transactional
    public void resetPassword(ResetPasswordRequest request) {
        ForgotPasswordToken token = forgotPasswordTokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> new CustomException("Invalid or expired reset token", HttpStatus.BAD_REQUEST));

        if (token.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new CustomException("Reset token has expired", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByEmail(token.getEmail())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        if (!isValidPassword(request.getNewPassword())) {
            throw new CustomException("Password must meet security requirements", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        forgotPasswordTokenRepository.delete(token);
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new CustomException("Current password is incorrect", HttpStatus.UNAUTHORIZED);
        }

        if (!isValidPassword(request.getNewPassword())) {
            throw new CustomException("New password does not meet security requirements", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}
