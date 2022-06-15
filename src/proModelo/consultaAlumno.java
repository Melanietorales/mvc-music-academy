
package proModelo;

import conexionMySQL.conexion;
//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mel
 */
public class consultaAlumno extends conexion {
    conexion metoCon = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
//    public List listAlumnos(){
//        List<alumnoNuevo>datos=new ArrayList<>();
//        String sql="SELECT * FROM proyectomel10.alumnos";
//        try{
//            con=metoCon.getConexion();
//            ps=con.prepareStatement(sql);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                alumnoNuevo tAlu = new alumnoNuevo();
//                tAlu.setUsu_cedula(rs.getString(1));
//                tAlu.setUsu_nombre(rs.getString(2));
//                tAlu.setUsu_apellido(rs.getString(3));
//                tAlu.setSuc_nombre(rs.getString(4));
//                tAlu.setProf_nombre(rs.getString(5));
//                tAlu.setMat_descripcion(rs.getString(6));
//                datos.add(tAlu);
//            }
//        }catch(Exception e){
//        }
//        return datos;
//        
//    }
    
    public boolean buscar(alumnoNuevo tAlu) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM alumnos WHERE usu_cedula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tAlu.getUsu_cedula());
            
            rs = ps.executeQuery();
            if (rs.next()) {
                tAlu.setUsu_cedula(rs.getString("usu_cedula"));
                tAlu.setUsu_nombre(rs.getString("usu_nombre"));
                tAlu.setUsu_apellido(rs.getString("usu_apellido"));
                tAlu.setSuc_nombre(rs.getString("suc_nombre"));
                tAlu.setProf_nombre(rs.getString("prof_nombre"));
                tAlu.setMat_descripcion(rs.getString("mat_descripcion"));
                return true;
            }
            return false;
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
