/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DaoItemsComercializacion;

/**
 *
 * @author Daniel
 */
public class ControladorItemsComercializacion {
    
    DaoItemsComercializacion dao;

    public ControladorItemsComercializacion() {
        this.dao = new DaoItemsComercializacion();
    }
    
    public String ingresarItem(String item){
        String mensaje = "Ingreso un item exitosamente" ;
                              
        int filaRegistro = dao.ingresarItem(item);

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
}
