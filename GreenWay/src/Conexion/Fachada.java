 

package Conexion;

/**************************************************/
import java.sql.*;
/**************************************************/


/**************************************************/
//Declaracion de la clase
public class Fachada {
    
    
    /**************************************************/
    //Atributos
    private String url, usuario, contrasena;
    private Connection conexion;
    /**************************************************/
    
    
    /**************************************************/
    //Constructor
    public Fachada(){

        url = "jdbc:postgresql://localHost:5432/GreenWay_BD";
        
        usuario="postgres";
        contrasena ="postgres";
        
    }
    /**************************************************/
    
    
    /**************************************************/
    //Metodo que se encarga de conectarse a la base de datos
    //  -> conectar_BD -> Connection
    public Connection conectar_BD(){

        try{
            
            Class.forName("org.postgresql.Driver");
            
            System.out.println( "Driver Cargado" );
            
        }
        
        catch(Exception e){
            
            System.out.println( "No se pudo cargar el driver " + e );
            
        }
              
        try{
            
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            
            System.out.println( "Conexion Abierta" );
            
            return conexion;
            
        }
        
        catch( Exception e ) {
            
            System.out.println( "No se pudo abrir " + e );
            
            return null;
            
        }
        
    }
    /**************************************************/
    
    
    /**************************************************/
    //Metodo que cierra la conexion a la base de datos
    //Connection -> cerrarConexion -> void
    public void cerrarConexion(Connection c){
        
        try{
            
            c.close();
            
           }
        
        catch( Exception e ) {
            
            System.out.println( "No se pudo cerrar la conexion" );
                
            }
        
    }
    /**************************************************/
    
    
}
/**************************************************/