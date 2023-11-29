package com.example.tsl.exceptions;

public class WarehouseNotFoundException extends  RuntimeException{
    public WarehouseNotFoundException(String message) {
        super(message);
    }
}
