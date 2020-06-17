/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenni
 */
public class LogUsuario {
   private Conexion mysql=new Conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    //MEtodo para insertar
        public boolean insertar(DatosUsuario dts){
        try {
            Connection cn=mysql.conectar();
            sSql="insert into usuario(Nombre,Apellido,Telefono,Correo,nick, Contrasena,Rol)"+
                "values(?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
           // pst.setInt(1,dts.getIdusuario());
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTelefono());
            pst.setString(4, dts.getCorreo());
            pst.setString(5, dts.getNick());
            pst.setString(6, dts.getContrasena());
            pst.setString(7, dts.getRol());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
}
