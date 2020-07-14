/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosDetalleEntrada;
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
public class LogDetalleEntrada {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
       public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"idDetalle_Entrada","idLibro","Cantidad","idEntrada"};
    String [] registro = new String [4];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from detalle_entrada where idEntrada like'%"+buscar+"%' order by idDetalle_Entrada";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idDetalle_Entrada");
            registro [1]=rs.getString("idLibro");
            registro [2]=rs.getString("Cantidad"); 
            registro [3]=rs.getString("idEntrada"); 
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
         }
         rs.close();
         st.close();
         return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar Detalle entrada: "+e);
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
    
    
        public boolean insertar(DatosDetalleEntrada dts){
        try {
             cn=metodospool.dataSource.getConnection();
            sSql="insert into detalle_entrada(idDetalleEntrada,idLibro,cantidad,idEntrada)"+
                "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
             pst.setInt(1, dts.getIdDetalle_Entrada());
             pst.setString(2, dts.getIdLibro());
             pst.setInt(3,dts.getCantidad());
             pst.setInt(4, dts.getIdEntrada());
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
        
         public boolean editar(DatosDetalleEntrada dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update detalle_entrada set  idLibro=?, Cantidad=?, idEntrada=? "+
                   "where idDetalle_Entrada=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            
            pst.setString(1, dts.getIdLibro());
            pst.setInt(2, dts.getCantidad());
            pst.setInt(3, dts.getIdEntrada());
            pst.setInt(4, dts.getIdDetalle_Entrada());
           
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
         
        
      public boolean eliminar(DatosDetalleEntrada dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from detalle_entrada where idDetalleEntrada=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdDetalle_Entrada());
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
