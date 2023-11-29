package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum PaymentsRating {
    PAYMENTS_ON_TIME("Płatności na czas"),
    SMALL_DELAYS("Małe opóźnienia"),
    LONG_DELAYS("Duże opóźnienia"),
    BLACK_LIST("Zablokowany");

    private String description;

    PaymentsRating(String description) {
        this.description = description;
    }
}
