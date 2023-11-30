/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.estancias.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;

/**
 *
 * @author Admin
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(generator="uuid")
    private String id;
    private String alias;
    private String correo;
    private String password;
    private Date fechaAlta;

    public Usuario() {
    }

    public Usuario(String id, String alias, String correo, String password, Date fechaAlta) {
        this.id = id;
        this.alias = alias;
        this.correo = correo;
        this.password = password;
        this.fechaAlta = fechaAlta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", alias=" + alias + ", correo=" + correo + ", password=" + password + ", fechaAlta=" + fechaAlta + '}';
    }
    
    
    
}
