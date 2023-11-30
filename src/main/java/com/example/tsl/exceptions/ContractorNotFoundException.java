package com.example.tsl.exceptions;

public class ContractorNotFoundException extends RuntimeException{
    public ContractorNotFoundException(String message) {
        super(message);
    }
}
