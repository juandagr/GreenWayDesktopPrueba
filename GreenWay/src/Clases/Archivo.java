package Clases;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


import java.sql.Date;
import java.util.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAGALI
 */
public class Archivo {
    
    File file;
    
    
    public Archivo(){
        
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
    public void guardarEnArchivo(String file,String datos){
        
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try{
            fw = new FileWriter(new File(file), true);
            pw = new PrintWriter(fw);
            

                
            pw.println(datos);

                  
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (fw != null) {
                    fw.close();
                }
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
        
        
    }
    
}
