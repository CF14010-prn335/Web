/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author StevenCastro
 */
@Local
public interface TipoEstadoReservaFacadeLocal extends AbstracInterface<TipoEstadoReserva> {

    public List<TipoEstadoReserva> findByFiltro(String select_ternombre_FROM_TipoEstadoReserva_t);
    
}
