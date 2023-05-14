/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.administracion;

import com.domiciliosenvia.domicilio.dominio.generico.Auditoria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rpalacic
 */
public class Modulo extends Auditoria {

    public static final char TIPO_NINGUNO = '0';
    public static final char TIPO_APLICACION = 'A';
    public static final char TIPO_MODULO = 'M';
    public static final char TIPO_OPCION = 'O';
    //Administración
    public static final int ID_UBICACIONES = 3;
    public static final int ID_MAESTROS = 4;
    public static final int ID_EMPRESAS = 5;
    public static final int ID_MODULOS = 6;
    public static final int ID_CALENDARIO = 7;
    public static final int ID_GN_CONFIGURACION = 8;
    public static final int ID_ESTADO_SERVICIOS = 9;
    public static final int ID_RECURRENCIAS = 10;
    public static final int ID_HILOS = 11;
    public static final int ID_MAESTRO_TIPOS = 12;
    //Seguridad
    public static final int ID_PERFILES = 21;
    public static final int ID_ROL = 22;
    public static final int ID_USUARIOS = 23;
    public static final int ID_LOGS = 24;
    //Maestros
    public static final int ID_MAESTRO_DIAGNOSTICOS = 261;
    public static final int ID_MAESTRO_ESPECIALIDADES = 262;
    public static final int ID_MAESTRO_SERVICIOS_HABILITACION = 263;
    public static final int ID_MAESTRO_TECNOLOGIAS = 264;
    public static final int ID_MAESTRO_INSUMOS = 265;
    public static final int ID_MAESTRO_MEDICAMENTOS = 266;
    public static final int ID_MAESTRO_PAQUETES = 267;
    public static final int ID_MAESTRO_CARGA_MASIVA = 268;
    //Aseguramiento
    public static final int ID_ASEGURAMIENTO_GESTION_AFILIADOS = 61;
    public static final int ID_ASEGURAMIENTO_CARGA_MASIVA = 62;
    public static final int ID_ASEGURAMIENTO_REPORTES = 63;
    public static final int ID_ASEGURAMIENTO_GESTION_PORTABILIDAD = 64;
    public static final int ID_ASEGURAMIENTO_VALIDACION_DERECHOS = 65;
    public static final int ID_ASEGURAMIENTO_CONSULTA_AFILIADOS = 66;
    public static final int ID_ASEGURAMIENTO_CERTIFICADOS = 67;
    public static final int ID_ASEGURAMIENTO_ANEXO1 = 68;
    //Contratación
    public static final int ID_CONTRATACION_PRESTADORES = 81;
    public static final int ID_CONTRATACION_CONTRATOS = 82;
    public static final int ID_CONTRATACION_CONTRATOS_CARGA_MASIVA = 83;
    public static final int ID_CONTRATACION_PROFESIONALES = 84;
    public static final int ID_CONTRATACION_CONSULTA_TECNOLOGIAS = 85;
    public static final int ID_CONTRATACION_REPS_CARGA_MASIVA = 86;
    //Autorizaciones
    public static final int ID_AUTORIZACIONES_SOLICITUDES = 101;
    public static final int ID_AUTORIZACIONES_AUTORIZACIONES = 102;
    public static final int ID_AUTORIZACIONES_CARGA_MASIVA = 103;
    public static final int ID_AUTORIZACIONES_COTIZACIONES = 104;
    public static final int ID_AUTORIZACIONES_ZONAS = 105;
    public static final int ID_AUTORIZACIONES_IMPRESIONES_REPORTE = 106;
    public static final int ID_AUTORIZACIONES_GRUPOS = 107;
    public static final int ID_AUTORIZACIONES_IMPRESIONES = 108;
    //Centro Regulador (CRUE)
    public static final int ID_REFERENCIA_CONTRARREFERENCIA = 121;
    public static final int ID_SOLICITUDES_URGENCIAS = 122;
    //Cuentas Médicas
    public static final int ID_FACTURA_AUDITORIA_EVENTO = 181;
    public static final int ID_FACTURA_AUDITORIA_LIDER = 182;
    public static final int ID_FACTURA_CONCILIACIONES = 184;
    public static final int ID_FACTURA_GLOSAS = 185;
    public static final int ID_FACTURA_CARGA_MASIVA_CONC = 186;
    public static final int ID_FACTURA_REPORTES = 187;
    public static final int ID_REINTENTOS_RESPUESTAS_GLOSAS = 188;
    public static final int ID_CM_ASIGNACION_USUARIOS = 189;
    public static final int ID_CM_AUDITORIA_MASIVA = 190;
    public static final int ID_CM_CONTROL_AUDITORIA_MASIVA = 191;
    public static final int ID_CM_CONTROL_CIERRE = 192;
    //RIPS
    public static final int ID_CM_RIPS_REGLAS = 201;
    public static final int ID_CM_RIPS = 202;
    //Gestión del riegbo (Programas especiales)
    public static final int ID_PROGRAMA_ESPECIAL_GESTION_PROGRAMAS = 221;
    public static final int ID_PROGRAMA_ESPECIAL_GESTION_AFILIADOS = 222;
    public static final int ID_PROGRAMA_ESPECIAL_CARGAS_MASIVAS = 223;
    //Web Services
    public static final int ID_WEBSERVICES_CONEXIONES = 241;
    public static final int ID_WEBSERVICES_SERVICIOS = 242;
    public static final int ID_WEBSERVICES_TRANSACCIONES = 243;
    //MIPRES
    public static final int ID_GESTION_MIPRES = 161;
    //Informes
    public static final int ID_INFORMES = 301;
    public static final int ID_INFORMES_GRUPOS = 302;
    public static final int ID_INFORMES_GENERADOS = 303;
    //Gestion de Solicitudes    
    public static final int ID_SOLICITUD_MENSAJES = 321;
    public static final int ID_SOLICITUD_ZONAS = 322;
    public static final int ID_SOLICITUD_SOLICITUDES = 323;
    //Contratación Jurídoca
    public static final int ID_JURIDICO_ACOS = 341;
    public static final int ID_JURIDICO_CONTRATOS = 342;
    //Atencion al usuario
    public static final int ID_AUS_PERSONAS = 361;
    public static final int ID_AUS_CASOS = 362;
    public static final int ID_AUS_CARGA_MASIVA = 363;
    public static final int ID_AUS_GRAFICAS = 364;
    public static final int ID_AUS_SERVICIOS = 365;
    // Ordenes de ventas
    public static final int ID_ORD_CLIENTE = 30;
    public static final int ID_ORD_VENTA = 31;

