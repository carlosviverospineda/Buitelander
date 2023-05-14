/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.utilidades;

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

    public static final int GN_RUTA_MANUALES_AYUDA = 1;
    public static final int GN_SOCKET_BACK_3 = 120;
    //GENERAL
    public static final int SMTP_BASE_AUTH_USER = 2;
    public static final int SMTP_BASE_AUTH_PWD = 3;
    public static final int SMTP_BASE_HOST_NAME = 4;
    public static final int SMTP_BASE_HOST_PORT = 5;
    public static final int SMTP_BASE_SECURITY = 6;
    public static final int SMS_REST_TIGO_URL = 7;
    public static final int SMS_REST_TIGO_COUNTRY = 8;
    public static final int SMS_REST_TIGO_USER = 9;
    public static final int SMS_REST_TIGO_PWD = 10;
    public static final int SMS_WS_TIGO_CONSUMO = 11;
    
    public static final int LOG_RUTA_SUCESOS = 95;
    public static final int LOG_RUTA_ERRORES = 96;
    //ASEGURAMIENTO
    public static final int RUTA_ASEGURAMIENTO_ANEXO1_SOPORTES = 17;
    public static final int RUTA_ASEGURAMIENTO_CERTIFICADOS = 18;
    public static final int RUTA_ASEGURAMIENTO = 19;
    public static final int RUTA_ASEGURAMIENTO_REPORTES = 20;
    public static final int RUTA_ASEGURAMIENTO_CARGA_MASIVA_AFILIADOS = 21;
    public static final int RUTA_ASEGURAMIENTO_CARGA_MASIVA_NOVEDADES = 22;
    public static final int RUTA_ASEGURAMIENTO_VALIDACION_DERECHOS = 23;
    //CONTRATACION
    public static final int CNT_RUTA_CARGA_MASIVA_CONTRATOS = 80;
    //MAESTROS (PARAMETRIZACION)
    public static final int MA_RUTA_CARGA_MAESTROS = 122;
    //CENTRO REGULADOR
    public static final int REF_RUTA_ANEXOS = 42;
    public static final int REF_RUTA_ADJUNTOS = 43;
    //RIPS
    public static final int CM_RUTA_RIPS_CARGA = 24;
    public static final int CM_RUTA_RIPS_DESCARGA = 32;
    //CUENTAS MÉDICAS
    public static final int WS_USUARIO_TOKEN_CONCILIACION_FACTURA = 25;
    public static final int WS_CONTRASENA_TOKEN_CONCILIACION_FACTURA = 26;
    public static final int RUTA_SERVICIO_TOKEN_CONCILIACION_FACTURA = 27;
    public static final int RUTA_SERVICIO_CONCILIACION_FACTURA = 28;
    //CUENTAS MEDICAS
    public static final int CM_WS_RUTA_SERVICIO_DEVOLUCION_FACTURA = 41;
    public static final int CM_RUTA_REPORTES = 29;
    public static final int CM_RUTA_AUDITORIA_DESCARGA = 40;
    public static final int CM_WS_NOTIFICACION_FACTURA_USUARIO_TOKEN = 34;
    public static final int CM_WS_NOTIFICACION_FACTURA_PASSWORD_TOKEN = 35;
    public static final int CM_WS_NOTIFICACION_FACTURA_URL = 36;
    public static final int CM_RUTA_CONCILIACION_CARGA_MASIVA = 121;    
    //GESTIÓN DEL RIESGO (Programas especiales)
    public static final int PE_RUTA_ADJUNTOS_GESTIONES = 30;
    public static final int PE_RUTA_ADJUNTOS_GESTIONES_CARGA_MASIVA = 31;
    //AUTORIZACIONES
    public static final int AU_TUTELA_CONSULTA_USUARIO_TOKEN = 37;
    public static final int AU_TUTELA_CONSULTA_PASSWORD_TOKEN = 38;
    public static final int AU_TUTELA_CONSULTA_URL = 39;
    public static final int AU_A3_ADJUNTOS = 44;
    public static final int AU_A3_CARGA_MASIVA = 45;
    public static final int AU_A3_ANEXOS = 46;
    public static final int AU_A4_ANEXOS = 47;
    public static final int AU_A2_ANEXOS = 48;
    public static final int AU_A4_REPORTES = 49;
    public static final int AU_RUTA_ADJUNTOS_COTIZACIONES = 81;
    public static final int AU_AUTORIZACION_AUTOMATICA = 97;    
    //INFORMES
    public static final int INF_RUTA_REPORTES = 110;
    //ATENCION AL USUARIO
    public static final int AUS_RUTA_CARGA = 124;
    public static final int AUS_DEFECTO_DESTINO = 127;
    public static final int AUS_DEFECTO_ESPECIALIDAD = 128;
    public static final int AUS_DEFECTO_ESTADO_SERVICIO = 129;
    public static final int AUS_DEFECTO_PRESCRIPTORA = 130;
    public static final int AUS_DEFECTO_PRIORIDAD = 131;
    public static final int AUS_DEFECTO_SEDE = 132;
    public static final int AUS_DEFECTO_UBICACION = 133;
    public static final int AUS_HORAS_SERVICIO = 134;
    //GESTION DE SOLICITUDES
    public static final int GS_SOLICITUDES_CARGA = 126;
    //NO FUNCIONAN
//    public static final int BD1_CONEXION_URL = 70;
//    public static final int BD1_CONEXION_USUARIO = 71;
//    public static final int BD1_CONEXION_CONTRASENA = 72;
//    public static final int BD2_CONEXION_URL = 73;
//    public static final int BD2_CONEXION_USUARIO = 74;
//    public static final int BD2_CONEXION_CONTRASENA = 75;
    
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
