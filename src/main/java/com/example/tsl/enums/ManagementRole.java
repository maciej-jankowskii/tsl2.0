package com.example.tsl.enums;

import lombok.Getter;

@Getter
public enum ManagementRole {
    BRANCH_MANAGER("Kierownik oddziału"),
    REGIONAL_MANAGER("Kierownik regionalny"),
    DIRECTOR("Generalny dyrektor");
    private final String description;

    ManagementRole(String description) {
        this.description = description;
    }
}
