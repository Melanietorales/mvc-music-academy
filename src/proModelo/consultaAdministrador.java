/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proModelo;

import conexionMySQL.conexion;
//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mel
 */
public class consultaAdministrador extends conexion {
    conexion metoCon = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listAlumnos(){
        List<administrador>datos=new ArrayList<>();
        String sql="SELECT * FROM proyectomel10.alumnos";
//        administrador tAdmin;
        try{
            con=metoCon.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                administrador tAdmin = new administrador();
                tAdmin.setUsu_cedula(rs.getString(1));
                tAdmin.setUsu_nombre(rs.getString(2));
                tAdmin.setUsu_apellido(rs.getString(3));
                tAdmin.setSuc_nombre(rs.getString(4));
                tAdmin.setProf_nombre(rs.getString(5));
                tAdmin.setMat_descripcion(rs.getString(6));
                datos.add(tAdmin);
            }
        }catch(Exception e){
        }
        return datos;
        
    }
    public int actualizar(administrador tAdmi){
        int r=0;
        String sql="UPDATE alumnos set usu_nombre=?, usu_apellido=?, suc_nombre=?, prof_nombre=?, mat_descripcion=? where usu_cedula=?";
        try{
            con=metoCon.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,tAdmi.getUsu_nombre());
            ps.setString(2,tAdmi.getUsu_apellido());
            ps.setString(3,tAdmi.getSuc_nombre());
            ps.setString(4,tAdmi.getProf_nombre());
            ps.setString(5,tAdmi.getMat_descripcion());
            ps.setString(6,tAdmi.getUsu_cedula());
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
            
        }
        return r;
    }
    
    public void eliminar(int usu_cedula){
        String sql="Delete from alumnos where usu_cedula="+usu_cedula;
        try{
            con=metoCon.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
}  

