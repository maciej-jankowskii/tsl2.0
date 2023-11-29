package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum FormOfEmployment {
    CONTRACT_OF_EMPLOYMENT("Umowa o prace"),
    B2B("Kontrakt B2b"),
    MANDATE_CONTRACT("Umowa zlecenie");

    private String description;

    FormOfEmployment(String description) {
        this.description = description;
    }
}
