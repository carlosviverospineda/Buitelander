/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.utilidades;

import com.domiciliosenvia.domicilio.negocio.administracion.ConfiguracionRemoto;
import java.util.HashMap;

/**
 *
 * @author raul-palacios
 */
public class PropApl {

    private ConfiguracionRemoto getConfiguracionRemoto() throws Exception {
        return (ConfiguracionRemoto) RemotoEJB.getEJBRemoto("ConfiguracionServicio", ConfiguracionRemoto.class.getName());
    }

    private static PropApl propAplInstance = null;
    private HashMap<Integer, String> hashConfiguraciones = new HashMap();

    public static final int BD1_CONEXION_URL = 70;
    public static final int BD1_CONEXION_USUARIO = 71;
    public static final int BD1_CONEXION_CONTRASENA = 72;

    public static final int BD2_CONEXION_URL = 73;
    public static final int BD2_CONEXION_USUARIO = 74;
    public static final int BD2_CONEXION_CONTRASENA = 75;

    public static final int BD3_CONEXION_URL = 76;
    public static final int BD3_CONEXION_USUARIO = 77;
    public static final int BD3_CONEXION_CONTRASENA = 78;

    public PropApl() {
        try {
            hashConfiguraciones = getConfiguracionRemoto().consultarHash();
        } catch (Exception ex) {
            hashConfiguraciones = new HashMap();
        }
    }

    public static PropApl getInstance() {
        if (propAplInstance == null) {
            propAplInstance = new PropApl();
        }
        return propAplInstance;
    }

    public static PropApl getInstanceLimpiar() {
        propAplInstance = new PropApl();
        return propAplInstance;
    }

    public String get(int id) {
        return hashConfiguraciones.get(id);
    }

}
