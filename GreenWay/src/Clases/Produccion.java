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
public class Produccion {
    
     //Atributos
    private String Lote_identificador;
    private String anio;
    private String semana;
    private String dia;
    private double selecta;
    private double corriente;
    private double industrial;
    

    //Constructor

    public Produccion(String Lote_identificador, String anio, String semana, String dia, double selecta, double corriente, double industrial) {
        this.Lote_identificador = Lote_identificador;
        this.anio = anio;
        this.semana = semana;
        this.dia = dia;
        this.selecta = selecta;
        this.corriente = corriente;
        this.industrial = industrial;
    }
    
    //Getters

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

    public double getSelecta() {
        return selecta;
    }

    public double getCorriente() {
        return corriente;
    }

    public double getIndustrial() {
        return industrial;
    }
    
    //Setters

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

    public void setSelecta(double selecta) {
        this.selecta = selecta;
    }

    public void setCorriente(double corriente) {
        this.corriente = corriente;
    }

    public void setIndustrial(double industrial) {
        this.industrial = industrial;
    }
    
}
