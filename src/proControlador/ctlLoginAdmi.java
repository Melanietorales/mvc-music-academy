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
import proModelo.consultaAdministrador;
import proModelo.consultaLoginAdmi;
import proModelo.loginAdmi;
import proVista.frmAdministrador;
import proVista.frmLoginAdmi;

/**
 *
 * @author Mel
 */
public class ctlLoginAdmi implements ActionListener {

    private final frmLoginAdmi frmLogAdmi;
    private final loginAdmi tLogAdmi;
    private final consultaLoginAdmi cLogAdmi;

    public ctlLoginAdmi(consultaLoginAdmi cLogAdmi, loginAdmi tLogAdmi, frmLoginAdmi frmLogAdmi) {
        this.cLogAdmi = cLogAdmi;
        this.tLogAdmi = tLogAdmi;
        this.frmLogAdmi = frmLogAdmi;
        this.frmLogAdmi.btnAcceder.addActionListener(this);
    }

    public void validar_campos_usuario() {

        if ("".equals(frmLogAdmi.txtCodigoAdmi.getText())) {
            JOptionPane.showMessageDialog(null, "El campo no puede esta vacio");
            frmLogAdmi.txtCodigoAdmi.requestFocus();
        } else {
            frmLogAdmi.btnAcceder.requestFocus();
        }
    }

    public void iniciar() {
        frmLogAdmi.setTitle("Acceder");
        frmLogAdmi.setLocationRelativeTo(null);
        frmLogAdmi.txtCodigoAdmi.setVisible(true);
        frmLogAdmi.txtCodigoAdmi.requestFocus();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogAdmi.btnAcceder) {
            tLogAdmi.setAdmin_codigo(frmLogAdmi.txtCodigoAdmi.getText());

            if (cLogAdmi.buscar(tLogAdmi)) {
                frmAdministrador frmAdmi = new frmAdministrador();
                ctlAdministrador ctlAdmi = new ctlAdministrador(frmAdmi);
                frmAdmi.setVisible(true);
                frmAdmi.setLocationRelativeTo(frmAdmi);
                frmLogAdmi.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                limpiar();
            }
        }

    }

    public void limpiar() {
        frmLogAdmi.txtCodigoAdmi.setText(null);
    }
}
