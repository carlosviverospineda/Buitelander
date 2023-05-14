/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.servicios.financiero;

import com.domiciliosenvia.domicilio.dominio.administracion.Empresa;
import com.domiciliosenvia.domicilio.dominio.administracion.Perfil;
import com.domiciliosenvia.domicilio.dominio.financiero.Orden;
//import com.domiciliosenvia.domicilio.dominio.financiero.OrdenDetalle;
//import com.domiciliosenvia.domicilio.dominio.financiero.OrdenReporte;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import com.domiciliosenvia.domicilio.ejb.entidades.FaOrdenes;
import com.domiciliosenvia.domicilio.ejb.entidades.GnPerfiles;
import static com.domiciliosenvia.domicilio.ejb.servicios.administracion.PerfilServicio.castEntidadNegocio;
//import com.domiciliosenvia.domicilio.dominio.registro.Area;
//import com.domiciliosenvia.domicilio.dominio.registro.Proveedor;
//import com.domiciliosenvia.domicilio.ejb.entidades.Areas;
//import com.domiciliosenvia.domicilio.ejb.entidades.FiOrdenes;
//import com.domiciliosenvia.domicilio.ejb.entidades.Empresas;
//import com.domiciliosenvia.domicilio.ejb.entidades.FiOrdenDetalles;
//import com.domiciliosenvia.domicilio.ejb.entidades.Proveedores;
import com.domiciliosenvia.domicilio.ejb.servicios.administracion.UbicacionServicio;
//import com.domiciliosenvia.domicilio.ejb.servicios.registro.ProveedorServicio;
import com.domiciliosenvia.domicilio.ejb.utilidades.GenericoServicio;
import com.domiciliosenvia.domicilio.negocio.financiero.OrdenRemoto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author raul-palacios
 */
@Stateless
@Remote(OrdenRemoto.class)
//@Local(OrdenLocal.class)
public class OrdenServicio extends GenericoServicio implements OrdenLocal, OrdenRemoto {

