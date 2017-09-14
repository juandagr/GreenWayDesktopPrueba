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
}
