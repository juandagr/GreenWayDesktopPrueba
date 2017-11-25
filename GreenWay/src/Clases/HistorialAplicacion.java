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
public class HistorialAplicacion {
    
    //Atributos
    private String Lote_identificador;
    private String id_historial;
    private String anio;
    private String semana;
    private String dia;
    private String objetivoBiologico;
    private String producto_utilizado;
    private double dosis_por_litro;
    private double volumen_utilizado;

    //Constructor

    public HistorialAplicacion(String Lote_identificador, String id_historial, String anio, String semana, String dia, String objetivoBiologico, String producto_utilizado, double dosis_por_litro, double volumen_utilizado) {
        this.Lote_identificador = Lote_identificador;
        this.id_historial = id_historial;
        this.anio = anio;
        this.semana = semana;
        this.dia = dia;
        this.objetivoBiologico = objetivoBiologico;
        this.producto_utilizado = producto_utilizado;
        this.dosis_por_litro = dosis_por_litro;
        this.volumen_utilizado = volumen_utilizado;
    }
    

    //Getters para los atributos de la clase ***********************************************

    public String getLote_identificador() {
        return Lote_identificador;
    }

    public String getId_historial() {
        return id_historial;
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

    public String getObjetivoBiologico() {
        return objetivoBiologico;
    }

    public String getProducto_utilizado() {
        return producto_utilizado;
    }

    public double getDosis_por_litro() {
        return dosis_por_litro;
    }

    public double getVolumen_utilizado() {
        return volumen_utilizado;
    }

    
    
   
    //**************************************************************************************
    
    //Setters para los atributos de la clase ***********************************************

    public void setLote_identificador(String Lote_identificador) {
        this.Lote_identificador = Lote_identificador;
    }

    public void setId_historial(String id_historial) {
        this.id_historial = id_historial;
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

    public void setObjetivoBiologico(String objetivoBiologico) {
        this.objetivoBiologico = objetivoBiologico;
    }

    public void setProducto_utilizado(String producto_utilizado) {
        this.producto_utilizado = producto_utilizado;
    }

    public void setDosis_por_litro(double dosis_por_litro) {
        this.dosis_por_litro = dosis_por_litro;
    }

    public void setVolumen_utilizado(double volumen_utilizado) {
        this.volumen_utilizado = volumen_utilizado;
    }

    

    
}
