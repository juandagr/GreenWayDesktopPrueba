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
    public int ingresarCultivoBD(Ubicacion ubicacion) {
        
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
    
}
