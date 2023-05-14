/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.financiero.bean;

import com.domiciliosenvia.domicilio.dominio.administracion.Maestro;
import com.domiciliosenvia.domicilio.dominio.administracion.Modulo;
import com.domiciliosenvia.domicilio.dominio.financiero.Orden;
//import com.domiciliosenvia.domicilio.dominio.financiero.OrdenDetalle;
//import com.domiciliosenvia.domicilio.dominio.financiero.OrdenReporte;
//import com.domiciliosenvia.domicilio.dominio.registro.Area;
//import com.domiciliosenvia.domicilio.dominio.registro.Persona;
//import com.domiciliosenvia.domicilio.dominio.registro.Proveedor;
import com.domiciliosenvia.domicilio.web.financiero.servicio.OrdenServicioIface;
import com.domiciliosenvia.domicilio.web.utilidades.CompatibilidadPF;
import com.domiciliosenvia.domicilio.web.utilidades.Url;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;

//Librerias para JasperReports
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.springframework.web.servlet.support.RequestContext;

/**
 *
 * @author jramirer (SystemTech Integral)
 */
@ManagedBean
@ViewScoped
public class OrdenBean extends Url implements Serializable {

    private OrdenServicioIface ordenServicio;
    private Orden objeto;
//    private OrdenDetalle detalle;
//    List<OrdenDetalle> listaDetalles;
//    List<OrdenReporte> listaReporteOC;
    private List<Orden> registros;
    private LazyDataModel<Orden> lazyOrden;
//
//    private List<Area> listaAreas;
//    private HashMap<Integer, Area> hashAreas;
//    private List<Proveedor> listaProveedores;
//    private HashMap<Integer, Proveedor> hashProveedores;
////    private List<Persona> listaPersonas;
////    private HashMap<Integer, Persona> hashPersonas;
    //Maestros
    private HashMap<Integer, Maestro> hashMaeTiposDocumento;
    private HashMap<Integer, Maestro> hashMaeTiposOrden;
    private List<Maestro> listaMaeTiposOrden;
    private HashMap<Integer, Maestro> hashMaeTiposActa;
    private List<Maestro> listaMaeTiposActa;
    private HashMap<Integer, Maestro> hashMaeUnidades;
    private List<Maestro> listaMaeUnidades;

    public OrdenBean() {
        this.objeto = new Orden();
        Modulo mod = super.validarModulo(Modulo.ID_ORD_VENTA);
//        super.getParamConsulta().setEmpresaId(super.getConexion().getEmpresa().getId());
        if (mod == null) {
            super.redireccionar("/domicilios/home.faces");
        } else {
            super.setModulo(mod);
//            super.getParamConsulta().setEmpresaId(super.getConexion().getEmpresa().getId());
            lazyOrden = new LazyDataModel<Orden>() {

                private List<Orden> lista;

                @Override
                public List<Orden> load(int primerRegistro, int registrosPagina, String orden, SortOrder formaOrden, Map<String, FilterMeta> filtros) {
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
                public Object getRowKey(Orden vendedor) {
                    return vendedor.getId();
                }

                @Override
                public Orden getRowData(String vendedorId) {
                    Integer id = Integer.valueOf(vendedorId);
                    for (Orden vendedor : lista) {
                        if (id.equals(vendedor.getId())) {
                            return vendedor;
                        }
                    }
                    return null;
                }
//
            };
        }
    }

    @PostConstruct
    public void postConstruct() {
        getOrdenServicio().cargaInial(this);
        listar();
    }

    public Orden getObjeto() {
        return objeto;
    }

    public void setObjeto(Orden objeto) {
        this.objeto = objeto;
    }

//    public OrdenDetalle getDetalle() {
//        return detalle;
//    }
//
//    public void setDetalle(OrdenDetalle detalle) {
//        this.detalle = detalle;
//    }
//
//    public List<OrdenDetalle> getListaDetalles() {
//        return listaDetalles;
//    }
//
//    public OrdenDetalle getDetalle(int pos) {
//        try {
//            return listaDetalles.get(pos);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public void setListaDetalles(List<OrdenDetalle> listaDetalles) {
//        this.listaDetalles = listaDetalles;
//    }
//
//    public void addDetalle(OrdenDetalle obj) {
//        if (listaDetalles == null) {
//            listaDetalles = new ArrayList();
//        }
//        obj.setPos(listaDetalles.size());
//        this.listaDetalles.add(obj);
//    }
//
//    public void delDetalle(int pos) {
//        List<OrdenDetalle> lista = new ArrayList();
//        int i = 0, j = 0;
//        for (OrdenDetalle det : listaDetalles) {
//            if (j != pos) {
//                det.setPos(i);
//                lista.add(det);
//                i++;
//            }
//            j++;
//        }
//        listaDetalles = lista;
//    }
//
    public List<Orden> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Orden> registros) {
        this.registros = registros;
    }
//

