package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RHM_EMPLEADOTIPO")
public class TipoEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEMPLEADOTIPO")
    private Integer idTipoEmpleado;
    @Column(name = "EMPLEADOTIPO")
    private String tipoEmpleado;
}
