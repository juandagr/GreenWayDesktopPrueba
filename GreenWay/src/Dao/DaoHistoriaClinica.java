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
public class DaoHistoriaClinica {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoHistoriaClinica() {
        fachada = new Fachada();        
    }
    
    /**
     *metodo encargado de ingresar la informacion de historia clinica a la base de datos
     * @param loteId
     * @param anio
     * @param semana
     * @param dia
     * @param descripcion
     * @return 
     */
    public int ingresarHistoriaClinicaBD(String loteId, String anio, String semana, String dia, String descripcion) {
        
        int numFilas;
        String consulta = "INSERT INTO historia_clinica VALUES ('" + loteId + "','" + anio + "','" + semana
                        + "','" + dia + "','"  + descripcion + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en historia clinica \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en historia clinica" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar una historia clinica que se encuentran regstrados en la base de datos
     * @param loteId
     * @param anio
     * @param semana
     * @param dia
     * @return
     */
    public ResultSet consultarHistoriaClinicaBD(String loteId, String anio, String semana, String dia){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM historia_clinica WHERE Lote_identificador ='"+loteId+ "' AND anio ='" +anio+ "' AND semana ='"+semana+ "' AND dia ='" +dia+"';";
        
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
     *  Metodo para consultar una historia clinica que se encuentran regstrados en la base de datos
     * @param loteId
     * @param anio
     * @param semana
     * @param dia
     * @return
     */
    public ResultSet consultarHistoriasClinicasxLoteBD(String loteId){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM historia_clinica WHERE Lote_identificador ='"+loteId+"';";
        
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
     * @param anio
     * @param semana
     * @param dia
     * @param descripcion
     * @return
     */
    public int actualizarHistoriaClinicaBD(String loteId, String anio, String semana, String dia, String descripcion){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE historia_clinica SET descripcion='" + descripcion+ "' WHERE Lote_identificador ='"+loteId
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
    
    public ResultSet consultarHistoriasClinicasxMesBD(String loteId, String anio, String s1,String s2,String s3,String s4,String s5 ){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM historia_clinica WHERE Lote_identificador ='"+loteId+ "' AND anio ='" +anio
                + "' AND (semana ='"+s1+ "' OR semana ='"+s2+ "' OR semana ='"+s3+ "' OR semana ='"+s4+ "' OR semana ='"+s5+"')"+";";
        
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