    public LazyDataModel<Orden> getLazyOrden() {
        return lazyOrden;
    }

    public void setLazyOrden(LazyDataModel<Orden> lazyOrden) {
        this.lazyOrden = lazyOrden;
    }

    public OrdenServicioIface getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioIface ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

//    public List<Area> getListaAreas() {
//        return listaAreas;
//    }
//
//    public void setListaAreas(List<Area> listaAreas) {
//        this.listaAreas = listaAreas;
//    }
//
//    public HashMap<Integer, Area> getHashAreas() {
//        return hashAreas;
//    }
//
//    public void setHashAreas(HashMap<Integer, Area> hashAreas) {
//        this.hashAreas = hashAreas;
//    }
//
//    public List<Proveedor> getListaProveedores() {
//        return listaProveedores;
//    }
//
//    public void setListaProveedores(List<Proveedor> listaProveedores) {
//        this.listaProveedores = listaProveedores;
//    }
//
//    public HashMap<Integer, Proveedor> getHashProveedores() {
//        return hashProveedores;
//    }
//
//    public void setHashProveedores(HashMap<Integer, Proveedor> hashProveedores) {
//        this.hashProveedores = hashProveedores;
//    }
//    public HashMap<Integer, Maestro> getHashMaeTiposDocumento() {
//        return hashMaeTiposDocumento;
//    }
//    public String getTipoDocumento(int id) {
//        try {
//            return hashMaeTiposDocumento.get(id).getNombre();
//        } catch (Exception e) {
//            return "";
//        }
//    }
//    public void setHashMaeTiposDocumento(HashMap<Integer, Maestro> hashMaeTiposDocumento) {
//        this.hashMaeTiposDocumento = hashMaeTiposDocumento;
//    }
//
    public HashMap<Integer, Maestro> getHashMaeTiposOrden() {
        return hashMaeTiposOrden;
    }

//    public String getTipoOrden(int id) {
//        try {
//            return hashMaeTiposOrden.get(id).getNombre();
//        } catch (Exception e) {
//            return "";
//        }
//    public void setHashMaeTiposOrden(HashMap<Integer, Maestro> hashMaeTiposOrden) {
//        this.hashMaeTiposOrden = hashMaeTiposOrden;
//    }
//
    public List<Maestro> getListaMaeTiposOrden() {
        return listaMaeTiposOrden;
    }

    public void setListaMaeTiposOrden(List<Maestro> listaMaeTiposOrden) {
        this.listaMaeTiposOrden = listaMaeTiposOrden;
    }

    public HashMap<Integer, Maestro> getHashMaeTiposActa() {
        return hashMaeTiposActa;
    }

    public String getTipoActa(int id) {
        try {
            return hashMaeTiposActa.get(id).getNombre();
        } catch (Exception e) {
            return "";
        }
    }

    public void setHashMaeTiposActa(HashMap<Integer, Maestro> hashMaeTiposActa) {
        this.hashMaeTiposActa = hashMaeTiposActa;
    }

    public List<Maestro> getListaMaeTiposActa() {
        return listaMaeTiposActa;
    }

