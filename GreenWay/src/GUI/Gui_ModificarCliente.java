/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Clases.*;
import Controlador.ControladorCliente;
import Controlador.ControladorEmpleado;
import Controlador.ControladorUsuario;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author
 */
public class Gui_ModificarCliente extends javax.swing.JFrame {

    //Atributos
    //GUI de la ventana principal del gerente
    GUI_clientes gui_clientes;
    File foto;
    String identificacionCliente;
    
    //Constructor
    public Gui_ModificarCliente(GUI_clientes gui_clientes, String identificacion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.identificacionCliente = identificacion;
        this.gui_clientes = gui_clientes; 
        this.llenarDatos();
    }

    /**
     * Metodo para llenar los datos de la interfaz automaticamente en base a la cedula seleccionado en la interfaz principal del cliente
     */
    public void llenarDatos(){
        Cliente cliente  = new ControladorCliente().consultarCliente(identificacionCliente);
        
        
        this.jTextFieldIdentificacion.setText(cliente.getIdentificacion());
        this.jTextFieldIdentificacion.setEnabled(false);
        
        this.jTextFieldNombre.setText(cliente.getNombre());
        this.jTextFieldApellidos.setText(cliente.getApellido());
                   
        if(cliente.getEstado() == true){
            this.jComboBoxEstado.setSelectedIndex(1);
        }else{
            this.jComboBoxEstado.setSelectedIndex(2);
        }
   
        this.jTextFieldCelular.setText(cliente.getTelefono());
        this.jTextFieldDireccion.setText(cliente.getDireccion());
        this.jTextFieldEmail.setText(cliente.getCorreo());
        
        ImageIcon icon = new ImageIcon("Clientes/"+jTextFieldIdentificacion.getText()+".png");
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_DEFAULT));
        jLabelFoto.setIcon(icono);
        this.foto = new File("Clientes/"+jTextFieldIdentificacion.getText()+".png");
   }

    //metodo para guardar una imagen que representa la foto del cliente
    public String copiarImagen(){
        FileInputStream in = null;
        String ruta=null;
        
        if (foto == null) {
            
        }else{
            try {
                System.err.println(foto.toString());
                System.err.println("Clientes/"+jTextFieldIdentificacion.getText()+".png");
                if (foto.toString().equalsIgnoreCase("Clientes\\"+jTextFieldIdentificacion.getText()+".png")) {
                    ruta="Clientes/"+jTextFieldIdentificacion.getText()+".png";
                    
                }else{
                    File inFile = new File(foto.toString());
                    ruta="Clientess/"+jTextFieldIdentificacion.getText()+".png";
                    File outFile = new File(ruta);
                    in = new FileInputStream(inFile);
                    FileOutputStream out = new FileOutputStream(outFile);
                    int c;
                    while( (c = in.read() ) != -1)
                        out.write(c);
                    in.close();
                    out.close();
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Gui_ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Gui_ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        
        return ruta;
    }

    /**
     * Metodo para agregar un cleinte a la base de datos
     * @param identificacion
     * @param nombre
     * @param apellido
     * @param estado
     * @param telefono
     * @param direccion
     * @param email
     * @param foto
     * @return
     */
    public String modificarCliente(String identificacion, String nombre, String apellido, boolean estado, String telefono, String direccion, String email, String foto){
        //variable que almacenara el resultado
        String resultado = "";          
        
        //creacion de  controlador para realizar el ingreso del cliente, tambien de la clase que valida los campos
        ControladorCliente controladorCliente = new ControladorCliente();
        Validaciones validar = new Validaciones();
        
        try {
            //se verifica que no haya campos obligatorios vacios, que los tipos de datos sean correctos asi como los datos que deben estar dentro de un rango como el cargo y estado civil
            if ((verificarCamposVacios() == false) && verificarTipos() && (foto != null)) {
                //se verifica que el cliente no haya sido creado anteriormente por medio de la identificacion
                    resultado = controladorCliente.actualizarCliente(nombre, apellido, identificacion, telefono, direccion, estado, email, foto);      
                    limpiar();

            }else{
                resultado = "No se pudo modificar el cliente, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
                //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NullPointerException ex) {
            resultado = "No se pudo modificar el cliente, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(Gui_ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
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

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox();
        jLabelFoto = new javax.swing.JLabel();
        jButtonSeleccionarFoto = new javax.swing.JButton();
        jTextFieldIdentificacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonModificar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jLabel1.setText("Identificación:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("E_mail:");

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jTextFieldApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidosKeyTyped(evt);
            }
        });

        jTextFieldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCelularKeyTyped(evt);
            }
        });

        jLabel9.setText("Direccion:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Activo", "Inactivo" }));

        jLabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonSeleccionarFoto.setText("Seleccionar Imagen");
        jButtonSeleccionarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarFotoActionPerformed(evt);
            }
        });

        jTextFieldIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdentificacionActionPerformed(evt);
            }
        });
        jTextFieldIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIdentificacionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonSeleccionarFoto)
                        .addGap(82, 82, 82))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSeleccionarFoto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Save).jpg"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Delete).jpg"))); // NOI18N
        jButtonSalir.setText("salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(567, 567, 567))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        try{
            this.gui_clientes.setVisible(true);
            this.gui_clientes.buscarClientes();
            this.dispose();
        }catch(Exception e){}
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
  
        // Obtencion de datos de la interfaz
        String identificacion = jTextFieldIdentificacion.getText().trim();
        String nombre = jTextFieldNombre.getText().trim();
        String apellido = jTextFieldApellidos.getText().trim();
        
        String estadocombo = jComboBoxEstado.getSelectedItem().toString();
        boolean estado = true;
        if (estadocombo.equalsIgnoreCase("activo")) {
            estado = true;
        }else{
            estado = false;
        }
                
        String telefono = jTextFieldCelular.getText().trim();
        String email=jTextFieldEmail.getText().trim();
        String direccion = jTextFieldDireccion.getText().trim();
        String foto = this.copiarImagen();     
        
        String resultado = this.modificarCliente(identificacion, nombre, apellido, estado, telefono, direccion, email, foto);
        
        if (resultado.equalsIgnoreCase("No se pudo modificar el cliente, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            try{
                this.dispose();
                JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
                this.gui_clientes.buscarClientes();
                this.gui_clientes.setVisible(true);
           }catch(Exception e){}
        
        }

        }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldIdentificacion.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldIdentificacionKeyTyped

    private void jTextFieldIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdentificacionActionPerformed

    private void jButtonSeleccionarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarFotoActionPerformed
        // TODO add your handling code here:
        int resultado;

        JFileChooser ventana = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");

        ventana.setFileFilter(filtro);

        resultado= ventana.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){

            foto = ventana.getSelectedFile();

            try{

                ImageIcon icon = new ImageIcon(foto.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_DEFAULT));
                jLabelFoto.setText(null);
                jLabelFoto.setIcon( icono );

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);

            }

        }
    }//GEN-LAST:event_jButtonSeleccionarFotoActionPerformed

    private void jTextFieldCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldCelular.getText().length()>=11)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldCelularKeyTyped

    private void jTextFieldApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidosKeyTyped
        char car=evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidosKeyTyped

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    //Metodo para limpiar los campos de la interfaz grafica de usuario y devolverlos a su estado inicial
    public void limpiar(){
        this.jTextFieldIdentificacion.setText("");
        this.jTextFieldNombre.setText("");
        this.jTextFieldApellidos.setText(""); 
        this.jComboBoxEstado.setSelectedIndex(0);   
        this.jTextFieldCelular.setText("");
        this.jTextFieldEmail.setText("");     
        this.jTextFieldDireccion.setText("");
        jLabelFoto.setIcon(null);       
    }
     
    //Metodo para habilitar los campos de la interfaz grafica de usuario y asignar sus estado inicial 
    public void habilitar(){
        this.jTextFieldIdentificacion.setEnabled(true);
        this.jTextFieldNombre.setEnabled(true);
        this.jTextFieldApellidos.setEnabled(true); 
        this.jComboBoxEstado.setEnabled(true);
        this.jTextFieldCelular.setEnabled(true);
        this.jTextFieldEmail.setEnabled(true);
        this.jTextFieldDireccion.setEnabled(true);
      
    }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarCamposVacios(){
         boolean var =false;
         
         if (jTextFieldIdentificacion.getText().equalsIgnoreCase("") || jTextFieldNombre.getText().equalsIgnoreCase("") ||
                jTextFieldApellidos.getText().equalsIgnoreCase("") || jComboBoxEstado.getSelectedItem().toString().equalsIgnoreCase("Seleccione...") ||
                jTextFieldCelular.getText().equalsIgnoreCase("") || jTextFieldDireccion.getText().equalsIgnoreCase("") || jTextFieldEmail.getText().equalsIgnoreCase("")) {
   
             var = true;             
         }
         
         return var;
     }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarTipos(){
         
         boolean var =false;
         Validaciones validar = new Validaciones();
         
         if (validar.isNumeric(jTextFieldIdentificacion.getText().trim()) && validar.isNumeric(jTextFieldCelular.getText().trim())) {
            var = true;             
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
            java.util.logging.Logger.getLogger(Gui_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Gui_ModificarCliente(new GUI_clientes(new Gui_VentanaPrincipalGerente(new Gui_login())), new String()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSeleccionarFoto;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFoto;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIdentificacion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
