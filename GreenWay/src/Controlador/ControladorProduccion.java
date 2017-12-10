/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Clases.Produccion;
import Dao.DaoProduccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorProduccion {
    //Atributos
    private DaoProduccion daoProduccion;
    
    //Constructor
    public ControladorProduccion() {
        this.daoProduccion = new DaoProduccion();
    }
    

    public String ingresarProduccion(String Lote_identificador, String anio, String semana, String dia, double selecta, double corriente, double industrial){
       
        String mensaje = "Produccion creada exitosamente." ;
        Produccion produccion = new Produccion(Lote_identificador, anio, semana, dia, selecta, corriente, industrial);
        int filaRegistro = this.daoProduccion.ingresarProduccionBD(produccion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso de la produccion";
        }
        return mensaje;
    } 
    

    public String actualizarProduccion(String Lote_identificador, String anio, String semana, String dia, double selecta, double corriente, double industrial){
       
        
        String mensaje = "Actualizo la produccion con Exito" ;
        Produccion produccion = new Produccion(Lote_identificador, anio, semana, dia, selecta, corriente, industrial);
                                        
        int filaRegistro = this.daoProduccion.actualizarproduccionBD(produccion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion de la produccion";
        }
        return mensaje;
    }   
    

    public Produccion consultarProduccion(String loteId, String anio, String semana, String dia){
        
        Produccion hc = null;
        ResultSet consulta = this.daoProduccion.consultarProduccionBD(loteId, anio, semana, dia);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto

                double selecta = consulta.getDouble(5);
                double corriente = consulta.getDouble(6);
                double industrial = consulta.getDouble(7);

                //se crea el objeto una vez se hayan extraido los datos
                hc = new Produccion(loteId, anio, semana, dia, selecta, corriente, industrial);
  
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
    

    
    public boolean produccionRegistrada(String loteId, String anio, String semana, String dia){
        boolean resultado = false;
        ResultSet rs = this.daoProduccion.consultarProduccionBD(loteId, anio, semana, dia);
        
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
    

    public ArrayList<Produccion> consultarProduccionxLote(String lote){
        ArrayList<Produccion> producciones = new ArrayList();
        
        ResultSet consulta = this.daoProduccion.consultarProduccionxLoteBD(lote);
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String Lote_identificador  = consulta.getString(1);
                String anio = consulta.getString(2);
                String semana = consulta.getString(3);
                String dia = consulta.getString(4);
                double selecta = consulta.getDouble(5);
                double corriente = consulta.getDouble(6);
                double industrial = consulta.getDouble(7);
                                           
                //se crea el objeto una vez se hayan extraido los datos
                Produccion produccion = new Produccion(Lote_identificador, anio, semana, dia, selecta, corriente, industrial);
                producciones.add(produccion);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return producciones;
        
    }
}
