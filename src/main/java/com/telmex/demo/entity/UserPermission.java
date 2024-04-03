package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adm_rolfuncion")
public class UserPermission {
    @EmbeddedId
    @JsonIgnore
    private PermissionKey id;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "id_rol")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private UserRole rol;

    @ManyToOne
    @MapsId("idFuncion")
    @JoinColumn(name = "id_funcion")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private UserFunction function;

    private Boolean create;
    private Boolean update;
    private Boolean delete;
    private Boolean read;
}
