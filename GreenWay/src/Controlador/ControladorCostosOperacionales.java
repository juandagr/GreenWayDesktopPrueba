/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoItemsCostosOperacionales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ControladorCostosOperacionales {
    private DaoItemsCostosOperacionales dao;

    public ControladorCostosOperacionales() {
        this.dao = new DaoItemsCostosOperacionales();
    }
    
    public String ingresarItem(String subCategoria, String item){
        String mensaje = "Ingreso un item exitosamente" ;
                              
        int filaRegistro = dao.ingresarItem(subCategoria, item);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del item";
        }
        
        return mensaje;
    }
    
    public String eliminarItem(String item){
        String mensaje = "Elimino un item exitosamente" ;
                              
        int filaRegistro = dao.eliminarItem(item);

        if (filaRegistro == 0) {
            
            mensaje = "Fallo en la eliminacion del item";
        }
        
        return mensaje;
    }
    
    
    public String existeItem(String item){
        String mensaje = null ;
                              
        ResultSet rs = dao.consultarItemCostosOperacionales(item);

        try {
            if ( rs.next() )
            {
                mensaje = "El item ya se encuentra registrado en la base de datos";
            }
            else {
                mensaje =  "No existe";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItemsInversion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mensaje;
    }
}