    @Override
    public int consultarCantidadLista(ParamConsulta paramConsulta) throws Exception {
        int cant = 0;
        try {
            String strQuery = "SELECT COUNT(fo) FROM FaOrdenes fo "
                    + "WHERE 1 = 1";
            if (paramConsulta.getFiltros() != null) {
                for (Map.Entry e : paramConsulta.getFiltros().entrySet()) {
                    switch ((String) e.getKey()) {
//                        case "maeTipoOrden":
//                            strQuery += "AND o.maeTipoOrden = '" + (String) e.getValue() + "' ";
//                            break;
//                        case "area.id":
//                            strQuery += "AND o.areasId.id = '" + (String) e.getValue() + "' ";
//                            break;
//                        case "numero":
//                            strQuery += "AND o.numero LIKE '%" + (String) e.getValue() + "%' ";
//                            break;
//                        case "estado":
//                            strQuery += "AND o.estado = " + e.getValue() + " ";
//                            break;
//                        case "persona.id":
//                            strQuery += "AND o.personasId.id = " + e.getValue() + " ";
//                            break;
//                        case "proveedor.id":
//                            strQuery += "AND o.proveedoresId.id = " + e.getValue() + " ";
//                            break;
                    }
                }
            }
            cant = (int) (long) getEntityManager().createQuery(strQuery)
                    //                    .setParameter("empresa_id", paramConsulta.getEmpresaId())
                    .getSingleResult();
        } catch (NoResultException e) {
            cant = 0;
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return cant;
    }

    @Override
    public List<Orden> consultarLista(ParamConsulta paramConsulta) throws Exception {
        List<Orden> listResult = new ArrayList();
        try {
            String strQuery = "FROM FaOrdenes f "
                    + "WHERE 1 = 1 ";
            if (paramConsulta.getFiltros() != null) {
                for (Map.Entry e : paramConsulta.getFiltros().entrySet()) {
                    switch ((String) e.getKey()) {
                        case "id":
                            strQuery += "AND f.id LIKE '" + (String) e.getValue() + "%' ";
                            break;
//                        case "activo":
//                            strQuery += "AND p.activo = " + (String) e.getValue() + " ";
//                            break;
                    }
                }
            }
            strQuery += "ORDER BY ";
            if (paramConsulta.getOrden() != null) {
                strQuery += "f." + paramConsulta.getOrden() + " "
                        + (paramConsulta.isAscendente() ? "ASC" : "DESC");
            } else {
                strQuery += "f.id ASC ";
            }
            List<FaOrdenes> list = getEntityManager().createQuery(strQuery)
                    .setFirstResult(paramConsulta.getPrimerRegistro())
                    .setMaxResults(paramConsulta.getRegistrosPagina())
                    .getResultList();
            for (FaOrdenes per : list) {
                listResult.add(castEntidadNegocio(per));
            }
        } catch (NoResultException e) {
            listResult = new ArrayList();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return listResult;
    }

//
//    @Override
//    public Orden consultarReporteOC(int id) throws Exception {
//        Orden objRes = null;
//        try {
//            FiOrdenes per = (FaOrdenes) getEntityManager().find(FiOrdenes.class, id);
//            objRes = castEntidadNegocioReporte(per);
//            List<OrdenReporte> lista = new ArrayList();
//            for (FiOrdenDetalles perDet : per.getFiOrdenDetallesList()) {
//                lista.add(castEntidadNegocioReporte(objRes, perDet));
//            }
//            objRes.setListaReporteOC(lista);
//        } catch (NoResultException e) {
//            objRes = null;
//        } catch (Exception e) {
//            Exception(CONSULTAR, e);
//        } finally {
//            cerrarEntityManager();
//        }
//        return objRes;
//    }
    @Override
    public Orden consultar(int id) throws Exception {
        Orden objRes = null;
        try {
            FaOrdenes per = (FaOrdenes) getEntityManager().find(FaOrdenes.class, id);
            objRes = castEntidadNegocio(per);
//            List<OrdenDetalle> lista = new ArrayList();
//            for (FiOrdenDetalles perDet : per.getFiOrdenDetallesList()) {
//                lista.add(castEntidadNegocio(perDet));
//            }
//            objRes.setListaOrdenDetalles(lista);
        } catch (NoResultException e) {
            objRes = null;
        } catch (Exception e) {
            Exception(CONSULTAR, e);
        } finally {
            cerrarEntityManager();
        }
        return objRes;
    }

    @Override
    public int insertar(Orden obj) throws Exception {
        int id = 0;
        try {
            FaOrdenes per = castNegocioEntidad(obj);
            id = (int) getEntityManager().merge(per).getId();
            obj.setId(id);
//            List<OrdenDetalle> listaOrdenes = new ArrayList();
//            for (OrdenDetalle objDet : obj.getListaOrdenDetalles()) {
//                objDet.setOrden(new Orden(id));
//                objDet.setUsuarioCrea(obj.getUsuarioCrea());
//                objDet.setTerminalCrea(obj.getTerminalCrea());
//                objDet.setFechaHoraCrea(obj.getFechaHoraCrea());
//                FiOrdenDetalles perDet = castNegocioEntidad(objDet);
//                int idDet = (int) getEntityManager().merge(perDet).getId();
//                objDet.setId(idDet);
//                listaOrdenes.add(objDet);
//            }
//            obj.setListaOrdenDetalles(listaOrdenes);
        } catch (NoResultException e) {
            id = 0;
        } catch (Exception e) {
            Exception(INSERTAR, e);
        } finally {
            cerrarEntityManager();
        }
        return id;
    }
//    @Override
//    public void actualizar(Orden obj) throws Exception {
//        try {
//            FiOrdenes per = castNegocioEntidad(obj);
//            int id = (int) getEntityManager().merge(per).getId();
//            obj.setId(id);
//            List<OrdenDetalle> listaOrdenes = new ArrayList();
//            for (OrdenDetalle objDet : obj.getListaOrdenDetalles()) {
//                if (objDet.getAccion() == OrdenDetalle.ACCION_INSERTAR) {
//                    objDet.setOrden(new Orden(id));
//                    objDet.setUsuarioCrea(obj.getUsuarioModifica());
//                    objDet.setTerminalCrea(obj.getTerminalModifica());
//                    objDet.setFechaHoraCrea(obj.getFechaHoraModifica());
//                    FiOrdenDetalles perDet = castNegocioEntidad(objDet);
//                    int idDet = (int) getEntityManager().merge(perDet).getId();
//                    objDet.setId(idDet);
//                    listaOrdenes.add(objDet);
//                } else if (objDet.getAccion() == OrdenDetalle.ACCION_BORRAR) {
//                    FiOrdenDetalles ent = getEntityManager().find(FiOrdenDetalles.class, objDet.getId());
//                    if (ent != null) {
//                        getEntityManager().remove(ent);
//                    }
//                }
//            }
//            obj.setListaOrdenDetalles(listaOrdenes);
//        } catch (NoResultException e) {
//
//        } catch (Exception e) {
//            Exception(ACTUALIZAR, e);
//        } finally {
//            cerrarEntityManager();
//        }
//    }
//    @Override
//    public Orden eliminar(int id) throws Exception {
//        Orden obj = null;
//        try {
//            FiOrdenes ent = getEntityManager().find(FiOrdenes.class, id);
//            if (ent != null) {
//                obj = castEntidadNegocio(ent);
//                getEntityManager().remove(ent);
//            }
//        } catch (NoResultException e) {
//            obj = null;
//        } catch (Exception e) {
//            Exception(ELIMINAR, e);
//        } finally {
//            cerrarEntityManager();
//        }
//        return obj;
//    }
//    @Override
//    public List<Orden> consultarTodos(int empresaId) throws Exception {
//        List<Orden> listResult = new ArrayList();
//        try {
//            String strQuery = "FROM FiOrdenes o "
//                    + "WHERE o.empresasId.id = :empresa_id "
//                    + "ORDER BY o.fechaHoraCrea DESC";
//            List<FiOrdenes> list = getEntityManager().createQuery(strQuery)
//                    .setParameter("empresa_id", empresaId)
//                    .getResultList();
//            for (FiOrdenes per : list) {
//                listResult.add(castEntidadNegocio(per));
//            }
//        } catch (NoResultException e) {
//            listResult = new ArrayList();
//        } catch (Exception e) {
//            Exception(CONSULTAR_TODOS, e);
//        } finally {
//            cerrarEntityManager();
//        }
//        return listResult;
//    }
//    public static Orden castEntidadNegocioReporte(FaOrdenes per) {

    public static Orden castEntidadNegocio(FaOrdenes per) {
        Orden obj = new Orden();
        obj.setId(per.getId());
        obj.setEstado(per.getEstado());
        obj.setFechaOrden(per.getFechaOrden());
//        obj.setArea(new Area(per.getAreasId().getId(), per.getAreasId().getNombre(), per.getAreasId().getDescripcion()));
//        if (per.getAreasId().getAreasId() == null) {
//            obj.getArea().setArea(new Area());
//        } else {
//            obj.getArea().setArea(new Area(per.getAreasId().getAreasId().getId(), per.getAreasId().getAreasId().getNombre(), per.getAreasId().getAreasId().getDescripcion()));
//        }
//        Proveedor prov = ProveedorServicio.castEntidadNegocio(per.getProveedoresId());
//        prov.setUbicacion(UbicacionServicio.castEntidadNegocio(per.getProveedoresId().getUbicacionesId()));

        obj.setSubTotal(per.getSubTotal().doubleValue());
        obj.setValorDescuento(per.getValorDescuento().doubleValue());
        obj.setValorAdicional(per.getValorAdicional().doubleValue());
        obj.setSubTotalSinIva(per.getSubTotalSinIva().doubleValue());
//        obj.setPorcentajeRetefuente(per.getPorcentajeRetefuente());
//        obj.setValorRetefuente(per.getValorRetefuente().doubleValue());
//        obj.setPorcentajeImpuestoConsumo(per.getPorcentajeImpuestoConsumo());
//        obj.setValorImpuestoConsumo(per.getValorImpuestoConsumo().doubleValue());
//        obj.setValorIva(per.getValorIva().doubleValue());
        obj.setTotal(per.getTotal().doubleValue());
        obj.setAnticipo(per.getAnticipo().doubleValue());
//        obj.setPlazo(per.getPlazo());
//        obj.setSolicito(per.getSolicito());
//        obj.setReviso(per.getReviso());
        obj.setAprobo(per.getAprobo());
        //Auditoría
//        obj.setUsuarioCrea(per.getUsuarioCrea());
//        obj.setTerminalCrea(per.getTerminalCrea());
//        obj.setFechaHoraCrea(per.getFechaHoraCrea());
//        obj.setUsuarioModifica(per.getUsuarioModifica());
//        obj.setTerminalModifica(per.getTerminalModifica());
//        obj.setFechaHoraModifica(per.getFechaHoraModifica());
        //System.out.println("Ubcacion:");
        //System.out.println(obj.getProveedor().getUbicacion().getUbicacionPadre().getNombre());
        return obj;
    }

//    public static Orden castEntidadNegocio(FiOrdenes per) {
//        Orden obj = new Orden();
//        obj.setId(per.getId());
//        obj.setEstado(per.getEstado());
//        obj.setEstadoAnt(per.getEstado());
//        obj.setEmpresa(new Empresa(per.getEmpresasId().getId()));
//        obj.setMaeTipoOrden(per.getMaeTipoOrden());
//        obj.setFechaOrden(per.getFechaOrden());
//        obj.setArea(new Area(per.getAreasId().getId(), per.getAreasId().getNombre(), per.getAreasId().getDescripcion()));
//        if (per.getAreasId().getAreasId() == null) {
//            obj.getArea().setArea(new Area());
//        } else {
//            obj.getArea().setArea(new Area(per.getAreasId().getAreasId().getId(), per.getAreasId().getAreasId().getNombre(), per.getAreasId().getDescripcion()));
//        }
//        obj.setProveedor(new Proveedor(per.getProveedoresId().getId(), per.getProveedoresId().getRazonSocial(), per.getProveedoresId().getNombreComercial()));
//        obj.setMaeActaTipo(per.getMaeActaTipo());
//        obj.setActaNumero(per.getActaNumero());
//        obj.setActaFecha(per.getActaFecha());
//        obj.setObjeto(per.getObjeto());
//        obj.setObservacion(per.getObservacion());
//        //Valores finales
//        obj.setSubTotal(per.getSubTotal().doubleValue());
//        obj.setValorDescuento(per.getValorDescuento().doubleValue());
//        obj.setValorAdicional(per.getValorAdicional().doubleValue());
//        obj.setSubTotalSinIva(per.getSubTotalSinIva().doubleValue());
//        obj.setPorcentajeRetefuente(per.getPorcentajeRetefuente());
//        obj.setValorRetefuente(per.getValorRetefuente().doubleValue());
//        obj.setPorcentajeImpuestoConsumo(per.getPorcentajeImpuestoConsumo());
//        obj.setValorImpuestoConsumo(per.getValorImpuestoConsumo().doubleValue());
//        obj.setValorIva(per.getValorIva().doubleValue());
//        obj.setTotal(per.getTotal().doubleValue());
//        obj.setAnticipo(per.getAnticipo().doubleValue());
//        obj.setPlazo(per.getPlazo());
//        obj.setSolicito(per.getSolicito());
//        obj.setReviso(per.getReviso());
//        obj.setAprobo(per.getAprobo());
//        //Auditoría
//        obj.setUsuarioCrea(per.getUsuarioCrea());
//        obj.setTerminalCrea(per.getTerminalCrea());
//        obj.setFechaHoraCrea(per.getFechaHoraCrea());
//        obj.setUsuarioModifica(per.getUsuarioModifica());
//        obj.setTerminalModifica(per.getTerminalModifica());
//        obj.setFechaHoraModifica(per.getFechaHoraModifica());
//        return obj;
//    }
//
    public static FaOrdenes castNegocioEntidad(Orden obj) {
        FaOrdenes per = new FaOrdenes();
        per.setId(obj.getId());
        per.setEstado(obj.getEstado());
        per.setMaeTipoOrden(obj.getMaeTipoOrden());
        per.setFechaOrden(obj.getFechaOrden());
        per.setDescripcion(obj.getDescripcion());
        per.setSubTotalSinIva(Double.valueOf(obj.getSubTotalSinIva()));
        per.setValorDescuento(Double.valueOf(obj.getValorDescuento()));
        per.setValorAdicional(Double.valueOf(obj.getValorAdicional()));
        per.setSubTotal(Double.valueOf(obj.getSubTotal()));
        per.setPorcentajeIimpuesto(Double.valueOf(obj.getPorcentajeImpuestoConsumo()));
        per.setValorImpuesto(Double.valueOf(obj.getValorImpuestoConsumo()));
        per.setPorcentajeRetefuente(Double.valueOf(obj.getPorcentajeRetefuente()));
        per.setValorRetefuente(Double.valueOf(obj.getValorRetefuente()));
        per.setValorIva(Double.valueOf(obj.getValorIva()));
        per.setTotal(Double.valueOf(obj.getTotal()));
        per.setAnticipo(Double.valueOf(obj.getAnticipo()));
        per.setPlazo(obj.getPlazo());
        per.setElaboro(obj.getUsuarioCrea());

        //Valores finales
//        per.setSubTotal(BigDecimal.valueOf(obj.getSubTotal()));
//        per.setValorDescuento(BigDecimal.valueOf(obj.getValorDescuento()));
//        per.setValorAdicional(BigDecimal.valueOf(obj.getValorAdicional()));

//        per.setPorcentajeRetefuente(obj.getPorcentajeRetefuente());
//        per.setValorRetefuente(BigDecimal.valueOf(obj.getValorRetefuente()));
//        per.setPorcentajeImpuestoConsumo(obj.getPorcentajeImpuestoConsumo());
//        per.setValorImpuestoConsumo(BigDecimal.valueOf(obj.getValorImpuestoConsumo()));
//        per.setValorIva(BigDecimal.valueOf(obj.getValorIva()));
//        per.setTotal(BigDecimal.valueOf(obj.getTotal()));
//        per.setAnticipo(BigDecimal.valueOf(obj.getAnticipo()));
//        per.setPlazo(obj.getPlazo());
//        per.setSolicito(obj.getSolicito());
//        per.setReviso(obj.getReviso());
        per.setAprobo(obj.getAprobo());
        //Auditoria
//        per.setUsuarioCrea(obj.getUsuarioCrea());
//        per.setTerminalCrea(obj.getTerminalCrea());
//        per.setFechaHoraCrea(obj.getFechaHoraCrea());
//        per.setUsuarioModifica(obj.getUsuarioModifica());
//        per.setTerminalModifica(obj.getTerminalModifica());
//        per.setFechaHoraModifica(obj.getFechaHoraModifica());
        return per;
    }
//
//    public static OrdenDetalle castEntidadNegocio(FiOrdenDetalles per) {
//        OrdenDetalle obj = new OrdenDetalle();
//        obj.setId(per.getId());
//        obj.setDescripcion(per.getDescripcion());
//        obj.setMaeUnidadMedida(per.getMaeUnidadMedida());
//        //Valores finales
//        obj.setCantidad(per.getCantidad());
//        obj.setValorUnitario(per.getValorUnitario().doubleValue());
//        obj.setSubTotal(per.getSubTotal().doubleValue());
//        obj.setPorcentajeIva(per.getPorcentajeIva());
//        obj.setValorIva(per.getValorIva().doubleValue());
//        obj.setTotal(per.getTotal().doubleValue());
//        //Auditoría
//        obj.setUsuarioCrea(per.getUsuarioCrea());
//        obj.setTerminalCrea(per.getTerminalCrea());
//        obj.setFechaHoraCrea(per.getFechaHoraCrea());
//        return obj;
//    }
//
//    public static OrdenReporte castEntidadNegocioReporte(Orden ord, FiOrdenDetalles per) {
//        OrdenReporte obj = new OrdenReporte();
//
//        try {
//            obj.setRow_num(per.getId());
//            obj.setId(per.getId());
//            obj.setTipo_orden(String.valueOf(ord.getMaeTipoOrden()));//Maestro
//            obj.setFecha_orden(ord.getFechaOrden());
//            obj.setActa_tipo(String.valueOf(ord.getMaeActaTipo()));
//            obj.setActa_numero(ord.getActaNumero());
//            obj.setActa_fecha(ord.getActaFecha());
//            obj.setProveedor_id(ord.getProveedor().getDocumento());
//            obj.setSolicito(ord.getSolicito());
//            obj.setReviso(ord.getReviso());
//
//            obj.setAprobo(ord.getAprobo());
//            obj.setValor_descuento(ord.getValorDescuento());
//            obj.setSub_total_sin_iva(ord.getSubTotalSinIva());
//            obj.setSub_total(ord.getSubTotal());
//            obj.setValor_impuesto_consumo(ord.getValorImpuestoConsumo());
//            obj.setValor_retefuente(ord.getValorRetefuente());
//            obj.setValor_iva(ord.getValorIva());
//            obj.setTotal(ord.getTotal());
//            obj.setAnticipo(ord.getAnticipo());
//            obj.setPlazo(ord.getPlazo());
//            obj.setValor_adicional(ord.getValorAdicional());
//
//            obj.setNombre_comercial(ord.getProveedor().getNombreComercial());
//            obj.setContacto_proveedor(ord.getProveedor().getNombreRepresentante());
//            obj.setTelefono(ord.getProveedor().getTelefono());
//            obj.setDepartamento(ord.getProveedor().getUbicacion().getUbicacionPadre().getNombre());//ord.getProveedor().getUbicacion().getUbicacionPadre().getNombre()//Maestro
//            obj.setMunicipio(ord.getProveedor().getUbicacion().getNombre());//ord.getProveedor().getUbicacion().getNombre()//Maestro
//            obj.setDireccion(ord.getProveedor().getDireccion());//ord.getProveedor().getDireccion()//Maestro
//            obj.setEmail(ord.getProveedor().getContactoCorreoElectronico());
//            obj.setMae_tipo_documento_representante(String.valueOf(ord.getProveedor().getMaeTipoDocumento()));//Maestro
//            obj.setDocumento(ord.getProveedor().getDocumento());//Maestro  ord.getProveedor().getEmpresa().getNit()
//            obj.setDigito_verificacion("0");//Maestro
//
//            obj.setClasificacion_proveedor("");
//            obj.setNaturaleza_proveedor("");
//            obj.setDescripcion(per.getDescripcion());
//            obj.setUnidad_medida(String.valueOf(per.getMaeUnidadMedida()));//per.getMaeUnidadMedida()//Maestro
//            obj.setCantidad(per.getCantidad());
//            obj.setValor_unitario(per.getValorUnitario().doubleValue());
//            obj.setDetalle_sub_total(per.getSubTotal().doubleValue());
//            obj.setDetalle_valor_iva(per.getValorIva().doubleValue());
//            obj.setPorcentaje_iva(new Double(per.getPorcentajeIva()));
//            obj.setDetalle_total(per.getTotal().doubleValue());
//
//            //String[] strIdentificacion =  ord.getProveedor().getDocumento().split("-");
//            obj.setNit(ord.getProveedor().getDocumento());//ord.getProveedor().getDocumento()//Maestro
//            obj.setDigito("0");
//            obj.setClasificacion("");//Contacto
//            obj.setNaturaleza("");//Contacto
//            obj.setObservaciones(ord.getObservacion());
//            obj.setTipo_identificacion(String.valueOf(ord.getProveedor().getMaeTipoDocumento()));//Maestro
//
//            //obj.setMaeUnidadMedida(per.getMaeUnidadMedida());
//            //obj.setValorUnitario(per.getValorUnitario());
//            //Auditoría
//            obj.setUsuarioCrea(per.getUsuarioCrea());
//            obj.setTerminalCrea(per.getTerminalCrea());
//            obj.setFechaHoraCrea(per.getFechaHoraCrea());
//
//            obj.setProceso(ord.getArea().getNombre());
//            obj.setSubgerencia(ord.getArea().getArea().getNombre());//ord.getArea().getArea().getNombre()//Maestro
//
//        } catch (Exception e) {
//            System.out.println("Campo con error en reporte" + e.toString() + " " + e.getMessage());
//        };
//        return obj;
//    }
//    public static FiOrdenDetalles castNegocioEntidad(OrdenDetalle obj) {
//        FiOrdenDetalles per = new FiOrdenDetalles();
//        per.setFiOrdenesId(new FiOrdenes(obj.getOrden().getId()));
//        per.setId(obj.getId());
//        per.setDescripcion(obj.getDescripcion());
//        per.setMaeUnidadMedida(obj.getMaeUnidadMedida());
//        //Valores finales
//        per.setCantidad(obj.getCantidad());
//        per.setValorUnitario(BigDecimal.valueOf(obj.getValorUnitario()));
//        per.setSubTotal(BigDecimal.valueOf(obj.getSubTotal()));
//        per.setPorcentajeIva(obj.getPorcentajeIva());
//        per.setValorIva(BigDecimal.valueOf(obj.getValorIva()));
//        per.setTotal(BigDecimal.valueOf(obj.getTotal()));
//        //Auditoria
//        per.setUsuarioCrea(obj.getUsuarioCrea());
//        per.setTerminalCrea(obj.getTerminalCrea());
//        per.setFechaHoraCrea(obj.getFechaHoraCrea());
//        return per;
//    }
}
