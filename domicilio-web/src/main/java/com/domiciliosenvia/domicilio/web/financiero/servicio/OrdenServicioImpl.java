/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.financiero.servicio;

import com.domiciliosenvia.domicilio.dominio.administracion.Maestro;
import com.domiciliosenvia.domicilio.dominio.financiero.Orden;
//import com.domiciliosenvia.domicilio.dominio.registro.Area;
//import com.domiciliosenvia.domicilio.dominio.registro.Persona;
//import com.domiciliosenvia.domicilio.dominio.registro.Proveedor;
import com.domiciliosenvia.domicilio.negocio.administracion.MaestroRemoto;
import com.domiciliosenvia.domicilio.negocio.financiero.OrdenRemoto;
import com.domiciliosenvia.domicilio.web.utilidades.AccionesBO;
import com.domiciliosenvia.domicilio.web.utilidades.RemotoEJB;
import com.domiciliosenvia.domicilio.web.utilidades.Url;
//import com.domiciliosenvia.domicilio.negocio.registro.AreaRemoto;
//import com.domiciliosenvia.domicilio.negocio.registro.ProveedorRemoto;
import com.domiciliosenvia.domicilio.web.financiero.bean.OrdenBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author raul-palacios
 */
public class OrdenServicioImpl extends AccionesBO implements OrdenServicioIface {

    private OrdenRemoto getOrdenRemoto() throws Exception {
        return (OrdenRemoto) RemotoEJB.getEJBRemoto("OrdenServicio", OrdenRemoto.class.getName());
    }
//
//    private ProveedorRemoto getProveedorRemoto() throws Exception {
//        return (ProveedorRemoto) RemotoEJB.getEJBRemoto("ProveedorServicio", ProveedorRemoto.class.getName());
//    }
//
////    private PersonaRemoto getPersonaRemoto() throws Exception {
////        return (PersonaRemoto) RemotoEJB.getEJBRemoto("PersonaServicio", PersonaRemoto.class.getName());
////    }
//
//    private AreaRemoto getAreaRemoto() throws Exception {
//        return (AreaRemoto) com.domiciliosenvia.domicilio.web.utilidades.RemotoEJB.getEJBRemoto("AreaServicio", AreaRemoto.class.getName());
//    }

    private MaestroRemoto getMaestroRemoto() throws Exception {
        return (MaestroRemoto) RemotoEJB.getEJBRemoto("MaestroServicio", MaestroRemoto.class.getName());
    }

    @Override
    public void Accion(OrdenBean bean) {
        if (super.ValidarSesion(bean)) {
//            bean.getObjeto().setEmpresa(bean.getConexion().getEmpresa());
            switch (bean.getAccion()) {
                case Url.ACCION_LISTAR:
                    listar(bean);
                    break;
                case Url.ACCION_VER:
                    ver(bean);
                    break;
                case Url.ACCION_CREAR:
                    crear(bean);
                    break;
                case Url.ACCION_GUARDAR:
                    guardar(bean);
                    break;
                case Url.ACCION_EDITAR:
                    editar(bean);
                    break;
                case Url.ACCION_MODIFICAR:
                    modificar(bean);
                    break;
                case Url.ACCION_BORRAR:
                    borrar(bean);
                    break;
                case Url.ACCION_ADICIONAL_1:
                    generarReporteOC(bean);
                    break;
                case Url.ACCION_ADICIONAL_2:
                    break;
                case Url.ACCION_ADICIONAL_3:
                    break;
                default:
                    break;
            }
            cargas(bean);
        } else {
            System.err.println("Sesion inactiva");
        }
    }

