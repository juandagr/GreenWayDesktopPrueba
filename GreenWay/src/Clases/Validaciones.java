/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class Validaciones {

    public Validaciones() {
    }
    
    //metodo para validar si el dato leido es un numero
    public boolean isNumeric(String cadena){
         return (cadena.matches("[+-]?\\d*(\\.\\d+)?") && cadena.equals("")==false);
    }
    
    //metodo para validar si el dato leido es un numero
    public boolean isString(String cadena){
        boolean var = true;
        try{
            Integer.parseInt(cadena);
            var = false;
        }catch(NumberFormatException e){
            var = true;
        }
        
        return var;
    }
    
    //metodo para validar que el cargo de un empleado este dentro de las posibles opciones correctas
    public boolean validarCargoEmpleado(String cargo){
        boolean var = false;
        if (cargo.equalsIgnoreCase("Gerente") || cargo.equalsIgnoreCase("Digitador") || cargo.equalsIgnoreCase("Administrador")) {
            var = true;
        }
        return var;
    }

    //metodo para validar que el estado civil de un empleado este dentro de las posibles opciones correctas
    public boolean validarEstadoCivilEmpleado(String estadoCivil){
        boolean var = false;
        if (estadoCivil.equalsIgnoreCase("soltero") || estadoCivil.equalsIgnoreCase("casado") ||
                estadoCivil.equalsIgnoreCase("viudo") ||estadoCivil.equalsIgnoreCase("divorciado")||estadoCivil.equalsIgnoreCase("union libre")) {
            var = true;
        }
        return var;
    }
    
}
