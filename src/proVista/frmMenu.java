/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proVista;

import java.awt.Color;
import proControlador.ctlAlumnoNuevo;
import proControlador.ctlLogin;
import proControlador.ctlLoginAdmi;
import proModelo.alumnoNuevo;
import proModelo.consultaAlumnoNuevo;
import proModelo.consultaLogin;
import proModelo.consultaLoginAdmi;
import proModelo.login;
import proModelo.loginAdmi;

/**
 *
 * @author Mel
 */
public class frmMenu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public frmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        Color color = new Color(215, 204, 200);
        this.getContentPane().setBackground(color);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnQuieroInscribirme = new javax.swing.JButton();
        btnSoyAlumno = new javax.swing.JButton();
        btnSoyAdmin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPpal = new javax.swing.JMenu();
        jMenuInscribirme = new javax.swing.JMenuItem();
        jMenuIngre = new javax.swing.JMenuItem();
        jMenuAdmi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel1.setText("Sounds Of Music");

        btnQuieroInscribirme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrarme.png"))); // NOI18N
        btnQuieroInscribirme.setText("Quiero inscribirme");
        btnQuieroInscribirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuieroInscribirmeActionPerformed(evt);
            }
        });

        btnSoyAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alumnoo (1).png"))); // NOI18N
        btnSoyAlumno.setText("Soy alumno");
        btnSoyAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoyAlumnoActionPerformed(evt);
            }
        });

        btnSoyAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adminn (1).png"))); // NOI18N
        btnSoyAdmin.setText("Soy administrador");
        btnSoyAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoyAdminActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 2, 14)); // NOI18N
        jLabel2.setText("Musical Academy");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/musica2.png"))); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jMenuPpal.setText("Menu");

        jMenuInscribirme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrarme.png"))); // NOI18N
        jMenuInscribirme.setText("Inscribirme");
        jMenuInscribirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInscribirmeActionPerformed(evt);
            }
        });
        jMenuPpal.add(jMenuInscribirme);

        jMenuIngre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alumnoo (1).png"))); // NOI18N
        jMenuIngre.setText("Ingresar");
        jMenuIngre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIngreActionPerformed(evt);
            }
        });
        jMenuPpal.add(jMenuIngre);

        jMenuAdmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adminn (1).png"))); // NOI18N
        jMenuAdmi.setText("Ingresar como administrador");
        jMenuAdmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAdmiActionPerformed(evt);
            }
        });
        jMenuPpal.add(jMenuAdmi);

        jMenuBar1.add(jMenuPpal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnQuieroInscribirme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSoyAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSoyAdmin)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(86, 86, 86))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuieroInscribirme)
                    .addComponent(btnSoyAlumno)
                    .addComponent(btnSoyAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoyAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoyAlumnoActionPerformed
        consultaLogin cLogin = new consultaLogin();
        frmLogin frmIn = new frmLogin();
        login tlogin = new login();
        ctlLogin login = new ctlLogin(frmIn, tlogin, cLogin);
        login.iniciar();
        frmIn.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnSoyAlumnoActionPerformed

    private void btnQuieroInscribirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuieroInscribirmeActionPerformed
        consultaAlumnoNuevo cNuevo = new consultaAlumnoNuevo();
        frmAlumnoNuevo frmNuevo = new frmAlumnoNuevo();
        alumnoNuevo tAlumnoNuevo = new alumnoNuevo();
        ctlAlumnoNuevo contNuevo = new ctlAlumnoNuevo(frmNuevo, tAlumnoNuevo, cNuevo);
        contNuevo.iniciar();
        frmNuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuieroInscribirmeActionPerformed

    private void btnSoyAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoyAdminActionPerformed

        consultaLoginAdmi cLogAdmi = new consultaLoginAdmi();
        frmLoginAdmi frmLogAdmi = new frmLoginAdmi();
        loginAdmi tLogAdmi = new loginAdmi();
        ctlLoginAdmi contLogAdmi = new ctlLoginAdmi(cLogAdmi, tLogAdmi, frmLogAdmi);
        contLogAdmi.iniciar();
        frmLogAdmi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSoyAdminActionPerformed

    private void jMenuInscribirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInscribirmeActionPerformed
        consultaAlumnoNuevo cNuevo = new consultaAlumnoNuevo();
        frmAlumnoNuevo frmNuevo = new frmAlumnoNuevo();
        alumnoNuevo tAlumnoNuevo = new alumnoNuevo();
        ctlAlumnoNuevo contNuevo = new ctlAlumnoNuevo(frmNuevo, tAlumnoNuevo, cNuevo);
        contNuevo.iniciar();
        frmNuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuInscribirmeActionPerformed

    private void jMenuIngreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIngreActionPerformed
        consultaLogin cLogin = new consultaLogin();
        frmLogin frmIn = new frmLogin();
        login tlogin = new login();
        ctlLogin login = new ctlLogin(frmIn, tlogin, cLogin);
        login.iniciar();
        frmIn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuIngreActionPerformed

    private void jMenuAdmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAdmiActionPerformed
        consultaLoginAdmi cLogAdmi = new consultaLoginAdmi();
        frmLoginAdmi frmLogAdmi = new frmLoginAdmi();
        loginAdmi tLogAdmi = new loginAdmi();
        ctlLoginAdmi contLogAdmi = new ctlLoginAdmi(cLogAdmi, tLogAdmi, frmLogAdmi);
        contLogAdmi.iniciar();
        frmLogAdmi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuAdmiActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuieroInscribirme;
    private javax.swing.JButton btnSoyAdmin;
    public javax.swing.JButton btnSoyAlumno;
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JMenuItem jMenuAdmi;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuIngre;
    public javax.swing.JMenuItem jMenuInscribirme;
    public javax.swing.JMenu jMenuPpal;
    // End of variables declaration//GEN-END:variables
}
