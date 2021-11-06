/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador;

import com.mono.modelo.Fotos;
import java.util.ArrayList;
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
public class FotosC extends Fotos{
    private List<Fotos> fotos;
    
    @PostConstruct
    public void init(){
        fotos=new ArrayList<>();
        for(int i=0;i<5;i++){
            Fotos f=new Fotos(i, "Campo verde", i+".png", i+"");
            fotos.add(f);
        }
    }
    

    public List<Fotos> getFotos() {
        return fotos;
    }

    public void setFotos(List<Fotos> fotos) {
        this.fotos = fotos;
    }
}
