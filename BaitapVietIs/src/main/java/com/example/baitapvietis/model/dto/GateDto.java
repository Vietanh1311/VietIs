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
public class GateDto {
    private Long id;
    private Long wareHouseId;
    private String name;
    private String ipadress;
}
