package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LYT_ESTADOCUENTA")
public class EstadoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer idEstadoCuenta;
    private String estadoCuenta;
    private String nombreArchivo;
    @ManyToOne
    @JoinColumn(name = "idEstatusCarga", nullable = false)
    private EstatusCarga estatusCarga;

    //@OneToMany(mappedBy = "estadoCuenta")
    //private Set<EstadoCuentaDetalle> detalleCuenta;
}
