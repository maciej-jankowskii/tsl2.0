package com.example.tsl.model.invoices.service;

import java.math.BigDecimal;

public interface VatCalculator {
    BigDecimal calculateBrutto(BigDecimal nettoValue, String vatNumber);
}
