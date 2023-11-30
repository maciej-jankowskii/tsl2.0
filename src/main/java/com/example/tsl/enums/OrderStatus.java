package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ASSIGNED_TO_CARRIER("Przypisane do przewoźnika"),
    ON_LOADING("Na załadunku"),
    ON_THE_WAY_TO_UNLOADING("W drodze na rozładunek"),
    ON_UNLOADING("Na rozładunku"),
    UNLOADED("Rozładowany"),
    ENDED("Zakończone"),
    CANCELED("Anulowane");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
