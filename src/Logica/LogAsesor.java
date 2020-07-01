/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosAsesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jenni
 */
public class LogAsesor {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
   
    public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"RFC","Nombre","Apellidos","Domicilio","Telefono","Correo",};
    String [] registro = new String [6];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from ASESOR where nombre like'%"+buscar+"%' order by nombre";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("RFCE");
            registro [1]=rs.getString("Nombre");
            registro [2]=rs.getString("Apellido");
            registro [3]=rs.getString("Direccion");
            registro [4]=rs.getString("Telefono");
            registro [5]=rs.getString("Correo"); 
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
         }
         rs.close();
         st.close();
         return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar usuario: "+e);
            return null;
        }finally{
        try {
            
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    //MEtodo para insertar
        public boolean insertar(DatosAsesor dts){
        try {
            cn=metodospool.dataSource.getConnection();
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
           public boolean editar(DatosAsesor dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update Asesor set  nombre=?, apellido=?,domicilio=?, telefono=?,correo=? "+
                   "where RFC=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(4, dts.getDomicilio());
            pst.setString(3, dts.getTelefono());
            pst.setString(5, dts.getCorreo());
            pst.setString(6, dts.getRFC());
           
            int n=pst.executeUpdate();
            pst.close();
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
               public boolean eliminar(DatosAsesor dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from asesor where FFC=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1,dts.getRFC());
            int n=pst.executeUpdate();
            pst.close();
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
