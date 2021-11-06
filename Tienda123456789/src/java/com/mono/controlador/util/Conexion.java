package com.mono.controlador.util;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    private Connection conexion;
    private String usuarioBD="root";
    private String claveBD="";
    private String nombreBD="tienda3";
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nombreBD,usuarioBD,claveBD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
    public void cerrar(){
        try {
            getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
