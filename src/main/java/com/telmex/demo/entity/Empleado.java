package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RHM_EMPLEADO")
public class Empleado extends BaseObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEMPLEADO")
    private Integer idEmpleado;

    @NotNull
    @Column(name = "EMPNUMERO")
    private String numeroEmpleado;
    @Column(name = "EMPNOMBRECOMPLETO")
    @NotNull
    private String nombreCompleto;

    @NotNull
    @Column(name = "EMPSUBGRUPO")
    private String subGrupo;
    @NotNull
    @Column(name = "EMPESTRATEGIA")
    private String estrategia;
    @NotNull
    @Column(name = "EMPESTRATEGIAGLOBAL")
    private String estrategiaGlobal;
    @NotNull
    @Column(name = "EMPFECHAINGRESO")
    private Date fechaIngreso;
    //@NotNull
    @Column(name = "EMPFECHABAJA")
    private Date fechaBaja;
    @NotNull
    @Column(name = "IEMPRFC")
    private String rfc;
    @NotNull
    @Column(name = "EMPFECHANACIMIENTO")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "IDEMPLEADOTIPO", nullable = false)
    private TipoEmpleado tipoEmpleado;

    @ManyToOne
    @JoinColumn(name = "idPerfil", nullable = false)
    private PerfilEmpleado perfil;

    @ManyToOne
    @JoinColumn(name = "idEstatus", nullable = false)
    private EstatusEmpleado estatusEmpleado;

    @ManyToOne
    @JoinColumn(name = "idGenero", nullable = false)
    private Genero genero;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idempleado")
    private Set<DatoBancarioEmpleado> detalleBancario;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "empleado")
    @Fetch(value= FetchMode.SELECT)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<UserInfo> usuarios;

    @Transient
    public boolean getHasUser(){
        return Optional.ofNullable(usuarios).isPresent() && !usuarios.isEmpty();
    }
}
