/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proModelo;

//import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import conexionMySQL.conexion;
import java.sql.Connection;
import javax.swing.JComboBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proVista.frmAlumnoNuevo;



/**
 *
 * @author Mel
 */
public class consultaAlumnoNuevo extends conexion {
    conexion metoCon = new conexion();
    
public void consulta_materia(JComboBox comboMaterias){
        java.sql.Connection con = null;
        String sql="SELECT * FROM materia";
    try{

        con = metoCon.getConexion();
        
        Statement pst = con.createStatement();
        
        ResultSet result = pst.executeQuery(sql);

        while(result.next()){
            String id, nomMate;
            int id2;
            id2=result.getInt(1);
            id=String.valueOf(id2);
            nomMate=result.getString(2);
            comboMaterias.addItem(nomMate);
            
        }      
        
    }catch(SQLException e){
        System.out.println("Error");
        System.out.println(e.getMessage());
        
    }finally{
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
}

public void consulta_sucursal(JComboBox cbox_sucursal){
    java.sql.Connection con = null;
    String sql="SELECT suc_nombre FROM sucursal";
    try{
        con = metoCon.getConexion();
        
        PreparedStatement pst = con.prepareStatement(sql);
        
        ResultSet result = pst.executeQuery();

        cbox_sucursal.addItem("Seleccione una sucursal");
        while(result.next()){
            cbox_sucursal.addItem(result.getString("suc_nombre"));
        }        
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        
    }finally{
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
}

public void consulta_profesor(JComboBox comboProfe){
        java.sql.Connection con = null;
        String sql="SELECT * FROM profesores";
    try{

        con = metoCon.getConexion();
        
        Statement pst = con.createStatement();
        
        ResultSet result = pst.executeQuery(sql);

        while(result.next()){
            String id, nomMate;
            int id2;
            id2=result.getInt(1);
            id=String.valueOf(id2);
            nomMate=result.getString(2);
            comboProfe.addItem(nomMate);
            
        }      
        
    }catch(SQLException e){
        System.out.println("Error");
        System.out.println(e.getMessage());
        
    }finally{
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
}


public boolean registrar(alumnoNuevo tNuevo) {
        PreparedStatement ps = null;
        con = metoCon.getConexion();
        String sql = "INSERT INTO proyectomel10.alumnos (usu_cedula, usu_nombre, usu_apellido, mat_descripcion, prof_nombre, suc_nombre) VALUES(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tNuevo.getUsu_cedula());
            ps.setString(2, tNuevo.getUsu_nombre());
            ps.setString(3, tNuevo.getUsu_apellido());
            ps.setString(4, tNuevo.getMat_descripcion());
            ps.setString(5, tNuevo.getProf_nombre());
            ps.setString(6, tNuevo.getSuc_nombre());   
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }


}
