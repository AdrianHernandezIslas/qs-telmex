package com.telmex.demo.model;

import lombok.Data;

@Data
public class Chargeback {
	private String clave;
	private String nombrePromotor;
	private Double anticipo;
	private Double montoDescuento;

}
