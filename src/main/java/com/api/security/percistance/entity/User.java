package com.api.security.percistance.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
    @Table(name = "user")
    public class User implements UserDetails {

        // Attributes
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        @Column(name = "id_user")
        private Long id;

        private String username;




        @Column(name = "email", unique = true, nullable = false)
        private String email;

        private String password;

         @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
         // anotacion para evitar la serializacion infinita entre relaciones bidireccionales JSON
         @JsonIgnore
         private Set<UserRol> userRoles = new HashSet<>();



        // constructors

        public User() {
        }

        public User(Long id, String username,  String email, String password) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
        }


        // getters and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }


    //-------------------- Begin UserDetails methods --------------------


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        this.userRoles.forEach(userRol ->
                authorities.add(new Authority(userRol.getRol().getName())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    //-------------------- End UserDetails methods --------------------

}

