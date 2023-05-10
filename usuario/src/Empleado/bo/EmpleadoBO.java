/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado.bo;

import Empleado.dao.EmpleadoDAO;
import Empleado.db.Conexion;
import java.sql.Connection;
import Empleado.entity.Empleado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Santiago
 */
public class EmpleadoBO {
    private String mensaje = "";
    private EmpleadoDAO edao = new EmpleadoDAO();
    
     public String agregarEmpleado( Empleado emp){
         Connection conn =  Conexion.getConnection();
         try {
             mensaje = edao.agregarEmpleado(conn, emp);
         } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
         }finally{
             try {
                 if (conn != null){
                     conn.close();
                 }
             } catch (Exception e) {
                  mensaje = mensaje + " " + e.getMessage();
             }
         }
        return mensaje;
    }
     public String actualizarEmpleado( Empleado emp){
        Connection conn =  Conexion.getConnection();
         try {
             mensaje = edao.actualizarEmpleado(conn, emp);
         } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
         }finally{
             try {
                 if (conn != null){
                     conn.close();
                 }
             } catch (Exception e) {
                  mensaje = mensaje + " " + e.getMessage();
             }
         }
        return mensaje;
    }
      public String eliminarEmpleado( int cedula){
         Connection conn =  Conexion.getConnection();
         try {
             mensaje = edao.eliminarEmpleado(conn, cedula);
         } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
         }finally{
             try {
                 if (conn != null){
                     conn.close();
                 }
             } catch (Exception e) {
                  mensaje = mensaje + " " + e.getMessage();
             }
         }
        return mensaje;
    }
       public void mostrarEmpleado(JTable tabla){
        Connection conn =  Conexion.getConnection();  
        edao.mostrarEmpleado(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