    private void listar(OrdenBean bean) {
        try {
            bean.getParamConsulta().setCantidadRegistros(getOrdenRemoto().consultarCantidadLista(bean.getParamConsulta()));
            bean.setRegistros(getOrdenRemoto().consultarLista(bean.getParamConsulta()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void ver(OrdenBean bean) {
        try {
            bean.setObjeto(getOrdenRemoto().consultar(bean.getObjeto().getId()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void generarReporteOC(OrdenBean bean) {
        try {
//            bean.getObjeto().setEmpresa(bean.getConexion().getEmpresa());
//            bean.setHashMaeTiposDocumento(getMaestroRemoto().consultarHashPorTipo(Maestro.GN_TIPO_DOCUMENTO));
//            bean.setObjeto(getOrdenRemoto().consultarReporteOC(bean.getObjeto().getId()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void crear(OrdenBean bean) {
        try {
            bean.setObjeto(new Orden());
//            bean.setListaDetalles(new ArrayList());
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void editar(OrdenBean bean) {
        try {
//            bean.setObjeto(getOrdenRemoto().consultar(bean.getObjeto().getId()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void guardar(OrdenBean bean) {
        try {
//            bean.auditoriaGuardar(bean.getObjeto());
//            getOrdenRemoto().insertar(bean.getObjeto());
            bean.addMensaje("Se creo un registro de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void modificar(OrdenBean bean) {
        try {
//            bean.auditoriaModificar(bean.getObjeto());
//            getOrdenRemoto().actualizar(bean.getObjeto());
            bean.addMensaje("Se actualizó un registro de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void borrar(OrdenBean bean) {
        try {
//            bean.setObjeto(getOrdenRemoto().eliminar(bean.getObjeto().getId()));
            bean.addMensaje("Se eliminó un registro de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void cargas(OrdenBean bean) {
        try {
            switch (bean.getAccion()) {
                case Url.ACCION_LISTAR:
                    break;
                case Url.ACCION_VER:
                    break;
                case Url.ACCION_CREAR:
                case Url.ACCION_EDITAR:
                    break;
                case Url.ACCION_ADICIONAL_1:
                    generarReporteOC(bean);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public void cargaInial(OrdenBean bean) {
        try {
            //CARGAR PROVEEDORES
//            HashMap<Integer, Proveedor> hashProveedores = new HashMap();
//            List<Proveedor> listaProveedores = getProveedorRemoto().consultarTodas(bean.getConexion().getEmpresa().getId());
//            for (Proveedor proveedor : listaProveedores) {
//                hashProveedores.put(proveedor.getId(), proveedor);
//            }
//            bean.setListaProveedores(listaProveedores);
//            bean.setHashProveedores(hashProveedores);
            //CARGAR AREAS
//            HashMap<Integer, Area> hashAreas = new HashMap();
//            List<Area> listaAreas = getAreaRemoto().consultarTodas(bean.getConexion().getEmpresa().getId());
//            for (Area area : listaAreas) {
//                hashAreas.put(area.getId(), area);
//            }
//            bean.setListaAreas(listaAreas);
//            bean.setHashAreas(hashAreas);
//            //CARGAR PERSONAS
//            HashMap<Integer, Persona> hashPersonas = new HashMap();
//            List<Persona> listaPersonas = getPersonaRemoto().consultarTodas(bean.getConexion().getEmpresa().getId());
//            for (Persona persona : listaPersonas) {
//                hashPersonas.put(persona.getId(), persona);
//            }
//            bean.setListaPersonas(listaPersonas);
//            bean.setHashPersonas(hashPersonas);
            //CARGA DE MAESTROS
//            bean.setListaMaeTiposOrden(getMaestroRemoto().consultarPorTipo(Maestro.FI_TIPO_ORDEN));
//            bean.setHashMaeTiposOrden(getMaestroRemoto().consultarHashPorTipo(Maestro.FI_TIPO_ORDEN));
//            bean.setListaMaeTiposActa(getMaestroRemoto().consultarPorTipo(Maestro.FI_TIPO_ACTA));
//            bean.setHashMaeTiposActa(getMaestroRemoto().consultarHashPorTipo(Maestro.FI_TIPO_ACTA));
//            bean.setListaMaeUnidades(getMaestroRemoto().consultarPorTipo(Maestro.FI_UNIDAD_MEDIDA));
//            bean.setHashMaeUnidades(getMaestroRemoto().consultarHashPorTipo(Maestro.FI_UNIDAD_MEDIDA));

        } catch (Exception ex) {
        }
    }

}
