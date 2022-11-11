package com.api.security.percistance.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class Rol {

    // Attributes
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id_rol")
    private Long id;


    private String name;


    private String description;


    @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    private Set<UserRol> userRoles = new HashSet<>();

    // constructors

    public Rol() {
    }

    public Rol(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
