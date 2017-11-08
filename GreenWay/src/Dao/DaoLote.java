/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Lote;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoLote {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoLote() {
        fachada = new Fachada();        
    }
    
    /**
     *metodo encargado de ingresar un Lote a la base de datos en la tabla lote, el metodo recribe un lote y lo guarda en la base de datos
     * @param lote
     * @return 
     */
    public int ingresarLoteBD(Lote lote) {
        
        int numFilas;
        String consulta = "INSERT INTO lote VALUES ('" + lote.getCliente_identificacion() + "','" + lote.getCultivo_identificador() + "','" + lote.getIdentificador()
                        + "','" + lote.getArea() + "','" + lote.getNumero_plantas() + "','" + lote.getCosto_por_hora() + "','"
                        + lote.getUbicacion_id_ubicacion() + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en lote \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en lote" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar un lote en la base de datos, la busqueda se realiza por medio del id del lote (identificador)
     * @param identificador
     * @return
     */
    public ResultSet consultarLoteBD(String identificador){
        
        String sql_select;
        sql_select="SELECT * FROM lote WHERE identificador ='"+identificador+"';";
        
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
     * Metodo para consultar todos los lotes que se encuentran registrados en la base de datos 
     * @return
     */
    public ResultSet consultarTodosLoteBD(){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM lote;";
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
     * Metodo para consultar todos los lotes que se encuentran registrados a un cliente en la base de datos 
     * @return
     */
    public ResultSet consultarLotesClienteBD(String cliente){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM lote WHERE cliente_identificacion = '"+cliente+"';";
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
     *  Metodo para realizar la actualización de un lote en la base de datos
     * @param lote
     * @return
     */
    public int actualizarLoteBD(Lote lote){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE lote SET cliente_identificacion='" + lote.getCliente_identificacion()+ "', cultivo_identificador='" + lote.getCultivo_identificador()+ 
                    "',identificador='" + lote.getIdentificador() + "',area='" + lote.getArea() + 
                    "',numero_plantas='" + lote.getNumero_plantas() + "',costo_por_hora='" + lote.getCosto_por_hora()
                    +  "' WHERE ubicacion_id_ubicacion = '" + lote.getUbicacion_id_ubicacion()+"';";   
            
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
