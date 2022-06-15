/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class consultaLogin extends conexion {
    public boolean buscar(login tlogin) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM alumnos WHERE usu_cedula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tlogin.getUsu_cedula());
            
            rs = ps.executeQuery();
            if (rs.next()) {
                tlogin.setUsu_cedula(rs.getString("usu_cedula"));
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
