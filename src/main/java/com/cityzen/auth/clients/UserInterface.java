package com.cityzen.auth.clients;


import com.cityzen.auth.dto.ApiResponse;
import com.cityzen.auth.dto.TokenResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "UserManagementService", url = "https://auth-backend-cpcr.onrender.com")
//@FeignClient(name = "UserManagementService", url = "http://localhost:7000")
public interface UserInterface {
    @GetMapping("/api/auth/validate")
     ResponseEntity<TokenResponseDto> validateUser(@RequestHeader("token")  String token);
    @GetMapping("/api/auth/checkUser/{email}")
     ResponseEntity<ApiResponse<Boolean>>  checkUser(@PathVariable("email") String emailId);
}
