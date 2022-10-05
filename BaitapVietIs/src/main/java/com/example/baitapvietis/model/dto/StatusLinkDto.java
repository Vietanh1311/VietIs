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
public class StatusLinkDto {
    private Long id;
    private String name;
    private Long atenId;
    private Long wareHouseId;
    private String wareHouseName;
    private Long portId;
    private Long classificationId;
    private Long readerId;
}
