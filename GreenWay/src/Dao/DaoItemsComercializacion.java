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


public class DaoItemsComercializacion {
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;

    public DaoItemsComercializacion() {
        fachada = new Fachada();
    }
    
    public int ingresarItem(String item){
        int numFilas = 0;
        String consulta = "INSERT INTO items_de_comercializacion (item) VALUES ('" + item + "');";
        
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en items_de_comercializacion\n" + sqle);
            numFilas = -1; 
        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en items_de_comercializacion" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    public ResultSet consultarItemsComercializacion(){
        
        String sql_select;
        sql_select="SELECT * FROM items_de_comercializacion;";
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
    
    public ResultSet consultarItemsComercializacionPorCategoria(String categoria){
        
        String sql_select;
        sql_select="SELECT * FROM items_de_comercializacion WHERE categoria = '"+categoria+"';";
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
        String consulta = "DELETE FROM items_de_comercializacion WHERE item = '"+item+"';";
        
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en items_de_comercializacion\n" + sqle);
            numFilas = -1; 
        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en items_de_comercializacion" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
}
