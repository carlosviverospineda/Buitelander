/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.negocio.financiero;

import com.domiciliosenvia.domicilio.dominio.financiero.Orden;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import java.util.List;

/**
 *
 * @author jramirer
 */
public interface OrdenRemoto {
    
    /**
     * Consulta de cantidad de registros en una lista
     * @param paramConsulta
     * @return
     * @throws Exception 
     */
    int consultarCantidadLista(ParamConsulta paramConsulta) throws Exception;
    
    /**
     * Consultar lista de registros
     * @param paramConsulta
     * @return
     * @throws Exception 
     */
    List<Orden> consultarLista(ParamConsulta paramConsulta) throws Exception;
    
    /**
     * Método para consultar un registro por ID
     * @param id
     * @return (Ordenes) cargado
     * @throws java.lang.Exception
     */
    Orden consultar(int id) throws Exception;
//    
//    Orden consultarReporteOC(int id) throws Exception;
    /**
     * Método para crear una nuevo registro
     * @param obj (Ordenes)
     * @return (int) id del registro generado
     * @throws java.lang.Exception
     */
    int insertar(Orden obj) throws Exception;
    
    /**
     * Método para actualizar la información de un registro
     * @param obj (Ordenes)
     * @throws java.lang.Exception
     */
////    void actualizar(Orden obj) throws Exception;
    
    /**
     * Método para eliminar un registro
     * @param id
     * @return (Ordenes) La persistencia del objeto eliminado
     * @throws java.lang.Exception
     */
//    Orden eliminar(int id) throws Exception;
    
    /**
     * Consultar todas las Ordenes
     * @param empresaId
     * @return
     * @throws Exception 
     */
//    List<Orden> consultarTodos(int empresaId) throws Exception;
    
}
