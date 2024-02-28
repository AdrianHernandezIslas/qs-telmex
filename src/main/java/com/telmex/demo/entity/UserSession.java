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
@Table(name = "session")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idSesion;
    private String ip;
    private Date fechaCreacion;
    private Date fechaFin;
    private Integer activa;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private UserInfo usuario;
}
