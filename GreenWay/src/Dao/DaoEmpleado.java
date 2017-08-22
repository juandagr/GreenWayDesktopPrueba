/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Empleado;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoEmpleado {
    
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;

    //Constructor
    public DaoEmpleado() {
        fachada = new Fachada();
    }

    //metodo encargado de ingresar un empleado a la base de datos en la tabla empleado, el metodo recribe un empleado 
    // y lo guarda en la BD
    public int ingresarEmpleadoBD(Empleado empleado) {
        
        int numFilas;
        String consulta = "INSERT INTO empleado VALUES ('" + empleado.getNombre() + "','" + empleado.getApellido() + "','" + empleado.getIdentificacion()
                        + "','" + empleado.getCargo() + "','" + empleado.getTelefono() + "','" + empleado.getDireccion() + "','" + empleado.isEstado()
                        + "','" + empleado.getFotografia() + "','" + empleado.getCorreo() + "','" + empleado.getFechaDeNacimiento() + "','" + empleado.getEstado_civil() + "');";
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en empleado \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en empleado" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    public ResultSet consultarEmpleadoBD(String idEmpleado){
        
        String sql_select;
        sql_select="SELECT * FROM empleado WHERE identificacion ='"+idEmpleado+"';";
        try{
            Connection conn= fachada.conectar_BD();
            instruccion = conn.createStatement();
            respuesta = instruccion.executeQuery(sql_select);
            fachada.cerrarConexion(conn);              
        }catch(SQLException e){
            
            System.out.println("Error al consultar datos");
        }
        return respuesta; 
    
    }
    
    public ResultSet consultarTodosEmpleadosBD(){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM empleado;";
        try{
            Connection conn= fachada.conectar_BD();
            instruccion = conn.createStatement();
            respuesta = instruccion.executeQuery(sql_select);
            fachada.cerrarConexion(conn);              
        }catch(SQLException e){
            
            System.out.println("Error al consultar datos");
        }
        return respuesta; 
    
    }
     
    /*public int actualizarEmpleado(Empleado emp){
        
        int numFilas = 0;
        String sql_update;
         
        sql_update = "UPDATE empleado SET nombre='" + emp.getNombre()+ "',cargo='" + emp.getCargo() +"',telefono='"+emp.getTelefono()
                    +"',direccion='"+emp.getDireccion() + "' WHERE id_empleado= '"+emp.getIdEmpleado()+"';";
                     
        try{
                Connection conn= fachada.conectarABD();
                instruccion = conn.createStatement();
                numFilas = instruccion.executeUpdate(sql_update);
                fachada.cerrarConexion(conn);     
        }
        catch(SQLException sqle){
            
            System.out.println("Error de Sql al conectar en programa \n" + sqle);
            numFilas = -1;   
        }
        catch(Exception e){
            
            System.out.println("Ocurrió cualquier otra excepcion en programa"+e);
            numFilas = -1;   
        }
        return numFilas;
     }*/
}
