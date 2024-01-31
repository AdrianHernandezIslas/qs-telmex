package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RHM_EMPLEADO")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEMPLEADO")
    private Integer idEmpleado;
    @Column(name = "EMPNUMERO")
    @NotNull
    @NotBlank
    private String numeroEmpleado;
    @Column(name = "EMPNOMBRECOMPLETO")
    @NotNull
    @NotBlank
    private String nombreCompleto;
    @Column(name = "EMPBANCO")
    @NotNull
    @NotBlank
    private String nombreBanco;
    @Column(name = "EMPCLABEINTERBANCARIA")
    @NotNull
    @NotBlank
    private String clabeInterbancaria;
    @NotNull
    @NotBlank
    @Column(name = "EMPCUENTABANCARIA")
    private String cuentaBancaria;
    @NotNull
    @NotBlank
    @Column(name = "EMPSUBGRUPO")
    private String subGrupo;
    @NotNull
    @NotBlank
    @Column(name = "EMPESTRATEGIA")
    private String estrategia;
    @NotNull
    @NotBlank
    @Column(name = "EMPESTRATEGIAGLOBAL")
    private String estrategiaGlobal;
    @NotNull
    @NotBlank
    @Column(name = "EMPFECHAINGRESO")
    private Date fechaIngreso;
    @NotNull
    @NotBlank
    @Column(name = "EMPFECHABAJA")
    private Date fechaBaja;
    @NotNull
    @NotBlank
    @Column(name = "IEMPRFC")
    private String rfc;
    @NotNull
    @NotBlank
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

    @ManyToOne
    @JoinColumn(name = "idGenero", nullable = false)
    private Genero genero;
}
