/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador;

import com.mono.controlador.util.CRUD;
import com.mono.controlador.util.Msg;
import com.mono.modelo.Empleados;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class EmpleadosC extends Empleados{
    
    private List<Empleados> empleados;
            
    @PostConstruct
    public void init(){
        empleados=new ArrayList<>();
        String sql = "SELECT * FROM Empleados";
        
        ResultSet r = CRUD.select(sql);
        try {
            while (r.next()) {
                Empleados p=new Empleados(r.getInt(1), r.getString(2));
                empleados.add(p);
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
    }
    
    public void consultaPrimaria() {
        String sql="SELECT * FROM Empleados WHERE  documento='"+getDocumento()+"'";
        ResultSet r= CRUD.select(sql);
        try {
            if(r.next()){
                setClave(r.getString(2));
            }else{
                Msg.ad("El Empleado no está registrado");
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
        
    }

    public void eliminar() {
        String sql = "DELETE FROM Empleados WHERE documento='"+getDocumento()+"'";
        String m = "Se ha eliminado el Empleados";
        Msg.msgDB(m, CRUD.DML(sql, m));
    }

    public void insertar(){
        CRUD.insert(creaO());
    }
    public void actualizar(){
        CRUD.update(creaO(),"documento='"+getDocumento()+"'");
    }
    private ArrayList<Object> creaO (){
        ArrayList<Object> o =new ArrayList<>();
        o.add(this);
        return o;
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }
    
    
}
