package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adm_rol")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private long idRole;
    @Column(name = "rol")
    private String name;
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "rol")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<UserPermission> permissions;
}
