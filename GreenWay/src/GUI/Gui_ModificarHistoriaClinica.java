/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Clases.*;
import Controlador.ControladorEmpleado;
import Controlador.ControladorHistoriaClinica;
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
public class Gui_ModificarHistoriaClinica extends javax.swing.JFrame {

    //Atributos
    //GUI de la ventana principal del gerente
    GUI_HistoriaClinica gui_historiaClinica;
    
    //Constructor
    public Gui_ModificarHistoriaClinica(GUI_HistoriaClinica gui_historiaClinica, String loteId, String anio, String semana, String dia) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gui_historiaClinica = gui_historiaClinica;        

        this.jTextFieldLote.setText(this.gui_historiaClinica.gui_infoLotes.gui_adminLotes.loteID);
        this.jTextFieldLote.setEditable(false);
        
        this.llenarDatos(loteId, anio, semana, dia);
    }
    
    public void llenarDatos(String loteId, String anio, String semana, String dia){
        HistoriaClinica hs = new ControladorHistoriaClinica().consultarHistoriaClinica(loteId, anio, semana, dia);
        
        this.jTextFieldSemana.setText(hs.getSemana()); 
        this.jTextFieldDia.setText(hs.getDia()); 
        this.jTextArea1.setText(hs.getDescripcion()); 
        this.jTextFieldAño.setText(hs.getAnio()); 
        this.jTextFieldSemana.setEditable(false);
        this.jTextFieldDia.setEditable(false);
        this.jTextArea1.setEditable(true);
        this.jTextFieldAño.setEditable(false);
    }


    //metodo para agregar un empleado a la base de datos
    public String modificarHistoria(String loteId, String anio, String semana, String dia, String descripcion){
        //variable que almacenara el resultado
        String resultado = "";     
        
        //creacion de  controlador para realizar el ingreso del empleado y el usuario, tambien de la clase que valida los campos
        ControladorHistoriaClinica controladorHistoria = new ControladorHistoriaClinica();
        Validaciones validar = new Validaciones();
        
        try {
            //se verifica que no haya campos obligatorios vacios, que los tipos de datos sean correctos asi como los datos que deben estar dentro de un rango como el cargo y estado civil
            if ((verificarCamposVacios() == false) && verificarTipos()&& validar.validarDia(dia)) {
                //se verifica que el empleado no haya sido creado anteriormente por medio de la identificacion
                if (controladorHistoria.HistoriaRegistrada(loteId, anio, semana, dia)) {
                    
                    resultado = controladorHistoria.actualizarHistoriaClinica(loteId, anio, semana, dia, descripcion);                        
                    limpiar();
                    
                }else{
                    
                    resultado = "la historia clinica no se encuentra registrado.";
                    //JOptionPane.showMessageDialog(null, "El empleado ya se encuentra registrado.", "Error!", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }                
                
            }else{
                resultado = "No se pudo modificar la historia clinica, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
                //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NullPointerException ex) {
            resultado = "No se pudo modificar la historia clinica, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(Gui_ModificarHistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonagregar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Historia clinica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 0, 255)));

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel14.setText("Descripcion:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                            .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 112, Short.MAX_VALUE))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButtonagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Save).jpg"))); // NOI18N
        jButtonagregar.setText("Actualizar");
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

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Wzdelete.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonagregar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(567, 567, 567))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAñoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldAño.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldAñoKeyTyped

    private void jTextFieldSemanaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSemanaKeyTyped
        char car=evt.getKeyChar();
        if(  jTextFieldSemana.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSemanaKeyTyped

    private void jButtonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonagregarActionPerformed
        
        // Obtencion de datos de la interfaz
        String lote=jTextFieldLote.getText().trim();
        String anio =jTextFieldAño.getText().trim();
        String semana = jTextFieldSemana.getText().trim();
        String dia = jTextFieldDia.getText().trim();
        String descripcion = jTextArea1.getText().trim();
        
        String resultado = this.modificarHistoria(lote, anio, semana, dia, descripcion);
       
        if (resultado.equalsIgnoreCase("No se pudo modificar la historia clinica, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("la historia clinica no se encuentra registrado.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("No se pudo modificar la historia clinica, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
            this.gui_historiaClinica.buscarHistorias();
            this.gui_historiaClinica.setVisible(true);
            this.dispose();
        }
            
    }//GEN-LAST:event_jButtonagregarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
         try{
         this.gui_historiaClinica.setVisible(true);
         this.gui_historiaClinica.buscarHistorias();
         this.dispose();
       }catch(Exception e){}

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiar();
        habilitar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLoteActionPerformed

    private void jTextFieldLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoteKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldLote.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldLoteKeyTyped

    private void jTextFieldDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiaKeyTyped

    //Metodo para limpiar los campos de la interfaz grafica de usuario y devolverlos a su estado inicial
    public void limpiar(){
        this.jTextFieldAño.setText("");
        this.jTextFieldSemana.setText(""); 
        this.jTextFieldDia.setText(""); 
        this.jTextArea1.setText(""); 

    }
     
    //Metodo para habilitar los campos de la interfaz grafica de usuario y asignar sus estado inicial 
    public void habilitar(){
        this.jTextFieldAño.setEnabled(true);
        this.jTextFieldSemana.setEnabled(true); 
        this.jTextFieldDia.setEnabled(true); 
        this.jTextArea1.setEnabled(true); 

    }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarCamposVacios(){
         boolean var =false;
         
         if (jTextFieldLote.getText().equalsIgnoreCase("") || jTextFieldAño.getText().equalsIgnoreCase("") ||
                 jTextFieldSemana.getText().equalsIgnoreCase("") || jTextFieldDia.getText().equalsIgnoreCase("") || jTextArea1.getText().equalsIgnoreCase("")) {
             
             var = true;             
         }
         
         return var;
     }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarTipos(){
         
         boolean var =false;
         Validaciones validar = new Validaciones();
         
         if (validar.isNumeric(jTextFieldAño.getText().trim()) && validar.isNumeric(jTextFieldSemana.getText().trim())) {
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
            java.util.logging.Logger.getLogger(Gui_ModificarHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarHistoriaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_ModificarHistoriaClinica(new GUI_HistoriaClinica(new Gui_InfoLotes(new GUI_AdminLotes(new Gui_Lotes(new Gui_VentanaPrincipalGerente(new Gui_login()))))), null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonagregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldSemana;
    // End of variables declaration//GEN-END:variables
}
