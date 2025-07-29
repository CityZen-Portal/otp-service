package com.cityzen.auth.service;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
    public boolean validateAdminCredentials(String email, String password) {
        // TODO: Handle hardcoded admin login validation
        return false; // Placeholder
    }
    public void addStaff(String email, String password) {
        // TODO: Logic to save new staff with default password
    }
}