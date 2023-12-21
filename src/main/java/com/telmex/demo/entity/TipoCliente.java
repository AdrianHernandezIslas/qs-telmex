package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipocliente")
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer idTipoCliente;
    private String tipoCliente;
}
