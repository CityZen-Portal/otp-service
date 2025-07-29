package com.cityzen.auth.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class ForgotPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String token;
    private LocalDateTime expiryDate;
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email; // Return the actual email
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getToken() {
        return token; // Return the actual token
    }
    public void setToken(String token) {
        this.token = token;
    }
    public LocalDateTime getExpiryDate() {
        return expiryDate; // Return the actual expiry date
    }
    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}