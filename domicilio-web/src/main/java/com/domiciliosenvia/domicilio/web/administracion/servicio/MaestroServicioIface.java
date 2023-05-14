/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.administracion.servicio;

import com.domiciliosenvia.domicilio.dominio.administracion.Maestro;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroAccion;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroTipo;
import com.domiciliosenvia.domicilio.web.administracion.bean.MaestroBean;
import java.util.List;

/**
 *
 * @author rpalacic (SystemTech Integral)
 */
public interface MaestroServicioIface {

    void Accion(MaestroBean bean);
    
    /**
     * Carga inicial de la opción
     * @param bean 
     */
    void cargasInicial(MaestroBean bean);
    
    /**
     * Consultar MaestroTipo padre por tipo hijo
     * @param tipo
     * @return 
     */
    List<MaestroTipo> consultarDependenciaPadre(String tipo);
    
    /**
     * Consulta lista de depéndencias
     * @param tipo
     * @return 
     */
    List<Maestro> listaDependencias(String tipo);
    
    /**
     * Consulta de liosta de Acciones
     * @param tipo
     * @return 
     */
    List<MaestroAccion> listaAcciones(String tipo);

//    /**
//     * Método para consultar acciones por tipo de maestro
//     * @param tipo
//     * @return 
//     */
//    List<MaestroAccion> consultarAcciones(String tipo);    
//    
//    /**
//     * Método para consultar lista de dependencias por maestro 
//     * @param tipoDependencia
//     * @return  
//     */
//    List<Maestro> ListarDependencias(String tipoDependencia);
    
}
