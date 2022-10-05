package com.example.baitapvietis.model.dto;

import com.example.baitapvietis.constants.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private RolesEnum position;
    private String name;
    private String DateOfBirth;
}
