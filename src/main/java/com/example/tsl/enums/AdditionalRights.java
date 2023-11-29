package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum AdditionalRights {
    ADR("ADR"),
    LARGE_SCALE_TRANSPORT("Transport ponad-gabarytowy");

    private String description;

    AdditionalRights(String description) {
        this.description = description;
    }
}
