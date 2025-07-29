package com.cityzen.auth;
import com.cityzen.auth.entity.AadhaarRegistry;
import com.cityzen.auth.repository.AadhaarRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AadhaarRegistryRepository aadhaarRegistryRepository;
    @Override
    public void run(String... args) throws Exception {
        // Example Aadhaar numbers to store
//        aadhaarRegistryRepository.save(new AadhaarRegistry("123412341234"));
//        aadhaarRegistryRepository.save(new AadhaarRegistry("567856785678"));
//        aadhaarRegistryRepository.save(new AadhaarRegistry("111222333444"));
//        aadhaarRegistryRepository.save(new AadhaarRegistry("555666777888"));
//        aadhaarRegistryRepository.save(new AadhaarRegistry("432143214321"));
//        aadhaarRegistryRepository.save(new AadhaarRegistry("876587658765"));
    }
}