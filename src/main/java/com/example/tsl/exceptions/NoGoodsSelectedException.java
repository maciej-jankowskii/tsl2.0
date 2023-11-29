package com.example.tsl.exceptions;

public class NoGoodsSelectedException extends RuntimeException {
    public NoGoodsSelectedException(String message) {
        super(message);
    }
}
