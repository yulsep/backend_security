//package com.api.security.percistance.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Permission")
//public class Permission {
//
//    // Attributes
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    @Column(name = "id_permission")
//    private Long id;
//
//    private String url;
//
//    private String metodo;
//
//    // constructors
//
//    public Permission() {
//    }
//
//    public Permission(Long id, String url, String metodo) {
//        this.id = id;
//        this.url = url;
//        this.metodo = metodo;
//    }
//
//    // getters and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getMetodo() {
//        return metodo;
//    }
//
//    public void setMetodo(String metodo) {
//        this.metodo = metodo;
//    }
//}
