package com.example.tsl.exceptions;

public class IncompatibleGoodsTypeException extends RuntimeException {
    public IncompatibleGoodsTypeException(String message) {
        super(message);
    }
}
