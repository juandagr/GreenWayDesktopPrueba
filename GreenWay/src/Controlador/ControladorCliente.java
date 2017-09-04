/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Cliente;
import Dao.DaoCliente;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorCliente {
    
    //Atributos
    private DaoCliente daoCliente;
    
    //Constructor
    public ControladorCliente() {
        this.daoCliente = new DaoCliente();
    }
    
    /**
     *Metodo para realizar el ingreso de un cliente a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param nombre , 
     * @param apellido
     * @param identificacion
     * @param telefono
     * @param direccion
     * @param fotografia
     * @param correo
     * @param estado
     * @return String mensaje
     */
    public String ingresarCliente(String nombre, String apellido, String identificacion, String telefono, String direccion, boolean estado, String correo , String fotografia){
       
        String mensaje = "Cliente creado exitosamente." ;
        Cliente cliente = new Cliente(nombre, apellido, identificacion, telefono, direccion, estado, correo, fotografia);
                              
        int filaRegistro = this.daoCliente.ingresarClienteBD(cliente);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del cliente";
        }
        return mensaje;
    } 
    
    /**
     * Metodo para actualizqar la actualización de un registro de un cliente dada la cedula y con los datos que se le proporciona por medio de la interfaz
     * @param nombre
     * @param apellido
     * @param identificacion
     * @param telefono
     * @param direccion
     * @param estado
     * @param correo
     * @param fotografia
     * @return String mensaje
     */
    public String actualizarCliente(String nombre, String apellido, String identificacion, String telefono, String direccion, boolean estado, String correo, String fotografia){
       
        
        String mensaje = "Actualizo un cliente con Exito" ;
        Cliente cliente = new Cliente(nombre, apellido, identificacion, telefono, direccion, estado, correo, fotografia);
                                        
            int filaRegistro = this.daoCliente.actualizarClienteBD(cliente);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion del cliente";
        }
        return mensaje;
    }   
    
    /**
     * metodo para realizar la consulta de un cliente a la base de datos, este recibe la cedula del cliente que se desea consultar y devuelve el objeto representando el mismo
     * @param idCliente
     * @return Cliente
     */
    public Cliente consultarCliente(String idCliente){
        
        Cliente cliente = null;
        ResultSet consulta = this.daoCliente.consultarClienteBD(idCliente);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String nombre = consulta.getString(1);
                String apellido = consulta.getString(2);
                String identificacion = consulta.getString(3);
                String telefono = consulta.getString(4);
                String direccion = consulta.getString(5);
                boolean estado = consulta.getBoolean(6);
                String correo = consulta.getString(7);
                String fotografia = consulta.getString(8);
               
                
                //se crea el objeto una vez se hayan extraido los datos
                cliente = new Cliente(nombre, apellido, identificacion, telefono, direccion, estado, correo, fotografia);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                cliente = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return cliente;
        
    }
    
    /**
     * Metodo para verificar si un cliente ya ha sido registrado en la base de datos
     * @param cliente
     * @return boolean resultado
     */
    public boolean clienteRegistrado(String identificacion){
        boolean resultado = false;
        ResultSet rs = this.daoCliente.consultarClienteBD(identificacion);
        
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
     * Metodo para realizar la consulta de todos los clientesque se encuentran registrados en la base de datos devuelve una lista con un objeto por cada cliente encontrado
     * @return ArrayList<Cliente>
     */
    public ArrayList<Cliente> consultarTodosClientes(){
        ArrayList<Cliente> clientes = new ArrayList();
        
        ResultSet consulta = this.daoCliente.consultarTodosClientesBD();
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String nombre = consulta.getString(1);
                String apellido = consulta.getString(2);
                String identificacion = consulta.getString(3);
                String telefono = consulta.getString(4);
                String direccion = consulta.getString(5);
                boolean estado = consulta.getBoolean(6);
                String correo = consulta.getString(7);
                String fotografia = consulta.getString(8);
                
              
                
                //se crea el objeto una vez se hayan extraido los datos
                Cliente cliente = new Cliente(nombre, apellido, identificacion, telefono, direccion, estado, correo, fotografia);
                clientes.add(cliente);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return clientes;
        
    }
}
