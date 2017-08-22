/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class Usuario {
    
    //Atributos
    private String usuario;
    private String password;
    private boolean estado;
    private String identificacion;

    //Constructor
    public Usuario(String usuario, String password, boolean estado, String identificacion) {
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.identificacion = identificacion;
    }

    //Getters para los atributos de la clase ***********************************************
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public boolean getEstado() {
        return estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    //**************************************************************************************
    
    //Setters para los atributos de la clase ***********************************************
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    //**************************************************************************************
    
}
