/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author raul-palacios
 */
public class AccionesBO {
    
    /**
     * Metodo para realizar la validación de la sesion actual y los permisos del
     * usuario de la occion a ejecutar sobre la opcion seleccionada 
     * @param url
     * @return (boolena) indica si la validacion fue exitosa o no
     */
    protected boolean ValidarSesion(Url url){
        boolean validado = true;
        switch(url.getAccion()){
                case Url.ACCION_LISTAR:
                    if(!url.isAccionListar()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_VER:
                    if(!url.isAccionVer()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_CREAR:
                    if(!url.isAccionCrear()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_GUARDAR:
                    if(!url.isAccionGuardar()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_EDITAR:
                    if(!url.isAccionEditar()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_MODIFICAR:
                    if(!url.isAccionModificar()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_BORRAR:
                    if(!url.isAccionBorrar()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_ADICIONAL_1:
                    if(!url.isAccionAdicional1()){
                        validado = false;
                    }
                    break;
                case Url.ACCION_ADICIONAL_2:
                    if(!url.isAccionAdicional2()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_3:
                    if(!url.isAccionAdicional3()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_4:
                    if(!url.isAccionAdicional4()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_5:
                    if(!url.isAccionAdicional5()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_6:
                    if(!url.isAccionAdicional6()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_7:
                    if(!url.isAccionAdicional7()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_8:
                    if(!url.isAccionAdicional8()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_9:
                    if(!url.isAccionAdicional9()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_10:
                    if(!url.isAccionAdicional10()){
                        validado = false;
                    } 
                    break;
                case Url.ACCION_ADICIONAL_11:
                    if(!url.isAccionAdicional11()){
                        validado = false;
                    } 
                    break;
                default:
                    break;
            }
        if(!validado){
            try{
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "INTENTO DE VIOLACIÓN DE SEGURIDAD DEL SISTEMA", "Intento ejecutar una acción para la que no tiene permisos"));
                String _ruta = request.getContextPath();
                FacesContext.getCurrentInstance().getExternalContext().redirect(_ruta+"/");
            }catch(Exception ex){}
        }
        return validado;
    }
    
}
