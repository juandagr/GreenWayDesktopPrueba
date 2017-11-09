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
public class HistoriaClinica {
    
    //Atributos
    private String Lote_identificador;
    private String anio;
    private String semana;
    private String dia;
    private String descripcion;
    

    //Constructor
    public HistoriaClinica(String Lote_identificador, String anio, String semana, String dia, String descripcion) {    
        this.Lote_identificador = Lote_identificador;
        this.anio = anio;
        this.semana = semana;
        this.dia = dia;
        this.descripcion = descripcion;
    }

    //Getters para los atributos de la clase ***********************************************

    public String getLote_identificador() {
        return Lote_identificador;
    }

    public String getAnio() {
        return anio;
    }

    public String getSemana() {
        return semana;
    }

    public String getDia() {
        return dia;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
   
    //**************************************************************************************
    
    //Setters para los atributos de la clase ***********************************************

    public void setLote_identificador(String Lote_identificador) {
        this.Lote_identificador = Lote_identificador;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    
}
