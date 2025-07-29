package com.cityzen.auth.exception;
public class OTPMismatchException extends RuntimeException {
    public OTPMismatchException(String message) {
        super(message);
    }
}