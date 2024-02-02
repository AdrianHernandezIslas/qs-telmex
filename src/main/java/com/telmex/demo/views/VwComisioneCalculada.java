package com.telmex.demo.views;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vw_ComisionesCalculadas")
public class VwComisioneCalculada {
    @Id
    @Column
    private Integer idEmpleadoComision;
    private Double montoPagadoConcepto;
    private Double montoEsperadoConcepto;

    private Double montoTotal;

    private String empnumero;
    private String empnombrecompleto;
    private Integer idEstatus;

    private String empclabeinterbancaria;

    private String cuentabancaria;

    private String empestrategia;

    private String empestrategiaglobal;

    private String iemprfc;

    private String estatus;

    private String pagoconcepto;

}
