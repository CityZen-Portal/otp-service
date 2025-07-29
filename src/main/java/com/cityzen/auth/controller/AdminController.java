package com.cityzen.auth.controller;
import com.cityzen.auth.dto.AddStaffRequest; // Create this DTO
import com.cityzen.auth.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/add-staff")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addStaff(@RequestBody AddStaffRequest request) {
        // TODO: Validate email format ends with staff-name123@gov.in
        // TODO: Save new staff user with default password
        return ResponseEntity.ok().build();
    }
}