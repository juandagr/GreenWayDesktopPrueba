/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.ControladorItemsComercializacion;
import Controlador.ControladorItemsInversion;
import Controlador.ControladorCostosOperacionales;
import Dao.DaoItemsInversion;
import Dao.DaoItemsCostosOperacionales;
import Dao.DaoItemsComercializacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class GUI_items extends javax.swing.JFrame {

    String[] subCategoriasInversion = {"APS", "Equipos y maquinaria"};
    String[] subCategoriasCostosOperacionales = {"Mano de obra", "Insecticidas-acaricidas", "Fungicidas", "Herbicidas", "Coadyuvantes", "Fertilizantes foliares", "Fertilizantes edaficos", "Otros gastos-imprevistos"};
    DefaultTableModel modeloItems = new DefaultTableModel(){
           
           //sobreescribir el metodo para que las celdas no se puedan editar
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;}
        };
    /**
     * Creates new form GUI_items
     */
    public GUI_items() {
        initComponents();
        this.setLocationRelativeTo(null);
        modeloItems.addColumn("Id");
        modeloItems.addColumn("Item");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void consultarItemsInversion(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
 
        jTableItems.setModel(modeloItems);

        ResultSet rs = new DaoItemsInversion().consultarItemsInversion();
        
        try {
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[2]; // Hay tres columnas en la tabla
                
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = rs.getObject(1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                fila[1] = rs.getObject(3);
                
                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsCostosOperacionales(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        
        jTableItems.setModel(modeloItems);
        
        ResultSet rs = new DaoItemsCostosOperacionales().consultarItemsCostosOperacionales();
        
        try {
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[2]; // Hay tres columnas en la tabla
                
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = rs.getObject(1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                fila[1] = rs.getObject(3);
                
                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsComercializacion(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);

        jTableItems.setModel(modeloItems);

        ResultSet rs = new DaoItemsComercializacion().consultarItemsComercializacion();
        
        try {
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[2]; // Hay tres columnas en la tabla
                
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = rs.getObject(1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                fila[1] = rs.getObject(2);
                
                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsInversionSubcategoria(String subCategoria){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        
        jTableItems.setModel(modeloItems);
        
        ResultSet rs = new DaoItemsInversion().consultarItemsInversionPorCategoria(subCategoria);
        
        try {
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[2]; // Hay tres columnas en la tabla
                
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = rs.getObject(1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                fila[1] = rs.getObject(3);
                
                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsCostosOperacionalesSubcategoria(String subCategoria){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);

        jTableItems.setModel(modeloItems);
        
        ResultSet rs = new DaoItemsCostosOperacionales().consultarItemsCostosOperacionalesPorCategoria(subCategoria);
        
        try {
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[2]; // Hay tres columnas en la tabla
                
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = rs.getObject(1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                fila[1] = rs.getObject(3);
                
                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableItems = new javax.swing.JTable();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSubCategoria = new javax.swing.JComboBox();
        jButtonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableItems);

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoria", "Inversion", "Costos operacionales", "Comercializacion" }));
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Agregar item por categoria");

        jComboBoxSubCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una subcategoria" }));
        jComboBoxSubCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSubCategoriaItemStateChanged(evt);
            }
        });
        jComboBoxSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSubCategoriaActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButtonEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String categoria = jComboBoxCategoria.getSelectedItem().toString();
        String subCategoria = jComboBoxSubCategoria.getSelectedItem().toString();
        String item = jTextField1.getText();
        String mensaje = null;
        
        if (item.trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No escribio ningun item", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if (categoria.equalsIgnoreCase("Inversion")) {

                if (subCategoria.equalsIgnoreCase("Seleccione una subcategoria") == false) {
                    ControladorItemsInversion controlador = new ControladorItemsInversion();
                    mensaje = controlador.existeItem(item);
                    
                    if (mensaje.equalsIgnoreCase("No existe")) {
                        mensaje = controlador.ingresarItem(subCategoria, item);
                        this.consultarItemsInversionSubcategoria(subCategoria);
                        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione una subcategoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }

            }else if (categoria.equalsIgnoreCase("Costos operacionales")) {

                if (subCategoria.equalsIgnoreCase("Seleccione una subcategoria") == false) {
                    ControladorCostosOperacionales controlador = new ControladorCostosOperacionales();
                    mensaje = controlador.existeItem(item);
                    
                    if (mensaje.equalsIgnoreCase("No existe")) {
                        mensaje = controlador.ingresarItem(subCategoria, item);
                        this.consultarItemsCostosOperacionalesSubcategoria(subCategoria);
                        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione una subcategoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }

            }else if (categoria.equalsIgnoreCase("Comercializacion")){

                ControladorItemsComercializacion controlador = new ControladorItemsComercializacion();
                mensaje = controlador.existeItem(item);
                    
                    if (mensaje.equalsIgnoreCase("No existe")) {
                        mensaje = controlador.ingresarItem(item);
                        this.consultarItemsComercializacion();
                        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }

            }else{
                JOptionPane.showMessageDialog(null, "Seleccione una categoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }     
        }
        
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubCategoriaActionPerformed

    private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaItemStateChanged
        String categoria = jComboBoxCategoria.getSelectedItem().toString();
        jComboBoxSubCategoria.removeAllItems();
        jComboBoxSubCategoria.addItem("Seleccione una subcategoria");
        if (categoria.equalsIgnoreCase("Inversion")) {
            for (int i = 0; i < subCategoriasInversion.length; i++) {
                jComboBoxSubCategoria.addItem(subCategoriasInversion[i]);
            }
            
            this.consultarItemsInversion();
            
        }else if (categoria.equalsIgnoreCase("Costos operacionales")) {
            for (int i = 0; i < subCategoriasCostosOperacionales.length; i++) {
                jComboBoxSubCategoria.addItem(subCategoriasCostosOperacionales[i]);
            }
            this.consultarItemsCostosOperacionales();
            
        }else if (categoria.equalsIgnoreCase("Comercializacion")) {
            this.consultarItemsComercializacion();
            
        }else if(categoria.equalsIgnoreCase("Seleccione una categoria")){
            while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
            jTableItems.setModel(modeloItems);
        }

    }//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

    private void jComboBoxSubCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoriaItemStateChanged
        try{
            String categoria = jComboBoxCategoria.getSelectedItem().toString();
            String subCategoria = jComboBoxSubCategoria.getSelectedItem().toString();
            
            if (categoria.equalsIgnoreCase("Inversion")) {
                if (subCategoria.equalsIgnoreCase("Seleccione una subcategoria")) {
                    this.consultarItemsInversion();
                }else{
                    this.consultarItemsInversionSubcategoria(subCategoria);
                }

            }else if (categoria.equalsIgnoreCase("Costos operacionales")) {
                if (subCategoria.equalsIgnoreCase("Seleccione una subcategoria")) {
                    this.consultarItemsInversion();
                }else{
                    this.consultarItemsCostosOperacionalesSubcategoria(subCategoria);
                }
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jComboBoxSubCategoriaItemStateChanged

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int seleccion = this.jTableItems.getSelectedRow();  
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String item = this.jTableItems.getValueAt(seleccion, 1).toString();
            String categoria = jComboBoxCategoria.getSelectedItem().toString();

            if (categoria.equalsIgnoreCase("Inversion")) {
                ControladorItemsInversion controlador = new ControladorItemsInversion();
                String mensaje = controlador.eliminarItem(item);
                JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                modeloItems.removeRow(seleccion);

            }else if (categoria.equalsIgnoreCase("Costos operacionales")) {
                ControladorCostosOperacionales controlador = new ControladorCostosOperacionales();
                String mensaje = controlador.eliminarItem(item);
                JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                modeloItems.removeRow(seleccion);

            }else if (categoria.equalsIgnoreCase("Comercializacion")) {
                ControladorItemsComercializacion controlador = new ControladorItemsComercializacion();
                String mensaje = controlador.eliminarItem(item);
                JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                modeloItems.removeRow(seleccion);

            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_items().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JComboBox jComboBoxSubCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableItems;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
