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
public class DaoValorFacturado {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoValorFacturado() {
        fachada = new Fachada();        
    }
    

    public int ingresarValorFacturadoBD(String loteId, String anio, String semana, int horas, double valorFacturado, double valorHora) {
        
        int numFilas;
        String consulta = "INSERT INTO valor_facturado_semana VALUES ('" + loteId + "','" + anio + "','" + semana + "','" + horas
                        + "','" + valorFacturado + "','"  + valorHora + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en valor facturado \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en historia clinica" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    

    public ResultSet consultarValorFacturadoBD(String loteId, String anio, String semana){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM valor_facturado_semana WHERE Cliente_identificacion ='"+loteId+ "' AND anio ='" +anio+ "' AND semana ='"+semana+ "';";
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
    

    public int actualizarHistoriaClinicaBD(String loteId, String anio, String semana, int horas, double valorFacturado, double valorHora){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE valor_facturado_semana SET horas='" + horas+ "', valor_facturado='" + valorFacturado+ "', valor_hora='" + valorHora+ "' WHERE Cliente_identificacion ='"+loteId
                + "' AND anio ='" +anio+ "' AND semana ='"+semana+"';";   
            
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
