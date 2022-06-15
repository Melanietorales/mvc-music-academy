package proControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
import proModelo.alumnoNuevo;
import proModelo.consultaAlumno;
import proVista.frmAlumno;
import proVista.frmMenu;

/**
 *
 * @author Mel
 */
public class ctlAlumno implements ActionListener {

    private final frmAlumno frmA;
    private final alumnoNuevo tAlu;
    private final consultaAlumno cAlu;
    DefaultTableModel modelo = new DefaultTableModel();

    public ctlAlumno(consultaAlumno cAlu, alumnoNuevo tAlu, frmAlumno frmA) {
        this.frmA = frmA;
        this.tAlu = tAlu;
        this.cAlu = cAlu;
        this.frmA.BtnOkAlu.addActionListener(this);
        this.frmA.btnMenu.addActionListener(this);

    }

    public void validar_campos_usuario() {

        if ("".equals(frmA.txtCedulaAlumno.getText())) {
            JOptionPane.showMessageDialog(null, "El campo no puede esta vacio");
            frmA.txtCedulaAlumno.requestFocus();
        } else {
            frmA.BtnOkAlu.requestFocus();
        }
    }

    public void iniciar() {
        frmA.setTitle("Ver mis datos");
        frmA.setLocationRelativeTo(null);
        frmA.txtCedulaAlumno.setVisible(true);
        frmA.txtCedulaAlumno.requestFocus();

    }

    public void limpiar() {
        frmA.txtCedulaAlumno.setText(null);
    }

//    public void llenarTabla(JTable tabla) {
//        modelo = (DefaultTableModel) tabla.getModel();
//        List<alumnoNuevo> lista = cAlu.listAlumnos();
//        Object[] columna = new Object[6];
//        for (int i = 0; i < lista.size(); i++) {
//            columna[0] = lista.get(i).getUsu_cedula();
//            columna[1] = lista.get(i).getUsu_nombre();
//            columna[2] = lista.get(i).getUsu_apellido();
//            columna[3] = lista.get(i).getSuc_nombre();
//            columna[4] = lista.get(i).getProf_nombre();
//            columna[5] = lista.get(i).getMat_descripcion();
//            modelo.addRow(columna);
//        }
//    }
    private void buscar() {
        tAlu.setUsu_cedula(frmA.txtCedulaAlumno.getText());
        if (cAlu.buscar(tAlu)) {
            frmA.txtNombre.setText(tAlu.getUsu_nombre());
            frmA.txtApellido.setText(tAlu.getUsu_apellido());
            frmA.txtSucursal.setText(tAlu.getSuc_nombre());
            frmA.txtProfesor.setText(tAlu.getProf_nombre());
            frmA.txtMateria.setText(tAlu.getMat_descripcion());

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmA.BtnOkAlu) {
            tAlu.setUsu_cedula(frmA.txtCedulaAlumno.getText());
            if (cAlu.buscar(tAlu)) {
                JOptionPane.showMessageDialog(null, "Encontrado");
                buscar();
         
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
            limpiar();
        }
        }
        if (e.getSource() == frmA.btnMenu) {
            frmMenu frm = new frmMenu();
            frm.setTitle("Iniciar sesion");
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
            
        }
    }

}
