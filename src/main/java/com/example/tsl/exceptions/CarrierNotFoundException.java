package com.example.tsl.exceptions;

public class CarrierNotFoundException extends RuntimeException {
    public CarrierNotFoundException(String message) {
        super(message);
    }
}
