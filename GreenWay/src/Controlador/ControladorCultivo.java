/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Cultivo;
import Dao.DaoCultivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorCultivo {
    //Atributos
    private DaoCultivo daoCultivo;
    
    //Constructor
    public ControladorCultivo() {
        this.daoCultivo = new DaoCultivo();
    }
    
    /**
     *Metodo para realizar el ingreso de un cultivo a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param identificador , 
     * @param nombre
     * @param descripcion
     * @return String mensaje
     */
    public String ingresarCultivo(String identificador, String nombre, String descripcion){
       
        String mensaje = "Cultivo creado exitosamente." ;
        Cultivo cultivo = new Cultivo(identificador, nombre, descripcion);
                              
        int filaRegistro = this.daoCultivo.ingresarCultivoBD(cultivo);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del cultivo";
        }
        return mensaje;
    } 
    
      /**
     *Metodo para realizar la actualizacion de un cultivo en la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param identificador , 
     * @param nombre
     * @param descripcion
     * @return String mensaje
     */
    public String actualizarCultivo(String identificador, String nombre, String descripcion){
       
        
        String mensaje = "Actualizo el cultivo con Exito" ;
        Cultivo cultivo = new Cultivo(identificador, nombre, descripcion);
                                        
        int filaRegistro = this.daoCultivo.actualizarCultivoBD(cultivo);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion de el cultivo";
        }
        return mensaje;
    }   
    
    /**
     * metodo para realizar la consulta de un cultivo en la base de datos, este recibe el id del cultivo que se desea consultar y devuelve el objeto representando el mismo
     * @param identificador
     * @return Cultivo
     */
    public Cultivo consultarCultivo(String identificador){
        
        Cultivo cultivo = null;
        ResultSet consulta = this.daoCultivo.consultarCultivoBD(identificador);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String id  = consulta.getString(1);
                String nombre = consulta.getString(2);
                String descripcion = consulta.getString(3);

                //se crea el objeto una vez se hayan extraido los datos
                cultivo = new Cultivo(id, nombre, descripcion);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                cultivo = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return cultivo;
        
    }
    
    /**
     * Metodo para verificar si un cultivo ya ha sido registrado en la base de datos
     * @param identificador
     * @return boolean resultado
     */
    public boolean cultivoRegistrado(String identificador){
        boolean resultado = false;
        ResultSet rs = this.daoCultivo.consultarCultivoBD(identificador);
        
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
     * Metodo para realizar la consulta de todos los cultivos que se encuentran registrados en la base de datos devuelve una lista con un objeto por cada cultivo encontrado
     * @return ArrayList<Cultivo>
     */
    public ArrayList<Cultivo> consultarTodosCultivos(){
        ArrayList<Cultivo> cultivos = new ArrayList();
        
        ResultSet consulta = this.daoCultivo.consultarTodosCultivosBD();
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String id  = consulta.getString(1);
                String nombre = consulta.getString(2);
                String descripcion = consulta.getString(3);
                                           
                //se crea el objeto una vez se hayan extraido los datos
                Cultivo cultivo = new Cultivo(descripcion, nombre, descripcion);
                cultivos.add(cultivo);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return cultivos;
        
    }
}
