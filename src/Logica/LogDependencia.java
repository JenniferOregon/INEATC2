/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosDependencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenni
 */
public class LogDependencia {
   private Pool_conexion mysql=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    //MEtodo para insertar
        public boolean insertar(DatosDependencia dts){
        try {
             cn=mysql.dataSource.getConnection();
            sSql="insert into Dependencia(idDependencia,Nombre,Dependencia,Cordinacion_de_zona,Direccion,Telefono)"+
                "values(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            //pst.setInt(1,dts.getidDependencia());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getDependencia());
            pst.setString(4, dts.getCordinacion_de_zona());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getTelefono());
          
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
