package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pag_pagoconcepto")
public class PagoConcepto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpagoconcepto")
    private Integer idPagoConcepto;
    @Column(name = "pagoconcepto")
    private String pagoConcepto;
    @Column(name = "columnaorigenmonto")
    private String origenMonto;
    private Integer activo;
}
