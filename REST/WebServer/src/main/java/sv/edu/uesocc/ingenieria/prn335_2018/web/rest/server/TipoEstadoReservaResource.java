/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.web.rest.server;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso.TipoEstadoReservaFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author StevenCastro
 */


@Path("tipoEstadoReserva") //Nombre del Path para identificar el recurso
public class TipoEstadoReservaResource implements Serializable{
 
    /**
     * Punto de inyeccion de EJB
     */
   @EJB
   private TipoEstadoReservaFacadeLocal terf;
  
    /**
     * Metodo que busca en un rango determinado
     * @param first Recibe el primer parametro desde
     * @param pageSize Recibe el ultimo parametro hasta
     * @return Retorna los resultados entre los datos dados
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List <TipoEstadoReserva> findRange(
            @QueryParam ("desde") @DefaultValue("0") int first,
            @QueryParam("cantidad") @DefaultValue("10") int pageSize){
        if(terf!=null){
            return terf.findRange(first, pageSize);
        }
        return Collections.EMPTY_LIST;   
    }
     
    /**
     * Metodo para buscar todos los datos de la entidad 
     * @return Retorna todos los datos.
     */
    @GET
    @Path("/All")
    @Produces({MediaType.APPLICATION_JSON})
    public List <TipoEstadoReserva> findAll(){
      try {
            if (terf != null) {
                return terf.findAll( );
            } 
        } catch (Exception e) {
             Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Collections.EMPTY_LIST;
    }
   
    /**
     * Metodo que cuenta la cantidad existentes de datos en la entity
     * @return Retorna el numero de datos
     */
    @GET
    @Path("/count")
    @Produces({MediaType.TEXT_PLAIN})
    public int count() {
    return terf.count();
    }
    
   /**
    * Metodo que buscar por Id
    * @param idTipoEstadoReserva
    * @return Retorna la busqueda obtenida por el id
    */
  @GET 
  @Path("{idTipoEstadoReserva}") 
  @Produces(MediaType.APPLICATION_JSON) 
  public TipoEstadoReserva find(
  @PathParam("idTipoEstadoReserva") Integer idTipoEstadoReserva) { 
      if (idTipoEstadoReserva != null) { 
          try { 
              return (TipoEstadoReserva) terf.find(idTipoEstadoReserva); 
          } catch (Exception e) { 
              System.out.println("Error: " + e.getMessage() + " : " 
                      + terf + " : " + idTipoEstadoReserva); 
          } 
      } 
      return new TipoEstadoReserva(); 
  }
  
     /**
     * Metodo para buscar coincidencias en el nombre de las entities
     * @param query
     * @return Retorna los resultados obtenidos como coincidencias
     */
    @GET
    @Path("{like}/{query}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoEstadoReserva> findLike(@PathParam("query") String query){
        if(terf != null){
            return terf.findLike(query);
        }
    return Collections.EMPTY_LIST;
    }
}