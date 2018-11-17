/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.web.rest.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author StevenCastro
 */
@Named(value = "tipoEstadoReservaCliente")
@ViewScoped
public class TipoEstadoReservaCliente implements Serializable{


private WebTarget target;
    private Client cliente;
    private  List<TipoEstadoReserva>  salida;
    private String TipoEstadoReservaMatch;    
    
    public TipoEstadoReservaCliente() {
         try {
           cliente=ClientBuilder.newClient( );
          target = cliente.target("http://localhost:8080/WebServer-1.0-SNAPSHOT/webresources/TipoEstadoReserva");
        } catch (Exception e) {
             Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public List findLike(){
         List<TipoEstadoReserva> out=null, temp= new ArrayList();

         try {
            out = target.request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<TipoEstadoReserva>>(){});
             for (TipoEstadoReserva tipoEstadoReserva : out) {
                 if (tipoEstadoReserva.getNombre().matches("(.*)"+TipoEstadoReservaMatch+"(.*)")) {
                    temp.add(tipoEstadoReserva);
                     System.out.println(temp.get(0).getNombre());
              } 
          }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }finally{
             if (temp.isEmpty()) {
                 temp= Collections.EMPTY_LIST;
                 System.out.println("   hola");
            }
        }
        salida=temp;
        return salida;
    }
  
    @PostConstruct
    public void init (){
        salida = findLike();
    }

    public List<TipoEstadoReserva> getSalida() {
        return salida;
    }

    public void setSalida(List<TipoEstadoReserva> salida) {
        this.salida = salida;
    }

    public String getTipoEstadoReservaMatch() {
        return TipoEstadoReservaMatch;
    }

    public void setTipoEstadoReservaMatch(String TipoEstadoReservaMatch) {
        this.TipoEstadoReservaMatch = TipoEstadoReservaMatch;
    }
}