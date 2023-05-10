/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Empleado.db;


import java.sql.Connection; //Libreria para conexión 
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */


public class Conexion {
     private static Connection conn = null; 
     private static  String login = "postgres";
     private static  String passw = "STMun#20";
     private static  String url = "jdbc:postgresql://localhost:5433/Usuarios";
     
     public static Connection getConnection(){
         try {
             Class.forName("org.postgresql.Driver");
             conn = DriverManager.getConnection(url, login , passw);
             conn.setAutoCommit(false);
             if (conn != null) {
                System.out.println("Conexion Exitosa");
             }else{
                System.out.println("Conexion Erronea");
             }
         } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null, "Conexion Erronea "+e.getMessage());
         }
         return conn;
     }
     public void disconnect(){
         try {
             conn.close();
         } catch (Exception e) {
             System.out.println("Error al desconectar"+e.getMessage());
         }
     }
     public static void main(String[] args) {
        Conexion conec = new Conexion();
        conec.getConnection();
    }
}
