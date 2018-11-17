/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso.AbstracInterface;
import sv.edu.uesocc.ingenieria.prn335_2018.datos.acceso.TipoEstadoReservaFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author StevenCastro
 */
@Named(value = "tipoEstadoReservaBean")
@ViewScoped
public class TipoEstadoReservaBean extends AbstractManagedBean<TipoEstadoReserva> implements Serializable{

    @EJB 
    TipoEstadoReservaFacade terf;
    TipoEstadoReserva ter = new TipoEstadoReserva();
    boolean activo=false, panel=true;
    
    public TipoEstadoReservaBean() {
    }
    
   /**
     * Este metodo carga la lista inicial de datos a la DataTable al ingresar a
     * la aplicacion
     */
    @PostConstruct
    public void init() {
        super.AbstractManagedBean();
        llenarLista();
        System.out.println("POSTCONSTRUCT");
    }

    /**
     * Invoca al metodo create de la clase AbstractFacade y crea un registro en
     * la DB
     */
    @Override
    public void crear() {
        super.AbstractManagedBean();
        super.crear();
        cancelar();
    }

    /**
     * Elimina registros de la DB utilizando el metodo remove de la clase
     * AbstractFacade
     */
    @Override
    public void eliminar() {
        super.AbstractManagedBean();
        super.eliminar();
        cancelar();
    }

    /**
     * Invoca al metodo edit de la clase AbstractFacade para editar un registro
     */
    @Override
    public void editar() {
        super.AbstractManagedBean();
        super.editar();
        cancelar();
    }

    /**
     * Si el objeto Tipo Estado Reserva es diferente de nulo asigna una nueva instancia a este
     * para dejarlo vacio, oculta el panel de botones de edicion
     */
    public void cancelar() {
        ter = new TipoEstadoReserva();
        System.out.println("LIMPIAR");
        panel = true;
        activo=false;
    }
    

    /**
     * Recice un evente de tipo SelectEvent, asigna los valores del objeto
     * recibido a las propiedades del objeto rol
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        ter = (TipoEstadoReserva) event.getObject();
        panel=false;
        activo=true;
    } 

public TipoEstadoReserva getEstadoReserva() {
        return ter;
    }

    public void setRol(TipoEstadoReserva ter) {
        this.ter = ter;
    }

    public  TipoEstadoReservaFacade getEstadoReservaFacade() {
        return terf;
    }

    public void setTipoEstadoReservaFacade(TipoEstadoReservaFacade terf) {
        this.terf = terf;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isPanel() {
        return panel;
    }

    public void setPanel(boolean panel) {
        this.panel = panel;
    }

    public List<TipoEstadoReserva> getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List<TipoEstadoReserva> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }
    
    /**
     * Metodo que obtiene el facade Local de Tipo Estado Reserva
     * @return Devuelve una instancia de Tipo Estado Reserva Facade
     */
    
    @Override
    protected AbstracInterface<TipoEstadoReserva> getFacadeLocal() {
       return (AbstracInterface<TipoEstadoReserva>) terf;
    }

    /**
     * Metodo que obtiene la Entity Tipo Estado Reserva 
     * @return Retorna una instancia de la entity Tipo Estado Reserva
     */
    @Override
    protected TipoEstadoReserva getEntity() {
    return ter;
    }
}