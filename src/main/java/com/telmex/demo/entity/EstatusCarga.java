package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LYTESTADOCUENTASTATUS")
public class EstatusCarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer idEstatusCarga;
    private String estatusCarga;
}