    public Modulo() {
    }
// Ordenes de ventas
    
    public Modulo(Integer id) {
        this.id = id;
    }

    private Modulo moduloPadre = null;
    private Integer id;
    private char tipo = Modulo.TIPO_NINGUNO;
    private String nombre = "";
    private String descripcion = "";
    private boolean activo = true;
    private String privilegios = "";
    private int orden = 0;
    private String url = "";
    private String icono;
    private String version;
    private Date fechaVersion;
    private List<Modulo> modulosHijos = new ArrayList();
    private boolean listarPermiso;
    private boolean verPermiso;
    private boolean crearPermiso;
    private boolean editarPermiso;
    private boolean borrarPermiso;
    private boolean accionAdicional1Permiso;
    private boolean accionAdicional2Permiso;
    private boolean accionAdicional3Permiso;
    private boolean accionAdicional4Permiso;
    private boolean accionAdicional5Permiso;
    private boolean accionAdicional6Permiso;
    private boolean accionAdicional7Permiso;
    private boolean accionAdicional8Permiso;
    private boolean accionAdicional9Permiso;
    private boolean accionAdicional10Permiso;
    private boolean accionAdicional11Permiso;

    private String adicional1Nombre;
    private String adicional2Nombre;
    private String adicional3Nombre;
    private String adicional4Nombre;
    private String adicional5Nombre;
    private String adicional6Nombre;
    private String adicional7Nombre;
    private String adicional8Nombre;
    private String adicional9Nombre;
    private String adicional10Nombre;
    private String adicional11Nombre;

    private Permiso permiso;

    private String manual;

    public boolean isListarPermiso() {
        listarPermiso = privilegios.contains("L");
        return listarPermiso;
    }

    public boolean isVerPermiso() {
        verPermiso = privilegios.contains("V");
        return verPermiso;
    }

    public boolean isCrearPermiso() {
        crearPermiso = privilegios.contains("C");
        return crearPermiso;
    }

