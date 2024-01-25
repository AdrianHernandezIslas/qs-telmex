package com.telmex.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lyt_comision")
public class Comision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Integer idComision;
	private String velocidad;
	private String paquete;
	private Double renta;
	private Double posteo;
	private Double navegacion;
	private Double pagoCliente;
	private Double total;
	@ManyToOne
	@JoinColumn(name = "idTipoCliente", nullable = false)
	private TipoCliente tipoCliente;
	@ManyToOne
	@JoinColumn(name = "idTipoServicio", nullable = false)
	private TipoServicio tipoServicio;
	@ManyToOne
	@JoinColumn(name = "idPorcentajeComision", nullable = false)
	private PorcentajeComision porcentajeComision;

}
