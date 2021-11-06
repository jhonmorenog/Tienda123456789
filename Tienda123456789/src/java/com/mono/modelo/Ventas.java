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
public class Ventas {
    private int numeroF;
    private String cb;
    private int cantidad;

    public Ventas() {
    }

    public Ventas(int numeroF, String cb, int cantidad) {
        this.numeroF = numeroF;
        this.cb = cb;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroF() {
        return numeroF;
    }

    public void setNumeroF(int numeroF) {
        this.numeroF = numeroF;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    @Override
    public String toString() {
        return "Ventas set numeroF='" + numeroF + "', cb='" + cb + "', cantidad='" + cantidad + "'";
    }
    
}
