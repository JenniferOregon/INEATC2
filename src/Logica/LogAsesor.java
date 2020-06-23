/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosAsesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenni
 */
public class LogAsesor {
   private Conexion mysql=new Conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    //MEtodo para insertar
        public boolean insertar(DatosAsesor dts){
        try {
            Connection cn=mysql.conectar();
            sSql="insert into Asesor(RFC,Nombre,Apellido,Domicilio,Telefono,Correo)"+
                "values(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1,dts.getRFC());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellido());
            pst.setString(4, dts.getDomicilio());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getCorreo());
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
