/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Empleado.entity.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class EmpleadoDAO {
    private String mensaje = "";
    
    public String agregarEmpleado(Connection con, Empleado emp){
        PreparedStatement pst = null; 
        String sql = "INSERT INTO usuario (cedula, nombre, correo, contrasena) "
                + "VALUES(?,?,?,?); ";
        
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            pst.setInt(1,emp.getCedula());
            pst.setString(2, emp.getNombre());
            pst.setString(3, emp.getCorreo());
            pst.setString(4, emp.getContrasena());
            
            System.out.println(pst.toString());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            con.commit();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE \n "+e.getMessage();
        }
        return mensaje;
    }
     public String actualizarEmpleado(Connection con, Empleado emp){
        PreparedStatement pst = null; 
        String sql = "UPDATE usuario SET  nombre = ?, correo = ?, contrasena = ?  WHERE cedula = ?";
                
        
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getNombre());
            pst.setString(2, emp.getCorreo());
            pst.setString(3, emp.getContrasena());
            
            pst.setInt(4, emp.getCedula());
            
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            con.commit();
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO ACTUALIZAR CORRECTAMENTE \n "+e.getMessage();
        }
        return mensaje;
    }
      public String eliminarEmpleado(Connection con, int cedula){
          
        PreparedStatement pst = null; 
        String sql = "DELETE FROM  usuario  WHERE cedula = ?";
                
        
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            pst.setInt(1, cedula);
            
          
            mensaje = "ELIMINADO CORRECTAMENTE";
            
            pst.execute();
            con.commit();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "NO SE PUDO ELIMINAR CORRECTAMENTE \n "+e.getMessage();
        }
        return mensaje;
    }
       public void mostrarEmpleado(Connection con, JTable tabla){
           DefaultTableModel model;
           String[] columnas = {"Cedula", "Nombre", "Correo", "Contrasena"};
           model = new DefaultTableModel(null, columnas);
           
           String sql = "SELECT * FROM usuario";
           
           String[] filas = new String[4];
           Statement st = null; //ejecutar query
           ResultSet rs = null; //obtener resultados
           
           try {
               st = con.createStatement();
               rs = st.executeQuery(sql);
               while (rs.next()) {
                   for (int i= 0; i<4; i++ ) {
                        filas[i] = rs.getString(i+1);
                   }
                   model.addRow(filas);
               }
               tabla.setModel(model);
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,"No se puede listar tabla");
           }
           
           
    }
    
}
