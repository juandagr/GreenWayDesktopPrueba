/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Clases.Ubicacion;
import Conexion.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class DaoUbicacion {
    
    //Atributos
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    //Constructor
    public DaoUbicacion() {
        fachada = new Fachada();
    }
    
    /**
     *metodo encargado de ingresar una ubicacion a la base de datos en la tabla ubicacion, el metodo recribe una ubicacion y lo guarda en la base de datos
     * @param ubicacion
     * @return 
     */
    public int ingresarUbicacionBD(Ubicacion ubicacion) {
        
        int numFilas;
        String consulta = "INSERT INTO ubicacion VALUES ('" + ubicacion.getId_ubicacion() + "','" + ubicacion.getDepartamento()
                        + "','" + ubicacion.getMunicipio()+ "','" + ubicacion.getVereda() + "');" ;
        try {
                Connection con = fachada.conectar_BD();
                instruccion = con.createStatement();
                numFilas = instruccion.executeUpdate(consulta);
                fachada.cerrarConexion(con);
                
        } catch (SQLException sqle) {
            
            System.out.println("Error de Sql al conectar en ubicacion \n" + sqle);
            numFilas = -1;

        } catch (Exception e) {
            
            System.out.println("Ocurrió cualquier otra excepcion en ubicacion" + e);
            numFilas = -1; 
        }
        return numFilas;
    }
    
    /**
     *  Metodo para consultar una ubicacion en la base de datos, la busqueda se realiza por medio del id de la ubicacion (id_ubicacion)
     * @param idUbicacion
     * @return
     */
    public ResultSet consultarUbicacionBD(String idUbicacion){
        
        String sql_select;
        sql_select="SELECT * FROM ubicacion WHERE id_ubicacion ='"+idUbicacion+"';";
        
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
     * Metodo para consultar todas las ubicaciones que se encuentran registrados en la base de datos 
     * @return
     */
    public ResultSet consultarTodasUbicacionesBD(){
        
        String sql_select;
        sql_select="SELECT DISTINCT * FROM ubicacion;";
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
     *  Metodo para realizar la actualización de una ubicacion en la base de datos
     * @param ubicacion
     * @return
     */
    public int actualizarUbicacionBD(Ubicacion ubicacion){
        
        int numFilas = 0;
        String sql_update;
        String id_ubicacionNueva = ubicacion.getDepartamento() + "-" + ubicacion.getMunicipio() + "-" + ubicacion.getVereda();
            sql_update = "UPDATE ubicacion SET id_ubicacion='" + id_ubicacionNueva + "', departamento='" + ubicacion.getDepartamento()+ 
                    "',municipio='" + ubicacion.getMunicipio()+ "',vereda='" + ubicacion.getVereda()+                   
                    "' WHERE id_ubicacion = '" + ubicacion.getId_ubicacion()+"';";   
            
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
