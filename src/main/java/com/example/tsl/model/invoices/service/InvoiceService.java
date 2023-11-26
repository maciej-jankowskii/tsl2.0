package com.example.tsl.model.invoices.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InvoiceService {
    private final VatCalculatorService vatCalculatorService;

    public InvoiceService(VatCalculatorService vatCalculatorService) {
        this.vatCalculatorService = vatCalculatorService;
    }

    public BigDecimal calculateBrutto(BigDecimal nettoValue, String vatNumber) {
        return vatCalculatorService.calculateBrutto(nettoValue, vatNumber);
    }
}
