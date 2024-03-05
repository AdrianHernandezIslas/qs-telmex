package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adm_funcion")
public class UserFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncion;
    private String funcion;
    private Long orden;
    @OneToMany(mappedBy = "function")
    private Set<UserPermission> permissions;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private UserCategory categoria;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "adm_funcion_path",
            joinColumns = {
                    @JoinColumn(name = "id_funcion")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_path")
            }
    )
    private Set<UserPath> paths;
}
