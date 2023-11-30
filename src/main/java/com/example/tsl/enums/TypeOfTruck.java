package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum TypeOfTruck {
    BOX("Standardowa skrzynia"),
    FRIGO("Standowa chłodnia"),
    FLATBED("Standardowa platforma"),
    TAUTLINER("Standard firanka/plandeka"),
    MEGA("Naczepa mega 3m"),
    TANKER("Standardowa cysterna"),
    TIPPER("Standardowa wywrotka"),
    ROAD_TRAIN("Standardowy zestaw 7,7 + 7,7m");

    private final String description;

    TypeOfTruck(String description) {
        this.description = description;
    }
}
