/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Cliente;
import Clases.CostosInversion;
import Clases.Lote;
import Clases.Reportes;
import Conexion.Fachada;
import Controlador.ControladorCliente;
import Controlador.ControladorHistoriaClinica;
import Controlador.ControladorHistorialAplicacion;
import Controlador.ControladorLote;
import Dao.DaoCostosComercializacion;
import Dao.DaoCostosInversion;
import Dao.DaoCostosOperacionales;
import Dao.DaoCostosOperacionalesOtros;
import Dao.DaoCostosOperacionalesProducto;
import Dao.DaoValorFacturado;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel
 */
public class GUI_AdminLotesReportes extends javax.swing.JFrame {

    //Atributos
    Gui_Reportes admin;
    private TableRowSorter trsFiltro;
    String loteID = null;
    String cliente = null;
    ArrayList<String> idLotes = new ArrayList();
    
    DefaultTableModel modeloItems = new DefaultTableModel(){
           
           //sobreescribir el metodo para que las celdas no se puedan editar
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;}
        };
    //Constructor
    public GUI_AdminLotesReportes(Gui_Reportes admin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.admin = admin;
        modeloItems.addColumn("Cliente");
        modeloItems.addColumn("Cultivo");
        modeloItems.addColumn("Area");
        modeloItems.addColumn("Numero de plantas");
        modeloItems.addColumn("Ubicacion");
        
        buscarLotes();
    }
    
    // metodo para buscar los lotes que estan registrados en la base de datos y mostrar sus datos
    // en pantalla por medio de una tabla
    public void buscarLotes(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        jTableLotes.setModel(modeloItems);
        
        ArrayList<Lote> lotes = new ControladorLote().consultarTodosLotes();
        
        for (int i = 0; i < lotes.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[5]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = lotes.get(i).getCliente_identificacion();
            fila[1] = lotes.get(i).getCultivo_identificador();
            fila[2] = lotes.get(i).getArea();
            fila[3] = lotes.get(i).getNumero_plantas();
            fila[4] = lotes.get(i).getUbicacion_id_ubicacion();
            
            this.idLotes.add(lotes.get(i).getIdentificador());

            // Se añade al modelo la fila completa.
            modeloItems.addRow(fila);
            
        }
        
    }

    //filtro para realizar las busquedas
    public void filtro() {
        int columnaABuscar = 0;
        if (jComboBoxBusqueda.getSelectedItem() == "cliente") {
            columnaABuscar = 0;
        }
        if (jComboBoxBusqueda.getSelectedItem().toString() == "cultivo") {
            columnaABuscar = 1;
        }
        if (jComboBoxBusqueda.getSelectedItem() == "ubicacion") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(jTextFieldBusqueda.getText(), columnaABuscar));
    }
    
    public List valorOperacionalxSemana(String loteID, String anio, String mes){
        Reportes reportes = new Reportes();
        ArrayList<Integer> semanas = reportes.determinarSemnas(mes);
        
        ResultSet consulta = new DaoCostosOperacionales().consultarCostosOperacionalesxMesBD(loteID, anio, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
        List costos = new ArrayList();
        
        try {
            //se extraen los registros de la tabla cliente
            while( consulta.next()){
                
                //en caso de ser exitosa la consulta se procede a extraer los datos del objeto

                String item = consulta.getString(1);
                String semana = consulta.getString(2);           
                int horas = consulta.getInt(3);           
                Double valor = 0.0;
                
                ResultSet rs = new DaoValorFacturado().consultarValorFacturadoBD(cliente, anio, semana);
                if( rs.next()){
                    valor = rs.getDouble(6);
                }else{
                    valor = 0.0;
                }
                
                //se crea el objeto una vez se hayan extraido los datos
                CostosInversion c = new CostosInversion(item, valor);
                costos.add(c);
  
            }
        }

        catch (SQLException ex) {

        }
        
        return costos;
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
        jTableLotes = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxBusqueda = new javax.swing.JComboBox();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jButtonAgregar1 = new javax.swing.JButton();
        jButtonAgregar2 = new javax.swing.JButton();
        jButtonAgregar3 = new javax.swing.JButton();
        jButtonAgregar4 = new javax.swing.JButton();
        jButtonAgregar5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Administracion de lotes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lotes"));

        jTableLotes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableLotes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        jButtonAgregar.setText("Reporte General");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Generar reportes:");

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Consultar por:");

        jComboBoxBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cliente", "cultivo", "ubicacion" }));

        jTextFieldBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBusquedaKeyTyped(evt);
            }
        });

        jButtonAgregar1.setText("Reporte Inversion");
        jButtonAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar1ActionPerformed(evt);
            }
        });

        jButtonAgregar2.setText("Reporte Comercializacion");
        jButtonAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar2ActionPerformed(evt);
            }
        });

        jButtonAgregar3.setText("Reporte Costos Operacionales");
        jButtonAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar3ActionPerformed(evt);
            }
        });

        jButtonAgregar4.setText("Reporte Aplicacion");
        jButtonAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar4ActionPerformed(evt);
            }
        });

        jButtonAgregar5.setText("Reporte Historia Clinica");
        jButtonAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar5ActionPerformed(evt);
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
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAgregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAgregar1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAgregar2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAgregar3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonAgregar4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAgregar5)))))
                        .addGap(0, 9, Short.MAX_VALUE)))
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
                    .addComponent(jButtonAgregar2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar3)
                    .addComponent(jButtonAgregar4)
                    .addComponent(jButtonAgregar5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String cliente = this.obtenerIdentificacionSeleccionado();
        Reportes reportes = new Reportes();
        if (cliente.equalsIgnoreCase("No selecciono") == false) {
            try{
                this.loteID = this.idLotes.get(jTableLotes.getSelectedRow());
                this.cliente = cliente;
                String mesAño = JOptionPane.showInputDialog(null, "Ingrese el año y el mes separados por un espacio");
                StringTokenizer st = new StringTokenizer(mesAño, " ");
                String año = st.nextToken();
                String mes = st.nextToken();
                double c1 = reportes.costoOperacionalxMes(loteID,cliente, año, mes);
                double c2 = reportes.costoComercializacionxMes(loteID,cliente, año, mes);
                double c3 = reportes.costoInversionxMes(loteID,cliente, año, mes);
                ArrayList<Integer> semanas = reportes.determinarSemnas(mes);
                Double[] produccion = reportes.produccionxMes(loteID, cliente, año, mes);


                //String rutaInforme = "C:\\Users\\Daniel\\Documents\\Reportes GreenWay\\reporteBasico.jasper";
                Map parametros = new HashMap();
                parametros.put("bcorta", this.getClass().getResourceAsStream("/imagenes/reportes/bcorta.png"));
                parametros.put("blarga", this.getClass().getResourceAsStream("/imagenes/reportes/blarga.png"));
                parametros.put("cliente", cliente);
                parametros.put("corriente", produccion[1]);
                parametros.put("costoComercializacion", c2);
                parametros.put("costoInversion", c3);
                parametros.put("costoOperacional", c1);
                parametros.put("fecha", new Date());            
                parametros.put("fondo", this.getClass().getResourceAsStream("/imagenes/reportes/fondo.png"));
                parametros.put("industrial", produccion[2]);
                parametros.put("lote", loteID);
                parametros.put("mes", año + "-" + mes);
                parametros.put("selecta", produccion[0]);
                parametros.put("totalCostos", (c1+c2+c3));
                parametros.put("totalProduccion", produccion[3]);
                new Reportes().generarReporteBasico(parametros);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un lote para administrar informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
        trsFiltro = new TableRowSorter(jTableLotes.getModel());
        jTableLotes.setRowSorter(trsFiltro);

    }//GEN-LAST:event_jTextFieldBusquedaKeyTyped

    private void jButtonAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregar1ActionPerformed
        String cliente = this.obtenerIdentificacionSeleccionado();
        Reportes reportes = new Reportes();
        if (cliente.equalsIgnoreCase("No selecciono") == false) {
            try{
                this.loteID = this.idLotes.get(jTableLotes.getSelectedRow());
                this.cliente = cliente;
                String mesAño = JOptionPane.showInputDialog(null, "Ingrese el año y el mes separados por un espacio");
                StringTokenizer st = new StringTokenizer(mesAño, " ");
                String año = st.nextToken();
                String mes = st.nextToken();
                ArrayList<Integer> semanas = reportes.determinarSemnas(mes);
                Double[] produccion = reportes.produccionxMes(loteID, cliente, año, mes);


                //String rutaInforme = "C:\\Users\\Daniel\\Documents\\Reportes GreenWay\\reporteBasico.jasper";
                Map parametros = new HashMap();
                //parametros.put("bcorta", this.getClass().getResourceAsStream("/imagenes/reportes/bcorta.png"));
                //parametros.put("blarga", this.getClass().getResourceAsStream("/imagenes/reportes/blarga.png"));
                //parametros.put("cliente", cliente);
                //parametros.put("fecha", new Date());            
                parametros.put("fondo", this.getClass().getResourceAsStream("/imagenes/reportes/fondo.png"));
                //parametros.put("lote", loteID);
                parametros.put("mes", año + "-" + mes);

                List listaCostos = new ArrayList();
                if (semanas.size() == 4) {
                    listaCostos = new DaoCostosInversion().consultarCostosInversionxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
                }else{
                    listaCostos = new DaoCostosInversion().consultarCostosInversionxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(4).toString());
                }

                new Reportes().generarReporteInversion(parametros, listaCostos);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un lote para administrar informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAgregar1ActionPerformed

    private void jButtonAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregar2ActionPerformed
        String cliente = this.obtenerIdentificacionSeleccionado();
        Reportes reportes = new Reportes();
        if (cliente.equalsIgnoreCase("No selecciono") == false) {
            try{
                this.loteID = this.idLotes.get(jTableLotes.getSelectedRow());
                this.cliente = cliente;
                String mesAño = JOptionPane.showInputDialog(null, "Ingrese el año y el mes separados por un espacio");
                StringTokenizer st = new StringTokenizer(mesAño, " ");
                String año = st.nextToken();
                String mes = st.nextToken();
                ArrayList<Integer> semanas = reportes.determinarSemnas(mes);
                Double[] produccion = reportes.produccionxMes(loteID, cliente, año, mes);


                //String rutaInforme = "C:\\Users\\Daniel\\Documents\\Reportes GreenWay\\reporteBasico.jasper";
                Map parametros = new HashMap();
                //parametros.put("bcorta", this.getClass().getResourceAsStream("/imagenes/reportes/bcorta.png"));
                //parametros.put("blarga", this.getClass().getResourceAsStream("/imagenes/reportes/blarga.png"));
                //parametros.put("cliente", cliente);
                //parametros.put("fecha", new Date());            
                parametros.put("fondo", this.getClass().getResourceAsStream("/imagenes/reportes/fondo.png"));
                //parametros.put("lote", loteID);
                parametros.put("mes", año + "-" + mes);

                List listaCostos = new ArrayList();
                if (semanas.size() == 4) {
                    listaCostos = new DaoCostosComercializacion().consultarCostosComercializacionxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
                }else{
                    listaCostos = new DaoCostosComercializacion().consultarCostosComercializacionxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(4).toString());
                }

                new Reportes().generarReporteComercializacion(parametros, listaCostos);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un lote para administrar informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAgregar2ActionPerformed

    private void jButtonAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregar3ActionPerformed
        String cliente = this.obtenerIdentificacionSeleccionado();
        Reportes reportes = new Reportes();
        if (cliente.equalsIgnoreCase("No selecciono") == false) {
            try{
                this.loteID = this.idLotes.get(jTableLotes.getSelectedRow());
                System.out.println(loteID);
                this.cliente = cliente;
                String mesAño = JOptionPane.showInputDialog(null, "Ingrese el año y el mes separados por un espacio");
                StringTokenizer st = new StringTokenizer(mesAño, " ");
                String año = st.nextToken();
                String mes = st.nextToken();
                ArrayList<Integer> semanas = reportes.determinarSemnas(mes);
                Double[] produccion = reportes.produccionxMes(loteID, cliente, año, mes);


                //String rutaInforme = "C:\\Users\\Daniel\\Documents\\Reportes GreenWay\\reporteBasico.jasper";
                Map parametros = new HashMap();
                //parametros.put("bcorta", this.getClass().getResourceAsStream("/imagenes/reportes/bcorta.png"));
                //parametros.put("blarga", this.getClass().getResourceAsStream("/imagenes/reportes/blarga.png"));
                //parametros.put("cliente", cliente);
                //parametros.put("fecha", new Date());            
                parametros.put("fondo", this.getClass().getResourceAsStream("/imagenes/reportes/fondo.png"));
                //parametros.put("lote", loteID);
                parametros.put("mes", año + "-" + mes);

                List listaCostos1 = new ArrayList();
                List listaCostos2 = new ArrayList();
                List listaCostos3 = new ArrayList();

                if (semanas.size() == 4) {
                    listaCostos1 = new DaoCostosOperacionalesOtros().consultarCostosOtrosxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
                    listaCostos2 = new DaoCostosOperacionalesProducto().consultarCostosProductoxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
                    listaCostos3 = this.valorOperacionalxSemana(loteID, año, mes);
                    System.err.println(loteID);
                }else{
                    listaCostos1 = new DaoCostosOperacionalesOtros().consultarCostosOtrosxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(4).toString());
                    listaCostos2 = new DaoCostosOperacionalesProducto().consultarCostosProductoxMesBD(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(4).toString());
                    listaCostos3 = this.valorOperacionalxSemana(loteID, año, mes);
                    System.err.println(loteID);
                }

                listaCostos1.addAll(listaCostos2);
                listaCostos1.addAll(listaCostos3);
                new Reportes().generarReporteCoostosOperacionales(parametros, listaCostos1);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un lote para administrar informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAgregar3ActionPerformed

    private void jButtonAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregar4ActionPerformed
        String cliente = this.obtenerIdentificacionSeleccionado();
        Reportes reportes = new Reportes();
        if (cliente.equalsIgnoreCase("No selecciono") == false) {
            try{
                this.loteID = this.idLotes.get(jTableLotes.getSelectedRow());
                this.cliente = cliente;
                String mesAño = JOptionPane.showInputDialog(null, "Ingrese el año y el mes separados por un espacio");
                StringTokenizer st = new StringTokenizer(mesAño, " ");
                String año = st.nextToken();
                String mes = st.nextToken();
                ArrayList<Integer> semanas = reportes.determinarSemnas(mes);

                //String rutaInforme = "C:\\Users\\Daniel\\Documents\\Reportes GreenWay\\reporteBasico.jasper";
                Map parametros = new HashMap();
                //parametros.put("bcorta", this.getClass().getResourceAsStream("/imagenes/reportes/bcorta.png"));
                //parametros.put("blarga", this.getClass().getResourceAsStream("/imagenes/reportes/blarga.png"));
                //parametros.put("cliente", cliente);
                //parametros.put("fecha", new Date());            
                parametros.put("fondo", this.getClass().getResourceAsStream("/imagenes/reportes/fondo.png"));
                //parametros.put("lote", loteID);
                parametros.put("mes", año + "-" + mes);

                List listaCostos = new ArrayList();
                if (semanas.size() == 4) {
                    listaCostos = new ControladorHistorialAplicacion().consultarHistorialessxMes(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
                }else{
                    listaCostos = new ControladorHistorialAplicacion().consultarHistorialessxMes(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(4).toString());
                }

                new Reportes().generarReporteHistorialAp(parametros, listaCostos);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un lote para administrar informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAgregar4ActionPerformed

    private void jButtonAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregar5ActionPerformed
        String cliente = this.obtenerIdentificacionSeleccionado();
        Reportes reportes = new Reportes();
        if (cliente.equalsIgnoreCase("No selecciono") == false) {
            try{
                this.loteID = this.idLotes.get(jTableLotes.getSelectedRow());
                this.cliente = cliente;
                String mesAño = JOptionPane.showInputDialog(null, "Ingrese el año y el mes separados por un espacio");
                StringTokenizer st = new StringTokenizer(mesAño, " ");
                String año = st.nextToken();
                String mes = st.nextToken();
                ArrayList<Integer> semanas = reportes.determinarSemnas(mes);

                //String rutaInforme = "C:\\Users\\Daniel\\Documents\\Reportes GreenWay\\reporteBasico.jasper";
                Map parametros = new HashMap();
                //parametros.put("bcorta", this.getClass().getResourceAsStream("/imagenes/reportes/bcorta.png"));
                //parametros.put("blarga", this.getClass().getResourceAsStream("/imagenes/reportes/blarga.png"));
                //parametros.put("cliente", cliente);
                //parametros.put("fecha", new Date());            
                parametros.put("fondo", this.getClass().getResourceAsStream("/imagenes/reportes/fondo.png"));
                parametros.put("lote", loteID);
                parametros.put("mes", año + "-" + mes);

                List listaCostos = new ArrayList();
                if (semanas.size() == 4) {
                    listaCostos = new ControladorHistoriaClinica().consultarHistoriasxMes(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(3).toString());
                }else{
                    listaCostos = new ControladorHistoriaClinica().consultarHistoriasxMes(loteID, año, semanas.get(0).toString(), semanas.get(1).toString(), semanas.get(2).toString(), semanas.get(3).toString(), semanas.get(4).toString());
                }

                new Reportes().generarReporteHistoriaClinica(parametros, listaCostos);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un lote para administrar informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAgregar5ActionPerformed

    public String obtenerIdentificacionSeleccionado(){
        try{
            String identificacion = String.valueOf(jTableLotes.getValueAt(jTableLotes.getSelectedRow(), 0));
            return identificacion;
        }catch(Exception e){
            return "No selecciono";
        }
        
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
            java.util.logging.Logger.getLogger(GUI_AdminLotesReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_AdminLotesReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_AdminLotesReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_AdminLotesReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new GUI_AdminLotesReportes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonAgregar1;
    private javax.swing.JButton jButtonAgregar2;
    private javax.swing.JButton jButtonAgregar3;
    private javax.swing.JButton jButtonAgregar4;
    private javax.swing.JButton jButtonAgregar5;
    private javax.swing.JComboBox jComboBoxBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLotes;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
