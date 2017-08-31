/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Cliente;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class DaoCliente {
    
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;

    //Constructor
    public DaoCliente() {
        fachada = new Fachada();
    }


    /**
     *metodo encargado de ingresar un cliente a la base de datos en la tabla empleado, el metodo recribe un empleado y lo guarda en la base de datos
     * @param cliente
     * @return
     */
    public int ingresarClienteBD(Cliente cliente) {
        
        int numFilas;
        String consulta = "INSERT INTO cliente VALUES ('" + cliente.getNombre() + "','" + cliente.getApellido() + "','" + cliente.getIdentificacion()
                        + "','" + cliente.getTelefono() + "','" + cliente.getDireccion() + "','" + cliente.getEstado()
                        + "','" + cliente.getCorreo() + "','" + cliente.getFotografia() + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en cliente \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en empleado" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar un cliente en la base de datos, la busqueda se realiza por medio de la cedula (id_empleado)
     * @param idEmpleado
     * @return
     */
    public ResultSet consultarClienteBD(String idEmpleado){
        
        String sql_select;
        sql_select="SELECT * FROM cliente WHERE identificacion ='"+idEmpleado+"';";
        
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
    
    /**
     * Metodo para consultar todos los clientes que se encuentran registrados en la base de datos 
     * @return
     */
    public ResultSet consultarTodosClientesBD(){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM cliente;";
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
    
    /**
     *  Metodo para realizar la actualización de un cliente en la base de datos
     * @param cliente
     * @return
     */
    public int actualizarClienteBD(Cliente cliente){
        
        int numFilas = 0;
        String sql_update;
        
            sql_update = "UPDATE cliente SET nombre='" + cliente.getNombre()+ "', apellido='" + cliente.getApellido()+ 
                    "',telefono='" + cliente.getTelefono() + "',direccion='" + cliente.getDireccion() + 
                    "',estado='" + cliente.getEstado() + "',correo='" + cliente.getCorreo() 
                    + "',fotografia='" + cliente.getFotografia()+                   
                    "' WHERE identificacion = '" + cliente.getIdentificacion()+"';";   
            
            System.out.println(sql_update);
        try{
                Connection conn= fachada.conectar_BD();
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
    }
}
