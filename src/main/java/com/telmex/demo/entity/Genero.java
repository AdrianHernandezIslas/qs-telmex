package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RHMGENERO")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer idGenero;
    @Column()
    private String genero;
}
