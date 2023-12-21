package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tiposervicio")
public class TipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer idTipoServicio;
    private String tipoServicio;
}
