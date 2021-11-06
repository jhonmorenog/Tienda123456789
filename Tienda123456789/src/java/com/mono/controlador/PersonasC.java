/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador;

import com.mono.controlador.util.CRUD;
import com.mono.controlador.util.Msg;
import com.mono.modelo.Personas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class PersonasC extends Personas {

    private List<Personas> personas;
    
    @PostConstruct
    public void init(){
        personas=new ArrayList<>();
        
        String sql = "SELECT * FROM Personas";
        
        ResultSet r = CRUD.select(sql);
        try {
            while (r.next()) {
                Personas p=new Personas(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6));
                personas.add(p);
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
    }
    
    public void consultaPrimaria() {
        String sql = "SELECT * FROM Personas WHERE documento='" + getDocumento() + "'";
        
        ResultSet r = CRUD.select(sql);
        try {
            if (r.next()) {
                setPnombre(r.getString(2));
                setSnombre(r.getString(3));
                setPapellido(r.getString(4));
                setSapellido(r.getString(5));
                setEmail(r.getString(6));
            }else{
                Msg.ad("El usuario no se encuentra registrado.");
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
        
    }
    public void consultaPnombre() {
        String sql = "SELECT * FROM Personas WHERE pnombre='" + getPnombre()+ "'";
        
        ResultSet r = CRUD.select(sql);
        try {
            if (r.next()) {
                setDocumento(r.getInt(1));
                setPnombre(r.getString(2));
                setSnombre(r.getString(3));
                setPapellido(r.getString(4));
                setSapellido(r.getString(5));
                setEmail(r.getString(6));
            }else{
                Msg.ad("El usuario no se encuentra registrado.");
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
        
    }
    public List<String> listaDocumento(String dato){
        List<String> listaDocumento=new ArrayList<>();
        ResultSet r=CRUD.select("SELECT documento FROM Personas WHERE documento like '"+dato+"%'");
        try {
            while(r.next()){
                listaDocumento.add(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonasC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDocumento;
    }
    public List<String> listaPnombre(String dato){
        List<String> listaPnombre=new ArrayList<>();
        ResultSet r=CRUD.select("SELECT pnombre FROM Personas WHERE pnombre like '"+dato+"%'");
        try {
            while(r.next()){
                listaPnombre.add(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonasC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPnombre;
    }
    public void eliminar() {
        String sql = "DELETE FROM Personas WHERE documento='" + getDocumento() + "'";
        String m = "Se ha eliminado el Persona";
        Msg.msgDB(m, CRUD.DML(sql, m));
    }
    
    public void insertar() {
        CRUD.insert(creaO());
    }

    public void actualizar() {
        CRUD.update(creaO(), "documento='" + getDocumento() + "'");
    }

    private ArrayList<Object> creaO() {
        ArrayList<Object> o = new ArrayList<>();
        o.add(this);
        return o;
    }

    public List<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Personas> personas) {
        this.personas = personas;
    }
}
