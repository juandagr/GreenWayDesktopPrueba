/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Empleado;
import Clases.Validaciones;
import Controlador.ControladorEmpleado;
import Controlador.ControladorUbicacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Daniel
 */
public class GUI_Ubicaciones extends javax.swing.JFrame {

    //Atributos
    Gui_VentanaPrincipalGerente gui_gerente;
    private TableRowSorter trsFiltro;
    
    DefaultTableModel modeloItems = new DefaultTableModel();
    //Constructor
    public GUI_Ubicaciones(Gui_VentanaPrincipalGerente gui_gerente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gui_gerente = gui_gerente;
        modeloItems.addColumn("Identificador");
        modeloItems.addColumn("Departamento");
        modeloItems.addColumn("Municipio");
        modeloItems.addColumn("Vereda");
        
        //buscarEmpleados();
    }
    
    public void buscarEmpleados(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        jTableUbicaciones.setModel(modeloItems);
        
        ArrayList<Empleado> empleados = new ControladorEmpleado().consultarTodosEmpleados();
        
        for (int i = 0; i < empleados.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[6]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = empleados.get(i).getIdentificacion();
            fila[1] = empleados.get(i).getNombre();
            fila[2] = empleados.get(i).getApellido();
            fila[3] = empleados.get(i).getCargo();
            if (empleados.get(i).isEstado()) {
                fila[4] = "Activo";
            }else fila[4] = "Inactivo";
            fila[5] = empleados.get(i).getTelefono();

            // Se añade al modelo la fila completa.
            modeloItems.addRow(fila);
            
        }
        
    }

    public void filtro() {
        int columnaABuscar = 0;
        if (jComboBoxBusqueda.getSelectedItem() == "departamento") {
            columnaABuscar = 0;
        }
        if (jComboBoxBusqueda.getSelectedItem().toString() == "municipio") {
            columnaABuscar = 1;
        }
        if (jComboBoxBusqueda.getSelectedItem() == "vereda") {
            columnaABuscar = 2;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(jTextFieldBusqueda.getText(), columnaABuscar));
    }
    
    //metodo para buscar y mostrar la informacion de un solo empleado por medio de su identificacion
    public String buscarEmpleadoPorId(){
        String resultado = "";
        if (jTextFieldBusqueda.getText().trim().equalsIgnoreCase("") == false) {
            
            Empleado empleado = new ControladorEmpleado().consultarEmpleado(jTextFieldBusqueda.getText().trim());
            
            if (empleado != null) {
                
                while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
                jTableUbicaciones.setModel(modeloItems);

                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[6]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = empleado.getIdentificacion();
                fila[1] = empleado.getNombre();
                fila[2] = empleado.getApellido();
                fila[3] = empleado.getCargo();
                if (empleado.isEstado()) {
                    fila[4] = "Activo";
                }else fila[4] = "Inactivo";
                fila[5] = empleado.getTelefono();

                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
                
                resultado = "";
                
            }else{
                resultado = "Empleado no encontrado, inténtelo de nuevo.";
            }
        }else{
            resultado = "Por favor ingrese el numero de identificacion.";
        }
        
        return resultado;
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
                
                
            }else{
                
            }
        }else{
            System.err.println("no es string");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonAgregar)
                                    .addGap(202, 202, 202)))
                            .addComponent(jToggleButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
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
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        String departamento = JOptionPane.showInputDialog("Ingrese el departamento de la nueva ubicacion: ");
        String municipio = JOptionPane.showInputDialog("Ingrese el municipio de la nueva ubicacion: ");
        String vereda = JOptionPane.showInputDialog("Ingrese la vereda de la nueva ubicacion: ");
        Validaciones validaciones = new Validaciones();
        
        
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.gui_gerente.setVisible(true);
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
                new GUI_Ubicaciones(new Gui_VentanaPrincipalGerente(new Gui_login())).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JComboBox jComboBoxBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUbicaciones;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
