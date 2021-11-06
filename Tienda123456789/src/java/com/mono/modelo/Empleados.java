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
public class Empleados {
    private int documento;
    private String clave;

 public Empleados() {
    }

    public Empleados(int documento, String clave) {
        this.documento = documento;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Empleados set documento='" + documento + "', clave='" + clave + "'";
    }
    
   
}
