package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rhm_empleado_cuentabanco")
public class DatoBancarioEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado_cuenta")
    private Long idEmpleadoCuenta;
    @Column(name = "ECBBANCO")
    @NotNull
    private String nombreBanco;
    @Column(name = "ECBCLABEINTERBANCARIA")
    @NotNull
    private String clabeInterbancaria;
    @NotNull
    @Column(name = "ECBCUENTABANCARIA")
    private String cuentaBancaria;

    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name="idempleado", nullable=false)
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //private Empleado empleado;

}
