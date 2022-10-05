package com.example.baitapvietis.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "reader")
public class ReaderEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "warehouse_id")
    private Long wareHouseId;
    @Column(name = "ipaddress")
    private String ipaddess;
    @Column(name = "address")
    private String adress;

}
