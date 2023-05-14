/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.administracion.servicio;

import com.domiciliosenvia.domicilio.web.administracion.bean.PerfilBean;
import com.domiciliosenvia.domicilio.dominio.administracion.Perfil;
import java.util.List;

/**
 *
 * @author raul-palacios
 */
public interface PerfilServicioIface {

    void Accion(PerfilBean bean);

    List<Perfil> consultarLista();
}
