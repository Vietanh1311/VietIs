package com.example.baitapvietis.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RolesEnum {
    USER(0), ADMIN(1);
    private final int value;
}