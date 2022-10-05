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
public class AntennaDto {
    private Long id;
    private Long wareHouseId;
    private Long readerId;
    private String portNo;
    private Long shelfId;
    private int stageNumber;
}
