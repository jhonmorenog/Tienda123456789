/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

/**
 * Clase que permite gestionar los querys con la base de datos
 *
 * @author Jhon Mauricio Moreno
 */
public class CRUD {

    /**
     * Método encargado de ejecutar el query en la base de datos y devolver un
     * mensaje de error si existe
     *
     * @param sql
     * @param msg
     * @return msg
     */
    public static String DML(String sql, String msg) {

        Conexion conexion = new Conexion();
        try {
            Statement s = conexion.getConexion().createStatement();
            s.execute(sql);
        } catch (SQLException ex) {
            msg = ex.getMessage();
        }
        conexion.cerrar();

        return msg;
    }

    /**
     * Método que realiza consultas SELECT
     *
     * @param sql
     * @return ResultSet
     */
    public static ResultSet select(String sql) {
        ResultSet r = null;
        Conexion conexion = new Conexion();
        Statement s;
        try {
            s = conexion.getConexion().createStatement();
            r = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }
/**
 * Método que genera el query de Insert apartir del toStinrg del objeto, Debe editar el toString del objeto.
 * (NombreObjeto SET columna='"+getter+"' .....)
 * @param o 
 */
    public static void insert(ArrayList<Object> o) {
        String msg = "Se han guardado los datos.";

        System.err.println(gestionSQL(o));
        String m = DML("INSERT INTO " + gestionSQL(o), msg);
        Msg.msgDB(msg, m);

    }
/**
 *  Método que genera el query de Update apartir del toStinrg del objeto, Debe editar el toString del objeto.
 * (NombreObjeto SET columna='"+getter+"' .....)
 * @param o
 * @param where 
 */
    public static void update(ArrayList<Object> o, String where) {
        String msg = "Se han actualizado los datos.";
        String m = DML("UPDATE  " + gestionSQL(o) + " WHERE " + where, msg);
        Msg.msgDB(msg, m);
    }

    private static String gestionSQL(ArrayList<Object> o) {
        String sql = o.toString();
        sql = sql.replace("[", "");
        sql = sql.replace("]", "");
        return sql;
    }

    
}
