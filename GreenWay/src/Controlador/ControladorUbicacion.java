/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Ubicacion;
import Dao.DaoUbicacion;

/**
 *
 * @author Daniel
 */
public class ControladorUbicacion {
    //Atributos
    private DaoUbicacion daoUbicacion;
    
    //Constructor
    public ControladorUbicacion() {
        this.daoUbicacion = new DaoUbicacion();
    }
    
    /**
     *Metodo para realizar el ingreso de una ubicacion a la base de datos, dados los datos recibidos desde una interfaz de usuario
     * @param id_ubicacion , 
     * @param departamento
     * @param municipio
     * @param vereda
     * @return String mensaje
     */
    public String ingresarUbicacion(String id_ubicacion, String departamento, String municipio, String vereda){
       
        String mensaje = "Ubicacion creada exitosamente." ;
        Ubicacion ubicacion = new Ubicacion(id_ubicacion, departamento, municipio, vereda);
                              
        int filaRegistro = this.daoUbicacion.ingresarUbicacionBD(ubicacion);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del ubicacion";
        }
        return mensaje;
    } 
}
