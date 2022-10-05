package com.example.baitapvietis.model.entity;

import com.example.baitapvietis.constants.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", unique = true)
    private String userName;
    @Column(name = "position")
    private RolesEnum position;
    @Column(name = "name")
    private String name;
    @Column(name = "dateofbirth")
    private String DateOfBirth;
    @Column(name = "password", nullable = true)
    private String password;
}
