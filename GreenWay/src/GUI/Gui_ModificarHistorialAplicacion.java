/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Clases.*;
import Controlador.ControladorEmpleado;
import Controlador.ControladorHistoriaClinica;
import Controlador.ControladorHistorialAplicacion;
import Controlador.ControladorUsuario;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author
 */
public class Gui_ModificarHistorialAplicacion extends javax.swing.JFrame {

    //Atributos
    //GUI de la ventana principal del gerente
    GUI_HistorialAplicacion gui_historiaClinica;
    
    //Constructor
    public Gui_ModificarHistorialAplicacion(GUI_HistorialAplicacion gui_historiaClinica, String loteId, String anio, String semana, String dia, String producto_utilizado) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gui_historiaClinica = gui_historiaClinica;        

        this.jTextFieldLote.setText(this.gui_historiaClinica.gui_infoLotes.gui_adminLotes.loteID);
        this.jTextFieldLote.setEditable(false);
        this.llenarDatos(loteId, anio, semana, dia, producto_utilizado);
    }
    
    public void llenarDatos(String loteId, String anio, String semana, String dia, String producto_utilizado){
        String id_historial = loteId+"-"+anio+"-"+semana+"-"+dia;
        HistorialAplicacion hs = new ControladorHistorialAplicacion().consultarHistorialAplicacion(loteId, id_historial, anio, semana, dia, producto_utilizado);
        
        this.jTextFieldSemana.setText(hs.getSemana()); 
        this.jTextFieldDia.setText(hs.getDia());
        this.jTextFieldAño.setText(hs.getAnio());
        this.jTextAreaObjetivo.setText(hs.getObjetivoBiologico()); 
        this.jTextFieldDosis.setText(String.valueOf(hs.getDosis_por_litro())); 
        this.jTextFieldVolumen.setText(String.valueOf(hs.getVolumen_utilizado())); 
        this.jTextFieldProductoUtilizado.setText(hs.getProducto_utilizado()); 
        
        this.jTextFieldSemana.setEditable(false);
        this.jTextFieldDia.setEditable(false);
        this.jTextAreaObjetivo.setEditable(true);
        this.jTextFieldAño.setEditable(false);
    }

    
    //metodo para agregar un empleado a la base de datos
    public String modificarHistorial(String Lote_identificador, String id_historial, String anio, String semana, String dia, String objetivoBiologico, String producto_utilizado, double dosis_por_litro, double volumen_utilizado){
        //variable que almacenara el resultado
        String resultado = "";     
        
        //creacion de  controlador para realizar el ingreso del empleado y el usuario, tambien de la clase que valida los campos
        ControladorHistorialAplicacion controladorHistorial = new ControladorHistorialAplicacion();
        Validaciones validar = new Validaciones();
        
        try {
            //se verifica que no haya campos obligatorios vacios, que los tipos de datos sean correctos asi como los datos que deben estar dentro de un rango como el cargo y estado civil
            if ((verificarCamposVacios() == false) && verificarTipos() && validar.validarDia(dia)) {
                //se verifica que el empleado no haya sido creado anteriormente por medio de la identificacion
                if (controladorHistorial.HistorialAplicacionRegistrado(Lote_identificador, id_historial, anio, semana, dia, producto_utilizado)) {
                    
                    if ((jTextAreaObjetivo.getText().length() < 21) && (jTextFieldProductoUtilizado.getText().length() < 21)) {
                        
                        resultado = controladorHistorial.actualizarHistorialAplicacion(Lote_identificador, id_historial, anio, semana, dia, objetivoBiologico, producto_utilizado, dosis_por_litro, volumen_utilizado);
                        limpiar();
                    
                    }else{
                        resultado = "El objetivo biologico y el producto utilizado, deben tener menos de 20 letras.";
                    }
                    
                }else{
                    
                    resultado = "El historial de aplicacion no se encuentra registrado.";
                    //JOptionPane.showMessageDialog(null, "El empleado ya se encuentra registrado.", "Error!", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }                
                
            }else{
                resultado = "No se pudo modificar el historial de aplicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
                //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NullPointerException ex) {
            resultado = "No se pudo modificar el historial de aplicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(Gui_ModificarHistorialAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAño = new javax.swing.JTextField();
        jTextFieldSemana = new javax.swing.JTextField();
        jTextFieldLote = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObjetivo = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldProductoUtilizado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDosis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldVolumen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonagregar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Historial de aplicacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 0, 255)));

        jLabel1.setText("Lote:");

        jLabel2.setText("Año:");

        jLabel3.setText("Semana:");

        jTextFieldAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAñoKeyTyped(evt);
            }
        });

        jTextFieldSemana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSemanaKeyTyped(evt);
            }
        });

        jTextFieldLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoteActionPerformed(evt);
            }
        });
        jTextFieldLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLoteKeyTyped(evt);
            }
        });

        jLabel13.setText("Dia:");

        jTextFieldDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDiaKeyTyped(evt);
            }
        });

        jTextAreaObjetivo.setColumns(20);
        jTextAreaObjetivo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObjetivo);

        jLabel14.setText("Objetivo biologico");

        jLabel4.setText("Producto utilizado: ");

        jTextFieldProductoUtilizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldProductoUtilizadoKeyTyped(evt);
            }
        });

        jLabel5.setText("Dosis por litro:");

        jTextFieldDosis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDosisKeyTyped(evt);
            }
        });

        jLabel6.setText("Volumen utilizado:");

        jTextFieldVolumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVolumenKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProductoUtilizado, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldProductoUtilizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButtonagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Save).jpg"))); // NOI18N
        jButtonagregar.setText("agregar");
        jButtonagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonagregarActionPerformed(evt);
            }
        });

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Delete).jpg"))); // NOI18N
        jButtonSalir.setText("salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButtonagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonagregar)
                    .addComponent(jButtonSalir))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(668, 668, 668))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonagregarActionPerformed
        
        if (verificarTipos()) {
            // Obtencion de datos de la interfaz
            String lote=jTextFieldLote.getText().trim();
            String anio =jTextFieldAño.getText().trim();
            String semana = jTextFieldSemana.getText().trim();
            String dia = jTextFieldDia.getText().trim();
            String objetivo_biologico = jTextAreaObjetivo.getText().trim();
            String producto_utilizado = jTextFieldProductoUtilizado.getText().trim();
            double dosis_por_litro = Double.parseDouble(jTextFieldDosis.getText().trim());
            double volumen_utilizado = Double.parseDouble(jTextFieldVolumen.getText().trim());
            String id_historial = lote+"-"+anio+"-"+semana+"-"+dia;
            
            String resultado = this.modificarHistorial(lote, id_historial, anio, semana, dia, objetivo_biologico, producto_utilizado, dosis_por_litro, volumen_utilizado);

            if (resultado.equalsIgnoreCase("No se pudo modificar el historial de aplicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
                JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
            }else if (resultado.equalsIgnoreCase("El historial de aplicacion no se encuentra registrado.")) {
                JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
            }else if (resultado.equalsIgnoreCase("El objetivo biologico y el producto utilizado, deben tener menos de 20 letras.")) {
                JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
                try{
                    this.gui_historiaClinica.setVisible(true);
                    this.gui_historiaClinica.buscarHistoriales();
                    this.dispose();
                  }catch(Exception e){}
            }
        }else{
            JOptionPane.showMessageDialog(null,  "Por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonagregarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
         try{
         this.gui_historiaClinica.setVisible(true);
         this.gui_historiaClinica.buscarHistoriales();
         this.dispose();
       }catch(Exception e){}

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextFieldDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiaKeyTyped

    private void jTextFieldLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoteKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldLote.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldLoteKeyTyped

    private void jTextFieldLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLoteActionPerformed

    private void jTextFieldSemanaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSemanaKeyTyped
        char car=evt.getKeyChar();
        if(  jTextFieldSemana.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSemanaKeyTyped

    private void jTextFieldAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAñoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldAño.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldAñoKeyTyped

    private void jTextFieldProductoUtilizadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProductoUtilizadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductoUtilizadoKeyTyped

    private void jTextFieldDosisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDosisKeyTyped
        
    }//GEN-LAST:event_jTextFieldDosisKeyTyped

    private void jTextFieldVolumenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVolumenKeyTyped
        
    }//GEN-LAST:event_jTextFieldVolumenKeyTyped

    //Metodo para limpiar los campos de la interfaz grafica de usuario y devolverlos a su estado inicial
    public void limpiar(){
        this.jTextFieldAño.setText("");
        this.jTextFieldSemana.setText(""); 
        this.jTextFieldDia.setText(""); 
        this.jTextAreaObjetivo.setText(""); 
        this.jTextFieldDosis.setText(""); 
        this.jTextFieldProductoUtilizado.setText(""); 
        this.jTextFieldVolumen.setText(""); 

    }
     
    //Metodo para habilitar los campos de la interfaz grafica de usuario y asignar sus estado inicial 
    public void habilitar(){
        this.jTextFieldAño.setEnabled(true);
        this.jTextFieldSemana.setEnabled(true); 
        this.jTextFieldDia.setEnabled(true); 
        this.jTextAreaObjetivo.setEnabled(true); 
        this.jTextFieldDosis.setEnabled(true);  
        this.jTextFieldProductoUtilizado.setEnabled(true); 
        this.jTextFieldVolumen.setEnabled(true); 

    }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarCamposVacios(){
         boolean var =false;
         
         if (jTextFieldLote.getText().equalsIgnoreCase("") || jTextFieldAño.getText().equalsIgnoreCase("") ||
                 jTextFieldSemana.getText().equalsIgnoreCase("") || jTextFieldDia.getText().equalsIgnoreCase("") || jTextAreaObjetivo.getText().equalsIgnoreCase("")
                 || jTextFieldDosis.getText().equalsIgnoreCase("")|| jTextFieldProductoUtilizado.getText().equalsIgnoreCase("")|| jTextFieldVolumen.getText().equalsIgnoreCase("")) {
             
             var = true;             
         }
         
         return var;
     }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarTipos(){
         
         boolean var =false;
         Validaciones validar = new Validaciones();
         
         if (validar.isNumeric(jTextFieldAño.getText().trim()) && validar.isNumeric(jTextFieldSemana.getText().trim())
                 && validar.isNumeric(jTextFieldDosis.getText().trim())&& validar.isNumeric(jTextFieldVolumen.getText().trim())) {
            var = true;             
         }
         
         return var;
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistorialAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistorialAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistorialAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistorialAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_ModificarHistorialAplicacion(null, null, null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonagregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaObjetivo;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldDosis;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldProductoUtilizado;
    private javax.swing.JTextField jTextFieldSemana;
    private javax.swing.JTextField jTextFieldVolumen;
    // End of variables declaration//GEN-END:variables
}
