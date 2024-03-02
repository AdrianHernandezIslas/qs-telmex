package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telmex.demo.enums.PrioridadNotificacionEnum;
import com.telmex.demo.enums.TipoNotificacionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adm_notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long idNotificacion;
    private String titulo;
    private String descripcion;
    private boolean leido;
    private Date fechaCreacion;
    @Enumerated(EnumType.ORDINAL)
    private TipoNotificacionEnum tipo;
    @Enumerated(EnumType.ORDINAL)
    private PrioridadNotificacionEnum prioridad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore()
    private UserInfo usuario;
}
