/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Lote;
import Dao.DaoLote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorLote {
    //Atributos
    private DaoLote daoLote;
    
    //Constructor
    public ControladorLote() {
        this.daoLote = new DaoLote();
    }
    
    /**
     *Metodo para realizar el ingreso de un lote a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param Cliente_identificacion , 
     * @param Cultivo_identificador
     * @param identificador
     * @param area
     * @param numero_plantas
     * @param costo_por_hora
     * @param Ubicacion_id_ubicacion
     * @return String mensaje
     */
    public String ingresarLote(String Cliente_identificacion, String Cultivo_identificador, String identificador, double area, int numero_plantas, double costo_por_hora, String Ubicacion_id_ubicacion){
       
        String mensaje = "Lote creado exitosamente." ;
        Lote lote = new Lote(Cliente_identificacion, Cultivo_identificador, identificador, area, numero_plantas, costo_por_hora, Ubicacion_id_ubicacion);

        int filaRegistro = this.daoLote.ingresarLoteBD(lote);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del lote";
        }
        return mensaje;
    } 
    
      /**
     *Metodo para realizar la actualizacion de un lote en la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param Cliente_identificacion , 
     * @param Cultivo_identificador
     * @param identificador
     * @param area
     * @param numero_plantas
     * @param costo_por_hora
     * @param Ubicacion_id_ubicacion
     * @return String mensaje
     */
    public String actualizarLote(String Cliente_identificacion, String Cultivo_identificador, String identificador, double area, int numero_plantas, double costo_por_hora, String Ubicacion_id_ubicacion){
       
        
        String mensaje = "Actualizo el lote con Exito" ;
        Lote lote = new Lote(Cliente_identificacion, Cultivo_identificador, identificador, area, numero_plantas, costo_por_hora, Ubicacion_id_ubicacion);
                                        
        int filaRegistro = this.daoLote.actualizarLoteBD(lote);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion de el lote";
        }
        return mensaje;
    }   
    
    /**
     * metodo para realizar la consulta de un lote en la base de datos, este recibe el id del lote que se desea consultar y devuelve el objeto representando el mismo
     * @param identificador
     * @return Cultivo
     */
    public Lote consultarLote(String identificador){
        
        Lote lote = null;
        ResultSet consulta = this.daoLote.consultarLoteBD(identificador);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String Cliente_identificacion  = consulta.getString(1);
                String Cultivo_identificador = consulta.getString(2);
                String id = consulta.getString(3);
                double area = consulta.getDouble(4);
                int numero_plantas = consulta.getInt(5);
                double costo_por_hora = consulta.getDouble(6);
                String Ubicacion_id_ubicacion = consulta.getString(7);

                //se crea el objeto una vez se hayan extraido los datos
                lote = new Lote(Cliente_identificacion, Cultivo_identificador, id, area, numero_plantas, costo_por_hora, Ubicacion_id_ubicacion);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                lote = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return lote;
        
    }
    
    /**
     * metodo para realizar la consulta de los lotes de un cliente en la base de datos, este recibe el id del cliente y devuelve una lista con los lotes de el cliente
     * @param identificador
     * @return Cultivo
     */
    public ArrayList<String> consultarLotesCliente(String cliente){
        
        ArrayList<String> lotes = new ArrayList();
        ResultSet consulta = this.daoLote.consultarLotesClienteBD(cliente);

        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            while( consulta.next()){
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String id = consulta.getString(3);
                //se crea el objeto una vez se hayan extraido los datos
                lotes.add(id);
  
            }

        }

        catch (SQLException ex) {

        }
        
        return lotes;
        
    }
    
    /**
     * Metodo para verificar si un lote ya ha sido registrado en la base de datos
     * @param identificador
     * @return boolean resultado
     */
    public boolean loteRegistrado(String identificador){
        boolean resultado = false;
        ResultSet rs = this.daoLote.consultarLoteBD(identificador);
        
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
    
    /**
     * Metodo para realizar la consulta de todos los lotes que se encuentran registrados en la base de datos devuelve una lista con un objeto por cada lote encontrado
     * @return ArrayList<Lote>
     */
    public ArrayList<Lote> consultarTodosLotes(){
        ArrayList<Lote> lotes = new ArrayList();
        
        ResultSet consulta = this.daoLote.consultarTodosLoteBD();
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String Cliente_identificacion  = consulta.getString(1);
                String Cultivo_identificador = consulta.getString(2);
                String id = consulta.getString(3);
                double area = consulta.getDouble(4);
                int numero_plantas = consulta.getInt(5);
                double costo_por_hora = consulta.getDouble(6);
                String Ubicacion_id_ubicacion = consulta.getString(7);
                                           
                //se crea el objeto una vez se hayan extraido los datos
                Lote lote = new Lote(Cliente_identificacion, Cultivo_identificador, id, area, numero_plantas, costo_por_hora, Ubicacion_id_ubicacion);
                lotes.add(lote);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return lotes;
        
    }
}
