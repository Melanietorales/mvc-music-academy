/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proModelo.alumnoNuevo;
import proModelo.consultaAlumno;
import proModelo.consultaLogin;
import proModelo.login;
import proVista.frmAlumno;
import proVista.frmLogin;
//import proVista.frmMenu;

/**
 *
 * @author Mel
 */
public class ctlLogin implements ActionListener {

    private final frmLogin frmIn;
    private final login tlogin;
    private final consultaLogin cLogin;

    public ctlLogin(frmLogin frmIn, login tlogin, consultaLogin cLogin) {
        this.frmIn = frmIn;
        this.tlogin = tlogin;
        this.cLogin = cLogin;
        this.frmIn.btnIngresar.addActionListener(this);
    }

  

    public void validar_campos_usuario() {

        if ("".equals(frmIn.txtUsuario.getText())) {
            JOptionPane.showMessageDialog(null, "El campo no puede esta vacio");
            frmIn.txtUsuario.requestFocus();
        } else {
            frmIn.btnIngresar.requestFocus();
        }
    }

    public void iniciar() {
        frmIn.setTitle("Iniciar sesion");
        frmIn.setLocationRelativeTo(null);
        frmIn.txtUsuario.setVisible(true);
        frmIn.txtUsuario.requestFocus();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmIn.btnIngresar) {
            tlogin.setUsu_cedula(frmIn.txtUsuario.getText());

            if (cLogin.buscar(tlogin)) {
                consultaAlumno cAlumno = new consultaAlumno();
                frmAlumno frmA = new frmAlumno();
                alumnoNuevo tAlumno = new alumnoNuevo();
                ctlAlumno ctlA = new ctlAlumno(cAlumno, tAlumno, frmA);
                ctlA.iniciar();
                frmA.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                limpiar();
            }
        }

//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void limpiar() {
        frmIn.txtUsuario.setText(null);
    }

}
