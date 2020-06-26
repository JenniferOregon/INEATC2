/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosLibro;
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
public class LogLibro {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
       public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"Clave","Nombre","Unidades"};
    String [] registro = new String [3];
    
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
            registro [0]=rs.getString("Clave");
            registro [1]=rs.getString("Nombre");
            registro [2]=rs.getString("Unidades"); 
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
    
    
        public boolean insertar(DatosLibro dts){
        try {
             cn=metodospool.dataSource.getConnection();
            sSql="insert into Libro(Clave,Nombre,Unidades)"+
                "values(?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
             pst.setString(1, dts.getClave());
             pst.setString(2, dts.getNombre());
             pst.setInt(3,dts.getUnidades());
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
