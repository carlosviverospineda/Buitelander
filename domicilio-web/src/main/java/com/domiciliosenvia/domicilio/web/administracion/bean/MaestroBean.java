/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.administracion.bean;

import com.domiciliosenvia.domicilio.dominio.administracion.Modulo;
import com.domiciliosenvia.domicilio.dominio.administracion.Maestro;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroAccion;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroRelacion;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroTipo;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroTipoRelacion;
import com.domiciliosenvia.domicilio.web.administracion.servicio.MaestroServicioImpl;
import com.domiciliosenvia.domicilio.web.utilidades.Url;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import com.domiciliosenvia.domicilio.web.administracion.servicio.MaestroServicioIface;
import com.domiciliosenvia.domicilio.web.utilidades.CompatibilidadPF;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.List;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author rpalacic (SystemTech Integral)
 */
@ManagedBean
@ViewScoped
public class MaestroBean extends Url {

    private MaestroServicioIface maestroServicio;
    private List<MaestroAccion> listaAcciones;
    private Maestro objeto;
    private List<Maestro> registros;
    private LazyDataModel<Maestro> lazyMaestro;

    private List<MaestroTipo> listaTipoMaestros;
    private List<Maestro> listaDependencias;
    private HashMap<Integer, Maestro> hashListaDependencias;

    private List<MaestroAccion> listaTipoAcciones;
    private HashMap<Integer, MaestroAccion> hashListaTipoAcciones;
    //
    private List<Integer> selectedMaestrosHijos = new ArrayList();
    private List<String> selectedMaestrosPadres = new ArrayList();
    private List<MaestroTipoRelacion> listaMaestroTipoRelacion;
    private List<Maestro> listaMaestrosConsultados;
    private List<MaestroRelacion> selectedMaestros;
    private List<MaestroTipo> listaMaestroTiposPadre;  

    public MaestroBean() {
        this.objeto = new Maestro();
        listaMaestrosConsultados = new ArrayList<>();
        Modulo _mod = super.validarModulo(Modulo.ID_MAESTROS);
        if (_mod == null) {
            super.redireccionar("/savia/home.faces");
        } else {
            super.setModulo(_mod);
            lazyMaestro = new LazyDataModel<Maestro>() {

                private List<Maestro> lista;

                @Override
                public List<Maestro> load(int primerRegistro, int registrosPagina, String orden, SortOrder formaOrden, Map<String, FilterMeta> filtros) {
                    getParamConsulta().setPrimerRegistro(primerRegistro);
                    getParamConsulta().setRegistrosPagina(registrosPagina);
                    getParamConsulta().setOrden(orden);
                    getParamConsulta().setAscendente(SortOrder.ASCENDING.equals(formaOrden));
                    getParamConsulta().setFiltros(CompatibilidadPF.ConvertirFiltroMetaToHash(filtros));
                    refrescar();
                    lista = getRegistros();
                    setRowCount(getParamConsulta().getCantidadRegistros());
                    return lista;
                }

                @Override
                public Object getRowKey(Maestro objeto) {
                    return objeto.getId();
                }

                @Override
                public Maestro getRowData(String objetoId) {
                    Integer id = Integer.valueOf(objetoId);
                    for (Maestro objeto : lista) {
                        if (id.equals(objeto.getId())) {
                            return objeto;
                        }
                    }
                    return null;
                }

            };
        }
    }

    @PostConstruct
    public void postConstruct() {
        getMaestroServicio().cargasInicial(this);
        listar();
    }

//    private final static LinkedHashMap<String, String> tipos;
//
//    static {
//        tipos = Maestro.getTiposListar();
//    }
    public Maestro getObjeto() {
        return objeto;
    }

    public void setObjeto(Maestro objeto) {
        this.objeto = objeto;
    }

