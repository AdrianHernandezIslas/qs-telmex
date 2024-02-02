package com.telmex.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String velocidad;
	@NotNull
	private String paquete;
	@Min(value = 0)
	private Double renta;
	@Min(value = 0)
	private Double posteo;
	@Min(value = 0)
	private Double navegacion;
	@Min(value = 0)
	private Double pagoCliente;
	@Min(value = 0)
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