    public boolean isEditarPermiso() {
        editarPermiso = privilegios.contains("E");
        return editarPermiso;
    }

    public boolean isBorrarPermiso() {
        borrarPermiso = privilegios.contains("B");
        return borrarPermiso;
    }

    public boolean isAccionAdicional1Permiso() {
        accionAdicional1Permiso = privilegios.contains("O");
        return accionAdicional1Permiso;
    }

    public boolean isAccionAdicional2Permiso() {
        accionAdicional2Permiso = privilegios.contains("P");
        return accionAdicional2Permiso;
    }

    public boolean isAccionAdicional3Permiso() {
        accionAdicional3Permiso = privilegios.contains("Q");
        return accionAdicional3Permiso;
    }

    public boolean isAccionAdicional4Permiso() {
        accionAdicional4Permiso = privilegios.contains("R");
        return accionAdicional4Permiso;
    }

    public boolean isAccionAdicional5Permiso() {
        accionAdicional5Permiso = privilegios.contains("S");
        return accionAdicional5Permiso;
    }

    public boolean isAccionAdicional6Permiso() {
        accionAdicional6Permiso = privilegios.contains("T");
        return accionAdicional6Permiso;
    }

    public boolean isAccionAdicional7Permiso() {
        accionAdicional7Permiso = privilegios.contains("U");
        return accionAdicional7Permiso;
    }

    public boolean isAccionAdicional8Permiso() {
        accionAdicional8Permiso = privilegios.contains("W");
        return accionAdicional8Permiso;
    }

    public boolean isAccionAdicional9Permiso() {
        accionAdicional9Permiso = privilegios.contains("X");
        return accionAdicional9Permiso;
    }

    public boolean isAccionAdicional10Permiso() {
        accionAdicional10Permiso = privilegios.contains("Y");
        return accionAdicional10Permiso;
    }

    public boolean isAccionAdicional11Permiso() {
        accionAdicional11Permiso = privilegios.contains("Z");
        return accionAdicional11Permiso;
    }

    public String getAdicional1Nombre() {
        return adicional1Nombre;
    }

    public void setAdicional1Nombre(String adicional1Nombre) {
        this.adicional1Nombre = adicional1Nombre;
    }

    public String getAdicional2Nombre() {
        return adicional2Nombre;
    }

    public void setAdicional2Nombre(String adicional2Nombre) {
        this.adicional2Nombre = adicional2Nombre;
    }

    public String getAdicional3Nombre() {
        return adicional3Nombre;
    }

    public void setAdicional3Nombre(String adicional3Nombre) {
        this.adicional3Nombre = adicional3Nombre;
    }

    public String getAdicional4Nombre() {
        return adicional4Nombre;
    }

    public void setAdicional4Nombre(String adicional4Nombre) {
        this.adicional4Nombre = adicional4Nombre;
    }

    public String getAdicional5Nombre() {
        return adicional5Nombre;
    }

    public void setAdicional5Nombre(String adicional5Nombre) {
        this.adicional5Nombre = adicional5Nombre;
    }

    public String getAdicional6Nombre() {
        return adicional6Nombre;
    }

    public void setAdicional6Nombre(String adicional6Nombre) {
        this.adicional6Nombre = adicional6Nombre;
    }

    public String getAdicional7Nombre() {
        return adicional7Nombre;
    }

    public void setAdicional7Nombre(String adicional7Nombre) {
        this.adicional7Nombre = adicional7Nombre;
    }

    public String getAdicional8Nombre() {
        return adicional8Nombre;
    }

    public void setAdicional8Nombre(String adicional8Nombre) {
        this.adicional8Nombre = adicional8Nombre;
    }

    public String getAdicional9Nombre() {
        return adicional9Nombre;
    }

    public void setAdicional9Nombre(String adicional9Nombre) {
        this.adicional9Nombre = adicional9Nombre;
    }

    public String getAdicional10Nombre() {
        return adicional10Nombre;
    }

    public void setAdicional10Nombre(String adicional10Nombre) {
        this.adicional10Nombre = adicional10Nombre;
    }

    public String getAdicional11Nombre() {
        return adicional11Nombre;
    }

    public void setAdicional11Nombre(String adicional11Nombre) {
        this.adicional11Nombre = adicional11Nombre;
    }

