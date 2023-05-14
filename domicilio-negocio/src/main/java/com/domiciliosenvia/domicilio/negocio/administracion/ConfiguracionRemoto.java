/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.negocio.administracion;

import com.domiciliosenvia.domicilio.dominio.administracion.GnConfiguracionObj;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rpalacic
 */
public interface ConfiguracionRemoto {
    
    /**
     * 
     * @param paramConsulta
     * @return
     * @throws Exception 
     */
    int consultarCantidadLista(ParamConsulta paramConsulta) throws Exception;
    
    /**
     * 
     * @param paramConsulta
     * @return
     * @throws Exception 
     */
    List<GnConfiguracionObj> consultarLista(ParamConsulta paramConsulta) throws Exception;
    
    /**
     * Método para consultar un maestro por ID
     * @param id
     * @return 
     * @throws java.lang.Exception 
     */
    GnConfiguracionObj consultar(int id) throws Exception;
    
    /**
     * Método para crear un nuev maestro
     * @param obj (GnConfiguracionObjs)
     * @return (int) id del registro generado
     * @throws java.lang.Exception
     */
    int insertar(GnConfiguracionObj obj) throws Exception;
    
    /**
     * Método para actualizar la información de un maestro
     * @param obj (GnConfiguracionObjs)
     * @throws java.lang.Exception
     */
    void actualizar(GnConfiguracionObj obj) throws Exception;
    
    /**
     * Metodo para consultar un nuevo Id para guardar
     * @return (int) id más alto de la tabla
     * @throws Exception 
     */
    int consultarIdNuevo() throws Exception;
    
    /**
     * Método para consultar los maestros activos por tipo
     * @return (HashMap<Integer, String>) Hash con los maestros cargados 
     */
    HashMap<Integer, String> consultarHash();
   
}
