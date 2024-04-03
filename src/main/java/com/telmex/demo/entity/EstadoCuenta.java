package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LYT_ESTADOCUENTA")
public class EstadoCuenta extends BaseObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer idEstadoCuenta;
    private String estadoCuenta;
    private String nombreArchivo;
    @ManyToOne
    @JoinColumn(name = "idEstatusCarga", nullable = false)
    private EstatusCarga estatusCarga;

    private BigInteger totalRegistros;
    private BigDecimal montoTotal;
    private BigDecimal montoPosteo;
    private BigDecimal montoNavegacion;
    private BigDecimal montoCliente;
    private BigDecimal montoChargeBk;
    private BigDecimal montoOtros;
}
