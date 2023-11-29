package com.example.tsl.controller;

import com.example.tsl.exceptions.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientWarehouseSpaceException.class)
    public String handleInsufficientWarehouseSpaceException(InsufficientWarehouseSpaceException ex) {
        return "errors/warehouse-space-error";
    }

    @ExceptionHandler(WarehouseNotFoundException.class)
    public String handleWarehouseNotFoundException(WarehouseNotFoundException ex) {
        return "errors/warehouse-not-found";
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return "errors/warehouse-not-found";
    }

    @ExceptionHandler(IncompatibleGoodsTypeException.class)
    public String handleIncompatibleGoodsTypeException(IncompatibleGoodsTypeException ex) {
        return "errors/incompatible-type";
    }

    @ExceptionHandler(NoGoodsSelectedException.class)
    public String handleNoGoodsSelectedException(NoGoodsSelectedException ex) {
        return "errors/no-selected-goods";
    }

    @ExceptionHandler(NonUniqueLabelsException.class)
    public String handleNonUniqueLabelsException(NonUniqueLabelsException ex) {
        return "errors/non-unique-label";
    }
}
