/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.modelo;

import java.time.LocalDate;



/**
 *
 * @author Jhon Mauricio Moreno
 */
public class Precios {
    private String cb;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private double precio;

    public Precios() {
    }

    public Precios(String cb, LocalDate fechaIni, double precio) {
        this.cb = cb;
        this.fechaIni = fechaIni;
        this.precio = precio;
    }

    public Precios(String cb, LocalDate fechaIni, LocalDate fechaFin, double precio) {
        this.cb = cb;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public LocalDate getFechaIni() {
       
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
      
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Precios set cb='" + cb + "', fechaIni='" + fechaIni + "', fechaFin='" + fechaFin + "', precio='" + precio + "'";
    }
    
}
