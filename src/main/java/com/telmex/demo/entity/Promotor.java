package com.telmex.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "Promotor")
public class Promotor {

	@Id
	private String clave;
	private String nombre;
}
