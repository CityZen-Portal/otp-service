package com.cityzen.auth.service;

import com.cityzen.auth.exception.CustomException;
import com.cityzen.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    @Autowired
    private UserRepository userRepository;

    private static final int OTP_EXPIRY_MINUTES = 10;

    private static class OtpEntry {
        private final String otp;
        private final LocalDateTime expiryTime;

        public OtpEntry(String otp, LocalDateTime expiryTime) {
            this.otp = otp;
            this.expiryTime = expiryTime;
        }

        public String getOtp() {
            return otp;
        }

        public LocalDateTime getExpiryTime() {
            return expiryTime;
        }
    }

    private final ConcurrentHashMap<String, OtpEntry> otpMap = new ConcurrentHashMap<>();

    public String generateOtp(String email) {


        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(OTP_EXPIRY_MINUTES);
        otpMap.put(email, new OtpEntry(otp, expiry));

        System.out.println("Generated OTP for " + email + ": " + otp);
        return otp;


    }

    public String resendOtp(String email) {
        String otp = generateOtp(email);
        System.out.println("Resent OTP for " + email + ": " + otp);
        return otp;
    }

    public boolean validateOtp(String email, String otp) {
        OtpEntry entry = otpMap.get(email);
        if (entry == null) return false;
        if (LocalDateTime.now().isAfter(entry.getExpiryTime())) {
            otpMap.remove(email);
            return false;
        }
        return entry.getOtp().equals(otp);
    }
}
