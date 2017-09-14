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
public class Ubicacion {
    //Atributos
    private String id_ubicacion;
    private String departamento;
    private String municipio;
    private String vereda;
    
    //Constructor
    public Ubicacion(String id_ubicacion, String departamento, String municipio, String vereda) {
        this.id_ubicacion = id_ubicacion;
        this.departamento = departamento;
        this.municipio = municipio;
        this.vereda = vereda;
    }   
    
    //Getters para los atributos de la clase ***********************************************
    public String getId_ubicacion() {
        return id_ubicacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getVereda() {
        return vereda;
    }    
    
    //**************************************************************************************
    
    //Setters para los atributos de la clase ***********************************************
    public void setId_ubicacion(String id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setVereda(String vereda) {
        this.vereda = vereda;
    }

    

    

    
}
