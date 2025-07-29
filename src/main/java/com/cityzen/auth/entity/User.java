package com.cityzen.auth.entity;
import com.cityzen.auth.enums.Role;
import jakarta.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName; // New field for name
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String aadhaar;  // Nullable for staff
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName; // Return the actual first name
    }
    public void setUserName(String userName) {
        this.userName = userName; // Set the first name
    }
    public String getEmail() {
        return email; // Return the actual email
    }
    public void setEmail(String email) {
        this.email = email; // Set the email
    }
    public String getPassword() {
        return password; // Return the actual password
    }
    public void setPassword(String password) {
        this.password = password; // Accepts the encoded password directly
    }
    public Role getRole() {
        return role; // Return the role
    }
    public void setRole(Role role) {
        this.role = role; // Set the role
    }
    public String getAadhaar() {
        return aadhaar; // Return the Aadhaar number
    }
    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar; // Set the Aadhaar number
    }
}