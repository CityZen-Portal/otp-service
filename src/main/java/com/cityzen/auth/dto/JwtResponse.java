package com.cityzen.auth.dto;
public class JwtResponse {
    private String jwtToken;
    private String role;
    private String email;
    private long expiresAt;
    public JwtResponse(String jwtToken, String role, String email, long expiresAt) {
        this.jwtToken = jwtToken;
        this.role = role;
        this.email = email;
        this.expiresAt = expiresAt;
    }
    // Getters and Setters
    public String getJwtToken() {
        return jwtToken;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }
}