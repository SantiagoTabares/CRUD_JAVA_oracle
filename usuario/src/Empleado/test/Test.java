/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado.test;

import Empleado.bo.EmpleadoBO;
import Empleado.entity.Empleado;

/**
 *
 * @author Santiago
 */
public class Test {
    EmpleadoBO ebo = new EmpleadoBO();
    Empleado emp = new Empleado();
    String mensaje = " ";
    
    public void insertar(){
       emp.setNombre("JULIAN");
       emp.setCedula(10543554);
       emp.setCorreo("tabares@gmail.com");
       emp.setContrasena("123456");
       mensaje = ebo.agregarEmpleado(emp);
       System.out.println(mensaje);
    }
    
    public void modificar(){
       emp.setNombre("VALENTINA");
       emp.setCedula(10543554);
       emp.setCorreo("Vtabares@gmail.com");
       emp.setContrasena("123456");
       mensaje = ebo.actualizarEmpleado(emp);
       System.out.println(mensaje);
    }
    
    public void eliminar(){
       mensaje = ebo.eliminarEmpleado(10543554);
       System.out.println(mensaje);
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        test.insertar();
        //test.eliminar();
        //test.modificar();
    }
}

