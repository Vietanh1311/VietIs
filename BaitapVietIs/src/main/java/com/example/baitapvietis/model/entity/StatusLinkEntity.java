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
@Table(name = "statuslink")
public class StatusLinkEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "anten_id")
    private Long atenId;
    @Column(name = "warehouse_id")
    private Long wareHouseId;
    @Column(name = "warehouse_name")
    private String wareHouseName;
    @Column(name = "port_id")
    private Long portId;
    @Column(name = "classification_id")
    private Long classificationId;
    @Column(name = "reader_id")
    private Long readerId;
}
