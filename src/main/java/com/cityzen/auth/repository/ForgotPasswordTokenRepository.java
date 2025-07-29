package com.cityzen.auth.repository;
import com.cityzen.auth.entity.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface ForgotPasswordTokenRepository extends JpaRepository<ForgotPasswordToken, Long> {
    Optional<ForgotPasswordToken> findByToken(String token); // Corrected the parameter type
}