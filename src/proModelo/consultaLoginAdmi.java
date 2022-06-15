
package proModelo;

import conexionMySQL.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Mel
 */
public class consultaLoginAdmi extends conexion{
        public boolean buscar(loginAdmi tLogAdmi) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM administrador WHERE admin_codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tLogAdmi.getAdmin_codigo());
            
            rs = ps.executeQuery();
            if (rs.next()) {
                tLogAdmi.setAdmin_codigo(rs.getString("admin_codigo"));
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
