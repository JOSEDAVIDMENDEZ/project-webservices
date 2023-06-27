/**
 * 
 */
package com.cursoUdemy.projectwebservices.ws;

import com.cursoUdemy.projectwebservices.ws.Services.EmpleadoService;
import com.cursoUdemy.projectwebservices.ws.entity.Empleado;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * @author David
 * Web service generado con Jersey
 */

/*bajo que nombre accederiamos a este web service, quiere decir que para
el navegador llegar a este webservice tiene que excribir
http://localhost:8080/proyect-webservices/devpredator/empleadoWS/test
*/
@Path("empleadoWS")
public class EmpleadoWS {
	
    private EmpleadoService empleadoService = new EmpleadoService();
        
        @GET//pinta en pantalla el string de test, obtiene algo del servidor
        @Path("test")
	public String test() {
            return "Haciendo prueba con rest services";
	}
	
        @GET
        @Path("consultarEmpleado")
        @Produces(MediaType.APPLICATION_JSON)//por defecto se devuelve siempre un text html por lo que hay que poner esto para devolver json
	@Consumes(MediaType.APPLICATION_JSON)//por si quiero consumir el webservice desde otra aplicacion
        public Empleado ConsultarEmpleado() {
            return this.empleadoService.ConsultarEmpleado();
        }
        
        @GET
        @Path("consultarEmpleados")
        @Produces(MediaType.APPLICATION_JSON)//por defecto se devuelve siempre un text html por lo que hay que poner esto para devolver json
	@Consumes(MediaType.APPLICATION_JSON)//por si quiero consumir el webservice desde otra aplicacion
        public List<Empleado> ConsultarEmpleados() {
            return this.empleadoService.ConsultarEmpleados();
        }
        
        //@PathParam("numEmp") para pasar parametros, el navegador tiene que saber que parametros se deben utilizar, /{numEmp} hay que ponerlos en el path
        @GET
        @Path("consultarEmpleadosPorID/{numEmp}")//cuando busque el path hay que ponerle el numero de empleado (http:...../18)
        @Produces(MediaType.APPLICATION_JSON)//por defecto se devuelve siempre un text html por lo que hay que poner esto para devolver json
	@Consumes(MediaType.APPLICATION_JSON)//por si quiero consumir el webservice desde otra aplicacion
        public Response ConsultarEmpleadosID(@PathParam("numEmp") int id) {//objeto Response que es la respuesta del servidor
            if(id<=0){
               return Response.noContent().build();
            }
            
            Empleado empleadoConsultado = this.empleadoService.ConsultarById(id);
            
            if(empleadoConsultado==null){
                return Response.noContent().build();
            }
            GenericEntity <Empleado> empleadoGeneric = new GenericEntity(empleadoConsultado, Empleado.class);
            return Response.ok().entity(empleadoGeneric).build();
        }
        
        @POST
        @Path("guardarEmpleado")//cuando busque el path hay que ponerle el numero de empleado (http:...../18)
        @Produces(MediaType.APPLICATION_JSON)//por defecto se devuelve siempre un text html por lo que hay que poner esto para devolver json
	@Consumes(MediaType.APPLICATION_JSON)//por si quiero consumir el webservice desde otra aplicacion
        public Response GuardarEmpleado(Empleado emp) {//objeto Response que es la respuesta del servidor
                       
            if(emp==null){
                return Response.status(400).entity("No se ingreso info del empleado").build();//.build construye la respuesta
            }
            if(emp.getNombre()== null || emp.getNombre().isEmpty()){
                return Response.status(400).entity("Escriba el nombre").build();//.build construye la respuesta
            }
            
            GenericEntity <Empleado> empleadoGeneric = new GenericEntity(emp, Empleado.class);
            return Response.ok().entity(empleadoGeneric).build();
        }
        
}