    public List<Maestro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Maestro> registros) {
        this.registros = registros;
    }

    public LazyDataModel<Maestro> getLazyMaestro() {
        return lazyMaestro;
    }

    public void setLazyMaestro(LazyDataModel<Maestro> lazyMaestro) {
        this.lazyMaestro = lazyMaestro;
    }

    public List<MaestroTipo> getListaTipoMaestros() {
        return listaTipoMaestros;
    }

    public void setListaTipoMaestros(List<MaestroTipo> listaTipoMaestros) {
        this.listaTipoMaestros = listaTipoMaestros;
    }

    public List<Maestro> getListaDependencias() {
        return listaDependencias;
    }

    public void setListaDependencias(List<Maestro> listaDependencias) {
        this.listaDependencias = listaDependencias;
    }

    public HashMap<Integer, Maestro> getHashListaDependencias() {
        return hashListaDependencias;
    }

    public void setHashListaDependencias(HashMap<Integer, Maestro> hashListaDependencias) {
        this.hashListaDependencias = hashListaDependencias;
    }

    public List<MaestroAccion> getListaTipoAcciones() {
        return listaTipoAcciones;
    }

    public void setListaTipoAcciones(List<MaestroAccion> listaTipoAcciones) {
        this.listaTipoAcciones = listaTipoAcciones;
    }

    public HashMap<Integer, MaestroAccion> getHashListaTipoAcciones() {
        return hashListaTipoAcciones;
    }

    public void setHashListaTipoAcciones(HashMap<Integer, MaestroAccion> hashListaTipoAcciones) {
        this.hashListaTipoAcciones = hashListaTipoAcciones;
    }

    public List<MaestroAccion> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(List<MaestroAccion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }

    public List<Integer> getSelectedMaestrosHijos() {
        return selectedMaestrosHijos;
    }

    public void setSelectedMaestrosHijos(List<Integer> selectedMaestrosHijos) {
        this.selectedMaestrosHijos = selectedMaestrosHijos;
    }

    public List<MaestroTipoRelacion> getListaMaestroTipoRelacion() {
        return listaMaestroTipoRelacion;
    }

    public void setListaMaestroTipoRelacion(List<MaestroTipoRelacion> listaMaestroTipoRelacion) {
        this.listaMaestroTipoRelacion = listaMaestroTipoRelacion;
    }

    public List<Maestro> getListaMaestrosConsultados() {
        return listaMaestrosConsultados;
    }

    public void setListaMaestrosConsultados(List<Maestro> listaMaestrosConsultados) {
        this.listaMaestrosConsultados = listaMaestrosConsultados;
    }

    public List<MaestroRelacion> getSelectedMaestros() {
        return selectedMaestros;
    }

    public void setSelectedMaestros(List<MaestroRelacion> selectedMaestros) {
        this.selectedMaestros = selectedMaestros;
    }

    public List<MaestroTipo> getListaMaestroTiposPadre() {
        return listaMaestroTiposPadre;
    }

    public void setListaMaestroTiposPadre(List<MaestroTipo> listaMaestroTiposPadre) {
        this.listaMaestroTiposPadre = listaMaestroTiposPadre;
    }

    public List<String> getSelectedMaestrosPadres() {
        return selectedMaestrosPadres;
    }

    public void setSelectedMaestrosPadres(List<String> selectedMaestrosPadres) {
        this.selectedMaestrosPadres = selectedMaestrosPadres;
    }

    public void cargarAcciones() {
//        setListaAcciones(getMaestroServicio().consultarAcciones(getObjeto().getTipo()));
    }

    public MaestroServicioIface getMaestroServicio() {
        if (maestroServicio == null) {
            maestroServicio = new MaestroServicioImpl();
        }
        return maestroServicio;
    }

    public void setMaestroServicio(MaestroServicioIface maestroServicio) {
        this.maestroServicio = maestroServicio;
    }

    public void listar() {
        super.setAccion(ACCION_LISTAR);
        setSelectedMaestrosHijos(new ArrayList());
        procesoFinal();
    }

    public void refrescar() {
        super.setAccion(Url.ACCION_LISTAR);
        getMaestroServicio().Accion(this);
    }

    public void ver(int _id) {
        getObjeto().setId(_id);
        super.setAccion(ACCION_VER);
        getMaestroServicio().Accion(this);
        PrimeFaces.current().ajax().update("frmVer:panelVer");
        PrimeFaces.current().executeScript("PF('dialogoVer').show()");
        procesoFinal();
    }

    public void crear() {
        super.setAccion(ACCION_CREAR);
        getMaestroServicio().Accion(this);
        PrimeFaces.current().resetInputs("frmCrear:panelCrear");
        PrimeFaces.current().ajax().update("frmCrear:panelCrear");
        PrimeFaces.current().executeScript("PF('dialogoCrear').show()");
        procesoFinal();
    }

    public void guardar() {
        super.setAccion(ACCION_GUARDAR);
        getMaestroServicio().Accion(this);
        if (!super.isError()) {
            PrimeFaces.current().executeScript("PF('dialogoCrear').hide();");
        }
        procesoFinal();
    }

    public void editar(int _id) {
        getObjeto().setId(_id);
        setSelectedMaestrosHijos(new ArrayList());
        super.setAccion(ACCION_EDITAR);
        getMaestroServicio().Accion(this);
        PrimeFaces.current().resetInputs("frmEditar:panelEditar");
        PrimeFaces.current().ajax().update("frmEditar:panelEditar");
        PrimeFaces.current().executeScript("PF('dialogoEditar').show()");
        procesoFinal();
    }

    public void modificar() {
        super.setAccion(ACCION_MODIFICAR);
        getMaestroServicio().Accion(this);
        if (!super.isError()) {
            PrimeFaces.current().executeScript("PF('dialogoEditar').hide();");
        }
        procesoFinal();
    }

    public void borrar(int _id) {
        getObjeto().setId(_id);
        super.setAccion(ACCION_BORRAR);
        getMaestroServicio().Accion(this);
        procesoFinal();
    }

    public void listarDependencias() {
        getObjeto().getMaestroTipo().setMaestroTipo(getMaestroServicio().consultarDependenciaPadre(getObjeto().getMaestroTipo().getTipo()));
        if (getObjeto().getMaestroTipo().getTipo() != null) {
            setListaDependencias(getMaestroServicio().listaDependencias(getObjeto().getMaestroTipo().getTipo()));
            setListaAcciones(getMaestroServicio().listaAcciones(getObjeto().getMaestroTipo().getTipo()));
        } else {
            setListaDependencias(new ArrayList());
            setListaAcciones(new ArrayList());
        }
    }
    
    public List<Maestro> maestroPorTipo(String maestroTipo){
        List<Maestro> filtro = listaMaestrosConsultados;
        for(Maestro maestroFiltro: filtro){
            if(!maestroFiltro.getTipo().equals(maestroTipo)){
                filtro.remove(maestroFiltro);
            }
        }
        return filtro;
    }

    public void modificarRelacionHijos(RowEditEvent event) {
        setObjeto((Maestro) event.getObject());
        super.setAccion(ACCION_ADICIONAL_1);
        super.setDoAccion(ACCION_MODIFICAR);
        getMaestroServicio().Accion(this);
        generarMensajes();
    }

    private void procesoFinal() {
        if (!super.isError()) {
            switch (getAccion()) {
                case Url.ACCION_GUARDAR:
                case Url.ACCION_MODIFICAR:
                case Url.ACCION_BORRAR:
                case Url.ACCION_LISTAR:
                    PrimeFaces.current().ajax().update("frmMaestros");
                case Url.ACCION_CREAR:
                case Url.ACCION_EDITAR:
                    crearLog(getObjeto().toString());
                    break;
            }
        }
        generarMensajes();
    }

//    public Map<String, String> getTipos() {
//        return tipos;
//    }
}
