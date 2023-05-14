/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.administracion.servicio;

import com.domiciliosenvia.domicilio.web.administracion.bean.EmpresaBean;
import com.domiciliosenvia.domicilio.dominio.administracion.Empresa;
import com.domiciliosenvia.domicilio.dominio.administracion.Ubicacion;
import com.domiciliosenvia.domicilio.negocio.administracion.EmpresaRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.MaestroRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.UbicacionRemoto;
//import com.domiciliosenvia.domicilio.negocio.autorizacion.AuAnexo3Remoto;
//import com.domiciliosenvia.domicilio.negocio.contratacion.CntPrestadorRemoto;
import com.domiciliosenvia.domicilio.web.utilidades.AccionesBO;
import com.domiciliosenvia.domicilio.web.utilidades.RemotoEJB;
import com.domiciliosenvia.domicilio.web.utilidades.Url;

/**
 *
 * @author raul-palacios
 */
public class EmpresaServicioImpl extends AccionesBO implements EmpresaServicioIface {

    private Empresa per = new Empresa();

    private EmpresaRemoto getEmpresaRemoto() throws Exception {
        return (EmpresaRemoto) RemotoEJB.getEJBRemoto("EmpresaServicio", EmpresaRemoto.class.getName());
    }

    private UbicacionRemoto getUbicacionRemoto() throws Exception {
        return (UbicacionRemoto) RemotoEJB.getEJBRemoto("UbicacionServicio", UbicacionRemoto.class.getName());
    }

    private MaestroRemoto getMaestroRemoto() throws Exception {
        Object object = RemotoEJB.getEJBRemoto("MaestroServicio", MaestroRemoto.class.getName());
        return (MaestroRemoto) object;
    }

//    private CntPrestadorRemoto getPrestadorRemoto() throws Exception {
//        return (CntPrestadorRemoto) RemotoEJB.getEJBRemoto("CntPrestadorServicio", CntPrestadorRemoto.class.getName());
//    }

//    private AuAnexo3Remoto getAuAnexo3Remoto() throws Exception {
//        return (AuAnexo3Remoto) RemotoEJB.getEJBRemoto("AuAnexo3Servicio", AuAnexo3Remoto.class.getName());
//    }

    @Override
    public void Accion(EmpresaBean bean) {
        if (super.ValidarSesion(bean)) {
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

    private void listar(EmpresaBean bean) {
        try {
            bean.getParamConsulta().setCantidadRegistros(getEmpresaRemoto().consultarCantidadLista(bean.getParamConsulta()));
            bean.setRegistros(getEmpresaRemoto().consultarLista(bean.getParamConsulta()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void ver(EmpresaBean bean) {
        try {
            bean.setObjeto(getEmpresaRemoto().consultar(bean.getObjeto().getId()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void crear(EmpresaBean bean) {
        try {
            bean.setObjeto(new Empresa());
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void editar(EmpresaBean bean) {
        try {
            per.setId(bean.getObjeto().getId());
            bean.setObjeto(getEmpresaRemoto().consultar(per.getId()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void guardar(EmpresaBean bean) {
        try {
            bean.auditoriaGuardar(bean.getObjeto());
            bean.getObjeto().setId(getEmpresaRemoto().insertar(bean.getObjeto()));
            bean.addMensaje("Se creo un registro de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void modificar(EmpresaBean bean) {
        try {
            bean.auditoriaModificar(bean.getObjeto());
            getEmpresaRemoto().actualizar(bean.getObjeto());
            bean.addMensaje("Se actualizó el registro de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void borrar(EmpresaBean bean) {
        try {
            per = new Empresa();
            per.setId(bean.getObjeto().getId());
            bean.setObjeto(getEmpresaRemoto().eliminar(per.getId()));
            bean.addMensaje("Se eliminó un registro de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    private void cargas(EmpresaBean bean) {
        try {
            switch (bean.getAccion()) {
                case Url.ACCION_LISTAR:
                    bean.setUbicacionesRecursiva(getUbicacionRemoto().consultarMunicipios());
                    bean.setUbicaciones(getUbicacionRemoto().consultarPorTipo(Ubicacion.TIPO_MUNICIPIO));
                    break;
                case Url.ACCION_VER:
                    break;
                case Url.ACCION_CREAR:
                case Url.ACCION_EDITAR:
                    bean.setUbicacionesRecursiva(getUbicacionRemoto().consultarMunicipios());
                    bean.setUbicaciones(getUbicacionRemoto().consultarPorTipo(Ubicacion.TIPO_MUNICIPIO));
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public Empresa objetoConverter(Empresa per) {
        return per;
    }

    @Override
    public void cargaInicial(EmpresaBean bean) {
        try {

        } catch (Exception ex) {
            bean.addError(ex.toString());
        }
    }

    @Override
    public void listarIps(EmpresaBean bean) {
        try {
//            bean.getParamConsulta2().setCantidadRegistros(getPrestadorRemoto().consultarCantidadLista(bean.getParamConsulta2()));
//            bean.setListaIps(getPrestadorRemoto().consultarLista(bean.getParamConsulta2()));
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

}
