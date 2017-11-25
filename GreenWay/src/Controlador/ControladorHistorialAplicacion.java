/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.HistoriaClinica;
import Clases.HistorialAplicacion;
import Clases.Lote;
import Dao.DaoHistoriaClinica;
import Dao.DaoHistorialAplicacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorHistorialAplicacion {
    //Atributos
    private DaoHistorialAplicacion daoHistorialAplicacion;
    
    //Constructor
    public ControladorHistorialAplicacion() {
        this.daoHistorialAplicacion = new DaoHistorialAplicacion();
    }
    

    public String ingresarHistorialAplicacion(String Lote_identificador, String id_historial, String anio, String semana, String dia, String objetivoBiologico, String producto_utilizado, double dosis_por_litro, double volumen_utilizado){
       
        String mensaje = "Historial de aplicacion creado exitosamente." ;
        HistorialAplicacion historial = new HistorialAplicacion(Lote_identificador, id_historial, anio, semana, dia, objetivoBiologico, producto_utilizado, dosis_por_litro, volumen_utilizado);
        
        int filaRegistro = this.daoHistorialAplicacion.ingresarHistorialAplicacionBD(historial);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del hsitorial de aplicacion";
        }
        return mensaje;
    } 
    

    public String actualizarHistorialAplicacion(String Lote_identificador, String id_historial, String anio, String semana, String dia, String objetivoBiologico, String producto_utilizado, double dosis_por_litro, double volumen_utilizado){
       
        
        String mensaje = "Actualizo el historial de aplicacion con Exito" ;
        HistorialAplicacion historial = new HistorialAplicacion(Lote_identificador, id_historial, anio, semana, dia, objetivoBiologico, producto_utilizado, dosis_por_litro, volumen_utilizado);
        
        int filaRegistro = this.daoHistorialAplicacion.actualizarHistorialAplicacionBD(historial);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion de la Historia clinica";
        }
        return mensaje;
    }   
    

    public HistorialAplicacion consultarHistorialAplicacion(String loteId, String id_historial, String anio, String semana, String dia){
        
        HistorialAplicacion h= null;
        ResultSet consulta = this.daoHistorialAplicacion.consultarHistorialAplicacionBD(loteId, id_historial, anio, semana, dia);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto

                String objetivoBiologico = consulta.getString(6);;
                String producto_utilizado = consulta.getString(7);;
                double dosis_por_litro = consulta.getDouble(8);
                double volumen_utilizado = consulta.getDouble(9);
                //se crea el objeto una vez se hayan extraido los datos
                h = new HistorialAplicacion(loteId, id_historial, anio, semana, dia, objetivoBiologico, producto_utilizado, dosis_por_litro, volumen_utilizado);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                h = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return h;
        
    }
    

    
    public boolean HistorialAplicacionRegistrado(String loteId, String id_historial, String anio, String semana, String dia){
        boolean resultado = false;
        ResultSet rs = this.daoHistorialAplicacion.consultarHistorialAplicacionBD(loteId, id_historial, anio, semana, dia);
        
        try {
            if (rs.next()) {
                resultado = true;

            }else{

                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    

    public ArrayList<HistorialAplicacion> consultarHistorialessxLote(String lote){
        ArrayList<HistorialAplicacion> historiales = new ArrayList();
        
        ResultSet consulta = this.daoHistorialAplicacion.consultarHistorialxLoteBD(lote);
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String Lote_identificador = consulta.getString(1);
                String id_historial = consulta.getString(2);
                String anio = consulta.getString(3);
                String semana = consulta.getString(4);
                String dia = consulta.getString(5);
                String objetivoBiologico = consulta.getString(6);
                String producto_utilizado = consulta.getString(7);;
                double dosis_por_litro = consulta.getDouble(8);
                double volumen_utilizado = consulta.getDouble(9);
                //se crea el objeto una vez se hayan extraido los datos
                HistorialAplicacion h = new HistorialAplicacion(Lote_identificador, id_historial, anio, semana, dia, objetivoBiologico, producto_utilizado, dosis_por_litro, volumen_utilizado);
  
                historiales.add(h);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return historiales;
        
    }
}
