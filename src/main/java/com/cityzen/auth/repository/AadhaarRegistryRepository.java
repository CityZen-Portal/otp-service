package com.cityzen.auth.repository;

import com.cityzen.auth.entity.AadhaarRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AadhaarRegistryRepository extends JpaRepository<AadhaarRegistry, Long> {

    Optional<AadhaarRegistry> findByAadhaarNumber(String aadhaarNumber);

    boolean existsByAadhaarNumber(String aadhaarNumber); // ✅ Add this for duplicate check
}
