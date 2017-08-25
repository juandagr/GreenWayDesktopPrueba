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
public class Empleado {
    
    //Atributos
    private String nombre;
    private String apellido;
    private String identificacion;
    private String cargo;
    private String telefono;
    private String direccion;
    private boolean estado;
    private String fotografia;
    private String correo;
    private Date fechaDeNacimiento;
    private String estado_civil;

    //Constructor
    public Empleado(String nombre, String apellido, String identificacion, String cargo, String telefono, String direccion, boolean estado, String fotografia, String correo, Date fechaDeNacimiento, String estado_civil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.fotografia = fotografia;
        this.correo = correo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado_civil = estado_civil;
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

    public String getCargo() {
        return cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getFotografia() {
        return fotografia;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getEstado_civil() {
        return estado_civil;
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

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
    //**************************************************************************************
    
    //metodo para verificar que el cargo sea correcto
    public boolean verificarCargo(){
        boolean verificacion = false;
        if (this.cargo.equalsIgnoreCase("Gerente") || this.cargo.equalsIgnoreCase("Administrador") 
                || this.cargo.equalsIgnoreCase("Digitador")) {
            verificacion = true;
        }
        return verificacion;
    }
    
    //metodo para verificar que el estado civil sea correcto
    public boolean verificarEstadoCivil(){
        boolean verificacion = false;
        if (this.cargo.equalsIgnoreCase("soltero") || this.cargo.equalsIgnoreCase("casado") 
                || this.cargo.equalsIgnoreCase("viudo") || this.cargo.equalsIgnoreCase("divorciado")) {
            verificacion = true;
        }
        return verificacion;
    }
}
