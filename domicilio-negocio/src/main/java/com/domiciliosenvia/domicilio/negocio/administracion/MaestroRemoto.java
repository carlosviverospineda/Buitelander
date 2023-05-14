/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.negocio.administracion;

import com.domiciliosenvia.domicilio.dominio.administracion.Maestro;
import com.domiciliosenvia.domicilio.dominio.administracion.MaestroAccion;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rpalacic
 */
public interface MaestroRemoto {

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
    List<Maestro> consultarLista(ParamConsulta paramConsulta) throws Exception;

    /**
     * Método para consultar un maestro por ID
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    Maestro consultar(int id) throws Exception;

    /**
     * Método para crear un nuev maestro
     *
     * @param obj (Maestros)
     * @return (int) id del registro generado
     * @throws java.lang.Exception
     */
    int insertar(Maestro obj) throws Exception;

    /**
     * Método para actualizar la información de un maestro
     *
     * @param obj (Maestros)
     * @throws java.lang.Exception
     */
    void actualizar(Maestro obj) throws Exception;

    /**
     * Método para eliminar un maestro
     *
     * @param id
     * @return (Maestro) objeto eliminado
     * @throws java.lang.Exception
     */
    Maestro eliminar(int id) throws Exception;

    /**
     * Método para consultar los maestros activos por tipo
     *
     * @param _tipo
     * @return
     * @throws Exception
     */
    List<Maestro> consultarPorTipo(String _tipo) throws Exception;
    
    /**
     * Consulta lista de maestros segun el tipo de su Hijo
     * @param tipo
     * @return
     * @throws Exception 
     */
    List<Maestro> consultarPorTipoHijo(String tipo) throws Exception;

    /**
     * Método para consultar los maestros activos por tipo
     * @param _tipo
     * @return (HashMap<Integer, Maestro>) Hash con los maestros cargados
     * @throws Exception
     */
    HashMap<Integer, Maestro> consultarHashPorTipo(String _tipo) throws Exception;

    /**
     *
     * @param tipo
     * @return
     * @throws Exception
     */
    HashMap<String, Maestro> consultarHashPorTipoValor(String tipo) throws Exception;

    /**
     * Consultar todos los Maestros
     * @return (HashMap<Integer, Maestro>) Hash con los maestros cargados
     * @throws Exception
     */
    HashMap<Integer, Maestro> consultarHash() throws Exception;

    /**
     * Consultar todos los maetsros
     *
     * @return
     * @throws Exception
     */
    List<Maestro> consultarLista() throws Exception;
    
    /**
     * Consultar maestro por valor
     *
     * @param valor
     * @return
     * @throws Exception
     */
    public Maestro consultarPorValor(String valor) throws Exception;

    /**
     * Consultar de maestro por valor y tipo
     *
     * @param valor
     * @param tipo 
     * @return
     * @throws Exception
     */
    public Maestro consultarPorValorTipo(String valor, String tipo) throws Exception;
   
    /**
     * Método para consultar los maestros activos por tipo, ordenandolos por su id.
     *
     * @param _tipo
     * @return
     * @throws Exception
     */
    List<Maestro> consultarPorTipoYOrdenPorId(String _tipo) throws Exception;

    /**
     * Consultar lista de Acciones de Maestros por Tipo de maestro
     * @param tipo
     * @return
     * @throws Exception
     */
    List<MaestroAccion> consultarAccionesPorTipo(String tipo) throws Exception;
    
    /**
     * Consultar accion por ID
     * @param id
     * @return
     * @throws Exception 
     */
    MaestroAccion consultarAcciones(int id) throws Exception;
    
    /**
     * Consultar todos los Maestros
     * @param idPadre
     * @return (HashMap<Integer, Maestro>) Hash con los maestros cargados
     * @throws Exception
     */
    HashMap<Integer, Maestro> consultarHashPorPadre(int idPadre) throws Exception;

    /**
     * Consultar todos los maetros partiendo de un padre
     *
     * @param tipo tipo de maestro hijo
     * @param idPadre
     * @return
     * @throws Exception
     */
    List<Maestro> consultarListaPorPadre(String tipo, int idPadre) throws Exception;
    
    /**
     * Consultar todos los maetros partiendo de dos padres
     * 
     * @param tipo tipo de maestro hijo
     * @param idPadre1
     * @param idPadre2
     * @return 
     * @throws java.lang.Exception 
     */
    List<Maestro> consultarListaPorPadre(String tipo, int idPadre1, int idPadre2) throws Exception;
    
    /**
     * Consultar todos los maetros partiendo de tres padres
     * 
     * @param tipo tipo de maestro hijo
     * @param idPadre1
     * @param idPadre2
     * @param idPadre3
     * @return 
     * @throws java.lang.Exception 
     */
    List<Maestro> consultarListaPorPadre(String tipo, int idPadre1, int idPadre2, int idPadre3) throws Exception;

    /**
     * Validar si existe relación entre padres e hijos
     * 
     * @param idHijo
     * @param idPadre
     * @return
     * @throws Exception 
     */
    boolean isRelacionPadreHijo(int idHijo, int idPadre) throws Exception;

    /**
     * Validar si existe relación entre padres e hijos
     * 
     * @param idHijo
     * @param idPadre1
     * @param idPadre2
     * @return
     * @throws Exception 
     */
    boolean isRelacionPadreHijo(int idHijo, int idPadre1, int idPadre2) throws Exception;

    /**
     * Validar si existe relación entre padres e hijos
     * 
     * @param idHijo
     * @param idPadre1
     * @param idPadre2
     * @param idPadre3
     * @return
     * @throws Exception 
     */
    boolean isRelacionPadreHijo(int idHijo, int idPadre1, int idPadre2, int idPadre3) throws Exception;
}
