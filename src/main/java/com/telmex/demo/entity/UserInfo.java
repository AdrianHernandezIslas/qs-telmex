package com.telmex.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adm_usuario")
public class UserInfo extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long idUser;
    @Column(name = "usuario", unique = true, nullable = false)
    private String username;
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "adm_usuariorol",
            joinColumns = {
                    @JoinColumn(name = "id_usuario")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_rol")
            }
    )
    private Set<UserRole> roles;
    @ManyToOne
    @JoinColumn(name = "idempleado", nullable = false)
    private Empleado empleado;
}