package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LYTESTADOCUENTA")
public class EstadoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer idEstadoCuenta;
    private String estadoCuenta;
    private String nombreArchivo;

}
