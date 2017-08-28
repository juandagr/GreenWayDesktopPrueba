/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Usuario;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoUsuario {
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;

    public DaoUsuario() {
        fachada = new Fachada();
    }
    
    /**
     * Metodo encargado de ingresar un usuario a la base de datos en la tabla usuario, el metodo recribe un usuario y lo guarda en la base de datos
     * @param usuario
     * @return
     */
    public int ingresarUsuarioBD(Usuario usuario){
        int numFilas = 0;
        String consulta = "INSERT INTO Usuario (usuario, password, estado, Empleado_identificacion) "
                + "VALUES ('" + usuario.getUsuario() + "','" + usuario.getPassword() + "','" + usuario.getEstado() + "','" + usuario.getIdentificacion() + "');";
        
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en usuario \n" + sqle);
            numFilas = -1; 
        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en usuario" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     * Metodo para consultar un usuario en la base de datos, la busqueda se realiza por medio de la identificacion del empleado al cual corresponde el usuario
     * @param idUsuario
     * @return
     */
    public ResultSet consultarUsuarioPorId(String idUsuario){
        
        String sql_select;
        sql_select="SELECT * FROM usuario WHERE empleado_identificacion ='"+idUsuario+"';";
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
     * Metodo para consultar un usuario en la base de datos, la busqueda se realiza por medio del nombre de usuario
     * @param nombreUsuario
     * @return
     */
    public ResultSet consultarUsuarioPorNombre(String nombreUsuario){
        
        String sql_select;
        sql_select="SELECT * FROM usuario WHERE usuario ='"+nombreUsuario+"';";
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
     *  Metodo para realizar la actualización de un usuario en la base de datos
     * @param usuario
     * @return
     */
    public int actualizarUsuarioBD(Usuario usuario){
        
        int numFilas = 0;
        String sql_update;
        
            sql_update = "UPDATE empleado SET usuario='" + usuario.getUsuario() + "', password='" + usuario.getPassword()+ 
                    "',estado='" + usuario.getEstado() + "', empleado_identificacion='" + usuario.getIdentificacion() +
                    "' WHERE id_empleado= '" + usuario.getIdentificacion()+"';";         
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
