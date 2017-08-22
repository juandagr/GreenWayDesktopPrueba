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
    
    public ResultSet consultarItemInversion(String identificacion){
        
        String sql_select;
        sql_select="SELECT * FROM Usuario WHERE Empleado_identificacion = '"+identificacion+"';";
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
}
