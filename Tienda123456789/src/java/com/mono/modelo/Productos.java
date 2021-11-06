/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.modelo;

/**
 *
 * @author Jhon Mauricio Moreno
 */
public class Productos {
    private String cb;
    private String nombre;
    private String descripcion;

    public Productos() {
    }

    public Productos(String cb, String nombre) {
        this.cb = cb;
        this.nombre = nombre;
    }

    public Productos(String cb, String nombre, String descripcion) {
        this.cb = cb;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Productos set  cb='" + cb + "', nombre='" + nombre + "', descripcion='" + descripcion + "'";
    }
    
    
}
