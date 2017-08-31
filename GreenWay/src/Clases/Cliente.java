/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Cliente {
    
    //Atributos
    private String nombre;
    private String apellido;
    private String identificacion;
    private String telefono;
    private String direccion;
    private boolean estado;
    private String correo;
    private String fotografia;

    //Constructor
    public Cliente(String nombre, String apellido, String identificacion, String telefono, String direccion, boolean estado, String correo, String fotografia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.correo = correo;
        this.fotografia = fotografia;
        
    }

    //Getters para los atributos de la clase ***********************************************
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public String getFotografia() {
        return fotografia;
    }

   
    //**************************************************************************************
    
    //Setters para los atributos de la clase ***********************************************
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }


    
}
