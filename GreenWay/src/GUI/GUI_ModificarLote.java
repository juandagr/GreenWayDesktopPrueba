/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Cliente;
import Clases.Cultivo;
import Clases.Lote;
import Clases.Ubicacion;
import Clases.Validaciones;
import Controlador.ControladorCliente;
import Controlador.ControladorCultivo;
import Controlador.ControladorLote;
import Controlador.ControladorUbicacion;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Daniel
 */
public class GUI_ModificarLote extends javax.swing.JFrame {

    //Atributos
    GUI_AdminLotes admin;
    String idLote;
    //private TableRowSorter trsFiltro;
    
    DefaultTableModel modeloCliente = new DefaultTableModel(){
           
           //sobreescribir el metodo para que las celdas no se puedan editar
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;}
        };;
    DefaultTableModel modeloUbicacion = new DefaultTableModel(){
           
           //sobreescribir el metodo para que las celdas no se puedan editar
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;}
        };;
    //Constructor
    public GUI_ModificarLote(GUI_AdminLotes admin, String idLote) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.admin = admin;
        this.idLote = idLote;
        
        //items del modelo para los clientes
        modeloCliente.addColumn("Identificacion");
        modeloCliente.addColumn("Nombre");
        modeloCliente.addColumn("Apellido");
        
        //items del modelo para las ubicaciones
        modeloUbicacion.addColumn("Departamento");
        modeloUbicacion.addColumn("Municipio");
        modeloUbicacion.addColumn("Vereda");
        
        buscarClientes();
        buscarUbicaciones();
        buscarCultivos();
        llenarDatos();
    }

    // metodo para buscar los clientes que estan registrados en la base de datos y mostrar sus datos
    // en pantalla por medio de una tabla
    public void buscarClientes(){
        while(modeloCliente.getRowCount()>0)modeloCliente.removeRow(0);
        jTableClientes.setModel(modeloCliente);
        
        ArrayList<Cliente> clientes = new ControladorCliente().consultarClientesActivos();
        
        for (int i = 0; i < clientes.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[3]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = clientes.get(i).getIdentificacion();
            fila[1] = clientes.get(i).getNombre();
            fila[2] = clientes.get(i).getApellido();

            // Se añade al modelo la fila completa.
            modeloCliente.addRow(fila);
            
        }
        
    }
    
    //metodo para bucar todas las ubicaciones que se encuentren en la base de datos y mostrarlas en la tabla
    public void buscarUbicaciones(){
        while(modeloUbicacion.getRowCount()>0)modeloUbicacion.removeRow(0);
        jTableUbicaciones.setModel(modeloUbicacion);
        
        ArrayList<Ubicacion> ubicaciones = new ControladorUbicacion().consultarTodasUbicaciones();
        
        for (int i = 0; i < ubicaciones.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[3]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = ubicaciones.get(i).getDepartamento();
            fila[1] = ubicaciones.get(i).getMunicipio();
            fila[2] = ubicaciones.get(i).getVereda();


            // Se añade al modelo la fila completa.
            modeloUbicacion.addRow(fila);
            
        }
        
    }
    
    //metodo para traer los tipos de cultivos que se encuentran registrados en el sistema
    public void buscarCultivos(){  
        
        ArrayList<Cultivo> cultivos = new ControladorCultivo().consultarTodosCultivos();
        jComboBoxCultivo.removeAllItems();
        
        for (int i = 0; i < cultivos.size(); i++) {
            jComboBoxCultivo.addItem(cultivos.get(i).getNombre());            
        }
        
    }
    
     public String obtenerClienteSeleccionado(){
        try{
            String identificacion = String.valueOf(jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0));
            return identificacion;
        }catch(Exception e){
            return "No selecciono";
        }
        
    }
     
      public String obtenerUbicacionSeleccionado(){
        try{
            String identificacion = String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 0)) + "-"+
                    String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 1) + "-" +
                            String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 2)));
            return identificacion;
        }catch(Exception e){
            return "No selecciono";
        }
        
    }
      
    public void llenarDatos(){
        Lote lote = new ControladorLote().consultarLote(this.idLote);
        jTextFieldNumeroPlantas.setText(String.valueOf(lote.getNumero_plantas()));
        jTextFieldArea.setText(String.valueOf(lote.getArea()));
        
        for (int i = 0; i < jComboBoxCultivo.getItemCount(); i++) {
            if (jComboBoxCultivo.getItemAt(i).toString().equalsIgnoreCase(lote.getCultivo_identificador())) {
                jComboBoxCultivo.setSelectedIndex(i);
            }
        }
        
        
   }
    
    public String agregarLote(String Cliente_identificacion, String Cultivo_identificador, String identificador, double area, int numero_plantas, double costo_por_hora, String Ubicacion_id_ubicacion){
        //variable que almacenara el resultado
        String resultado = "";     
        
        //creacion de  controlador para realizar el ingreso del cliente, tambien de la clase que valida los campos
        ControladorLote controladorLote = new ControladorLote();
        Validaciones validar = new Validaciones();
        
        try {
            //se verifica que no haya campos obligatorios vacios, que los tipos de datos sean correctos
            if ((verificarCamposVacios() == false)) {
                //se verifica que el lote no haya sido creado anteriormente por medio de la identificacion
                if (controladorLote.loteRegistrado(identificador)) {

                    resultado = controladorLote.actualizarLote(Cliente_identificacion, Cultivo_identificador, identificador, area, numero_plantas, costo_por_hora, Ubicacion_id_ubicacion);
                    limpiar();

                }else{
                    
                    resultado = "El lote no se encuentra registrado.";
                    //JOptionPane.showMessageDialog(null, "El empleado ya se encuentra registrado.", "Error!", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }                
                
            }else{
                resultado = "No se pudo modificar el lote, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
                //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NullPointerException ex) {
            resultado = "No se pudo modificar el lote, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(Gui_AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUbicaciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCultivo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNumeroPlantas = new javax.swing.JTextField();
        jTextFieldArea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonAgregarLote = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Administracion de lotes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicaciones"));

        jTableUbicaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableUbicaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del lote"));

        jLabel1.setText("Tipo de cultivo: ");

        jComboBoxCultivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Area: ");

        jLabel3.setText("Numero de plantas:");

        jLabel4.setText("Hectareas");

        jButtonAgregarLote.setText("Modificar");
        jButtonAgregarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarLoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAgregarLote, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumeroPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNumeroPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jButtonAgregarLote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.admin.setVisible(true);
        this.admin.buscarLotes();
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonAgregarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarLoteActionPerformed
        try{
            String Cliente_identificacion = this.obtenerClienteSeleccionado();
            String Cultivo_identificador = jComboBoxCultivo.getSelectedItem().toString();
            double area = Double.parseDouble(jTextFieldArea.getText().trim());
            int numero_plantas = Integer.parseInt(jTextFieldNumeroPlantas.getText().trim());
            double costo_por_hora = 0;
            String Ubicacion_id_ubicacion = this.obtenerUbicacionSeleccionado();

            if ((Cliente_identificacion.equalsIgnoreCase("No selecciono")) || (Ubicacion_id_ubicacion.equalsIgnoreCase("No selecciono"))) {
                JOptionPane.showMessageDialog(null, "Seleccione un cliente y una ubicacion para el lote", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                String identificador = idLote;
                String resultado = this.agregarLote(Cliente_identificacion, Cultivo_identificador, identificador, area, numero_plantas, costo_por_hora, Ubicacion_id_ubicacion);
                
                if (resultado.equalsIgnoreCase("El lote no se encuentra registrado.")) {
                    JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
                }else if (resultado.equalsIgnoreCase("No se pudo modificar el lote, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
                    JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
                    this.admin.buscarLotes();
                    this.admin.setVisible(true);
                    this.dispose();
                }

            }
        }catch(NumberFormatException  e){
            JOptionPane.showMessageDialog(null, "Los datos area, numero de plantas y costo deben ser numericos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonAgregarLoteActionPerformed

    //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarCamposVacios(){
         boolean var =false;
         
         if (jTextFieldArea.getText().equalsIgnoreCase("") ||
                 jTextFieldNumeroPlantas.getText().equalsIgnoreCase("") ) {
             
             var = true;             
         }
         
         return var;
     }
     
     //metodo para poner en blanco los campos de la interfaz
     public void limpiar(){
         jTextFieldArea.setText("");
         jTextFieldNumeroPlantas.setText("");
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
            java.util.logging.Logger.getLogger(GUI_ModificarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ModificarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ModificarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ModificarLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ModificarLote(new GUI_AdminLotes(new Gui_Lotes(new Gui_VentanaPrincipalGerente(new Gui_login()))), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarLote;
    private javax.swing.JComboBox jComboBoxCultivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableUbicaciones;
    private javax.swing.JTextField jTextFieldArea;
    private javax.swing.JTextField jTextFieldNumeroPlantas;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