    public Modulo getModuloPadre() {
        return moduloPadre;
    }

    public void setModuloPadre(Modulo moduloPadre) {
        this.moduloPadre = moduloPadre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public char getTipo() {
        return tipo;
    }

    public boolean isTipoModulo() {
        return (tipo == 'M');
    }

    public String getTipoStr() {
        switch (tipo) {
            case Modulo.TIPO_APLICACION:
                return "Aplicacion";
            case Modulo.TIPO_MODULO:
                return "Módulo";
            case Modulo.TIPO_OPCION:
                return "Opción";
            default:
                return "NINGUNO";
        }
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDescripcionCorta() {
        if (descripcion != null && descripcion.length() > 16) {
            return descripcion.substring(0, 16) + "...";
        } else {
            return descripcion;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getActivoStr() {
        return (isActivo()) ? "SI" : "NO";
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public String getPrivilegiosStr() {
        String _str = "";
        if (privilegios.contains("L")) {
            _str += (_str.equals("")) ? "Listar" : " - Listar";
        }
        if (privilegios.contains("V")) {
            _str += (_str.equals("")) ? "Ver" : " - Ver";
        }
        if (privilegios.contains("C")) {
            _str += (_str.equals("")) ? "Crear" : " - Crear";
        }
        if (privilegios.contains("E")) {
            _str += (_str.equals("")) ? "Editar" : " - Editar";
        }
        if (privilegios.contains("B")) {
            _str += (_str.equals("")) ? "Borrar" : " - Borrar";
        }
        if (privilegios.contains("O")) {
            _str += (_str.equals("")) ? getAdicional1Nombre() : " - " + getAdicional1Nombre();
        }
        if (privilegios.contains("P")) {
            _str += (_str.equals("")) ? getAdicional2Nombre() : " - " + getAdicional2Nombre();
        }
        if (privilegios.contains("Q")) {
            _str += (_str.equals("")) ? getAdicional3Nombre() : " - " + getAdicional3Nombre();
        }
        if (privilegios.contains("R")) {
            _str += (_str.equals("")) ? getAdicional4Nombre() : " - " + getAdicional4Nombre();
        }
        if (privilegios.contains("S")) {
            _str += (_str.equals("")) ? getAdicional5Nombre() : " - " + getAdicional5Nombre();
        }
        if (privilegios.contains("T")) {
            _str += (_str.equals("")) ? getAdicional6Nombre() : " - " + getAdicional6Nombre();
        }
        if (privilegios.contains("U")) {
            _str += (_str.equals("")) ? getAdicional7Nombre() : " - " + getAdicional7Nombre();
        }
        if (privilegios.contains("W")) {
            _str += (_str.equals("")) ? getAdicional8Nombre() : " - " + getAdicional8Nombre();
        }
        if (privilegios.contains("X")) {
            _str += (_str.equals("")) ? getAdicional9Nombre() : " - " + getAdicional9Nombre();
        }
        if (privilegios.contains("Y")) {
            _str += (_str.equals("")) ? getAdicional10Nombre() : " - " + getAdicional10Nombre();
        }
        if (privilegios.contains("Z")) {
            _str += (_str.equals("")) ? getAdicional11Nombre() : " - " + getAdicional11Nombre();
        }
        if (!_str.equals("")) {
            _str = _str.substring(0, _str.length() - 1);
        }
        return _str;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = (privilegios == null) ? "" : privilegios;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return (icono == null) ? "" : icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Date getFechaVersion() {
        return fechaVersion;
    }

    public void setFechaVersion(Date fechaVersion) {
        this.fechaVersion = fechaVersion;
    }

    public List<Modulo> getModulosHijos() {
        return modulosHijos;
    }

    public void setModulosHijos(List<Modulo> modulosHijos) {
        this.modulosHijos = modulosHijos;
    }

    @Override
    public String toString() {
        return "Modulo{" + "moduloPadre=" + moduloPadre + ", id=" + id + ", tipo=" + getTipoStr() + ", nombre=" + nombre + ", descripcion=" + descripcion + ", activo=" + getActivoStr() + ", privilegios=" + getPrivilegiosStr() + ", orden=" + orden + ", url=" + url + ", icono=" + icono + ", modulosHijos=" + modulosHijos + '}';
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
