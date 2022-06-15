package proControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proModelo.administrador;
import proModelo.consultaAdministrador;
import proVista.frmAdministrador;
import proVista.frmMenu;

/**
 *
 * @author Mel
 */
public class ctlAdministrador implements ActionListener {

    frmAdministrador frmAdmi = new frmAdministrador();
    administrador tAdmi = new administrador();
    consultaAdministrador cAdmi = new consultaAdministrador();
    DefaultTableModel modelo = new DefaultTableModel();

    public ctlAdministrador(frmAdministrador frmAdmi) {
        this.frmAdmi = frmAdmi;
        this.frmAdmi.btnListar.addActionListener(this);
        this.frmAdmi.btnEditar.addActionListener(this);
        this.frmAdmi.btnOk.addActionListener(this);
        this.frmAdmi.btnEliminar.addActionListener(this);
        this.frmAdmi.btnMenu.addActionListener(this);
        
    }


    public void llenarTabla(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<administrador> lista = cAdmi.listAlumnos();
        Object[] columna = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            columna[0] = lista.get(i).getUsu_cedula();
            columna[1] = lista.get(i).getUsu_nombre();
            columna[2] = lista.get(i).getUsu_apellido();
            columna[3] = lista.get(i).getSuc_nombre();
            columna[4] = lista.get(i).getProf_nombre();
            columna[5] = lista.get(i).getMat_descripcion();
            modelo.addRow(columna);
        }
    }

    public void actualizar() {
        String ci = frmAdmi.txtCedula.getText();
        String nom = frmAdmi.txtNombre.getText();
        String ape = frmAdmi.txtApellido.getText();
        String suc = frmAdmi.txtSucursal.getText();
        String prof = frmAdmi.txtProfesor.getText();
        String mat = frmAdmi.txtMateria.getText();
        tAdmi.setUsu_cedula(ci);
        tAdmi.setUsu_nombre(nom);
        tAdmi.setUsu_apellido(ape);
        tAdmi.setSuc_nombre(suc);
        tAdmi.setProf_nombre(prof);
        tAdmi.setMat_descripcion(mat);
        int r = cAdmi.actualizar(tAdmi);
        if (r == 1) {
            JOptionPane.showMessageDialog(frmAdmi, "Datos del alumno actualizados");
        } else {
            JOptionPane.showMessageDialog(frmAdmi, "Error al actualizar datos");

        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < frmAdmi.tablaAlumnos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void eliminar() {
        int fila = frmAdmi.tablaAlumnos.getSelectedRow();
        int usu_cedula = Integer.parseInt((String) frmAdmi.tablaAlumnos.getValueAt(fila, 0).toString());
        if (fila == -1) {
            JOptionPane.showMessageDialog(frmAdmi, "Debe seleccionar una fila");
        } else {
            cAdmi.eliminar(usu_cedula);
            JOptionPane.showMessageDialog(frmAdmi, "Alumno eliminado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmAdmi.btnListar) {
            limpiarTabla();
            llenarTabla(frmAdmi.tablaAlumnos);

        }
        if (e.getSource() == frmAdmi.btnEditar) {
            int fila = frmAdmi.tablaAlumnos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(frmAdmi, "Debe seleccionar una fila");
            } else {
                String ci = (String) frmAdmi.tablaAlumnos.getValueAt(fila, 0);
                String nom = (String) frmAdmi.tablaAlumnos.getValueAt(fila, 1);
                String ape = (String) frmAdmi.tablaAlumnos.getValueAt(fila, 2);
                String sucu = (String) frmAdmi.tablaAlumnos.getValueAt(fila, 3);
                String prof = (String) frmAdmi.tablaAlumnos.getValueAt(fila, 4);
                String mat = (String) frmAdmi.tablaAlumnos.getValueAt(fila, 5);
                frmAdmi.txtCedula.setText(ci);
                frmAdmi.txtNombre.setText(nom);
                frmAdmi.txtApellido.setText(ape);
                frmAdmi.txtSucursal.setText(sucu);
                frmAdmi.txtProfesor.setText(prof);
                frmAdmi.txtMateria.setText(mat);

            }
        }
        if (e.getSource() == frmAdmi.btnOk) {
            actualizar();
            limpiarTabla();
            llenarTabla(frmAdmi.tablaAlumnos);
        }

        if (e.getSource() == frmAdmi.btnEliminar) {
            eliminar();
            limpiarTabla();
            llenarTabla(frmAdmi.tablaAlumnos);
        }
        if (e.getSource()==frmAdmi.btnMenu){
            frmMenu frm = new frmMenu();
            frm.setTitle("Menu principal");
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
            frmAdmi.dispose();
        }
        }

    }

