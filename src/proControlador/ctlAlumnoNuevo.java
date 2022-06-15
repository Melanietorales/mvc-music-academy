/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proControlador;

import conexionMySQL.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proModelo.alumnoNuevo;
import proModelo.consultaAlumnoNuevo;
import proVista.frmAlumnoNuevo;
import proVista.frmMenu;

/**
 *
 * @author Mel
 */
public class ctlAlumnoNuevo implements ActionListener {

    private final frmAlumnoNuevo frmNuevo;
    private final alumnoNuevo tAlumnoNuevo;
    private final consultaAlumnoNuevo cNuevo;

    public ctlAlumnoNuevo(frmAlumnoNuevo frmNuevo, alumnoNuevo tAlumnoNuevo, consultaAlumnoNuevo cNuevo) {
        this.frmNuevo = frmNuevo;
        this.tAlumnoNuevo = tAlumnoNuevo;
        this.cNuevo = cNuevo;
        this.frmNuevo.btnInscribirme.addActionListener(this);
        this.frmNuevo.btnMenu.addActionListener(this);

    }

    public void validar_campos_cedula() {

        if ("".equals(frmNuevo.txtIngreseCi.getText())) {
            JOptionPane.showMessageDialog(null, "El campo no puede esta vacio");
            frmNuevo.txtIngreseCi.requestFocus();
        } else {
            frmNuevo.txtIngreseNom.requestFocus();
        }
    }

    public void validar_campos_Nombre() {

        if ("".equals(frmNuevo.txtIngreseNom.getText())) {
            JOptionPane.showMessageDialog(null, "El campo no puede esta vacio");
            frmNuevo.txtIngreseNom.requestFocus();
        } else {
            frmNuevo.txtIngreseApe.requestFocus();
        }
    }

    public void validar_campos_apellido() {

        if ("".equals(frmNuevo.txtIngreseApe.getText())) {
            JOptionPane.showMessageDialog(null, "El campo no puede esta vacio");
            frmNuevo.txtIngreseApe.requestFocus();
        } else {
            frmNuevo.txtIngreseApe.requestFocus();         }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmNuevo.btnInscribirme) {
            tAlumnoNuevo.setUsu_cedula(frmNuevo.txtIngreseCi.getText());
            tAlumnoNuevo.setUsu_nombre(frmNuevo.txtIngreseNom.getText());
            tAlumnoNuevo.setUsu_apellido(frmNuevo.txtIngreseApe.getText());
            tAlumnoNuevo.setMat_descripcion(frmNuevo.cbox_materias.getSelectedItem().toString());
            tAlumnoNuevo.setProf_nombre(frmNuevo.cbox_profe.getSelectedItem().toString());
            tAlumnoNuevo.setSuc_nombre(frmNuevo.cbox_sucursal.getSelectedItem().toString());

            if (cNuevo.registrar(tAlumnoNuevo)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar");
                limpiar();
            }
        }
        if (e.getSource() == frmNuevo.btnMenu) {
            frmMenu frm = new frmMenu();
            frm.setTitle("Iniciar sesion");
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
            frmNuevo.dispose();
        }
    }

    public void limpiar() {
        frmNuevo.txtIngreseCi.setText(null);
        frmNuevo.txtIngreseNom.setText(null);
        frmNuevo.txtIngreseApe.setText(null);
        frmNuevo.cbox_materias.setSelectedItem(null);
        frmNuevo.cbox_profe.setSelectedItem(null);
        frmNuevo.cbox_sucursal.setSelectedItem(null);
    }

    public void iniciar() {
        frmNuevo.setTitle("Registrarme");
        frmNuevo.setLocationRelativeTo(null);
    }

}
