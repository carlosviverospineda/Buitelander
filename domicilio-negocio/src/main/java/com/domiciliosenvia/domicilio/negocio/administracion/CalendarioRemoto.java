/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.negocio.administracion;

import com.domiciliosenvia.domicilio.dominio.administracion.DiaHabil;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rpalacic
 */
public interface CalendarioRemoto {
    
    /**
     * Método para consultar todos los registros
     * @param paramConsulta
     * @return 
     * @throws java.lang.Exception 
     */
    public List<DiaHabil> consultarTodos(ParamConsulta paramConsulta) throws Exception;
    public DiaHabil consultarDia(Date fecha) throws Exception;
    
    /**
     * Método para crear una nuevo registro
     * @param obj (DiasHabiles)
     * @return (int) id del registro generado
     * @throws java.lang.Exception
     */
    public boolean actualizar(DiaHabil obj) throws Exception;
}
