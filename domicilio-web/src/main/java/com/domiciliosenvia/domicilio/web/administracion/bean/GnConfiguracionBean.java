/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.administracion.bean;

import com.domiciliosenvia.domicilio.dominio.administracion.GnConfiguracionObj;
import com.domiciliosenvia.domicilio.dominio.administracion.Modulo;
import com.domiciliosenvia.domicilio.web.administracion.servicio.GnConfiguracionServicioIface;
import com.domiciliosenvia.domicilio.web.utilidades.CompatibilidadPF;
import com.domiciliosenvia.domicilio.web.utilidades.PropApl;
import com.domiciliosenvia.domicilio.web.utilidades.Url;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Jaime Andres Olarte
 */
@ManagedBean
@ViewScoped
public class GnConfiguracionBean extends Url {

    private GnConfiguracionServicioIface gnConfiguracionServicio;
    private GnConfiguracionObj objeto;
    private List<GnConfiguracionObj> registros;
    private LazyDataModel<GnConfiguracionObj> lazyGnConfiguracion;

    public GnConfiguracionBean() {
        this.objeto = new GnConfiguracionObj();
        Modulo mod = super.validarModulo(Modulo.ID_GN_CONFIGURACION);
        if (mod == null) {
            super.redireccionar("/domicilio/home.faces");
        } else {
            super.setModulo(mod);

            lazyGnConfiguracion = new LazyDataModel<GnConfiguracionObj>() {
                private List<GnConfiguracionObj> gnConfiguraciones;

                @Override
                public List<GnConfiguracionObj> load(int primerRegistro, int registrosPagina, String orden, SortOrder formaOrden, Map<String, FilterMeta> filtros) {
                    getParamConsulta().setPrimerRegistro(primerRegistro);
                    getParamConsulta().setRegistrosPagina(registrosPagina);
                    getParamConsulta().setOrden(orden);
                    getParamConsulta().setAscendente(SortOrder.ASCENDING.equals(formaOrden));
                    getParamConsulta().setFiltros(CompatibilidadPF.ConvertirFiltroMetaToHash(filtros));
                    refrescar();
                    gnConfiguraciones = getRegistros();
                    setRowCount(getParamConsulta().getCantidadRegistros());
                    return gnConfiguraciones;
                }

                @Override
                public Object getRowKey(GnConfiguracionObj configuracionObj) {
                    return configuracionObj.getId();
                }

                @Override
                public GnConfiguracionObj getRowData(String portabilidadId) {
                    Integer id = Integer.valueOf(portabilidadId);
                    for (GnConfiguracionObj portabilidad : gnConfiguraciones) {
                        if (id.equals(portabilidad.getId())) {
                            return portabilidad;
                        }
                    }
                    return null;
                }
            };
        }
    }

    public GnConfiguracionServicioIface getGnConfiguracionServicio() {
        return gnConfiguracionServicio;
    }

    public void setGnConfiguracionServicio(GnConfiguracionServicioIface gnConfiguracionServicio) {
        this.gnConfiguracionServicio = gnConfiguracionServicio;
    }

    public GnConfiguracionObj getObjeto() {
        return objeto;
    }

    public void setObjeto(GnConfiguracionObj objeto) {
        this.objeto = objeto;
    }

    public LazyDataModel<GnConfiguracionObj> getLazyGnConfiguracion() {
        return lazyGnConfiguracion;
    }

    public void setLazyGnConfiguracion(LazyDataModel<GnConfiguracionObj> lazyGnConfiguracion) {
        this.lazyGnConfiguracion = lazyGnConfiguracion;
    }

    public List<GnConfiguracionObj> getRegistros() {
        return registros;
    }

    public void setRegistros(List<GnConfiguracionObj> registros) {
        this.registros = registros;
    }

    public void refrescar() {
        super.setAccion(Url.ACCION_LISTAR);
        getGnConfiguracionServicio().Accion(this);
    }

    public void modificarConfiguracion(RowEditEvent event) {
        setObjeto((GnConfiguracionObj) event.getObject());
        super.setAccion(ACCION_EDITAR);
        getGnConfiguracionServicio().Accion(this);
        procesoFinal();
    }
    
    public void refrescarConfiguracion() {
        try {
            PropApl.getInstanceLimpiar();            
            addMensaje("Se actualizo la configuración del sistema correctamente.");
            generarMensajes();
        } catch (Exception ex) {
            addError(ex.toString());
            generarMensajes();
        } 
    }
    
    public void crear() {
        super.setAccion(ACCION_CREAR);
        getGnConfiguracionServicio().Accion(this);
        setObjeto(new GnConfiguracionObj());
        refrescar();
        PrimeFaces.current().ajax().update("frmConfiguracion");        
        procesoFinal();
    }
    
    
    private void procesoFinal() {
        switch (getAccion()) {
            case Url.ACCION_VER:
            case Url.ACCION_CREAR:
            case Url.ACCION_EDITAR:
                crearLog(getObjeto().toString());
                break;
        }
        generarMensajes();
    }

}
