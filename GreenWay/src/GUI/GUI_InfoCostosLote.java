/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Dao.DaoItemsComercializacion;
import Dao.DaoItemsCostosOperacionales;
import Dao.DaoItemsInversion;
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
public class GUI_InfoCostosLote extends javax.swing.JFrame {

    String[] subCategoriasInversion = {"APS", "Equipos y maquinaria"};
    String[] subCategoriasCostosOperacionales = {"Mano de obra", "Insecticidas-acaricidas", "Fungicidas", "Herbicidas", "Coadyuvantes", "Fertilizantes foliares", "Fertilizantes edaficos", "Otros gastos-imprevistos"};
    
    DefaultTableModel modeloItems = new DefaultTableModel();
    DefaultTableModel modeloProductos = new DefaultTableModel();
    DefaultTableModel modeloOtros = new DefaultTableModel();
    
    DefaultTableModel modeloInversion = new DefaultTableModel();
    DefaultTableModel modeloComercializacion = new DefaultTableModel();
    
    /**
     * Creates new form GUI_InfoCostosLote
     */
    public GUI_InfoCostosLote() {
        initComponents();
        modeloItems.addColumn("Labores");modeloItems.addColumn("Lunes");modeloItems.addColumn("Martes");
        modeloItems.addColumn("Miercoles");modeloItems.addColumn("Jueves");modeloItems.addColumn("Viernes");
        modeloItems.addColumn("Sabado");modeloItems.addColumn("Domingo");modeloItems.addColumn("Horas");
        jTableLabores9.setModel(modeloItems);
        
        modeloProductos.addColumn("Producto");modeloProductos.addColumn("Lunes");modeloProductos.addColumn("Martes");
        modeloProductos.addColumn("Miercoles");modeloProductos.addColumn("Jueves");modeloProductos.addColumn("Viernes");
        modeloProductos.addColumn("Sabado");modeloProductos.addColumn("Domingo");modeloProductos.addColumn("Presentacion");
        modeloProductos.addColumn("Costo Producto");modeloProductos.addColumn("Vol utilizado");
        jTableProductos.setModel(modeloProductos);
        
        modeloOtros.addColumn("Otro");modeloOtros.addColumn("Lunes");modeloOtros.addColumn("Martes");
        modeloOtros.addColumn("Miercoles");modeloOtros.addColumn("Jueves");modeloOtros.addColumn("Viernes");
        modeloOtros.addColumn("Sabado");modeloOtros.addColumn("Domingo");modeloOtros.addColumn("Valor");
        jTableOtros9.setModel(modeloOtros);
        
        modeloComercializacion.addColumn("Comercializacion");modeloComercializacion.addColumn("Lunes");modeloComercializacion.addColumn("Martes");
        modeloComercializacion.addColumn("Miercoles");modeloComercializacion.addColumn("Jueves");modeloComercializacion.addColumn("Viernes");
        modeloComercializacion.addColumn("Sabado");modeloComercializacion.addColumn("Domingo");modeloComercializacion.addColumn("Valor");
        jTableComercializacion.setModel(modeloComercializacion);
        
        modeloInversion.addColumn("Inversion");modeloInversion.addColumn("Lunes");modeloInversion.addColumn("Martes");
        modeloInversion.addColumn("Miercoles");modeloInversion.addColumn("Jueves");modeloInversion.addColumn("Viernes");
        modeloInversion.addColumn("Sabado");modeloInversion.addColumn("Domingo");modeloInversion.addColumn("Valor");
        jTableInversion.setModel(modeloInversion);
    }
    
