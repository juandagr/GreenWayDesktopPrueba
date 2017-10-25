/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Cultivo;
import Clases.Empleado;
import Clases.Ubicacion;
import Clases.Validaciones;
import Controlador.ControladorCultivo;
import Controlador.ControladorEmpleado;
import Controlador.ControladorUbicacion;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Daniel
 */
public class GUI_Cultivos extends javax.swing.JFrame {

    //Atributos
    Gui_CultivosYUbicaciones cultivosYUbicaciones;
    private TableRowSorter trsFiltro;
    File archivo;
    
    DefaultTableModel modeloItems = new DefaultTableModel(){
           
           //sobreescribir el metodo para que las celdas no se puedan editar
            @Override
            public boolean isCellEditable (int fila, int columna) {
                return false;}
        };
    
    //Constructor
    public GUI_Cultivos(Gui_CultivosYUbicaciones cultivosYUbicaciones) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cultivosYUbicaciones = cultivosYUbicaciones;
        modeloItems.addColumn("Nombre");
        modeloItems.addColumn("Descripcion");
        
        buscarCultivos();
        modeloItems.addTableModelListener(new TableModelListener () {

            @Override
            public void tableChanged(TableModelEvent tme) {
                
                
            }
        } 
  
        );
    }
    
    //metodo para guardar el archivo de descripcion del cultivo
    public String copiarArchivo(){
        FileInputStream in = null;
        FileOutputStream out = null;
        String ruta=null;
        
        if (archivo == null) {
            
        }else{
            try {
                File inFile = new File(archivo.toString());
                ruta="Cultivos/"+jTextFieldNombre.getText().trim()+".pdf";
                JOptionPane.showMessageDialog(null, ruta);
                File outFile = new File(ruta);
                in = new FileInputStream(inFile);
                out = new FileOutputStream(outFile);
                int c;
                /*while( (c = in.read() ) != -1)
                    out.write(c);*/
                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                  out.write(buf, 0, len);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }catch (NullPointerException ex) {
                    Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return ruta;
    }
    
    //metodo para guardar el archivo de descripcion del cultivo
    public String copiarArchivoModificar(){
        FileInputStream in = null;
        FileOutputStream out = null;
        String ruta=null;
        
        if (archivo == null) {
            
        }else{
            try {
                File inFile = new File(archivo.toString());
                ruta="Cultivos/"+jTextFieldNombreModificar.getText().trim()+".pdf";
                JOptionPane.showMessageDialog(null, ruta);
                File outFile = new File(ruta);
                in = new FileInputStream(inFile);
                out = new FileOutputStream(outFile);
                int c;
                /*while( (c = in.read() ) != -1)
                    out.write(c);*/
                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                  out.write(buf, 0, len);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }catch (NullPointerException ex) {
                    Logger.getLogger(Gui_AgregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return ruta;
    }
    
    //metodo para bucar tods los cultivos que se encuentren en la base de datos y mostrarlos en la tabla
    public void buscarCultivos(){
        while(modeloItems.getRowCount()>0)modeloItems.removeRow(0);
        jTableUbicaciones.setModel(modeloItems);
        
        ArrayList<Cultivo> ubicaciones = new ControladorCultivo().consultarTodosCultivos();
        
        for (int i = 0; i < ubicaciones.size(); i++) {
            // Se crea un array que será una de las filas de la tabla.
            Object [] fila = new Object[2]; // Hay tres columnas en la tabla

            // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
            fila[0] = ubicaciones.get(i).getNombre();
            fila[1] = ubicaciones.get(i).getDescripcion();

            // Se añade al modelo la fila completa.
            modeloItems.addRow(fila);
            
        }
        
    }

    //factores por los cuales se va a aplicar el filtro a la tabla de ubicaciones
    public void filtro() {
        int columnaABuscar = 1;
        if (jComboBoxBusqueda.getSelectedItem() == "nombre") {
            columnaABuscar = 1;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(jTextFieldBusqueda.getText(), columnaABuscar));
    }

    /**
     * Metodo para agregar un cultivo a la base de datos
     * @param nombre
     * @param descripcion
     * @return
     */
    public String ingresarCultivo(String nombre,String descripcion){
        String resultado = "";
        
        //creacion de  controlador para realizar el ingreso de la ubicacion, tambien de la clase que valida los campos
        ControladorCultivo controlador = new ControladorCultivo();
        Validaciones validaciones = new Validaciones();
        
        //se valida que los datos ingresados sean String, pues no se aceptan numeros
        if (validaciones.isString(nombre) && validaciones.isString(descripcion)) {
            //se valida que almenos el dato del nombre no este vacio
            if (false == nombre.equalsIgnoreCase("")) {
                //se crea el id del cultivo partiendo del nombre
                String identificador = nombre;
                if (controlador.cultivoRegistrado(identificador) == false) {
                    
                    resultado = controlador.ingresarCultivo(identificador, nombre, descripcion);
                }else{
                    resultado = "No se pudo crear el cultivo debido a que ya se encuentra registrado.";
                }
            }else{
                resultado = "No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            }
        }else{
            resultado = "No se pudo crear el cultivo, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
        }
        
        return resultado;
    }
    
    /**
     * Metodo para agregar un cultivo a la base de datos
     * @param nombre
     * @param descripcion
     * @return
     */
    public String modificarCultivo(String nombreAnterior, String nombreNuevo, String descripcion){
        String resultado = "";
        
        //creacion de  controlador para realizar el ingreso de la ubicacion, tambien de la clase que valida los campos
        ControladorCultivo controlador = new ControladorCultivo();
        Validaciones validaciones = new Validaciones();
        
        //se valida que los datos ingresados sean String, pues no se aceptan numeros
        if (validaciones.isString(nombreNuevo)) {
            //se valida que almenos el dato del nombre no este vacio
            if (false == nombreNuevo.equalsIgnoreCase("")) {
                //se crea el id del cultivo partiendo del nombre
                String identificador = nombreAnterior;
                if (controlador.cultivoRegistrado(identificador) == true) {
                    
                    resultado = controlador.actualizarCultivo(identificador, nombreNuevo, descripcion);
                }else{
                    resultado = "No se pudo actualizar el cultivo debido a que no se encuentra registrado.";
                }
            }else{
                resultado = "No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            }
        }else{
            resultado = "No se pudo actualizar el cultivo, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
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
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jComboBoxBusqueda = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNombreModificar = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonArchivoModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Administracion de ubicaciones");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cultivos"));

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
        jTableUbicaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUbicacionesMouseClicked(evt);
            }
        });
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

        jComboBoxBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nombre" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar"));

        jTextFieldNombreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreModificarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel4.setText("Cambiar archivo");

        jButtonArchivoModificar.setText("Seleccionar");
        jButtonArchivoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArchivoModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonArchivoModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombreModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonModificar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonArchivoModificar))
                .addGap(18, 18, 18)
                .addComponent(jButtonModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar"));

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Seleccione el archivo de descripcion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAgregar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAgregar)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        String nombre = jTextFieldNombre.getText().trim();
        String descripcion = copiarArchivo();
        
        String resultado = this.ingresarCultivo(nombre, descripcion);
        
        if (resultado.equalsIgnoreCase("No se pudo crear el cultivo debido a que ya se encuentra registrado.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("No se pudo crear el cultivo, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        buscarCultivos();
        jTextFieldNombre.setText("");
        archivo = null;
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
        try{
            String nombreNuevo = jTextFieldNombreModificar.getText().trim();
            String nombreAnterior = String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 0));
            String descripcion = copiarArchivoModificar();
            if (obtenerIdentificacionSeleccionado().equalsIgnoreCase("No selecciono")) {
                JOptionPane.showMessageDialog(null, "Seleccione el cultivo que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
            }else{

                String resultado = modificarCultivo(nombreAnterior, nombreNuevo, descripcion);

                if (resultado.equalsIgnoreCase("No se pudo actualizar el cultivo debido a que no se encuentra registrado.")) {
                    JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
                }else if (resultado.equalsIgnoreCase("No puede dejar campos vacios, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
                    JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
                }else if (resultado.equalsIgnoreCase("No se pudo actualizar el cultivo, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
                    JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Seleccione el cultivo que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }

        buscarCultivos();
        jTextFieldNombreModificar.setText("");
        archivo = null;

    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldNombreModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int resultado;

        JFileChooser ventana = new JFileChooser();
        resultado= ventana.showOpenDialog(null);


        if (JFileChooser.APPROVE_OPTION == resultado){

                archivo = ventana.getSelectedFile();

         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableUbicacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUbicacionesMouseClicked
    jTableUbicaciones.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent e) {
      if(e.getClickCount()==1){
          jTextFieldNombreModificar.setText(String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 0)));
        }
      if(e.getClickCount()==2){
         String descripcion = String.valueOf(jTableUbicaciones.getValueAt(jTableUbicaciones.getSelectedRow(), 1));
         
         try{
             File file = new File(descripcion);
             Desktop.getDesktop().open(file);
             
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "El cultivo no tiene descripcion", "Error", JOptionPane.ERROR_MESSAGE);
         }
       }
        }
    });

    }//GEN-LAST:event_jTableUbicacionesMouseClicked

    private void jButtonArchivoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArchivoModificarActionPerformed
        // TODO add your handling code here:
        int resultado;

        JFileChooser ventana = new JFileChooser();
        resultado= ventana.showOpenDialog(null);


        if (JFileChooser.APPROVE_OPTION == resultado){

                archivo = ventana.getSelectedFile();

         }
    }//GEN-LAST:event_jButtonArchivoModificarActionPerformed


    
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
            java.util.logging.Logger.getLogger(GUI_Cultivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Cultivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Cultivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Cultivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Cultivos(new Gui_CultivosYUbicaciones(new Gui_VentanaPrincipalGerente(new Gui_login()))).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonArchivoModificar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox jComboBoxBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUbicaciones;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreModificar;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
