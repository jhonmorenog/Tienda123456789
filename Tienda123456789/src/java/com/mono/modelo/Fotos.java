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
public class Fotos {
    private int id;
    private String descripcion;
    private String foto;
    private String productoscb;

    public Fotos() {
    }

    public Fotos(int id, String descripcion, String foto, String productoscb) {
        this.id = id;
       
        this.descripcion = descripcion;
        this.foto = foto;
        this.productoscb = productoscb;
    }

    public String getProductoscb() {
        return productoscb;
    }

    public void setProductoscb(String productoscb) {
        this.productoscb = productoscb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Fotos set id='" + id + "', descripcion='" + descripcion + "', foto='" + foto + "', productoscb='" + productoscb + "'";
    }
    
    
    
    
}
