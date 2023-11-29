package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum TypeOfGoods {
    NEUTRAL_GOODS_ON_PALLETS("Neutralny na paletach"),
    BULK_GOODS("Towar sypki"),
    REFRIGERATED_GOODS("Towar chłodniczy"),
    ADR_GOODS("ADR"),
    HIGH_VALUE_GOODS("Wysoka wartość"),
    CARTONS("Kartony/skrzynie");

    private String description;

    TypeOfGoods(String description) {
        this.description = description;
    }
}