    //metodos para realizar las consultas de los items predeterminados ***********************
    public void consultarItemsInversion(){
        jComboBoxItem.removeAllItems();

        ResultSet rs = new DaoItemsInversion().consultarItemsInversion();
        
        try {
            while (rs.next())
            {
                jComboBoxItem.addItem(rs.getObject(3));
      
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsCostosOperacionales(){
        jComboBoxItem.removeAllItems();

        ResultSet rs = new DaoItemsCostosOperacionales().consultarItemsCostosOperacionales();
        
        try {
            while (rs.next())
            {
                jComboBoxItem.addItem(rs.getObject(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsComercializacion(){
        jComboBoxItem.removeAllItems();
        ResultSet rs = new DaoItemsComercializacion().consultarItemsComercializacion();
        
        try {
            while (rs.next())
            {
                jComboBoxItem.addItem(rs.getObject(2));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsInversionSubcategoria(String subCategoria){
        jComboBoxItem.removeAllItems();
        
        ResultSet rs = new DaoItemsInversion().consultarItemsInversionPorCategoria(subCategoria);
        
        try {
            while (rs.next())
            {
                jComboBoxItem.addItem(rs.getObject(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void consultarItemsCostosOperacionalesSubcategoria(String subCategoria){

        jComboBoxItem.removeAllItems();
        
        ResultSet rs = new DaoItemsCostosOperacionales().consultarItemsCostosOperacionalesPorCategoria(subCategoria);
        
        try {
            while (rs.next())
            {
                jComboBoxItem.addItem(rs.getObject(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_items.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAño = new javax.swing.JTextField();
        jTextFieldCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorFacturado = new javax.swing.JTextField();
        jTextFieldLote = new javax.swing.JTextField();
        jComboBoxItem = new javax.swing.JComboBox();
        jComboBoxSubCategoria = new javax.swing.JComboBox();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        jTableLabores9 = new javax.swing.JTable();
        jScrollPane37 = new javax.swing.JScrollPane();
        jTableOtros9 = new javax.swing.JTable();
        jScrollPane38 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonLabor = new javax.swing.JButton();
        jButtonOtro = new javax.swing.JButton();
        jButtonProducto1 = new javax.swing.JButton();
        jButtonInversion = new javax.swing.JButton();
        jButtonComercializacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInversion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableComercializacion = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSemana = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Información de costos operacionales de lote");

        jLabel1.setText("Cedula cliente:");

        jLabel2.setText("Año:");

        jLabel3.setText("Identificador Lote:");

        jLabel4.setText("Valor Facturado:");

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

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Costos"));

        jTableLabores9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane36.setViewportView(jTableLabores9);

        jTableOtros9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane37.setViewportView(jTableOtros9);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane38.setViewportView(jTableProductos);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addComponent(jScrollPane38)
                    .addComponent(jScrollPane36))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        jButtonLabor.setText("Agregar Labor");
        jButtonLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLaborActionPerformed(evt);
            }
        });

        jButtonOtro.setText("Agregar Otro");
        jButtonOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtroActionPerformed(evt);
            }
        });

        jButtonProducto1.setText("Agregar Producto");
        jButtonProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProducto1jButtonProductoActionPerformed(evt);
            }
        });

        jButtonInversion.setText("Agregar Inversion");
        jButtonInversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInversionjButtonProductoActionPerformed(evt);
            }
        });

        jButtonComercializacion.setText("Agregar Comercializacion");
        jButtonComercializacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComercializacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonLabor)
                .addGap(18, 18, 18)
                .addComponent(jButtonOtro)
                .addGap(18, 18, 18)
                .addComponent(jButtonProducto1)
                .addGap(18, 18, 18)
                .addComponent(jButtonInversion)
                .addGap(18, 18, 18)
                .addComponent(jButtonComercializacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLabor)
                    .addComponent(jButtonOtro)
                    .addComponent(jButtonProducto1)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonInversion)
                .addComponent(jButtonComercializacion))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Costos de inversion y comercializacion"));

        jTableInversion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableInversion);

        jTableComercializacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableComercializacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setText("Agregar Registros");

        jButton2.setText("Cancelar");

        jButton3.setText("Salir");

        jLabel5.setText("Semana:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2)
                                .addGap(27, 27, 27)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldValorFacturado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldValorFacturado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProducto1jButtonProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProducto1jButtonProductoActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloProductos.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonProducto1jButtonProductoActionPerformed

    private void jButtonLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaborActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloItems.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLaborActionPerformed

    private void jButtonOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtroActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloOtros.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOtroActionPerformed

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

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubCategoriaItemStateChanged

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
            jComboBoxItem.removeAllItems();
        } 
    }//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButtonInversionjButtonProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInversionjButtonProductoActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloInversion.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_jButtonInversionjButtonProductoActionPerformed

    private void jButtonComercializacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComercializacionActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloComercializacion.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_jButtonComercializacionActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_InfoCostosLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_InfoCostosLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_InfoCostosLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_InfoCostosLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_InfoCostosLote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonComercializacion;
    private javax.swing.JButton jButtonInversion;
    private javax.swing.JButton jButtonLabor;
    private javax.swing.JButton jButtonOtro;
    private javax.swing.JButton jButtonProducto1;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JComboBox jComboBoxItem;
    private javax.swing.JComboBox jComboBoxSubCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JTable jTableComercializacion;
    private javax.swing.JTable jTableInversion;
    private javax.swing.JTable jTableLabores9;
    private javax.swing.JTable jTableOtros9;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldSemana;
    private javax.swing.JTextField jTextFieldValorFacturado;
    // End of variables declaration//GEN-END:variables
}