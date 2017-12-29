/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.HistorialAplicacion;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoHistorialAplicacion {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoHistorialAplicacion() {
        fachada = new Fachada();        
    }
    
  
    public int ingresarHistorialAplicacionBD(HistorialAplicacion historial) {
        
        int numFilas;
        String consulta = "INSERT INTO historial_aplicacion VALUES ('" + historial.getLote_identificador() + "','" + historial.getId_historial() + "','" + historial.getAnio()
                        + "','" + historial.getSemana() + "','" + historial.getDia() + "','" + historial.getObjetivoBiologico()+ "','" + historial.getProducto_utilizado()+ "','" + historial.getDosis_por_litro()+ "','" + historial.getVolumen_utilizado() + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en costos operacionales por producto \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en costos operacionales por producto" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    

    public ResultSet consultarHistorialAplicacionBD(String loteId, String id_historial, String anio, String semana, String dia){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM historial_aplicacion WHERE lote_identificador ='"+loteId+"' AND id_historial ='" +id_historial+"' AND anio ='" +anio+ "' AND semana ='"+semana+"' AND dia ='" +dia+"';";
        
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
    
    

    public int actualizarHistorialAplicacionBD(HistorialAplicacion historial){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE historial_aplicacion SET objetivo_biologico='" + historial.getObjetivoBiologico()+ "',producto_utilizado='" + historial.getProducto_utilizado()
                + "', dosis_por_litro='" + historial.getDosis_por_litro()+ "', volumen_utilizado='" + historial.getVolumen_utilizado() + "' WHERE Lote_identificador ='"+historial.getLote_identificador()+ "' AND id_historial ='"+historial.getId_historial()
                + "' AND anio ='" +historial.getAnio()+ "' AND semana ='"+historial.getSemana()+"' AND dia ='" +historial.getDia()+"';";   
            
            
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
    
    public ResultSet consultarHistorialxLoteBD(String loteId){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM historial_aplicacion WHERE Lote_identificador ='"+loteId+"';";
        
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