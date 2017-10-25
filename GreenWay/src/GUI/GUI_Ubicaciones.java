/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Empleado;
import Clases.Ubicacion;
import Clases.Validaciones;
import Controlador.ControladorEmpleado;
import Controlador.ControladorUbicacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Daniel
 */
public class GUI_Ubicaciones extends javax.swing.JFrame {

    //Atributos
    Gui_CultivosYUbicaciones cultivosYUbicaciones;
    private TableRowSorter trsFiltro;
    
    DefaultTableModel modeloItems = new DefaultTableModel();
    //Constructor
    public GUI_Ubicaciones(Gui_CultivosYUbicaciones cultivosYUbicaciones) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cultivosYUbicaciones = cultivosYUbicaciones;
        modeloItems.addColumn("Identificador");
        modeloItems.addColumn("Departamento");
        modeloItems.addColumn("Municipio");
        modeloItems.addColumn("Vereda");
        
        buscarUbicaciones();
        modeloItems.addTableModelListener(new TableModelListener () {

            @Override
            public void tableChanged(TableModelEvent tme) {
                
                
            }
        } 
  
        );
    }
    
    
    
    //metodo para bucar todas las ubicaciones que se encuentren en la base de datos y mostrarlas en la tabla
    public void buscarUbicaciones(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        jTableUbicaciones.setModel(modeloItems);
        
        ArrayList<Ubicacion> ubicaciones = new ControladorUbicacion().consultarTodasUbicaciones();
        
        for (int i = 0; i < ubicaciones.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[6]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = ubicaciones.get(i).getId_ubicacion();
            fila[1] = ubicaciones.get(i).getDepartamento();
            fila[2] = ubicaciones.get(i).getMunicipio();
            fila[3] = ubicaciones.get(i).getVereda();


            // Se añade al modelo la fila completa.
            modeloItems.addRow(fila);
            
        }
        
    }

    //factores por los cuales se va a aplicar el filtro a la tabla de ubicaciones
    public void filtro() {
        int columnaABuscar = 1;
        if (jComboBoxBusqueda.getSelectedItem() == "departamento") {
            columnaABuscar = 1;
        }
        if (jComboBoxBusqueda.getSelectedItem().toString() == "municipio") {
            columnaABuscar = 2;
        }
        if (jComboBoxBusqueda.getSelectedItem() == "vereda") {
            columnaABuscar = 3;
        }
        System.err.println(columnaABuscar);
        trsFiltro.setRowFilter(RowFilter.regexFilter(jTextFieldBusqueda.getText(), columnaABuscar));
    }

    /**
     * Metodo para agregar una ubicacion a la base de datos
     * @param departamento
     * @param municipio
     * @param vereda
     * @return
     */
    public String ingresarUbicacion(String departamento,String municipio,String vereda){
        String resultado = "";
        
        //creacion de  controlador para realizar el ingreso de la ubicacion, tambien de la clase que valida los campos
        ControladorUbicacion controlador = new ControladorUbicacion();
        Validaciones validaciones = new Validaciones();
        
        //se valida que los datos ingresados sean String, pues no se aceptan numeros
        if (validaciones.isString(departamento) && validaciones.isString(municipio) && validaciones.isString(vereda)) {
            //se valida que almenos el dato del departamento y del municipio no esten vacios
            if (this.verificarCamposVacios(departamento, municipio)) {
                //se crea el id de la ubicacion a partir de los tados de departamento, municipio y vereda, posteriormente se valida
                //que no se encuentre registrado en la base de datos
                String id_ubicacion = departamento + "-" + municipio + "-" + vereda;
                if (controlador.ubicacionRegistrada(id_ubicacion) == false) {
                    
                    resultado = controlador.ingresarUbicacion(id_ubicacion, departamento, municipio, vereda);
                }else{
                    resultado = "No se pudo crear la ubicacion debido a que ya se encuentra registrada.";
                }
            }else{
                resultado = "No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            }
        }else{
            resultado = "No se pudo crear la ubicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
        }
        
        return resultado;
    }
    
    /**
     * Metodo para modificar una ubicacion a la base de datos
     * @param departamento
     * @param municipio
     * @param vereda
     * @return
     */
    public String modificarUbicacion(String identificacion, String departamento,String municipio,String vereda){
        String resultado = "";
        
        //creacion de  controlador para realizar el ingreso de la ubicacion, tambien de la clase que valida los campos
        ControladorUbicacion controlador = new ControladorUbicacion();
        Validaciones validaciones = new Validaciones();
        
        //se valida que los datos ingresados sean String, pues no se aceptan numeros
        if (validaciones.isString(departamento) && validaciones.isString(municipio) && validaciones.isString(vereda)) {
            //se valida que almenos el dato del departamento y del municipio no esten vacios
            if (this.verificarCamposVacios(departamento, municipio)) {
                //se crea el id de la ubicacion a partir de los tados de departamento, municipio y vereda, posteriormente se valida
                //que no se encuentre registrado en la base de datos
                resultado = controlador.actualizarUbicacion(identificacion, departamento, municipio, vereda);
                
            }else{
                resultado = "No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            }
        }else{
            resultado = "No se pudo modificar la ubicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
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
        jTableUbicaciones = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jComboBoxBusqueda = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldModificarDepartamento = new javax.swing.JTextField();
        jTextFieldModificarMunicipio = new javax.swing.JTextField();
        jTextFieldModificarVereda = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Administracion de ubicaciones");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

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
        jScrollPane1.setViewportView(jTableUbicaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Agregar nuevo:");

        jLabel3.setText("Consultar por:");

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTextFieldBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBusquedaKeyTyped(evt);
            }
        });

        jComboBoxBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "departamento", "municipio", "vereda" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar"));

        jTextFieldModificarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModificarDepartamentoActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jLabel2.setText("Departamento:");

        jLabel4.setText("Municipio:");

        jLabel5.setText("Vereda:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonModificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldModificarVereda)
                            .addComponent(jTextFieldModificarMunicipio)
                            .addComponent(jTextFieldModificarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModificarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModificarMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModificarVereda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonModificar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonAgregar)
                                    .addGap(202, 202, 202))))
                        .addGap(65, 65, 65)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jLabel1))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        String departamento = JOptionPane.showInputDialog("Ingrese el departamento de la nueva ubicacion: ");
        String municipio = JOptionPane.showInputDialog("Ingrese el municipio de la nueva ubicacion: ");
        String vereda = JOptionPane.showInputDialog("Ingrese la vereda de la nueva ubicacion: ");
        Validaciones validaciones = new Validaciones();
        
        String resultado = this.ingresarUbicacion(departamento, municipio, vereda);
        
        if (resultado.equalsIgnoreCase("No se pudo crear la ubicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("No se pudo crear la ubicacion debido a que ya se encuentra registrada.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        buscarUbicaciones();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.cultivosYUbicaciones.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    public String obtenerIdentificacionSeleccionado(){
        try{
            String identificacion = String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 0));
            return identificacion;
        }catch(Exception e){
            return "No selecciono";
        }
        
    }
    
    private void jTextFieldBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaKeyTyped
        // TODO add your handling code here:
        jTextFieldBusqueda.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jTextFieldBusqueda.getText());
                jTextFieldBusqueda.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(jTableUbicaciones.getModel());
        jTableUbicaciones.setRowSorter(trsFiltro);
        
        
    }//GEN-LAST:event_jTextFieldBusquedaKeyTyped

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        
        String departamento = jTextFieldModificarDepartamento.getText().trim();
        String municipio = jTextFieldModificarMunicipio.getText().trim();
        String vereda = jTextFieldModificarVereda.getText().trim();
        if (obtenerIdentificacionSeleccionado().equalsIgnoreCase("No selecciono")) {
            JOptionPane.showMessageDialog(null, "Seleccione la ubicacion que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String identificacion = String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 0));
            Validaciones validaciones = new Validaciones();
            String resultado = modificarUbicacion(identificacion, departamento, municipio, vereda);

            if (resultado.equalsIgnoreCase("No se pudo crear la ubicacion, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
                JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
            }else if (resultado.equalsIgnoreCase("No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
                JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
            }else if (resultado.equalsIgnoreCase("No se pudo modificar la ubicacion debido a que ya se encuentra registrada.")) {
                JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        buscarUbicaciones();
        jTextFieldModificarDepartamento.setText("");
        jTextFieldModificarMunicipio.setText("");
        jTextFieldModificarVereda.setText("");
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldModificarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModificarDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModificarDepartamentoActionPerformed


    
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarCamposVacios(String departamento,String municipio){
         boolean var =true;
         
         if (departamento.equalsIgnoreCase("") || municipio.equalsIgnoreCase("")) {
             
             var = false;             
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
            java.util.logging.Logger.getLogger(GUI_Ubicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Ubicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Ubicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Ubicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Ubicaciones(new Gui_CultivosYUbicaciones(new Gui_VentanaPrincipalGerente(new Gui_login()))).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox jComboBoxBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUbicaciones;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldModificarDepartamento;
    private javax.swing.JTextField jTextFieldModificarMunicipio;
    private javax.swing.JTextField jTextFieldModificarVereda;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
