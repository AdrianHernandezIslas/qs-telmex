package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RHMEMPLEADO")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDEMPLEADO")
    private Integer idEmpleado;
    @Column(name = "EMPNUMERO")
    private String numeroEmpleado;
    @Column(name = "EMPNOMBRECOMPLETO")
    private String nombreCompleto;
    @Column(name = "EMPBANCO")
    private String nombreBanco;
    @Column(name = "EMPCLABEINTERBANCARIA")
    private String clabeInterbancaria;
    @Column(name = "EMPCUENTABANCARIA")
    private String cuentaBancaria;
    @Column(name = "EMPSUBGRUPO")
    private String subGrupo;
    @Column(name = "EMPESTRATEGIA")
    private String estrategia;
    @Column(name = "EMPESTRATEGIAGLOBAL")
    private String estrategiaGlobal;
    @Column(name = "EMPESTATUS")
    private String estatus;
    @Column(name = "EMPFECHAINGRESO")
    private Date fechaIngreso;
    @Column(name = "EMPFECHABAJA")
    private Date fechaBaja;
    @Column(name = "EMPGENERO")
    private String genero;
    @Column(name = "IEMPRFC")
    private String rfc;
    @Column(name = "EMPFECHANACIMIENTO")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "IDEMPLEADOTIPO", nullable = false)
    private TipoEmpleado tipoEmpleado;

    @ManyToOne
    @JoinColumn(name = "idPerfil", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "idEstatus", nullable = false)
    private EstatusEmpleado estatusEmpleado;
}
