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
public class Fotos extends Productos{
    private int id;
    private String descripcionFotos;
    private String foto;
    private String productoscb;

    public Fotos() {
        id=0;
        descripcionFotos="Producto";
        foto="caja.png";
        productoscb="ABCD";
    }

    public Fotos(int id, String descripcion, String foto, String productoscb) {
        this.id = id;
       
        this.descripcionFotos = descripcion;
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


    public String getDescripcionFotos() {
        return descripcionFotos;
    }

    public void setDescripcionFotos(String descripcion) {
        this.descripcionFotos = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Fotos set id='" + id + "', descripcion='" + descripcionFotos + "', foto='" + foto + "', productoscb='" + productoscb + "'";
    }
    
    
    
    
}
