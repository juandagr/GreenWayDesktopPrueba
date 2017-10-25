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
public class Lote {
    //Atributos
    private String Cliente_identificacion ;
    private String Cultivo_identificador ;
    private String identificador ;
    private double area;
    private int numero_plantas;
    private double costo_por_hora;
    private String Ubicacion_id_ubicacion;
    
    //Constructor

    public Lote(String Cliente_identificacion, String Cultivo_identificador, String identificador, double area, int numero_plantas, double costo_por_hora, String Ubicacion_id_ubicacion) {
        this.Cliente_identificacion = Cliente_identificacion;
        this.Cultivo_identificador = Cultivo_identificador;
        this.identificador = identificador;
        this.area = area;
        this.numero_plantas = numero_plantas;
        this.costo_por_hora = costo_por_hora;
        this.Ubicacion_id_ubicacion = Ubicacion_id_ubicacion;
    }

     //Getters para los atributos de la clase ***********************************************
    public String getCliente_identificacion() {
        return Cliente_identificacion;
    }

    public String getCultivo_identificador() {
        return Cultivo_identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getArea() {
        return area;
    }

    public int getNumero_plantas() {
        return numero_plantas;
    }

    public double getCosto_por_hora() {
        return costo_por_hora;
    }

    public String getUbicacion_id_ubicacion() {
        return Ubicacion_id_ubicacion;
    }

    //**************************************************************************************
    //Setters para los atributos de la clase ***********************************************
    
    public void setCliente_identificacion(String Cliente_identificacion) {
        this.Cliente_identificacion = Cliente_identificacion;
    }

    public void setCultivo_identificador(String Cultivo_identificador) {
        this.Cultivo_identificador = Cultivo_identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setNumero_plantas(int numero_plantas) {
        this.numero_plantas = numero_plantas;
    }

    public void setCosto_por_hora(double costo_por_hora) {
        this.costo_por_hora = costo_por_hora;
    }

    public void setUbicacion_id_ubicacion(String Ubicacion_id_ubicacion) {
        this.Ubicacion_id_ubicacion = Ubicacion_id_ubicacion;
    }

    
    
}
