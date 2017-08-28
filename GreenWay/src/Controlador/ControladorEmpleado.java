/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Empleado;
import Dao.DaoEmpleado;
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
public class ControladorEmpleado {
    
    //Atributos
    private DaoEmpleado daoEmpleado;
    
    //Constructor
    public ControladorEmpleado() {
        this.daoEmpleado = new DaoEmpleado();
    }
    
    /**
     *Metodo para realizar el ingreso de un empleado a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param nombre , 
     * @param apellido
     * @param identificacion
     * @param cargo
     * @param telefono
     * @param direccion
     * @param estado
     * @param fotografia
     * @param correo
     * @param fechaDeNacimiento
     * @param estado_civil
     * @return String mensaje
     */
    public String ingresarEmpleado(String nombre, String apellido, String identificacion, String cargo, String telefono, String direccion, boolean estado, String fotografia, String correo, Date fechaDeNacimiento, String estado_civil){
       
        String mensaje = "Empleado creado exitosamente." ;
        Empleado empleado = new Empleado(nombre, apellido, identificacion, cargo, telefono, direccion, estado, fotografia, correo, fechaDeNacimiento, estado_civil);
                              
        int filaRegistro = this.daoEmpleado.ingresarEmpleadoBD(empleado);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del empleado";
        }
        return mensaje;
    } 
    
    /**
     * Metodo para realizar la actualización de un registro de un empleado dada la cedula y con los datos que se le proporciona por medio de la interfaz
     * @param nombre
     * @param apellido
     * @param identificacion
     * @param cargo
     * @param telefono
     * @param direccion
     * @param estado
     * @param fotografia
     * @param correo
     * @param fechaDeNacimiento
     * @param estado_civil
     * @return String mensaje
     */
    public String actualizarEmpleado(String nombre, String apellido, String identificacion, String cargo, String telefono, String direccion, boolean estado, String fotografia, String correo, Date fechaDeNacimiento, String estado_civil){
       
        
        String mensaje = "Actualizo un empleado con Exito" ;
        Empleado empleado = new Empleado(nombre, apellido, identificacion, cargo, telefono, direccion, estado, fotografia, correo, fechaDeNacimiento, estado_civil);
                                        
        int filaRegistro = daoEmpleado.actualizarEmpleadoBD(empleado);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo la actualizacion del empleaado";
        }
        return mensaje;
    }   
    
    /**
     * metodo para realizar la consulta de un empleado a la base de datos, este recibe la cedula del empleado que se desea consultar y devuelve el objeto representando el mismo
     * @param idEmpleado
     * @return Empleado
     */
    public Empleado consultarEmpleado(String idEmpleado){
        
        Empleado empleado = null;
        ResultSet consulta = this.daoEmpleado.consultarEmpleadoBD(idEmpleado);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String nombre = consulta.getString(1);
                String apellido = consulta.getString(2);
                String identificacion = consulta.getString(3);
                String cargo = consulta.getString(4);
                String telefono = consulta.getString(5);
                String direccion = consulta.getString(6);
                boolean estado = consulta.getBoolean(7);
                String fotografia = consulta.getString(8);
                String correo = consulta.getString(9);
                Date fechaDeNacimiento = consulta.getDate(10);
                String estado_civil = consulta.getString(11);
                
                //se crea el objeto una vez se hayan extraido los datos
                empleado = new Empleado(nombre, apellido, identificacion, cargo, telefono, direccion, estado, fotografia, correo, fechaDeNacimiento, estado_civil);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                empleado = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return empleado;
        
    }
    
    /**
     * Metodo para verificar si un empleado ya ha sido registrado en la base de datos
     * @param identificacion
     * @return boolean resultado
     */
    public boolean empleadoRegistrado(String identificacion){
        boolean resultado = false;
        ResultSet rs = this.daoEmpleado.consultarEmpleadoBD(identificacion);
        
        try {
            if (rs.next()) {
                resultado = true;

            }else{

                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    /**
     * Metodo para realizar la consulta de todos los empleados que se encuentran registrados en la base de datos devuelve una lista con un objeto por cada empleado encontrado
     * @return ArrayList<Empleado>
     */
    public ArrayList<Empleado> consultarTodosEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList();
        
        ResultSet consulta = this.daoEmpleado.consultarTodosEmpleadosBD();
        try {
            //se extraen los registros de la tabla empleados
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String nombre = consulta.getString(1);
                String apellido = consulta.getString(2);
                String identificacion = consulta.getString(3);
                String cargo = consulta.getString(4);
                String telefono = consulta.getString(5);
                String direccion = consulta.getString(6);
                boolean estado = consulta.getBoolean(7);
                String fotografia = consulta.getString(8);
                String correo = consulta.getString(9);
                Date fechaDeNacimiento = consulta.getDate(10);
                String estado_civil = consulta.getString(11);
                
                //se crea el objeto una vez se hayan extraido los datos
                Empleado empleado = new Empleado(nombre, apellido, identificacion, cargo, telefono, direccion, estado, fotografia, correo, fechaDeNacimiento, estado_civil);
                empleados.add(empleado);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return empleados;
        
    }
}
