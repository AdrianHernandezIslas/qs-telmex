package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aud_sesion")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long idSesion;
    private String ip;
    @Column(name = "fecha_inicio")
    private Date fechaCreacion;
    private Date fechaFin;
    private Integer activa;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserInfo usuario;
}
