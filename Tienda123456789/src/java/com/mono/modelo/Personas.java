/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.modelo;

import java.io.Serializable;

/**
 *
 * @author Jhon Mauricio Moreno
 */
public class Personas {
      private int documento;
      private String pnombre;
      private String snombre;
      private String papellido;
      private String sapellido;
      private String email;

    public Personas() {
    }

    public Personas(int documento, String pnombre, String papellido) {
        this.documento = documento;
        this.pnombre = pnombre;
        this.papellido = papellido;
    }

    public Personas(int documento, String pnombre, String snombre, String papellido, String sapellido, String email) {
        this.documento = documento;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.papellido = papellido;
        this.sapellido = sapellido;
        this.email = email;
    }
    
    
    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     
    @Override
    public String toString() {
        return "Personas set  documento='" + documento + "', pnombre='" + pnombre + "', snombre='" + snombre + "', papellido='" + papellido + "', sapellido='" + sapellido + "', email='" + email+"'" ;
    }


   
    
}
