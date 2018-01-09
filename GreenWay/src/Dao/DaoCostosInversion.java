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

/**
 *
 * @author Daniel
 */
public class DaoCostosInversion {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoCostosInversion() {
        fachada = new Fachada();        
    }
    
    /**
     *metodo encargado de ingresar la informacion de costo operacional a la base de datos en la tabla lote, el metodo recribe un objeto de costos y lo guarda en la base de datos
     * @param loteId
     * @param item
     * @param anio
     * @param semana
     * @param dia
     * @param valor
     * @return 
     */
    public int ingresarcostosInversionBD(String loteId, String item, String anio, String semana, String dia, int valor) {
        
        int numFilas;
        String consulta = "INSERT INTO costos_inversion VALUES ('" + loteId + "','" + item + "','" + anio
                        + "','" + semana + "','" + dia + "','" + valor + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en costos operacionales \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en costos operacionales" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar los costos operacionales por semana que se encuentran regstrados en la base de datos, la busqueda se realiza por medio del id del lote (identificador)
     * @param loteId
     * @param anio
     * @param semana
     * @return
     */
    public ResultSet consultarCostosInversionxSemanaBD(String loteId, String anio, String semana){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM costos_inversion WHERE Lote_identificador ='"+loteId+ "' AND anio ='" +anio+ "' AND semana ='"+semana+"';";
        
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
     *  Metodo para realizar la actualización de un registro de costo operacional que se encuentre en la base de datos
     * @param loteId
     * @param item
     * @param anio
     * @param semana
     * @param dia
     * @param valor
     * @return
     */
    public int actualizarCostosInversionBD(String loteId, String item, String anio, String semana, String dia, int valor){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE costos_inversion SET valor='" + valor+ "' WHERE Lote_identificador ='"+loteId+ "' AND items_de_inversion_item ='"+item 
                + "' AND anio ='" +anio+ "' AND semana ='"+semana+"' AND dia ='" +dia+"';";   
            
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
    
    public int eliminarCostosInversionBD(String loteId, String item, String anio, String semana) {
        
        int numFilas;
        String consulta = "DELETE FROM costos_inversion  WHERE Lote_identificador ='"+loteId+ "' AND items_de_inversion_item ='"+item 
                + "' AND anio ='" +anio+ "' AND semana ='"+semana+"';";   
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en costos operacionales \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en costos operacionales" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
}

