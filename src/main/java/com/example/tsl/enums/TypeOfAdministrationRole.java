package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum TypeOfAdministrationRole {
    DEBT_COLLECTION("Dział windykacji"),
    INVOICES("Faktury"),
    PAYMENTS("Płatności");

    private String description;

    TypeOfAdministrationRole(String description) {
        this.description = description;
    }
}
