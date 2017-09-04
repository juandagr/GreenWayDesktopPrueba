/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Clases.*;
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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author
 */
public class Gui_AgregarCliente extends javax.swing.JFrame {

    //Atributos
    //GUI de la ventana principal del gerente
    GUI_clientes gui_clientes;
    File foto;
    
    //Constructor
    public Gui_AgregarCliente(GUI_clientes gui_clientes) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gui_clientes = gui_clientes;        

    }
    

    //metodo para guardar una imagen que representa la foto del empleado
    public String copiarImagen(){
        FileInputStream in = null;
        String ruta=null;
        
        if (foto == null) {
            
        }else{
            try {
                File inFile = new File(foto.toString());
                ruta="Empleados/"+jTextFieldIdentificacion.getText()+".png";
                File outFile = new File(ruta);
                in = new FileInputStream(inFile);
                FileOutputStream out = new FileOutputStream(outFile);
                int c;
                while( (c = in.read() ) != -1)
                    out.write(c);
                in.close();
                out.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Gui_AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Gui_AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(Gui_AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }catch (NullPointerException ex) {
                    Logger.getLogger(Gui_AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return ruta;
    }

    //metodo para agregar un empleado a la base de datos
    public String agregarEmpleado(String id, String nombre, String apellido, String dni, String cargo, String telefono, String direccion, boolean estado, String foto, String email, Date fechaNacimiento, String estadoCivil, String usuario, String contraseña){
        //variable que almacenara el resultado
        String resultado = "";     
        
        //creacion de  controlador para realizar el ingreso del empleado y el usuario, tambien de la clase que valida los campos
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Validaciones validar = new Validaciones();
        
        try {
            //se verifica que no haya campos obligatorios vacios, que los tipos de datos sean correctos asi como los datos que deben estar dentro de un rango como el cargo y estado civil
            if ((verificarCamposVacios() == false) && verificarTipos() && validar.validarCargoEmpleado(cargo) && validar.validarEstadoCivilEmpleado(estadoCivil) && (foto != null)) {
                //se verifica que el empleado no haya sido creado anteriormente por medio de la identificacion
                if (controladorEmpleado.empleadoRegistrado(id) == false) {
                    //se verifica si el nombre de usuario ya se encuentra registrado en la base de datos
                    if (controladorUsuario.usuarioRegistrado(usuario) == false) {
                        
                        resultado = controladorEmpleado.ingresarEmpleado(nombre, apellido, id, cargo, telefono, direccion, estado, foto, email, fechaNacimiento, estadoCivil);
                        controladorUsuario.ingresarUsuario(usuario, contraseña, estado, id);
                        
                        limpiar();
                        
                    }else{
                        
                        resultado = "El usuario ya se encuentra registrado.";
                        //JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado.", "Error!", JOptionPane.ERROR_MESSAGE);
                        jTextFieldUsuario.setText("");
                    }
                    
                }else{
                    
                    resultado = "El empleado ya se encuentra registrado.";
                    //JOptionPane.showMessageDialog(null, "El empleado ya se encuentra registrado.", "Error!", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }                
                
            }else{
                resultado = "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
                //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NullPointerException ex) {
            resultado = "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.";
            //JOptionPane.showMessageDialog(null, "No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(Gui_AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        jButtonagregar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 0, 255)));

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButtonagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Save).jpg"))); // NOI18N
        jButtonagregar.setText("agregar");
        jButtonagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonagregarActionPerformed(evt);
            }
        });

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16 (Delete).jpg"))); // NOI18N
        jButtonSalir.setText("salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Wzdelete.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                                            .addComponent(jLabel5))
                                        .addGap(38, 38, 38)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonSeleccionarFoto)
                                        .addGap(10, 10, 10)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSeleccionarFoto))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(567, 567, 567))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();

    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidosKeyTyped
        char car=evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidosKeyTyped

    private void jTextFieldCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldCelular.getText().length()>=11)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldCelularKeyTyped

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

    private void jButtonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonagregarActionPerformed
        
        // Obtencion de datos de la interfaz
        String id=jTextFieldIdentificacion.getText().trim();
        String nombre =jTextFieldNombre.getText().trim();
        String apellido = jTextFieldApellidos.getText().trim();
        String cargo=this.jComboBoxCargo.getSelectedItem().toString();
        String dni=jComboBoxEstado.getSelectedItem().toString();
        boolean estado = true;
        if (dni.equalsIgnoreCase("activo")) {
            estado = true;
        }else{
            estado = false;
        }
        String telefono=jTextFieldCelular.getText().trim();
        String email=jTextFieldEmail.getText().trim();
        String direccion=jTextFieldDireccion.getText().trim();
        String estadoCivil = jComboBoxEstadoCivil.getSelectedItem().toString();
        Date fechaNacimiento = jDateChooserNacimiento.getDate();
        String usuario=jTextFieldUsuario.getText().trim();
        String contraseña = jTextFieldContraseña.getText().trim();
        String foto = this.copiarImagen();
        
        String resultado = this.agregarEmpleado(id, nombre, apellido, dni, cargo, telefono, direccion, estado, foto, email, fechaNacimiento, estadoCivil, usuario, contraseña);
       
        if (resultado.equalsIgnoreCase("No se pudo crear el empleado, por favor verifique que sus datos están correctos e inténtelo de nuevo.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("El usuario ya se encuentra registrado.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }else if (resultado.equalsIgnoreCase("El empleado ya se encuentra registrado.")) {
            JOptionPane.showMessageDialog(null, resultado, "Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, resultado, "Informacion!", JOptionPane.INFORMATION_MESSAGE);
        }
            
    }//GEN-LAST:event_jButtonagregarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
         try{
         this.gui_empleados.setVisible(true);
         this.gui_empleados.buscarEmpleados();
         this.dispose();
       }catch(Exception e){}

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiar();
        habilitar();
        foto = null;
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdentificacionActionPerformed

    private void jTextFieldIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacionKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  jTextFieldIdentificacion.getText().length()>=10)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextFieldIdentificacionKeyTyped

    //Metodo para limpiar los campos de la interfaz grafica de usuario y devolverlos a su estado inicial
    public void limpiar(){
        this.jTextFieldIdentificacion.setText("");
        this.jTextFieldNombre.setText("");
        this.jTextFieldApellidos.setText(""); 
        this.jComboBoxCargo.setSelectedIndex(0);
        this.jComboBoxEstado.setSelectedIndex(0);
        this.jComboBoxEstadoCivil.setSelectedIndex(0);
        this.jTextFieldCelular.setText("");
        this.jTextFieldEmail.setText("");
        this.jTextFieldContraseña.setText("");
        jTextFieldDireccion.setText("");
        jLabelFoto.setIcon(null);
        this.jDateChooserNacimiento.setDate(new Date());
        this.jTextFieldUsuario.setText("");

    }
     
    //Metodo para habilitar los campos de la interfaz grafica de usuario y asignar sus estado inicial 
    public void habilitar(){
        this.jTextFieldIdentificacion.setEnabled(true);
        this.jTextFieldNombre.setEnabled(true);
        this.jTextFieldApellidos.setEnabled(true); 
        this.jComboBoxCargo.setEnabled(true);
        this.jComboBoxEstado.setEnabled(true);
        this.jComboBoxEstadoCivil.setEnabled(true);
        this.jTextFieldCelular.setEnabled(true);
        this.jTextFieldEmail.setEnabled(true);
        this.jTextFieldDireccion.setEnabled(true);
        this.jTextFieldContraseña.setEnabled(true);
        this.jDateChooserNacimiento.setEnabled(true);
        this.jDateChooserNacimiento.setDate(new Date());
        this.jTextFieldUsuario.setEditable(true);
    }
     
     //metodo encargado de verificar que los campos obligatorios para crear un empleado
     //no se encuentren vacios, pues asi no se puede crear el empleado
     public boolean verificarCamposVacios(){
         boolean var =false;
         
         if (jTextFieldIdentificacion.getText().equalsIgnoreCase("") || jTextFieldNombre.getText().equalsIgnoreCase("") ||
                 jTextFieldApellidos.getText().equalsIgnoreCase("") || jComboBoxCargo.getSelectedItem().toString().equalsIgnoreCase("Seleccione...") ||
                 jComboBoxEstado.getSelectedItem().toString().equalsIgnoreCase("Seleccione...") || jTextFieldContraseña.getText().equalsIgnoreCase("") ||
                 jComboBoxEstadoCivil.getSelectedItem().toString().equalsIgnoreCase("Seleccione...") || jTextFieldUsuario.getText().equalsIgnoreCase("") ||
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
            java.util.logging.Logger.getLogger(Gui_AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_AgregarCliente(new GUI_empleados(new Gui_VentanaPrincipalGerente(new Gui_login()))).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSeleccionarFoto;
    private javax.swing.JButton jButtonagregar;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFoto;
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
