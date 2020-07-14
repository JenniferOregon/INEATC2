/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosUsuario;
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
public class LogUsuario {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
         public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre","Apellido","Telefono 1","Correo","Nick", "Contrasena","Rol"};
    String [] registro = new String [8];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from USUARIO where nombre like'%"+buscar+"%' order by nombre";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idusuario");
            registro [1]=rs.getString("Nombre");
            registro [2]=rs.getString("Apellido");
            registro [3]=rs.getString("Telefono");
            registro [4]=rs.getString("Correo");
            registro [5]=rs.getString("nick");
            registro [6]=rs.getString("Contrasena");
           registro [7]=rs.getString("Rol"); 
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
        public boolean insertar(DatosUsuario dts){
        try {
            cn = metodospool.dataSource.getConnection();
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
            JOptionPane.showConfirmDialog(null, e.getLocalizedMessage()+"   "+e.getMessage());
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        
          //----------------------------------   
   //----EDITAR USUARIO-----------------
   //----------------------------------
   public boolean editar(DatosUsuario dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update usuario set  nombre=?, apellido=?, telefono=?,correo=?,nick=?,contrasena=?,rol=? "+
                   "where idusuario=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getTelefono());
            pst.setString(4, dts.getCorreo());
            pst.setString(5, dts.getNick());
            pst.setString(6, dts.getContrasena());
            pst.setString(7, dts.getRol());
            pst.setInt(8, dts.getIdusuario());
           
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
   
    //----------------------------------   
   //----ELIMINAR USUARIO-----------------
   //----------------------------------
    public boolean eliminar(DatosUsuario dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from usuario where idusuario=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdusuario());
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
