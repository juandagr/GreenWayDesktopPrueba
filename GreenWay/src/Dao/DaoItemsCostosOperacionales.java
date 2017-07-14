/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DaoItemsCostosOperacionales {
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;

    public DaoItemsCostosOperacionales() {
        fachada = new Fachada();
    }
    
    public int ingresarItem(String subCategoria, String item){
        int numFilas = 0;
        String consulta = "INSERT INTO items_de_costos_operacionales (categoria, item) VALUES ('" + subCategoria + "','" + item + "');";
        
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en items_de_costos_operacionales\n" + sqle);
            numFilas = -1; 
        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en items_de_costos_operacionales" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    public ResultSet consultarItemCostosOperacionales(String item){
        
        String sql_select;
        sql_select="SELECT * FROM items_de_costos_operacionales WHERE item = '"+item+"';";
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
    
    public ResultSet consultarItemsCostosOperacionales(){
        
        String sql_select;
        sql_select="SELECT * FROM items_de_costos_operacionales;";
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
    
    public ResultSet consultarItemsCostosOperacionalesPorCategoria(String categoria){
        
        String sql_select;
        sql_select="SELECT * FROM items_de_costos_operacionales WHERE categoria = '"+categoria+"';";
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
    
    public int eliminarItem(String item){
        int numFilas = 0;
        String consulta = "DELETE FROM items_de_costos_operacionales WHERE item = '"+item+"';";
        
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en items_de_costos_operacionales\n" + sqle);
            numFilas = -1; 
        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en items_de_costos_operacionales" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
}
