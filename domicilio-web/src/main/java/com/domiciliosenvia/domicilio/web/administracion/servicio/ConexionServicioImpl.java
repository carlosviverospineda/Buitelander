/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.administracion.servicio;

import com.domiciliosenvia.domicilio.dominio.administracion.Empresa;
import com.domiciliosenvia.domicilio.dominio.administracion.Login;
import com.domiciliosenvia.domicilio.dominio.administracion.Modulo;
import com.domiciliosenvia.domicilio.dominio.administracion.ModuloManual;
import com.domiciliosenvia.domicilio.dominio.administracion.ModuloVersion;
import com.domiciliosenvia.domicilio.dominio.administracion.Usuario;
import com.domiciliosenvia.domicilio.negocio.administracion.ConexionRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.EmpresaRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.ModuloManualRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.ModuloRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.ModuloVersionRemoto;
import com.domiciliosenvia.domicilio.negocio.administracion.UsuarioRemoto;
import com.domiciliosenvia.domicilio.web.conexion.bean.ContrasenaBean;
import com.domiciliosenvia.domicilio.web.utilidades.Correo;
import com.domiciliosenvia.domicilio.web.utilidades.GeneradorContrasena;
import com.domiciliosenvia.domicilio.web.utilidades.RemotoEJB;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author raul-palacios
 */
public class ConexionServicioImpl implements ConexionServicioIface {

    private ConexionRemoto getConexionRemoto() throws Exception {
        return (ConexionRemoto) RemotoEJB.getEJBRemoto("ConexionServicio", ConexionRemoto.class.getName());
    }

    private ModuloRemoto getModuloRemoto() throws Exception {
        return (ModuloRemoto) RemotoEJB.getEJBRemoto("ModuloServicio", ModuloRemoto.class.getName());
    }

    private EmpresaRemoto getEmpresaRemoto() throws Exception {
        return (EmpresaRemoto) RemotoEJB.getEJBRemoto("EmpresaServicio", EmpresaRemoto.class.getName());
    }

    private UsuarioRemoto getUsuarioRemoto() throws Exception {
        return (UsuarioRemoto) RemotoEJB.getEJBRemoto("UsuarioServicio", UsuarioRemoto.class.getName());
    }
    
    private ModuloVersionRemoto getModuloVersionRemoto() throws Exception {
        return (ModuloVersionRemoto) RemotoEJB.getEJBRemoto("ModuloVersionServicio", ModuloVersionRemoto.class.getName());
    }
    
    private ModuloManualRemoto getModuloManualRemoto() throws Exception {
        return (ModuloManualRemoto) RemotoEJB.getEJBRemoto("ModuloManualServicio", ModuloManualRemoto.class.getName());
    }

    @Override
    public Login validaConexion(Login obj) throws Exception {
        Usuario usu = getConexionRemoto().validarConexion(obj);
        obj = new Login();
        try {
            obj.setUsuario(new Usuario());
            obj.getUsuario().setEmpresa(new Empresa());
            obj.setEmpresa(new Empresa());
            if (usu != null) {//Conectado
                obj.setUsuario(usu);
                obj.setEmpresa(usu.getEmpresa());
                obj.setConectado(true);
                getUsuarioRemoto().registroConexion(usu);
            } else {
                obj.setConectado(false);
            }
        } catch (Exception e) {
            throw new Exception("Error en la validación: " + e.getMessage());
        }
        return obj;
    }

    @Override
    public List<Empresa> consultarEmpresasActivas() throws Exception {
        List<Empresa> list = getEmpresaRemoto().consultarActivas();
        return list;
    }

    @Override
    public Empresa cambiarEmpresa(Empresa obj) {
        Empresa objResp = null;
        try {
            objResp = getEmpresaRemoto().consultar(obj.getId());
        } catch (Exception ex) {
//            bean.setError(ex.getMessage());
        }
        if (!obj.isActiva()) {
            objResp = null;
        }
        return objResp;
    }

    @Override
    public List<Modulo> consultarModulosPermiso(Usuario obj) {
        List<Modulo> lista = new ArrayList();
        try {
//            lista = getModuloRemoto().consultarModulosPorUsuario(obj);
            for (Modulo mod : getModuloRemoto().consultarModulosPorUsuario(obj)) {
                Modulo _obj = new Modulo();
                _obj.setId(mod.getId());
                _obj.setTipo(mod.getTipo());
                _obj.setNombre(mod.getNombre());
                _obj.setDescripcion(mod.getDescripcion());
                _obj.setActivo(mod.isActivo());
                _obj.setOrden(mod.getOrden());
                _obj.setPrivilegios(mod.getPrivilegios());
                _obj.setUrl(mod.getUrl());
                _obj.setVersion(mod.getVersion());
                _obj.setFechaVersion(mod.getFechaVersion());
                lista.add(_obj);
            }
        } catch (Exception ex) {
//            Logger.getLogger(ConexionServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Modulo consultarArbolModuloPorUsuario(Usuario obj) {
        Modulo mod;
        try {
            mod = getModuloRemoto().consultarArbolModuloPorUsuario(obj);
        } catch (Exception ex) {
            mod = null;
        }
        return mod;
    }

    @Override
    public void cambiarContrasena(ContrasenaBean bean) {
        try {
            if (bean.getContrasenaActual().trim().equals("")
                    || bean.getContrasenaNueva1().trim().equals("")
                    || bean.getContrasenaNueva2().trim().equals("")) {
                throw new Exception("Todos los campos son obligatorios");
            }
            String nuevaContrasena1 = bean.getContrasenaNueva1();
            String nuevaContrasena2 = bean.getContrasenaNueva2();
            if (!nuevaContrasena1.equals(nuevaContrasena2)) {
                throw new Exception("La nueva contraseña y su verificación no coinciden");
            }
            Usuario obj = new Usuario();
            obj.setId(bean.getIdUsuario());
            obj.setContrasena(bean.getContrasenaActual());
            obj = getUsuarioRemoto().validarUsuario(obj);
            if (obj != null) {
                obj.setContrasena(nuevaContrasena1);
                getUsuarioRemoto().cambioContrasena(obj);
            } else {
                throw new Exception("Contraseña inválida");
            }
            bean.addMensaje("Se cambio la contraseña de manera exitosa");
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }

    @Override
    public void restaurarContrasena(Login obj) throws Exception {
        Usuario usu = getUsuarioRemoto().consultarPorUsuario(obj.getUsuario().getUsuario());
        usu.setContrasena(GeneradorContrasena.getPassword());
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String RequestURI = request.getRequestURI();
        String requiestURL = String.valueOf(request.getRequestURL());
        String ContextPath = request.getContextPath();
        String url = requiestURL.replace(RequestURI, "") + ContextPath + "/";
        String correo = usu.getCorreoElectronico();
        String encabezado = "Sistema Savia: Restauración de contraseña";
        String mensaje = "Señor " + usu.getNombre() + ". Su contraseña, la cual corresponde al usuario " + usu.getUsuario() + ", ha sido restablecida. Su nueva contraseña es :" + usu.getContrasena();
        getUsuarioRemoto().cambioContrasena(usu);
        new Thread(new Correo(correo, encabezado, mensaje)).start();
    }
    
    
    
    @Override
    public ModuloVersion consultarVersion() throws Exception {
        return getModuloVersionRemoto().consultarActualByModulo(1);
    }
    
    @Override
    public ModuloManual consultarManual(int id, int tipo) throws Exception {
        return getModuloManualRemoto().consultarXModulo(id, true, tipo);
    }

}
