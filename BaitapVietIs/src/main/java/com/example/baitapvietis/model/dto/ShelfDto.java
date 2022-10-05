package com.example.baitapvietis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShelfDto {
    private Long id;
    private String name;
    private int numberOfStage;
    private Long wareHouseId;
}
