package com.domiciliosenvia.domicilio.negocio.administracion;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.saviasaludeps.savia.negocio.administracion;
//
//import com.saviasaludeps.savia.dominio.administracion.MaestroAccion;
//import com.saviasaludeps.savia.dominio.administracion.TipoMaestro;
//import com.saviasaludeps.savia.dominio.generico.ParamConsulta;
//import java.util.List;
//
///**
// *
// * @author rpalacic
// */
//public interface MaestroAccionRemoto {
//    
//
//    /**
//     * Consultar un registro
//     * @param id
//     * @return
//     * @throws Exception 
//     */
//
//    MaestroAccion consultar(int id) throws Exception;
//    
//    /**
//     * Método para crear una nuevo registro
//     * @param obj (Solicitud)
//     * @return (int) id del registro generado
//     * @throws java.lang.Exception
//     */
//    int insertar(MaestroAccion obj) throws Exception;
//    
//    /**
//     * Método para actualizar la información de un registro
//     * @param obj (Solicitud)
//     * @throws java.lang.Exception
//     */
//    void actualizar(MaestroAccion obj) throws Exception;
//    
//    /**
//     * Método para eliminar un registro
//     * @param id
//     * @return (Solicitud) La persistencia del objeto eliminado
//     * @throws java.lang.Exception
//     */
//    MaestroAccion eliminar(int id) throws Exception;
//    
//    /**
//     * Consultar todos los maestros accion
//     * @return
//     * @throws Exception 
//     */
//    List<MaestroAccion> consultarTodos() throws Exception;
//
// 
////    /**
////     * 
////     * @param tipoMaestro
////     * @return
////     * @throws Exception 
////     */
////    List<MaestroAccion> consultarPorTipoMaestro(int tipoMaestro) throws Exception;
//    
//    /**
//     * 
//     * @param idGrupo
//     * @return
//     * @throws Exception 
//     */
//    List<MaestroAccion> consultarPorGrupoId(int idGrupo) throws Exception;
//    
//    /**
//     * Método para consultar lista de Tipos de Maestro del sistema
//     * @return
//     * @throws Exception 
//     */
//    public List<TipoMaestro> consultarTiposMaestro() throws Exception;
//    
//}
