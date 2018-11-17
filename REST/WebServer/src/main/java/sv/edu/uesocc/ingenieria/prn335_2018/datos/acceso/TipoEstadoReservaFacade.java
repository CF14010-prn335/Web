/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso;

import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author StevenCastro
 */
@Stateless
public class TipoEstadoReservaFacade extends AbstractFacade<TipoEstadoReserva> implements TipoEstadoReservaFacadeLocal {

  /**
 * Persistence Context y definicion de el Entity Manager 
 * que se heredara al Abstract Facade
 */
@PersistenceContext(unitName="flota_unit")
private EntityManager em; 
 
@Override
   /**
    * Sobreescribimos el metodo del entity manager 
    * para que sea heredado en cualquier parte
    * @return em un entity manager
    */
    protected EntityManager getEntityManager() {
        return em;
    }
/**
 * Metodo para heredar de la clase TipoEstadoReserva
 */    
   public TipoEstadoReservaFacade() {
        super (TipoEstadoReserva.class);
    }

    public List<TipoEstadoReserva> findByFiltro(String select_ternombre_FROM_TipoEstadoReserva_t) {
       
    return (List<TipoEstadoReserva>) Collections.EMPTY_SET;
  }
}
