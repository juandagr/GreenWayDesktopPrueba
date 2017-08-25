/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Usuario;
import Dao.DaoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            mensaje = "No se pudo crear el usuario, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
        }
        return mensaje;
    } 
    
    //metodo para realizar la consulta de un usuario a la base de datos, este recibe la cedula del empleado asociado al cual se le desea
    //consultar el usuario y devuelve el objeto representando el mismo
    public Usuario consultarUsuario(String idEmpleado){
        
        Usuario usuario = null;
        ResultSet consulta = this.daoUsuario.consultarUsuarioPorId(idEmpleado);
        try {
            //se pregunta si el resultset no esta vacio, es decir si consulto algo
            if( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto
                String usuario_nombre = consulta.getString(1);
                String password = consulta.getString(2);
                boolean estado = consulta.getBoolean(3);
                String identificacion = consulta.getString(4);;
                
                //se crea el objeto una vez se hayan extraido los datos
                usuario = new Usuario(usuario_nombre, password, estado, identificacion);
  
            }
            else{
                //no se crea ningun objeto en caso de que no se haya cosultado nada
                usuario = null;
            }
        }

        catch (SQLException ex) {

        }
        
        return usuario;
        
    }
    
    //Metodo para verificar si un usuario ya ha sido registrado en la base de datos
    public boolean usuarioRegistrado(String nomreUsuario){
        boolean resultado = false;
        ResultSet rs = this.daoUsuario.consultarUsuarioPorNombre(nomreUsuario);
        
        try {
            if (rs.next()) {
                resultado = true;

            }else{

                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resultado;
    }
    
}
