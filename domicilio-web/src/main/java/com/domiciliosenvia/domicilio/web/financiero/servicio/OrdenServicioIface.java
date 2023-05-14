/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.financiero.servicio;

import com.domiciliosenvia.domicilio.web.financiero.bean.OrdenBean;

/**
 *
 * @author raul-palacios
 */
public interface OrdenServicioIface {
    
    void Accion(OrdenBean bean);
    
    /**
     * Cargar lista de Zonas
     * @param bean 
     */
    void cargaInial(OrdenBean bean);
    
}
