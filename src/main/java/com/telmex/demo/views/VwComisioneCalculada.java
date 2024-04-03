package com.telmex.demo.views;

//import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
//@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`vw_ComisionesCalculadas`")
public class VwComisioneCalculada {
    @Id
    @Column(name = "idempleadocomision")
    private Integer idEmpleadoComision;
    private Integer idEstadoCuenta;
    private BigDecimal montoPagadoConcepto;
    private BigDecimal montoEsperadoConcepto;

    private BigDecimal montoTotal;

    private String empnumero;
    private String empnombrecompleto;
    private BigInteger idEstatus;

    private String empclabeinterbancaria;

    private String empcuentabancaria;

    private String empestrategia;

    private String empestrategiaglobal;

    private String iemprfc;

    private String estatus;

    private String pagoconcepto;

    private String empleadotipo;

    private Integer idempleadotipo;

}
