/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Cultivo;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoCultivo {
    
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoCultivo() {
        fachada = new Fachada();        
    }
    
    /**
     *metodo encargado de ingresar un cultivo a la base de datos en la tabla cultivo, el metodo recribe un cultivo y lo guarda en la base de datos
     * @param cultivo
     * @return 
     */
    public int ingresarCultivoBD(Cultivo cultivo) {
        
        int numFilas;
        String consulta = "INSERT INTO cultivo VALUES ('" + cultivo.getIdentificador() + "','" + cultivo.getNombre() 
                        + "','" + cultivo.getDescripcion() + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en cultivo \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en cultivo" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar un cultivo en la base de datos, la busqueda se realiza por medio del id del cultivo (identificador)
     * @param identificador
     * @return
     */
    public ResultSet consultarCultivoBD(String identificador){
        
        String sql_select;
        sql_select="SELECT * FROM cultivo WHERE identificador ='"+identificador+"';";
        
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
     * Metodo para consultar todos los cultivos que se encuentran registrados en la base de datos 
     * @return
     */
    public ResultSet consultarTodosCultivosBD(){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM cultivo;";
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
     *  Metodo para realizar la actualización de un cultivo en la base de datos
     * @param cultivo
     * @return
     */
    public int actualizarCultivoBD(Cultivo cultivo){
        
        int numFilas = 0;
        String sql_update;
        sql_update = "UPDATE cultivo SET identificador='" + cultivo.getNombre() + "',nombre='" + cultivo.getNombre()+ 
                "',descripcion='" + cultivo.getDescripcion()+                   
                "' WHERE identificador = '" + cultivo.getIdentificador()+"';";   
            
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
