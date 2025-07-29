package com.cityzen.auth.service;

import com.cityzen.auth.entity.AadhaarRegistry;
import com.cityzen.auth.repository.AadhaarRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AadhaarRegistryService {

    @Autowired
    private AadhaarRegistryRepository repository;

    public String saveAadhaar(String aadhaarNumber) {
        if (repository.existsByAadhaarNumber(aadhaarNumber)) {
            return "Aadhaar already exists.";
        }

        AadhaarRegistry aadhaar = new AadhaarRegistry();
        aadhaar.setAadhaarNumber(aadhaarNumber);
        repository.save(aadhaar);

        return "Aadhaar saved successfully.";
    }
}
