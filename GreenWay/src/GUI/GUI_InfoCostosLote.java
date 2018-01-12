/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Validaciones;
import Dao.DaoCostosComercializacion;
import Dao.DaoCostosInversion;
import Dao.DaoCostosOperacionales;
import Dao.DaoCostosOperacionalesOtros;
import Dao.DaoCostosOperacionalesProducto;
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

    String loteID = null;
    String cliente = null;
    Gui_InfoLotes gui_infoLotes = null;
    
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
    public GUI_InfoCostosLote(Gui_InfoLotes gui_infoLotes) {
        initComponents();
        this.gui_infoLotes=gui_infoLotes;
        
        modeloItems.addColumn("Labores");modeloItems.addColumn("lunes");modeloItems.addColumn("martes");
        modeloItems.addColumn("miercoles");modeloItems.addColumn("jueves");modeloItems.addColumn("viernes");
        modeloItems.addColumn("sabado");modeloItems.addColumn("domingo");
        jTableLabores9.setModel(modeloItems);
        
        modeloProductos.addColumn("producto");modeloProductos.addColumn("lunes");modeloProductos.addColumn("martes");
        modeloProductos.addColumn("miercoles");modeloProductos.addColumn("jueves");modeloProductos.addColumn("viernes");
        modeloProductos.addColumn("sabado");modeloProductos.addColumn("domingo");modeloProductos.addColumn("Presentacion");
        modeloProductos.addColumn("Costo Producto");
        jTableProductos.setModel(modeloProductos);
        
        modeloOtros.addColumn("Otro");modeloOtros.addColumn("lunes");modeloOtros.addColumn("martes");
        modeloOtros.addColumn("miercoles");modeloOtros.addColumn("jueves");modeloOtros.addColumn("viernes");
        modeloOtros.addColumn("sabado");modeloOtros.addColumn("domingo");
        jTableOtros9.setModel(modeloOtros);
        
        modeloComercializacion.addColumn("Comercializacion");modeloComercializacion.addColumn("lunes");modeloComercializacion.addColumn("martes");
        modeloComercializacion.addColumn("miercoles");modeloComercializacion.addColumn("jueves");modeloComercializacion.addColumn("viernes");
        modeloComercializacion.addColumn("sabado");modeloComercializacion.addColumn("domingo");
        jTableComercializacion.setModel(modeloComercializacion);
        
        modeloInversion.addColumn("Inversion");modeloInversion.addColumn("lunes");modeloInversion.addColumn("martes");
        modeloInversion.addColumn("miercoles");modeloInversion.addColumn("jueves");modeloInversion.addColumn("viernes");
        modeloInversion.addColumn("sabado");modeloInversion.addColumn("domingo");
        jTableInversion.setModel(modeloInversion);
        
        this.jTextFieldLote.setText(this.gui_infoLotes.gui_adminLotes.loteID);
        this.jTextFieldLote.setEditable(false);
        this.jTextFieldCedula.setText(this.gui_infoLotes.gui_adminLotes.cliente);
        this.jTextFieldCedula.setEditable(false);
    }

    public void setLoteID(String loteID) {
        this.loteID = loteID;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLoteID() {
        return loteID;
    }

    public String getCliente() {
        return cliente;
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

    
    public void registrarInfoCostos(){
        Dao.DaoCostosOperacionales dao = new DaoCostosOperacionales();
        System.out.println(jTableLabores9.getRowCount());
        for (int i = 0; i < jTableLabores9.getRowCount(); i++) {
            for (int j = 1; j < 8; j++) {
                if (String.valueOf(jTableLabores9.getValueAt(i, j)).equalsIgnoreCase("null") || (new Validaciones().isNumeric(String.valueOf(jTableLabores9.getValueAt(i, j))) == false)) {  
                }else{
                    int horas = Integer.parseInt(String.valueOf(jTableLabores9.getValueAt(i, j)));
                    dao.ingresarcostosOperacionalesBD(jTextFieldLote.getText(), String.valueOf(jTableLabores9.getValueAt(i, 0)), jTextFieldAño.getText(), jTextFieldSemana.getText(), jTableLabores9.getColumnName(j), horas);

                }
            }
        }
    }
    
    public void registrarInfoCostosProducto(){
        Dao.DaoCostosOperacionalesProducto dao = new DaoCostosOperacionalesProducto();
        System.out.println(jTableProductos.getRowCount());
        for (int i = 0; i < jTableProductos.getRowCount(); i++) {
            for (int j = 1; j < 8; j++) {
                if (String.valueOf(jTableProductos.getValueAt(i, j)).equalsIgnoreCase("null")) {  
                }else{
                    double volumen_gastado = Double.parseDouble(String.valueOf(jTableProductos.getValueAt(i, j)));
                    double presentacion = Double.parseDouble(String.valueOf(jTableProductos.getValueAt(i, 8)));
                    double costo_producto = Double.parseDouble(String.valueOf(jTableProductos.getValueAt(i, 9)));
                    double costo_final = (volumen_gastado * costo_producto) / presentacion;
                    dao.ingresarcostosOperacionalesProductoBD(jTextFieldLote.getText(), String.valueOf(jTableProductos.getValueAt(i, 0)), jTextFieldAño.getText(), jTextFieldSemana.getText(), jTableProductos.getColumnName(j), costo_producto, presentacion, volumen_gastado, costo_final);

                }
            }
        }
    }
    
    public void registrarInfoCostosInversion(){
        Dao.DaoCostosInversion dao = new DaoCostosInversion();
        System.out.println(jTableInversion.getRowCount());
        for (int i = 0; i < jTableInversion.getRowCount(); i++) {
            for (int j = 1; j < 8; j++) {
                if (String.valueOf(jTableInversion.getValueAt(i, j)).equalsIgnoreCase("null")|| (new Validaciones().isNumeric(String.valueOf(jTableInversion.getValueAt(i, j))) == false)) {  
                }else{
                    int valor = Integer.parseInt(String.valueOf(jTableInversion.getValueAt(i, j)));
                    dao.ingresarcostosInversionBD(jTextFieldLote.getText(), String.valueOf(jTableInversion.getValueAt(i, 0)), jTextFieldAño.getText(), jTextFieldSemana.getText(), jTableLabores9.getColumnName(j), valor);

                }
            }
        }
    }
    
    public void registrarInfoCostosComercializacion(){
        Dao.DaoCostosComercializacion dao = new DaoCostosComercializacion();
        for (int i = 0; i < jTableComercializacion.getRowCount(); i++) {
            for (int j = 1; j < 8; j++) {
                if (String.valueOf(jTableComercializacion.getValueAt(i, j)).equalsIgnoreCase("null")|| (new Validaciones().isNumeric(String.valueOf(jTableComercializacion.getValueAt(i, j))) == false)) {  
                }else{
                    int valor = Integer.parseInt(String.valueOf(jTableComercializacion.getValueAt(i, j)));
                    dao.ingresarCostosComercializacionBD(jTextFieldLote.getText(), String.valueOf(jTableComercializacion.getValueAt(i, 0)), jTextFieldAño.getText(), jTextFieldSemana.getText(), jTableComercializacion.getColumnName(j), valor);

                }
            }
        }
    }
    
    public void registrarInfoCostosOtros(){
        Dao.DaoCostosOperacionalesOtros dao = new DaoCostosOperacionalesOtros();
        System.out.println(jTableOtros9.getRowCount());
        for (int i = 0; i < jTableOtros9.getRowCount(); i++) {
            for (int j = 1; j < 8; j++) {
                if (String.valueOf(jTableOtros9.getValueAt(i, j)).equalsIgnoreCase("null")|| (new Validaciones().isNumeric(String.valueOf(jTableOtros9.getValueAt(i, j))) == false)) {  
                }else{
                    int horas = Integer.parseInt(String.valueOf(jTableOtros9.getValueAt(i, j)));
                    dao.ingresarcostosOperacionalesBD(jTextFieldLote.getText(), String.valueOf(jTableOtros9.getValueAt(i, 0)), jTextFieldAño.getText(), jTextFieldSemana.getText(), jTableOtros9.getColumnName(j), horas);

                }
            }
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
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Información de costos operacionales de lote");

        jLabel1.setText("Cedula cliente:");

        jLabel2.setText("Año:");

        jTextFieldAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAñoKeyTyped(evt);
            }
        });

        jLabel3.setText("Identificador Lote:");

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
        jTableLabores9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableLabores9FocusLost(evt);
            }
        });
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
        jTableOtros9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableOtros9FocusLost(evt);
            }
        });
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
        jTableProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableProductosFocusLost(evt);
            }
        });
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
        jTableInversion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableInversionFocusLost(evt);
            }
        });
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
        jTableComercializacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableComercializacionFocusLost(evt);
            }
        });
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Semana:");

        jTextFieldSemana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSemanaKeyTyped(evt);
            }
        });

        jButton4.setText("Eliminar Registro");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
                                .addComponent(jButton4)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2)
                                .addGap(27, 27, 27)
                                .addComponent(jButton3))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextFieldSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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

            jButtonInversion.setEnabled(true);
            jButtonComercializacion.setEnabled(false);
            jButtonLabor.setEnabled(false);
            jButtonProducto1.setEnabled(false);
            jButtonOtro.setEnabled(false);
            
            this.consultarItemsInversion();

        }else if (categoria.equalsIgnoreCase("Costos operacionales")) {
            for (int i = 0; i < subCategoriasCostosOperacionales.length; i++) {
                jComboBoxSubCategoria.addItem(subCategoriasCostosOperacionales[i]);
            }
            
            jButtonInversion.setEnabled(false);
            jButtonComercializacion.setEnabled(false);
            jButtonLabor.setEnabled(true);
            jButtonProducto1.setEnabled(true);
            jButtonOtro.setEnabled(true);
            
            this.consultarItemsCostosOperacionales();

        }else if (categoria.equalsIgnoreCase("Comercializacion")) {
            
            jButtonInversion.setEnabled(false);
            jButtonComercializacion.setEnabled(true);
            jButtonLabor.setEnabled(false);
            jButtonProducto1.setEnabled(false);
            jButtonOtro.setEnabled(false);
            
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextFieldAño.getText().equalsIgnoreCase("") || jTextFieldSemana.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Llene los campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            this.registrarInfoCostos();
            this.registrarInfoCostosInversion();
            this.registrarInfoCostosComercializacion();
            this.registrarInfoCostosOtros();
            this.registrarInfoCostosProducto();
            
            while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
            while(modeloProductos.getRowCount()>0)modeloProductos.removeRow(0);
            while(modeloOtros.getRowCount()>0)modeloOtros.removeRow(0);
            while(modeloInversion.getRowCount()>0)modeloInversion.removeRow(0);
            while(modeloComercializacion.getRowCount()>0)modeloComercializacion.removeRow(0);
            jTextFieldAño.setText("");
            jTextFieldSemana.setText("");
            
            JOptionPane.showMessageDialog(null, "Registros agregados exitosamente!", "!Exito!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.gui_infoLotes.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAñoKeyTyped
        char car=evt.getKeyChar();
        if(  jTextFieldAño.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldAñoKeyTyped

    private void jTextFieldSemanaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSemanaKeyTyped
        char car=evt.getKeyChar();
        if(  jTextFieldSemana.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldSemanaKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableComercializacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableComercializacionFocusLost
        jTableComercializacion.clearSelection();        // TODO add your handling code here:
    }//GEN-LAST:event_jTableComercializacionFocusLost

    private void jTableInversionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableInversionFocusLost
        jTableInversion.clearSelection();        // TODO add your handling code here:
    }//GEN-LAST:event_jTableInversionFocusLost

    private void jTableLabores9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableLabores9FocusLost
        jTableLabores9.clearSelection();        // TODO add your handling code here:
    }//GEN-LAST:event_jTableLabores9FocusLost

    private void jTableOtros9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableOtros9FocusLost
        jTableOtros9.clearSelection();        // TODO add your handling code here:
    }//GEN-LAST:event_jTableOtros9FocusLost

    private void jTableProductosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableProductosFocusLost
        jTableProductos.clearSelection();        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProductosFocusLost

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
                new GUI_InfoCostosLote(new Gui_InfoLotes(new GUI_AdminLotes(new Gui_Lotes(new Gui_VentanaPrincipalGerente(new Gui_login()))))).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    // End of variables declaration//GEN-END:variables
}
