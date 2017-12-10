/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Produccion;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoProduccion {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoProduccion() {
        fachada = new Fachada();        
    }
    
    /**
     *metodo encargado de ingresar la informacion de produccion a la base de datos
     * @param loteId
     * @param anio
     * @param semana
     * @param dia
     * @param selecta
     * @param corriente
     * @param insustrial
     * @param produccion
     * @return 
     */
    public int ingresarProduccionBD(Produccion produccion) {
        
        int numFilas;
        String consulta = "INSERT INTO produccion VALUES ('" + produccion.getLote_identificador() + "','" + produccion.getAnio() + "','" + produccion.getSemana()
                        + "','" + produccion.getDia() +"','" + produccion.getSelecta() +"','" + produccion.getCorriente() + "','"  + produccion.getIndustrial() + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en produccion \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en historia clinica" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar un registro de produccion que se encuentran regstrados en la base de datos
     * @param loteId
     * @param anio
     * @param semana
     * @param dia
     * @return
     */
    public ResultSet consultarProduccionBD(String loteId, String anio, String semana, String dia){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM produccion WHERE Lote_identificador ='"+loteId+ "' AND anio ='" +anio+ "' AND semana ='"+semana+ "' AND dia ='" +dia+"';";
        
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
     *  Metodo para consultar los registros de produccion por lote que se encuentran regstrados en la base de datos
     * @param loteId
     * @return
     */
    public ResultSet consultarProduccionxLoteBD(String loteId){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM produccion WHERE Lote_identificador ='"+loteId+"';";
        
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
     * @param produccion
     * @return
     */
    public int actualizarproduccionBD(Produccion produccion){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE produccion SET selecta=" + produccion.getSelecta()+ " , corriente=" + produccion.getCorriente()+ " , industrial=" + produccion.getIndustrial()+ " WHERE Lote_identificador ='"+produccion.getLote_identificador()
                + "' AND anio ='" +produccion.getAnio()+ "' AND semana ='"+produccion.getSemana()+"' AND dia ='" +produccion.getDia()+"';";   
            
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
