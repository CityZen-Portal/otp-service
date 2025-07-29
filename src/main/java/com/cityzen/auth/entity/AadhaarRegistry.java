package com.cityzen.auth.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class AadhaarRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false) // Ensure the Aadhaar number is unique and not null
    @NotBlank(message = "Aadhaar number cannot be blank")
    private String aadhaarNumber;
    // Default constructor (required by JPA)
    public AadhaarRegistry() {
    }
    // Constructor with parameters
    public AadhaarRegistry(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }
    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
    @Override
    public String toString() {
        return "AadhaarRegistry{" +
                "id=" + id +
                ", aadhaarNumber='" + aadhaarNumber + '\'' +
                '}';
    }
}