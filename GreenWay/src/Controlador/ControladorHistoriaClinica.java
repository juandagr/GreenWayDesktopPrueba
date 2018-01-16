/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.HistoriaClinica;
import Clases.Lote;
import Dao.DaoHistoriaClinica;
import Dao.DaoLote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorHistoriaClinica {
    //Atributos
    private DaoHistoriaClinica daoHistoriaClinica;
    
    //Constructor
    public ControladorHistoriaClinica() {
        this.daoHistoriaClinica = new DaoHistoriaClinica();
    }
    

    public String ingresarHistoriaClinica(String loteId, String anio, String semana, String dia, String descripcion){
       
        String mensaje = "Historia clinica creada exitosamente." ;
        
        int filaRegistro = this.daoHistoriaClinica.ingresarHistoriaClinicaBD(loteId, anio, semana, dia, descripcion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso de la historia clinica";
        }
        return mensaje;
    } 
    

    public String actualizarHistoriaClinica(String loteId, String anio, String semana, String dia, String descripcion){
       
        
        String mensaje = "Actualizo la Historia clinica con Exito" ;
                                        
        int filaRegistro = this.daoHistoriaClinica.actualizarHistoriaClinicaBD(loteId, anio, semana, dia, descripcion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion de la Historia clinica";
        }
        return mensaje;
    }   
    

    public HistoriaClinica consultarHistoriaClinica(String loteId, String anio, String semana, String dia){
        
        HistoriaClinica hc= null;
        ResultSet consulta = this.daoHistoriaClinica.consultarHistoriaClinicaBD(loteId, anio, semana, dia);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto

                String descripcion = consulta.getString(5);

                //se crea el objeto una vez se hayan extraido los datos
                hc = new HistoriaClinica(loteId, anio, semana, dia, descripcion);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                hc = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return hc;
        
    }
    

    
    public boolean HistoriaRegistrada(String loteId, String anio, String semana, String dia){
        boolean resultado = false;
        ResultSet rs = this.daoHistoriaClinica.consultarHistoriaClinicaBD(loteId, anio, semana, dia);
        
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
    

    public ArrayList<HistoriaClinica> consultarHistoriasxLote(String lote){
        ArrayList<HistoriaClinica> historias = new ArrayList();
        
        ResultSet consulta = this.daoHistoriaClinica.consultarHistoriasClinicasxLoteBD(lote);
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String Lote_identificador  = consulta.getString(1);
                String anio = consulta.getString(2);
                String semana = consulta.getString(3);
                String dia = consulta.getString(4);
                String descripcion = consulta.getString(5);
                                           
                //se crea el objeto una vez se hayan extraido los datos
                HistoriaClinica hc = new HistoriaClinica(Lote_identificador, anio, semana, dia, descripcion);
                historias.add(hc);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return historias;
        
    }
    
    public List consultarHistoriasxMes(String loteId, String anio, String s1,String s2,String s3,String s4,String s5){
        ArrayList<HistoriaClinica> historias = new ArrayList();
        
        ResultSet consulta = this.daoHistoriaClinica.consultarHistoriasClinicasxMesBD(loteId, anio, s1, s2, s3, s4, s5);
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String Lote_identificador  = loteId;
                String semana = consulta.getString(3);
                String dia = consulta.getString(4);
                String descripcion = consulta.getString(5);
                                           
                //se crea el objeto una vez se hayan extraido los datos
                HistoriaClinica hc = new HistoriaClinica(Lote_identificador, anio, semana, dia, descripcion);
                historias.add(hc);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return historias;
        
    }
}
