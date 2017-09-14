/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author 
 */
public class Gui_VentanaPrincipalGerente extends javax.swing.JFrame {

    //Atributos
    public Gui_login gui_login;
    
    //Constructor
    public Gui_VentanaPrincipalGerente(Gui_login login) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gui_login = login;
    
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
        jButtonLotes = new javax.swing.JButton();
        jButtonEmpleados = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jButtonCultivos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonItems = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonReportes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Principal SG_REST");

        jPanel1.setLayout(null);

        jButtonLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLotesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLotes);
        jButtonLotes.setBounds(370, 50, 130, 130);

        jButtonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEmpleados);
        jButtonEmpleados.setBounds(30, 50, 130, 130);

        jButtonClientes.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClientes);
        jButtonClientes.setBounds(200, 50, 140, 130);

        jLabel3.setText("Lotes");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 180, 70, 14);

        jLabel1.setText("Clientes");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(230, 180, 110, 14);

        jLabel5.setText("Empleados");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 180, 90, 14);

        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir);
        jButtonSalir.setBounds(510, 10, 60, 60);

        jButtonCultivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCultivosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCultivos);
        jButtonCultivos.setBounds(30, 200, 130, 130);

        jLabel6.setText("Cultivos y Ubicaciones");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 330, 110, 14);

        jButtonItems.setBackground(new java.awt.Color(255, 255, 255));
        jButtonItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonItems);
        jButtonItems.setBounds(200, 200, 140, 130);

        jLabel2.setText("Items desplegables");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 330, 110, 14);

        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonReportes);
        jButtonReportes.setBounds(370, 200, 130, 130);

        jLabel4.setText("Reportes");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 330, 70, 14);
        jPanel1.add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 590, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpleadosActionPerformed
        // TODO add your handling code here:
        
         GUI_empleados empleados =new GUI_empleados(this);
    
         empleados.setVisible(true);
         
         this.dispose();
         
       
      
    }//GEN-LAST:event_jButtonEmpleadosActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        
        GUI_clientes clientes = new GUI_clientes(this);
        
        clientes.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLotesActionPerformed
        /*// TODO add your handling code here:
          // TODO add your handling code here:
        try{
         Gui_VerReportes reportes = new Gui_VerReportes(this);
    
         reportes.setVisible(true);
         this.dispose();
         
       }catch(Exception e){
       System.out.println(e);}*/
        
    }//GEN-LAST:event_jButtonLotesActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.setVisible(false); 
        
        Gui_Otros gui_Otros = new Gui_Otros(this);
        
        gui_Otros.setVisible(true); 
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCultivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCultivosActionPerformed
        this.setVisible(false);
        
        Gui_CultivosYUbicaciones cyU = new Gui_CultivosYUbicaciones(this);
        
        cyU.setVisible(true);
    }//GEN-LAST:event_jButtonCultivosActionPerformed

    private void jButtonItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemsActionPerformed
        this.setVisible(false); 
        
        GUI_items gui_items = new GUI_items(this);
        
        gui_items.setVisible(true);
    }//GEN-LAST:event_jButtonItemsActionPerformed

    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReportesActionPerformed

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
            java.util.logging.Logger.getLogger(Gui_VentanaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_VentanaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_VentanaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_VentanaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_VentanaPrincipalGerente(new Gui_login ()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonCultivos;
    private javax.swing.JButton jButtonEmpleados;
    private javax.swing.JButton jButtonItems;
    private javax.swing.JButton jButtonLotes;
    private javax.swing.JButton jButtonReportes;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFondo;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
