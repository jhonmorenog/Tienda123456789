/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mono.controlador.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jhon Mauricio Moreno
 */
public class Msg {
    /**
     * Método solo para las funciones de CRUD
     * @param msg
     * @param m 
     */
    public static void msgDB(String msg, String m) {
        if (msg.equals(m)) {
            Msg.addMessage(FacesMessage.SEVERITY_INFO, "Info", m);
        } else {
            Msg.addMessage(FacesMessage.SEVERITY_ERROR, "Error", m);
        }
    }
    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    public static void error(String msg){
         Msg.addMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
    }
    public static void ad(String msg){
         Msg.addMessage(FacesMessage.SEVERITY_WARN, "ojo", msg);
    }
}
