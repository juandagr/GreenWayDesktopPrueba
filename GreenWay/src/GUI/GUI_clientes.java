/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Cliente;
import Controlador.ControladorCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class GUI_clientes extends javax.swing.JFrame {

    //Atributos
    Gui_VentanaPrincipalGerente gui_gerente;
    
    
    DefaultTableModel modeloItems = new DefaultTableModel(){
           
           //sobreescribir el metodo para que las celdas no se puedan editar
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;}
        };
    //Constructor
    public GUI_clientes(Gui_VentanaPrincipalGerente gui_gerente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gui_gerente = gui_gerente;
        modeloItems.addColumn("Identificacion");
        modeloItems.addColumn("Nombre");
        modeloItems.addColumn("Apellido");
        modeloItems.addColumn("Estado");
        modeloItems.addColumn("Telefono");
        
        buscarClientes();
    }
    
    // metodo para buscar los clientes que estan registrados en la base de datos y mostrar sus datos
    // en pantalla por medio de una tabla
    public void buscarClientes(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        jTableClientes.setModel(modeloItems);
        
        ArrayList<Cliente> clientes = new ControladorCliente().consultarTodosClientes();
        
        for (int i = 0; i < clientes.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[6]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = clientes.get(i).getIdentificacion();
            fila[1] = clientes.get(i).getNombre();
            fila[2] = clientes.get(i).getApellido();
            if (clientes.get(i).getEstado()) {
                fila[3] = "Activo";
            }else fila[3] = "Inactivo";
            fila[4] = clientes.get(i).getTelefono();

            // Se añade al modelo la fila completa.
            modeloItems.addRow(fila);
            
        }
        
    }

    //metodo para buscar y mostrar la informacion de un solo empleado por medio de su identificacion
    public String buscarClientePorId(){
        String resultado = "";
        if (jTextFieldIdentificacion.getText().trim().equalsIgnoreCase("") == false) {
            
            Cliente cliente = new ControladorCliente().consultarCliente(jTextFieldIdentificacion.getText().trim());
            
            if (cliente != null) {
                
                while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
                jTableClientes.setModel(modeloItems);

                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[6]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = cliente.getIdentificacion();
                fila[1] = cliente.getNombre();
                fila[2] = cliente.getApellido();
                if (cliente.getEstado()) {
                    fila[3] = "Activo";
                }else fila[3] = "Inactivo";
                fila[4] = cliente.getTelefono();

                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
                
                resultado = "";
                
            }else{
                resultado = "Cliente no encontrado, inténtelo de nuevo.";
            }
        }else{
            resultado = "Por favor ingrese el numero de identificacion.";
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
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAgregar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextFieldIdentificacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Administracion de cliente");

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

        jLabel2.setText("Modificar existente:");

        jButtonAgregar1.setText("Modificar");
        jButtonAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Consultar por identificacion:");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTextFieldIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdentificacionKeyTyped(evt);
            }
        });

        jLabel5.setText("Mostrar todos");

        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jToggleButton1))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonAgregar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAgregar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMostrar)))
                        .addGap(0, 36, Short.MAX_VALUE)))
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
                    .addComponent(jLabel1)
                    .addComponent(jButtonAgregar1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jButtonMostrar))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        Gui_AgregarCliente gui_agregarCliente =new Gui_AgregarCliente(this);
    
        gui_agregarCliente.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.gui_gerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregar1ActionPerformed

        String identificacion = this.obtenerIdentificacionSeleccionado();
        if (identificacion.equalsIgnoreCase("No selecciono") == false) {
            
            Gui_ModificarCliente gui_modificarCliente = new Gui_ModificarCliente(this,identificacion);  

            gui_modificarCliente.setVisible(true);

            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un cliente para modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonAgregar1ActionPerformed

    public String obtenerIdentificacionSeleccionado(){
        try{
            String identificacion = String.valueOf(jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0));
            return identificacion;
        }catch(Exception e){
            return "No selecciono";
        }
        
    }
    
    private void jTextFieldIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionKeyTyped
        char car=evt.getKeyChar();
        if(  jTextFieldIdentificacion.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldIdentificacionKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String resultado = this.buscarClientePorId();
        if (resultado.equalsIgnoreCase("Cliente no encontrado, inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("Por favor ingrese el numero de identificacion.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        this.buscarClientes();
    }//GEN-LAST:event_jButtonMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_clientes(new Gui_VentanaPrincipalGerente(new Gui_login())).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonAgregar1;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldIdentificacion;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
