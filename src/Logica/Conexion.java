/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;

public class Conexion {

    public DataSource dataSource;
    public String db = "ineatc";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "";

    public Conexion() {
    }
     
     public Connection conectar(){
         Connection link=null;
         
         try {
             Class.forName("org.gjt.mm.mysql.Driver");
             link=DriverManager.getConnection(this.url, this.user, this.pass); 
         } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Error de conexion1: "+ e);
         }
         return link;
     }
            
    
}