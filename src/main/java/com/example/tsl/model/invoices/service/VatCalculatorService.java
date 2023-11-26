package com.example.tsl.model.invoices.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VatCalculatorService implements VatCalculator {
    private static final BigDecimal VAT_RATE_POLAND = new BigDecimal("0.23");

    @Override
    public BigDecimal calculateBrutto(BigDecimal nettoValue, String vatNumber) {
        if (vatNumber != null && vatNumber.startsWith("PL")) {
            return nettoValue.multiply(VAT_RATE_POLAND.add(BigDecimal.ONE));
        } else {
            return nettoValue;
        }
    }
}
