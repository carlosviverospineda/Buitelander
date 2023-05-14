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
import com.domiciliosenvia.domicilio.web.conexion.bean.ContrasenaBean;
import com.domiciliosenvia.domicilio.web.conexion.bean.LoginBean;
import java.util.List;

/**
 *
 * @author raul-palacios
 */
public interface ConexionServicioIface {
    
    /**
     * 
     * @param obj
     * @return
     * @throws Exception 
     */
    Login validaConexion(Login obj)throws Exception;
    
    /**
     * 
     * @return 
     * @throws java.lang.Exception 
     */
    List<Empresa> consultarEmpresasActivas()throws Exception;
    
    /**
     * 
     * @param obj
     * @return 
     */
    List<Modulo> consultarModulosPermiso(Usuario obj);
    
    /**
     * 
     * @param obj
     * @return 
     */
    Modulo consultarArbolModuloPorUsuario(Usuario obj);
    
    /**
     * 
     * @param empresa
     * @return 
     */
    Empresa cambiarEmpresa(Empresa empresa);
    
    /**
     * 
     * @param bean 
     */
    void cambiarContrasena(ContrasenaBean bean);
    
    /**
     * 
     * @param obj
     * @throws Exception 
     */
    void restaurarContrasena(Login obj) throws Exception;
    
    /**
     * Método para consultar la versión actual del sistema
     * @param bean
     * @return 
     * @throws Exception 
     */
    ModuloVersion consultarVersion() throws Exception;
    
    /**
     * Método para consultar el manual del sistema
     * @param id
     * @return
     * @throws Exception 
     */
    ModuloManual consultarManual(int id, int tipo) throws Exception;
    
}
