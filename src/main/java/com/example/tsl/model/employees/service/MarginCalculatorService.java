package com.example.tsl.model.employees.service;

public class MarginCalculatorService implements MarginCalculator{

    private static final Double TOTAL_MARGIN_1_LVL = 3000.0;
    private static final Double TOTAL_MARGIN_2_LVL = 4000.0;
    private static final Double TOTAL_MARGIN_3_LVL = 5000.0;
    private static final Double TOTAL_MARGIN_4_LVL = 6000.0;
    @Override
    public Double calculateExtraPercentage(Double totalMargin) {
        if (totalMargin > TOTAL_MARGIN_1_LVL){
            return 0.20;
        } else if (totalMargin > TOTAL_MARGIN_2_LVL) {
            return 0.24;
        } else if (totalMargin > TOTAL_MARGIN_3_LVL) {
            return 0.32;
        } else if (totalMargin > TOTAL_MARGIN_4_LVL){
            return 0.36;
        } else {
            return 0.0;
        }
    }
}
