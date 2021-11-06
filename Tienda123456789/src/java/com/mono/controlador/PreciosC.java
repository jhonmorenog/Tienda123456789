/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador;

import com.mono.controlador.util.CRUD;
import com.mono.controlador.util.Msg;
import com.mono.modelo.Precios;
import com.mono.modelo.Productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jhon Mauricio Moreno
 */
@Named
@RequestScoped
public class PreciosC extends Precios {

   

    public void consultaPrimaria() {
        String sql = "SELECT * FROM Precios WHERE cb='" + getCb()+ "' and fechaini='"+getFechaIni()+"'";
        System.err.println(sql);
        ResultSet r = CRUD.select(sql);
        try {
            if (r.next()) {
                setCb(r.getString(1));
                Date f=r.getTimestamp(2);
                LocalDate l=f.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                setFechaIni(l);
                f=r.getTimestamp(3);
                l=f.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                setFechaFin(l);
                setPrecio(r.getDouble(4));
            }else{
                Msg.ad("La factura no se encuentra registrado.");
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
    }

    public void eliminar() {
        String sql = "DELETE FROM Precios WHERE cb='" + getCb() + "' and fechaini='" + getFechaIni() + "'";
        String m = "Se ha eliminado el precio";
        Msg.msgDB(m, CRUD.DML(sql, m));
    }

    public void insertar() {
        //System.err.println(creaO());
        CRUD.insert(creaO());
    }

    public void actualizar() {
        CRUD.update(creaO(), "cb='" + getCb() + "' and fechaini='" + getFechaIni() + "'");
    }

    private ArrayList<Object> creaO() {
        ArrayList<Object> o = new ArrayList<>();
        o.add(this);
        return o;
    }
}
