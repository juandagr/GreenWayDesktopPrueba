/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Usuario;
import Dao.DaoUsuario;

/**
 *
 * @author Daniel
 */
public class ControladorUsuario {
    
    //Atributos
    private DaoUsuario daoUsuario;
    
    //Constructor
    public ControladorUsuario() {
        this.daoUsuario = new DaoUsuario();
    }
    
    //metodo para realizar el ingreso de un usuario a la base de datos, dados los datos
    //recibidos desde una interfaz de usuario
    public String ingresarUsuario(String nombreUsuario, String password, boolean estado, String identificacion){
       
        String mensaje = "Usuario creado exitosamente." ;
        Usuario usuario = new Usuario(nombreUsuario, password, estado, identificacion);
                              
        int filaRegistro = this.daoUsuario.ingresarUsuarioBD(usuario);

        if (filaRegistro == -1) {
            
            mensaje = "Fallo el ingreso del empleado";
        }
        return mensaje;
    } 
    
}