    public void setListaMaeTiposActa(List<Maestro> listaMaeTiposActa) {
        this.listaMaeTiposActa = listaMaeTiposActa;
    }

//    public HashMap<Integer, Maestro> getHashMaeUnidades() {
//        return hashMaeUnidades;
//    }
//
//    public String getUnidad(int id) {
//        try {
//            return hashMaeUnidades.get(id).getNombre();
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    public void setHashMaeUnidades(HashMap<Integer, Maestro> hashMaeUnidades) {
//        this.hashMaeUnidades = hashMaeUnidades;
//    }
//
//    public List<Maestro> getListaMaeUnidades() {
//        return listaMaeUnidades;
//    }
//
//    public void setListaMaeUnidades(List<Maestro> listaMaeUnidades) {
//        this.listaMaeUnidades = listaMaeUnidades;
//    }
    public void refrescar() {
        super.setAccion(Url.ACCION_LISTAR);
        getOrdenServicio().Accion(this);
    }

    public void listar() {
        super.setAccion(Url.ACCION_LISTAR);
        getOrdenServicio().Accion(this);
        procesoFinal();
    }

    public void ver(int id) {
        getObjeto().setId(id);
        super.setAccion(ACCION_VER);
        getOrdenServicio().Accion(this);
//        listaDetalles = objeto.getListaOrdenDetalles();
//        RequestContext.getCurrentInstance().update("frmVer");
//        RequestContext.getCurrentInstance().execute("PF('dialogoVer').show()");
//        RequestContext.getCurrentInstance().update("frmVer:detalles");
        procesoFinal();
    }
//    public StreamedContent generarReporte(int id) {
//        StreamedContent streamedContent2;
//        try {
//            getObjeto().setId(id);
//            super.setAccion(ACCION_ADICIONAL_1);
//            getOrdenServicio().Accion(this);
//            listaReporteOC = new ArrayList();
//            for(OrdenReporte ordenRep : objeto.getListaReporteOC()){
//                String strUnidadMedida = this.getUnidad(Integer.valueOf(ordenRep.getUnidad_medida()));
//                String strTipoOrden = this.getTipoOrden(Integer.valueOf(ordenRep.getTipo_orden()));
//                String strTipoActa = this.getTipoActa(Integer.valueOf(ordenRep.getActa_tipo()));
//                String strTipoDocumento  = this.getTipoDocumento(Integer.valueOf(ordenRep.getTipo_identificacion()));
//                ordenRep.setUnidad_medida(strUnidadMedida);
//                ordenRep.setTipo_orden(strTipoOrden);
//                ordenRep.setActa_tipo(strTipoActa);
//                ordenRep.setTipo_identificacion(strTipoDocumento);
//                listaReporteOC.add(ordenRep);
//            }
//            //Estrucutra de JasperReport
//            InputStream is = getClass().getResourceAsStream("/reportes/orden_compra.jasper");
//            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listaReporteOC);
//            
//            Map parameters = new HashMap();
//            parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "CO")); 
//            
//            byte[] bytes = JasperRunManager.runReportToPdf(is, parameters, beanColDataSource);
//            InputStream stream = new ByteArrayInputStream(bytes);
//            stream.mark(0); //remember to this position!
//            streamedContent2 = new DefaultStreamedContent(stream, "application/pdf", "Reporte.pdf");
//            
//        } catch (JRException ex) {
//            streamedContent2 = null;
//            System.out.println("Error Stream: " + ex.toString() + ex.getMessage());
//        }
//        return streamedContent2;
//    }
//

    public void crear() {
        super.setAccion(ACCION_CREAR);
        getOrdenServicio().Accion(this);
        getObjeto().setEstado(Orden.ESTADO_SOLICITADO);
        PrimeFaces.current().ajax().update("frmCrear:panelCrear");
        PrimeFaces.current().executeScript("PF('dialogoCrear').show()");
//        inicialEncabezadoCrear();
//        RequestContext.getCurrentInstance().update("frmCrear");
//        RequestContext.getCurrentInstance().execute("PF('dialogoCrear').show()");
//        RequestContext.getCurrentInstance().update("frmCrear:detalles");
        procesoFinal();
    }

    public void guardar() {
        super.setAccion(ACCION_CREAR);
        getOrdenServicio().Accion(this);
        PrimeFaces.current().ajax().update("frmCrear:panelCrear");
        PrimeFaces.current().executeScript("PF('dialogoCrear').show()");
//        objeto.setListaOrdenDetalles(listaDetalles);
//        calculoValores();
        procesoFinal();
    }

//    public void editar(int id) {
//        getObjeto().setId(id);
//        super.setAccion(ACCION_EDITAR);
//        getOrdenServicio().Accion(this);
//        objeto.setEstadoAnt(objeto.getEstado());
//        if (isPermisoEditar(getObjeto())) {
//            listaDetalles = new ArrayList(objeto.getListaOrdenDetalles());
//            if (getObjeto().getArea() != null) {
//                getObjeto().setArea(getHashAreas().get(getObjeto().getArea().getId()));
//            }
//            if (getObjeto().getProveedor() != null) {
//                getObjeto().setProveedor(getHashProveedores().get(getObjeto().getProveedor().getId()));
//            }
//            inicialEncabezadoEditar();
//            RequestContext.getCurrentInstance().update("frmEditar");
//            RequestContext.getCurrentInstance().execute("PF('dialogoEditar').show()");
//        } else {
//            addError("Este registro no se puede editar");
//        }
//        procesoFinal();
////        RequestContext.getCurrentInstance().update("frmEditar:detalles");
//    }
//    public void modificar() {
//        if (isPermisoEditar(getObjeto())) {
//            List<OrdenDetalle> listaInicial = new ArrayList();
//            listaInicial.addAll(objeto.getListaOrdenDetalles());
//            List<OrdenDetalle> listaFinal = new ArrayList();
//            listaFinal.addAll(listaDetalles);
//            List<OrdenDetalle> listaResultado = new ArrayList();
//            for (OrdenDetalle detIni : listaInicial) {
//                boolean encontro = false;
//                for (OrdenDetalle detFin : listaFinal) {
//                    if (detIni.getId() != null && Objects.equals(detIni.getId(), detFin.getId())) {
//                        detIni.setAccion(OrdenDetalle.ACCION_NINGUNO);
//                        listaResultado.add(detIni);
//                        listaFinal.remove(detFin);
//                        encontro = true;
//                        break;
//                    }
//                }
//                if (!encontro) {
//                    detIni.setAccion(OrdenDetalle.ACCION_BORRAR);
//                    listaResultado.add(detIni);
//                }
//            }
//            for (OrdenDetalle detFin : listaFinal) {
//                detFin.setAccion(OrdenDetalle.ACCION_INSERTAR);
//                listaResultado.add(detFin);
//            }
//            objeto.setListaOrdenDetalles(listaResultado);
//            super.setAccion(ACCION_MODIFICAR);
//            getOrdenServicio().Accion(this);
//        } else {
//            addError("Este registro no se puede editar");
//        }
//        if (!super.isError()) {
//            RequestContext.getCurrentInstance().execute("PF('dialogoEditar').hide();");
//        }
//        procesoFinal();
//    }
//    public void borrar(int id) {
//        getObjeto().setId(id);
//        super.setAccion(ACCION_BORRAR);
//        getOrdenServicio().Accion(this);
//        procesoFinal();
//    }
//
//    public void crearDetalle() {
//        detalle = new OrdenDetalle();
//        RequestContext.getCurrentInstance().reset("frmCrearDetalle:panelCrearDetalle");
//        RequestContext.getCurrentInstance().update("frmCrearDetalle:panelCrearDetalle");
//        RequestContext.getCurrentInstance().execute("PF('dialogoCrearDetalle').show()");
//    }
//
//    public void adicionarDetalle() {
//        try {
//            OrdenDetalle obj = getDetalle();
//            obj.setSubTotal(obj.getCantidad() * obj.getValorUnitario());
//            obj.setValorIva(obj.getSubTotal() * obj.getPorcentajeIva() / 100);
//            obj.setTotal(obj.getSubTotal() + obj.getValorIva());
//            addDetalle(obj);
//            calculoValores();
//        } catch (Exception e) {
//            super.addError("No es posible adicionar detalle");
//        }
//        if (!super.isError()) {
//            RequestContext.getCurrentInstance().execute("PF('dialogoCrearDetalle').hide();");
//            RequestContext.getCurrentInstance().update("frmCrear:detalles");
//            RequestContext.getCurrentInstance().update("frmEditar:detalles");
//        }
//    }
//    public void borrarDetalle(int pos) {
//        try {
//            delDetalle(pos);
//            calculoValores();
//        } catch (Exception e) {
//            super.addError("No es posible borrar detalle");
//        }
//        if (!super.isError()) {
//            RequestContext.getCurrentInstance().execute("PF('dialogoCrearDetalle').hide();");
//            RequestContext.getCurrentInstance().update("frmCrear:detalles");
//            RequestContext.getCurrentInstance().update("frmEditar:detalles");
//        }
//    }
//    public void inicialEncabezadoCrear() {
//        objeto.setValorDescuento(0);
//        objeto.setValorAdicional(0);
//        objeto.setValorImpuestoConsumo(0);
//        objeto.setValorRetefuente(0);
//        objeto.setPorcentajeRetefuente(0);
//        objeto.setPorcentajeImpuestoConsumo(0);
//        objeto.setAnticipo(0);
//        objeto.setPlazo(0);
//        refrescarValores();
//    }
//    private void inicialEncabezadoEditar() {
//        refrescarValores();
//    }
//    public void calculoValores() {
//        double valorSinIva = 0;
//        double subTotal = 0;
//        double valorIva = 0;
//        double total = 0;
//        for (OrdenDetalle det : listaDetalles) {
//            valorSinIva += det.getSubTotal();
//            valorIva += det.getValorIva();
//        }
//        subTotal = valorSinIva - objeto.getValorDescuento() + objeto.getValorAdicional();
//        total = subTotal + valorIva + objeto.getValorImpuestoConsumo() - objeto.getValorRetefuente();
//
//        objeto.setSubTotalSinIva(valorSinIva);
//        objeto.setSubTotal(subTotal);
//        objeto.setValorIva(valorIva);
//        objeto.setTotal(total);
//        refrescarValores();
//    }
//
//    private void refrescarValores() {
//        RequestContext.getCurrentInstance().update("frmCrear:detalles");
//        RequestContext.getCurrentInstance().update("frmCrear:valorSinIva");
//        RequestContext.getCurrentInstance().update("frmCrear:valorSubtotalGeneral");
//        RequestContext.getCurrentInstance().update("frmCrear:valorIva");
//        RequestContext.getCurrentInstance().update("frmCrear:valorTotal");
//        RequestContext.getCurrentInstance().update("frmEditar:detalles");
//        RequestContext.getCurrentInstance().update("frmEditar:valorSinIva");
//        RequestContext.getCurrentInstance().update("frmEditar:valorSubtotalGeneral");
//        RequestContext.getCurrentInstance().update("frmEditar:valorIva");
//        RequestContext.getCurrentInstance().update("frmEditar:valorTotal");
//    }
//
//    public boolean isPermisoEditar(Orden ord) {
//        if (ord != null && ord.getEstadoAnt() != null) {
//            return !(ord.getEstadoAnt() == Orden.ESTADO_CONTABILIZADO
//                    || ord.getEstadoAnt() == Orden.ESTADO_PAGADO
//                    || ord.getEstadoAnt() == Orden.ESTADO_ANULADO);
//        } else {
//            return false;
//        }
//    }
    public LinkedHashMap<String, Integer> getEstadosConsumo() {
        LinkedHashMap<String, Integer> estados = new LinkedHashMap();
        if (objeto != null && objeto.getEstado() != null) {
            switch (objeto.getEstado()) {
                case Orden.ESTADO_SOLICITADO:
                    estados.put("Solicitado", Orden.ESTADO_SOLICITADO);
                case Orden.ESTADO_REVISADO:
                    estados.put("Revisado", Orden.ESTADO_REVISADO);
                case Orden.ESTADO_APROBADO:
                    estados.put("Aprobado", Orden.ESTADO_APROBADO);
                case Orden.ESTADO_CONTABILIZADO:
                    estados.put("Contabilizado", Orden.ESTADO_CONTABILIZADO);
                case Orden.ESTADO_PAGADO:
                    estados.put("Pagado", Orden.ESTADO_PAGADO);
                case Orden.ESTADO_ANULADO:
                    estados.put("Anulado", Orden.ESTADO_ANULADO);
                default:
            }
        }
        return estados;
    }

    public LinkedHashMap<String, Integer> getEstados() {
        LinkedHashMap<String, Integer> estados = new LinkedHashMap();
        estados.put("Solicitado", Orden.ESTADO_SOLICITADO);
        estados.put("Revisado", Orden.ESTADO_REVISADO);
        estados.put("Aprobado", Orden.ESTADO_APROBADO);
        estados.put("Contabilizado", Orden.ESTADO_CONTABILIZADO);
        estados.put("Pagado", Orden.ESTADO_PAGADO);
        estados.put("Anulado", Orden.ESTADO_ANULADO);
        return estados;
    }

    private void procesoFinal() {
        if (!super.isError()) {
            crearLog(getObjeto().toString());
            switch (getAccion()) {
                case Url.ACCION_GUARDAR:
                case Url.ACCION_MODIFICAR:
                case Url.ACCION_BORRAR:
//                    RequestContext.getCurrentInstance().update("frmOrdenes");
                    break;
                case Url.ACCION_LISTAR:
                    break;
            }

        }
        generarMensajes();
    }

}
