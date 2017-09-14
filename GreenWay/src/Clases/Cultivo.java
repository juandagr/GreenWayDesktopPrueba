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
public class Cultivo {
    
    //Atributos
    private String identificador;
    private String nombre;
    private String descripcion;
    
    //Constructor

    public Cultivo(String identificador, String nombre, String descripcion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    //Getters para los atributos de la clase ***********************************************

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    //**************************************************************************************
    
    //Setters para los atributos de la clase ***********************************************

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
