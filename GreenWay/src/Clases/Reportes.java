/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Dao.DaoCostosOperacionales;
import java.sql.ResultSet;

/**
 *
 * @author Daniel
 */
public class Reportes {

    public Reportes() {
    }
    
    public void costoOperacionalxMes(String loteid, String anio, String mes){
        
        int semanaInicial = this.determinarSemanaInicial(mes);
        int duracion = this.determinarDuracion(mes);
        double costoOperacional = 0;
        
        for (int i = semanaInicial; i <= duracion; i++) {
            ResultSet rs = new DaoCostosOperacionales().consultarCostosOperacionalesxSemanaBD(loteid, anio, mes);
            //double 
        }
    }
    
    public int determinarSemanaInicial(String mes){
        /*
        Tabla de meses
        1 mes: 4 semanas
        2 mes:9 semanas
        3 mes: 13 semanas
        4 mes : 18 semanas
        5 mes: 22 semanas
        6 mes: 27 semanas
        7 mes: 31 semanas 
        8 mes: 36 semanas
        9 mes : 40 semanas
        10 mes : 44 semanas
        11 mes : 48 semanas
        12 mes : 52 semanas
        */
        int semanaInicial = 0;
        if (mes.equalsIgnoreCase("enero")) {
            semanaInicial = 1;
        }else if (mes.equalsIgnoreCase("febrero")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("marzo")) {
            semanaInicial = 10;
        }else if (mes.equalsIgnoreCase("abril")) {
            semanaInicial = 14;
        }else if (mes.equalsIgnoreCase("mayo")) {
            semanaInicial = 19;
        }else if (mes.equalsIgnoreCase("junio")) {
            semanaInicial = 23;
        }else if (mes.equalsIgnoreCase("julio")) {
            semanaInicial = 28;
        }else if (mes.equalsIgnoreCase("agosto")) {
            semanaInicial = 32;
        }else if (mes.equalsIgnoreCase("septiembre")) {
            semanaInicial = 37;
        }else if (mes.equalsIgnoreCase("octubre")) {
            semanaInicial = 41;
        }else if (mes.equalsIgnoreCase("noviembre")) {
            semanaInicial = 45;
        }else if (mes.equalsIgnoreCase("diciembre")) {
            semanaInicial = 49;
        }
        
        return semanaInicial;
    }
    
    public int determinarDuracion(String mes){
        /*
        Tabla de meses
        1 mes: 4 semanas
        2 mes:9 semanas
        3 mes: 13 semanas
        4 mes : 18 semanas
        5 mes: 22 semanas
        6 mes: 27 semanas
        7 mes: 31 semanas 
        8 mes: 36 semanas
        9 mes : 40 semanas
        10 mes : 44 semanas
        11 mes : 48 semanas
        12 mes : 52 semanas
        */
        int semanaInicial = 0;
        if (mes.equalsIgnoreCase("enero")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("febrero")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("marzo")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("abril")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("mayo")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("junio")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("julio")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("agosto")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("septiembre")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("octubre")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("noviembre")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("diciembre")) {
            semanaInicial = 4;
        }
        
        return semanaInicial;
    }
}
