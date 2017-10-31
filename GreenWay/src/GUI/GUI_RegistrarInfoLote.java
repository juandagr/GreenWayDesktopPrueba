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
public class GUI_RegistrarInfoLote extends javax.swing.JFrame {

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
    public GUI_RegistrarInfoLote() {
        initComponents();
        modeloItems.addColumn("Labores");modeloItems.addColumn("Lunes");modeloItems.addColumn("Martes");
        modeloItems.addColumn("Miercoles");modeloItems.addColumn("Jueves");modeloItems.addColumn("Viernes");
        modeloItems.addColumn("Sabado");modeloItems.addColumn("Domingo");modeloItems.addColumn("Horas");
        jTableLabores4.setModel(modeloItems);
        
        modeloProductos.addColumn("Producto");modeloProductos.addColumn("Lunes");modeloProductos.addColumn("Martes");
        modeloProductos.addColumn("Miercoles");modeloProductos.addColumn("Jueves");modeloProductos.addColumn("Viernes");
        modeloProductos.addColumn("Sabado");modeloProductos.addColumn("Domingo");modeloProductos.addColumn("Presentacion");
        modeloProductos.addColumn("Costo Producto");modeloProductos.addColumn("Vol utilizado");
        jTableProductos4.setModel(modeloProductos);
        
        modeloOtros.addColumn("Otro");modeloOtros.addColumn("Lunes");modeloOtros.addColumn("Martes");
        modeloOtros.addColumn("Miercoles");modeloOtros.addColumn("Jueves");modeloOtros.addColumn("Viernes");
        modeloOtros.addColumn("Sabado");modeloOtros.addColumn("Domingo");modeloOtros.addColumn("Valor");
        jTableOtros4.setModel(modeloOtros);
        
        modeloComercializacion.addColumn("Producto");modeloComercializacion.addColumn("Lunes");modeloComercializacion.addColumn("Martes");
        modeloComercializacion.addColumn("Miercoles");modeloComercializacion.addColumn("Jueves");modeloComercializacion.addColumn("Viernes");
        modeloComercializacion.addColumn("Sabado");modeloComercializacion.addColumn("Domingo");modeloComercializacion.addColumn("Valor");
        //jTableComercializacion.setModel(modeloComercializacion);
        
        modeloInversion.addColumn("Producto");modeloInversion.addColumn("Lunes");modeloInversion.addColumn("Martes");
        modeloInversion.addColumn("Miercoles");modeloInversion.addColumn("Jueves");modeloInversion.addColumn("Viernes");
        modeloInversion.addColumn("Sabado");modeloInversion.addColumn("Domingo");modeloInversion.addColumn("Valor");
        //jTableInversion.setModel(modeloInversion);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jButtonProducto1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        jTableLabores9 = new javax.swing.JTable();
        jScrollPane37 = new javax.swing.JScrollPane();
        jTableOtros9 = new javax.swing.JTable();
        jScrollPane38 = new javax.swing.JScrollPane();
        jTableP = new javax.swing.JTable();
        jButtonLabor = new javax.swing.JButton();
        jComboBoxItem = new javax.swing.JComboBox();
        jComboBoxSubCategoria = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorFacturado = new javax.swing.JTextField();
        jTextFieldLote = new javax.swing.JTextField();
        jTextFieldSemana = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jButtonOtro = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane40 = new javax.swing.JScrollPane();
        jTableComercializacion = new javax.swing.JTable();
        jComboBoxItem1 = new javax.swing.JComboBox();
        jComboBoxSubCategoria1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCedula1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldValorFacturado1 = new javax.swing.JTextField();
        jTextFieldLote1 = new javax.swing.JTextField();
        jTextFieldSemana1 = new javax.swing.JTextField();
        jComboBoxCategoria1 = new javax.swing.JComboBox();
        jButtonItemComercializacion = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane39 = new javax.swing.JScrollPane();
        jTableInversion = new javax.swing.JTable();
        jComboBoxItem2 = new javax.swing.JComboBox();
        jComboBoxSubCategoria2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldCedula2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldValorFacturado2 = new javax.swing.JTextField();
        jTextFieldLote2 = new javax.swing.JTextField();
        jTextFieldSemana2 = new javax.swing.JTextField();
        jComboBoxCategoria2 = new javax.swing.JComboBox();
        jButtonItemInversion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonProducto1.setText("Agregar Producto");
        jButtonProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductoActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

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

        jTableP.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane38.setViewportView(jTableP);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addComponent(jScrollPane37)
                    .addComponent(jScrollPane38))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonLabor.setText("Agregar Labor");
        jButtonLabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLaborActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Cedula cliente:");

