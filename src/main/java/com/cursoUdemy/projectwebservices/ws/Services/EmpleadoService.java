/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursoUdemy.projectwebservices.ws.Services;

import com.cursoUdemy.projectwebservices.ws.entity.Empleado;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase simulando que tengo un webservice
 * @author David
 */
public class EmpleadoService {
    //todos estos metodos son simulando bases de datos y webservices, en otras clases se integraran 
    public Empleado ConsultarById(int id) {
       List<Empleado> empleados = new ArrayList();
        for (Empleado empleado : empleados) {
            if(empleado.getNumeroEmpleado()==id)
                return empleado;
        }
        
        return null;
    }

    
    public Empleado ConsultarEmpleado(){
        Empleado empleado = new Empleado();
        empleado.setEdad(45);
        empleado.setFechaCreacion(LocalDateTime.now());
        empleado.setNombre("Antonio");
        empleado.setPrimerApellido("Suarez");
        empleado.setSegundoApellido("Garcia");
        empleado.setNumeroEmpleado(1);
        return empleado;
    }

    //metodo para consultar el listado de empleados, esto es para pruebas los set esos
    public List<Empleado> ConsultarEmpleados(){
        List<Empleado> empleados = new ArrayList();
        
        Empleado empleado = new Empleado();
        empleado.setEdad(45);
        empleado.setFechaCreacion(LocalDateTime.now());
        empleado.setNombre("Antonio");
        empleado.setPrimerApellido("Suarez");
        empleado.setSegundoApellido("Garcia");
        empleado.setNumeroEmpleado(1);
        
        Empleado empleadonuevo = new Empleado();
        empleadonuevo.setEdad(35);
        empleadonuevo.setFechaCreacion(LocalDateTime.now());
        empleadonuevo.setNombre("Pepe");
        empleadonuevo.setPrimerApellido("Alvarez");
        empleadonuevo.setSegundoApellido("Pome");
        empleadonuevo.setNumeroEmpleado(2);
        
        empleados.add(empleado);
        empleados.add(empleadonuevo);
        return empleados;
    }
}