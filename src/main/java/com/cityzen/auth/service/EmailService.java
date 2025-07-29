package com.cityzen.auth.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    public void sendPasswordResetEmail(String email, String token) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be null or empty");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText("To reset your password, click the link: " +
                "http://localhost:8080/reset-password?token=" + token);

        emailSender.send(message);
    }
    public void sendOtp(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        emailSender.send(message);
    }
}