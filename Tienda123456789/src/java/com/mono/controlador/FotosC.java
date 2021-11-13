/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador;

import com.mono.controlador.util.CRUD;
import com.mono.controlador.util.Msg;
import com.mono.modelo.Fotos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author Jhon Mauricio Moreno
 */
@Named
@RequestScoped
public class FotosC extends Fotos {

    private String destination;
    private List<Fotos> fotos;
    private UploadedFile file;

    
    
    @PostConstruct
    public void init() {
        destination = "D:\\jhon\\Documents\\NetBeansProjects\\Tienda123456789\\Tienda123456789\\web\\resources\\img\\";
        fotos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Fotos f = new Fotos(i, "Campo verde", i + ".png", i + "");
            fotos.add(f);
        }
    }

    public void consultaPrimaria() {
        fotos.clear();
        String sql = "SELECT * FROM Fotos f INNER JOIN Productos p ON p.cb=f.productoscb  WHERE id='" + getId() + "'";
       
        ResultSet r = CRUD.select(sql);
        try {
            if (r.next()) {
                setId(r.getInt(1));
                setDescripcionFotos(r.getString(2));
                setFoto(r.getString(3));
                setProductoscb(r.getString(4));
                
                setCb(r.getString(5));
                setNombre(r.getString(6));
                setDescripcion(r.getString(7));
            } else {
                Msg.ad("La foto no se encuentra registrado.");
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
       
        
        sql = "SELECT foto, id FROM Fotos  WHERE productoscb='" + getProductoscb() + "'";
      
        r = CRUD.select(sql);
        try {
            while (r.next()) {
                Fotos n= new Fotos();
                n.setFoto(r.getString(1));
                n.setId(r.getInt(2));
                fotos.add(n);
               
            }
        } catch (SQLException ex) {
            Msg.error(ex.getMessage());
        }
        
    }

    public void eliminar() {
        String sql = "DELETE FROM Fotos WHERE id='" + getId() + "'";
        String m = "Se ha eliminado la foto";
        Msg.msgDB(m, CRUD.DML(sql, m));
    }

    public void insertar() {
        try {
            copyFile(file.getFileName(), file.getInputStream());
            setFoto(file.getFileName());
            CRUD.insert(creaO());
        } catch (IOException ex) {
            Msg.error(ex.getMessage());
        }

    }

    public void actualizar() {
        try {
            copyFile(file.getFileName(), file.getInputStream());
            setFoto(file.getFileName());
            CRUD.update(creaO(), "id='" + getId() + "'");
        } catch (IOException ex) {
            Msg.error(ex.getMessage());
        }
    }

    private ArrayList<Object> creaO() {
        ArrayList<Object> o = new ArrayList<>();
        o.add(this);
        return o;
    }

    public List<Fotos> getFotos() {
        return fotos;
    }

    public void setFotos(List<Fotos> fotos) {
        this.fotos = fotos;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    private void copyFile(String fileName, InputStream inputStream) {

        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FotosC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FotosC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

}
