/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosDependencia;
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
public class LogDependencia {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar) throws SQLException{
        DefaultTableModel modelo;
        
         String [] titulos = {"ID","Nombre","Departamento","Cordinacion_de_zona","Direccion","Telefono"};
    String [] registro = new String [6];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from DEPENDENCIA where nombre like'%"+buscar+"%' order by nombre";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idDependencia");
            registro [1]=rs.getString("Nombre");
            registro [2]=rs.getString("Departamento");
            registro [3]=rs.getString("Cordinacion_de_zona");
            registro [4]=rs.getString("Direccion");
            registro [5]=rs.getString("Telefono");
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
         }
         rs.close();
         st.close();
         return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar dependencia: "+e);
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
        public boolean insertar(DatosDependencia dts){
        try {
             cn=metodospool.dataSource.getConnection();
            sSql="insert into Dependencia(idDependencia,Nombre,Departamento,Cordinacion_de_zona,Direccion,Telefono)"+
                "values(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdDependencia());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getDepartamento());
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
           public boolean editar(DatosDependencia dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update Dependencia set  Nombre=?, Departamento=?, Cordinacion_de_zona=?,Direccion=?,Telefono=?"+
                   "where idDependencia=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDepartamento());
            pst.setString(3, dts.getCordinacion_de_zona());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getTelefono());
            pst.setInt(6,dts.getIdDependencia());
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
    public boolean eliminar(DatosDependencia dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from dependencia where idDependencia=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdDependencia());
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
