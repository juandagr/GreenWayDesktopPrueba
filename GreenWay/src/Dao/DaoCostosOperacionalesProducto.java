/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.CostosInversion;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class DaoCostosOperacionalesProducto {
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoCostosOperacionalesProducto() {
        fachada = new Fachada();        
    }
    
    /**
     *metodo encargado de ingresar la informacion de costo operacional a la base de datos en la tabla lote, el metodo recribe un objeto de costos y lo guarda en la base de datos
     * @param loteId
     * @param item
     * @param anio
     * @param semana
     * @param dia
     * @param costoProducto
     * @param presentacion
     * @param volumenGastado
     * @param costoFinal
     * @return 
     */
    public int ingresarcostosOperacionalesProductoBD(String loteId, String item, String anio, String semana, String dia, double costoProducto, double presentacion, double volumenGastado, double costoFinal) {
        
        int numFilas;
        String consulta = "INSERT INTO costos_operacionales_producto VALUES ('" + loteId + "','" + item + "','" + anio
                        + "','" + semana + "','" + dia + "','" + costoProducto+ "','" + presentacion+ "','" + volumenGastado+ "','" + costoFinal + "');" ;
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
    
    /**
     *  Metodo para consultar los costos operacionales por semana que se encuentran regstrados en la base de datos, la busqueda se realiza por medio del id del lote (identificador)
     * @param loteId
     * @param anio
     * @param semana
     * @return
     */
    public ResultSet consultarCostosOperacionalesProductoxSemanaBD(String loteId, String anio, String semana){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM costos_operacionales_producto WHERE Lote_identificador ='"+loteId+"' AND anio ='" +anio+ "' AND semana ='"+semana+"';";
        
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
     * @param costoProducto
     * @param presentacion
     * @param volumenGastado
     * @param costoFinal
     * @return
     */
    public int actualizarCostosOperacionalesProductoBD(String loteId, String item, String anio, String semana, String dia, double costoProducto, double presentacion, double volumenGastado, double costoFinal){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE costos_operacionales_producto SET costo_producto='" + costoProducto+ "',presentacion='" + presentacion
                + "', volumen_gastado='" + volumenGastado+ "', costo_final='" + costoFinal + "' WHERE Lote_identificador ='"+loteId+ "' AND items_de_inversion_item ='"+item 
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
    
    public int eliminarCostosProductoBD(String loteId, String item, String anio, String semana) {
        
        int numFilas;
        String consulta = "DELETE FROM costos_operacionales_producto  WHERE Lote_identificador ='"+loteId+ "' AND items_de_inversion_item ='"+item 
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
    
    public List<CostosInversion> consultarCostosProductoxMesBD(String loteId, String anio, String s1,String s2,String s3,String s4,String s5 ){
        
        String sql_select;
        sql_select="SELECT  items_de_inversion_item, SUM(costo_final), SUM(volumen_gastado), AVG(costo_producto / presentacion) AS valor FROM costos_operacionales_producto WHERE Lote_identificador ='"+loteId+ "' AND anio ='" +anio
                + "' AND (semana ='"+s1+ "' OR semana ='"+s2+ "' OR semana ='"+s3+ "' OR semana ='"+s4+ "' OR semana ='"+s5+"') GROUP BY items_de_inversion_item"+";";
        try{System.err.println(sql_select);
            Connection conn= fachada.conectar_BD();
            instruccion = conn.createStatement();
            respuesta = instruccion.executeQuery(sql_select);
            fachada.cerrarConexion(conn);              
        }catch(SQLException e){
            
            System.out.println("Error al consultar datos");
        }
        
        
        
        List<CostosInversion> costos = new ArrayList();
        try {
            //se extraen los registros de la tabla cliente
            while( respuesta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto

                String item = respuesta.getString(1);
                Double valor = respuesta.getDouble(2);           
                String unidades = respuesta.getString(3)+" ml";           
                Double valorUnidad  = respuesta.getDouble(4);           
                //se crea el objeto una vez se hayan extraido los datos
                CostosInversion c = new CostosInversion(item, valor, valorUnidad, unidades);
                costos.add(c);
  
            }
        }

        catch (SQLException ex) {

        }
    
        return costos;
    }
}
