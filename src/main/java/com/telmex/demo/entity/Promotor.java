package com.telmex.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rhm_promotor")
public class Promotor {

	@Id
	private String clave;
	private String nombre;
}
