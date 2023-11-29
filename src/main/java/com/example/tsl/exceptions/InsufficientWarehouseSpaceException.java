package com.example.tsl.exceptions;

public class InsufficientWarehouseSpaceException extends RuntimeException{
    public InsufficientWarehouseSpaceException(String message) {
        super(message);
    }
}
