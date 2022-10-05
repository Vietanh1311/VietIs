package com.example.baitapvietis.model.entity;

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
@Table(name = "antenna")
public class AntennaEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "warehouse_id")
    private Long wareHouseId;
    @Column(name = "reader_id")
    private Long readerId;
    @Column(name = "port_no")
    private String portNo;
    @Column(name = "shelf_id")
    private Long shelfId;
    @Column(name = "stage_number")
    private int stageNumber;
}
