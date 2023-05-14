/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.negocio.administracion;

import com.domiciliosenvia.domicilio.dominio.administracion.Ubicacion;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rpalacic
 */
public interface UbicacionRemoto {

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
    List<Ubicacion> consultarLista(ParamConsulta paramConsulta) throws Exception;

    /**
     * Método para consultar una empresa por ID
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    Ubicacion consultar(int id) throws Exception;

    /**
     * Método para crear una nueva Ubicacion
     *
     * @param obj (Ubicaciones)
     * @return (int) id del registro generado
     * @throws java.lang.Exception
     */
    int insertar(Ubicacion obj) throws Exception;

    /**
     * Método para actualizar la información de una Ubicacion
     *
     * @param obj (Ubicaciones)
     * @throws java.lang.Exception
     */
    void actualizar(Ubicacion obj) throws Exception;

    /**
     * Método para eliminar una Ubicacion
     *
     * @param id
     * @return (Ubicaciones) Objeto eliminado
     * @throws java.lang.Exception
     */
    Ubicacion eliminar(int id) throws Exception;

    /**
     * Método para consultar todas las Ubicaciones activas.
     *
     * @return
     * @throws java.lang.Exception
     */
    List<Ubicacion> consultarActivas() throws Exception;

    /**
     * Método para consultar lista de ubicaciones de un tipo con profundidad
     *
     * @param tipo
     * @return Lista de ubicaciones
     * @throws java.lang.Exception
     */
    List<Ubicacion> consultarPorTipo(int tipo) throws Exception;

    /**
     * Método para consultar hash de departamentos de un tipo con profundidad
     *
     * @param tipo
     * @return Lista de ubicaciones
     * @throws java.lang.Exception
     */
    HashMap<Integer, Ubicacion> consultarDepartamentos() throws Exception;

    /**
     * Método para consultar la Ubicación padre de una Ubicación específica
     *
     * @param idHijo
     * @return Ubicación padre
     * @throws Exception
     */
    Ubicacion consultarPadre(int idHijo) throws Exception;

    /**
     * Método para consultar la los hijos de una ubicacion en especifico
     *
     * @param idPadre (Ubicaciones) ubicacion padre
     * @return Ubicación padre
     * @throws Exception
     */
    List<Ubicacion> consultarHijos(int idPadre) throws Exception;

    /**
     * Método para consultar la lista de municipios con sus departamentos y
     * paises
     *
     * @return
     * @throws Exception
     */
    HashMap<Integer, Ubicacion> consultarMunicipios() throws Exception;

    List<Ubicacion> consultarTodosMunicipios() throws Exception;

    /**
     * Método para consultar la los hijos dado un id padre especifico
     *
     * @param idPadre (Ubicaciones) ubicacion padre
     * @return Ubicación padre
     * @throws Exception
     */
    List<Ubicacion> consultarHijosSegunIdPadre(int idPadre) throws Exception;

    /**
     * Método para consultar la lista de municipios segun su idpadre
     *
     * @param idPadre
     * @return
     * @throws Exception
     */
    HashMap<Integer, Ubicacion> consultarMunicipiosSegunIdPadre(int idPadre) throws Exception;

    /**
     * Metodo que permite actualizar Municipo por prefijo
     *
     * @param departamentoPrefijo
     * @param municipioPrefijo
     * @return
     * @throws Exception
     */
    Ubicacion consultarMunicipiosPorPrefijo(String departamentoPrefijo, String municipioPrefijo) throws Exception;

    /**
     * Método para consultar la lista de municipios segun su idpadre y que
     * apliquen cobertura
     *
     * @param idPadre
     * @return
     * @throws Exception
     */
    HashMap<Integer, Ubicacion> consultarMunicipiosSegunIdPadreCobertura(int idPadre) throws Exception;

    /**
     * Método para consultar la los hijos dado un id padre especifico y que
     * apliquen cobertura
     *
     * @param idPadre (Ubicaciones) ubicacion padre
     * @return Ubicación padre
     * @throws Exception
     */
    List<Ubicacion> consultarHijosSegunIdPadreCobertura(int idPadre) throws Exception;

    /**
     * Metodo que permite actualizar Municipo por prefijo y que apliquen
     * cobertura
     *
     * @param departamentoPrefijo
     * @param municipioPrefijo
     * @return
     * @throws Exception
     */
    Ubicacion consultarMunicipiosPorPrefijoCobertura(String departamentoPrefijo, String municipioPrefijo) throws Exception;
    
    /**
     * Método que permite obtener hash de padres de tipo ubicacion
     * @param idPadre
     * @return
     * @throws Exception
     */
    HashMap<Integer, Ubicacion> consultarHashHijosSegunIdPadreCobertura(int idPadre) throws Exception;
    
    /**
     * Metodo que permite consultar la ubicacion con cobertura
     * @return
     * @throws Exception 
     */
    List<Ubicacion> consultarMunicipiosCobertura() throws Exception;

}
