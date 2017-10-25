/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Ubicacion;
import Dao.DaoUbicacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorUbicacion {
    //Atributos
    private DaoUbicacion daoUbicacion;
    
    //Constructor
    public ControladorUbicacion() {
        this.daoUbicacion = new DaoUbicacion();
    }
    
    /**
     *Metodo para realizar el ingreso de una ubicacion a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param id_ubicacion , 
     * @param departamento
     * @param municipio
     * @param vereda
     * @return String mensaje
     */
    public String ingresarUbicacion(String id_ubicacion, String departamento, String municipio, String vereda){
       
        String mensaje = "Ubicacion creada exitosamente." ;
        Ubicacion ubicacion = new Ubicacion(id_ubicacion, departamento, municipio, vereda);
                              
        int filaRegistro = this.daoUbicacion.ingresarUbicacionBD(ubicacion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del ubicacion";
        }
        return mensaje;
    } 
    
      /**
     *Metodo para realizar el ingreso de una ubicacion a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param id_ubicacion , 
     * @param departamento
     * @param municipio
     * @param vereda
     * @return String mensaje
     */
    public String actualizarUbicacion(String id_ubicacion, String departamento, String municipio, String vereda){
       
        
        String mensaje = "Actualizo la ubicacion con Exito" ;
        Ubicacion ubicacion = new Ubicacion(id_ubicacion, departamento, municipio, vereda);
                                        
        int filaRegistro = this.daoUbicacion.actualizarUbicacionBD(ubicacion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion de la ubicacion";
        }
        return mensaje;
    }   
    
    /**
     * metodo para realizar la consulta de una ubicacion en la base de datos, este recibe el id de la ubicacion que se desea consultar y devuelve el objeto representando el mismo
     * @param id_ubicacion
     * @return Ubicacion
     */
    public Ubicacion consultarUbicacion(String id_ubicacion){
        
        Ubicacion ubicacion = null;
        ResultSet consulta = this.daoUbicacion.consultarUbicacionBD(id_ubicacion);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String id  = consulta.getString(1);
                String departamento = consulta.getString(2);
                String municipio = consulta.getString(3);
                String vereda = consulta.getString(4);

                //se crea el objeto una vez se hayan extraido los datos
                ubicacion = new Ubicacion(id, departamento, municipio, vereda);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                ubicacion = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return ubicacion;
        
    }
    
    /**
     * Metodo para verificar si una ubicacion ya ha sido registrada en la base de datos
     * @param id_ubicacion
     * @return boolean resultado
     */
    public boolean ubicacionRegistrada(String id_ubicacion){
        boolean resultado = false;
        ResultSet rs = this.daoUbicacion.consultarUbicacionBD(id_ubicacion);
        
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
     * Metodo para realizar la consulta de todas las ubicaciones que se encuentran registrados en la base de datos devuelve una lista con un objeto por cada Ubicacion encontrada
     * @return ArrayList<Ubicacion>
     */
    public ArrayList<Ubicacion> consultarTodasUbicaciones(){
        ArrayList<Ubicacion> ubicaciones = new ArrayList();
        
        ResultSet consulta = this.daoUbicacion.consultarTodasUbicacionesBD();
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String id  = consulta.getString(1);
                String departamento = consulta.getString(2);
                String municipio = consulta.getString(3);
                String vereda = consulta.getString(4);
                                           
                //se crea el objeto una vez se hayan extraido los datos
                Ubicacion ubicacion = ubicacion = new Ubicacion(id, departamento, municipio, vereda);
                ubicaciones.add(ubicacion);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return ubicaciones;
        
    }
}