        jLabel2.setText("Semana:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Información de costos operacionales de lote");

        jLabel3.setText("Identificador Lote:");

        jLabel4.setText("Valor Facturado:");

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

        jButtonOtro.setText("Agregar Otro");
        jButtonOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldValorFacturado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLabor)
                            .addComponent(jButtonProducto1)
                            .addComponent(jButtonOtro))))
                .addGap(64, 64, 64))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorFacturado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProducto1))
                .addGap(11, 11, 11)
                .addComponent(jButtonLabor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOtro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Costos operacionales", jPanel14);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

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
        jScrollPane40.setViewportView(jTableComercializacion);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane40, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );

        jComboBoxSubCategoria1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una subcategoria" }));
        jComboBoxSubCategoria1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSubCategoria1ItemStateChanged(evt);
            }
        });
        jComboBoxSubCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSubCategoria1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Cedula cliente:");

        jLabel7.setText("Semana:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Información de costos de comercialización de lote");

        jLabel9.setText("Identificador Lote:");

        jLabel10.setText("Valor Facturado:");

        jComboBoxCategoria1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoria", "Inversion", "Costos operacionales", "Comercializacion" }));
        jComboBoxCategoria1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoria1ItemStateChanged(evt);
            }
        });
        jComboBoxCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoria1ActionPerformed(evt);
            }
        });

        jButtonItemComercializacion.setText("Agregar");
        jButtonItemComercializacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemComercializacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jComboBoxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSubCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSemana1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldValorFacturado1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldLote1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonItemComercializacion)))
                .addGap(110, 110, 110))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLote1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldSemana1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorFacturado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSubCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonItemComercializacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Costos de comercializacion", jPanel18);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

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
        jScrollPane39.setViewportView(jTableInversion);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane39, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 156, Short.MAX_VALUE))
        );

        jComboBoxSubCategoria2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una subcategoria" }));
        jComboBoxSubCategoria2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSubCategoria2ItemStateChanged(evt);
            }
        });
        jComboBoxSubCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSubCategoria2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cedula cliente:");

        jLabel12.setText("Semana:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Información de costos de inversión de lote");

        jLabel14.setText("Identificador Lote:");

        jLabel15.setText("Valor Facturado:");

        jComboBoxCategoria2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoria", "Inversion", "Costos operacionales", "Comercializacion" }));
        jComboBoxCategoria2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoria2ItemStateChanged(evt);
            }
        });
        jComboBoxCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoria2ActionPerformed(evt);
            }
        });

        jButtonItemInversion.setText("Agregar ");
        jButtonItemInversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemInversionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSemana2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCedula2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldValorFacturado2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldLote2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jComboBoxCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSubCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonItemInversion))
                            .addComponent(jLabel13))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldCedula2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLote2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldSemana2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorFacturado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSubCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonItemInversion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Costos de inversión", jPanel16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

    private void jComboBoxSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubCategoriaActionPerformed

    private void jComboBoxSubCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubCategoriaItemStateChanged

    private void jButtonOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOtroActionPerformed

    private void jButtonLaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaborActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLaborActionPerformed

    private void jButtonProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProductoActionPerformed

    private void jButtonItemInversionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemInversionActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem2.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloInversion.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonItemInversionActionPerformed

    private void jComboBoxCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoria2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoria2ActionPerformed

    private void jComboBoxCategoria2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoria2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoria2ItemStateChanged

    private void jComboBoxSubCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoria2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubCategoria2ActionPerformed

    private void jComboBoxSubCategoria2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoria2ItemStateChanged
        try{
            String categoria = jComboBoxCategoria2.getSelectedItem().toString();
            String subCategoria = jComboBoxSubCategoria2.getSelectedItem().toString();

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
    }//GEN-LAST:event_jComboBoxSubCategoria2ItemStateChanged

    private void jButtonItemComercializacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemComercializacionActionPerformed
        try{
            if (jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase("") ||jComboBoxItem.getSelectedItem().toString().equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[9]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                fila[0] = jComboBoxItem1.getSelectedItem().toString();

                // Se añade al modelo la fila completa.
                modeloComercializacion.addRow(fila);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonItemComercializacionActionPerformed

    private void jComboBoxCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoria1ActionPerformed

    private void jComboBoxCategoria1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoria1ItemStateChanged
        String categoria = jComboBoxCategoria1.getSelectedItem().toString();
        jComboBoxSubCategoria1.removeAllItems();
        jComboBoxSubCategoria1.addItem("Seleccione una subcategoria");
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
    }//GEN-LAST:event_jComboBoxCategoria1ItemStateChanged

    private void jComboBoxSubCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubCategoria1ActionPerformed

    private void jComboBoxSubCategoria1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubCategoria1ItemStateChanged
        try{
            String categoria = jComboBoxCategoria1.getSelectedItem().toString();
            String subCategoria = jComboBoxSubCategoria1.getSelectedItem().toString();

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
    }//GEN-LAST:event_jComboBoxSubCategoria1ItemStateChanged

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
            java.util.logging.Logger.getLogger(GUI_RegistrarInfoLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarInfoLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarInfoLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarInfoLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_RegistrarInfoLote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonItemComercializacion;
    private javax.swing.JButton jButtonItemInversion;
    private javax.swing.JButton jButtonLabor;
    private javax.swing.JButton jButtonOtro;
    private javax.swing.JButton jButtonProducto;
    private javax.swing.JButton jButtonProducto1;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JComboBox jComboBoxCategoria1;
    private javax.swing.JComboBox jComboBoxCategoria2;
    private javax.swing.JComboBox jComboBoxItem;
    private javax.swing.JComboBox jComboBoxItem1;
    private javax.swing.JComboBox jComboBoxItem2;
    private javax.swing.JComboBox jComboBoxSubCategoria;
    private javax.swing.JComboBox jComboBoxSubCategoria1;
    private javax.swing.JComboBox jComboBoxSubCategoria2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableComercializacion;
    private javax.swing.JTable jTableInversion;
    private javax.swing.JTable jTableLabores;
    private javax.swing.JTable jTableLabores1;
    private javax.swing.JTable jTableLabores2;
    private javax.swing.JTable jTableLabores3;
    private javax.swing.JTable jTableLabores4;
    private javax.swing.JTable jTableLabores5;
    private javax.swing.JTable jTableLabores6;
    private javax.swing.JTable jTableLabores7;
    private javax.swing.JTable jTableLabores8;
    private javax.swing.JTable jTableLabores9;
    private javax.swing.JTable jTableOtros;
    private javax.swing.JTable jTableOtros1;
    private javax.swing.JTable jTableOtros2;
    private javax.swing.JTable jTableOtros3;
    private javax.swing.JTable jTableOtros4;
    private javax.swing.JTable jTableOtros5;
    private javax.swing.JTable jTableOtros6;
    private javax.swing.JTable jTableOtros7;
    private javax.swing.JTable jTableOtros8;
    private javax.swing.JTable jTableOtros9;
    private javax.swing.JTable jTableP;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableProductos1;
    private javax.swing.JTable jTableProductos2;
    private javax.swing.JTable jTableProductos3;
    private javax.swing.JTable jTableProductos4;
    private javax.swing.JTable jTableProductos5;
    private javax.swing.JTable jTableProductos6;
    private javax.swing.JTable jTableProductos7;
    private javax.swing.JTable jTableProductos8;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldCedula1;
    private javax.swing.JTextField jTextFieldCedula2;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldLote1;
    private javax.swing.JTextField jTextFieldLote2;
    private javax.swing.JTextField jTextFieldSemana;
    private javax.swing.JTextField jTextFieldSemana1;
    private javax.swing.JTextField jTextFieldSemana2;
    private javax.swing.JTextField jTextFieldValorFacturado;
    private javax.swing.JTextField jTextFieldValorFacturado1;
    private javax.swing.JTextField jTextFieldValorFacturado2;
    // End of variables declaration//GEN-END:variables
}
