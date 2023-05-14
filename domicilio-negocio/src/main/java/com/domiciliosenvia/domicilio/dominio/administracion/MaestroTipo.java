/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.administracion;

import com.domiciliosenvia.domicilio.dominio.generico.Auditoria;
import java.util.List;

/**
 *
 * @author rpalacios
 */
public class MaestroTipo extends Auditoria {
    
    //General
    public static final String GN_NINGUNO = "00";
    public static final String GN_SEXO = "01";
    public static final String GN_TIPO_DOCUMENTO = "02";
    public static final String GN_TIPO_DOCUMENTO_PERSONA = "03";
    public static final String GN_TIPO_DOCUMENTO_EMPRESA = "04";
    public static final String GN_MEDIO_DIAGNOSTICO = "05";
    public static final String GN_AMBITO = "06";
    public static final String GN_UBICACION = "07";
    public static final String GN_REGIMEN = "08";
    public static final String GN_ORIGEN_ATENCION = "09";
    public static final String GN_ZONA_RESIDENCIA = "10";
    public static final String GN_REGION = "11";
    public static final String GN_ESPECIALIDAD_MEDICA = "12";
    public static final String GN_TIPO_SERVICIO = "13";
    public static final String GN_TIPO_DOCUMENTO_PROFESIONAL = "14";
    public static final String GN_PATOLOGIA_CATASTROFICA = "15";
    public static final String GN_COBERTURA = "16";
    public static final String GN_TIPO_CONTACTO = "17";
        
    public static final String GN_ZONA_UBICACION = "300";
    public static final String GN_TIPO_DISCAPACIDAD = "301";
    public static final String GN_ETNIA = "302";
    public static final String GN_ESTADO_CIVIL = "303";
    
    //Aseguramiento
    public static final String ASEG_ESTADO_AFILIACION = "21";
    public static final String ASEG_GRUPO_POBLACIONAL = "22";
    public static final String ASEG_ORIGEN_AFILIADO = "23";
    public static final String ASEG_CAUSA_NOVEDAD_ACTIVACION = "24";
    public static final String ASEG_CAJA_COMPENSACION = "25";
    public static final String ASEG_ARL = "26";
    public static final String ASEG_AFP = "27";
    public static final String ASEG_ACTIVIDAD_ECONOMICA = "28";
    //Salen las 4 causas
    public static final String ASEG_CAUSA_NOVEDAD_RETIRO = "29";
    public static final String ASEG_CAUSA_NOVEDAD_SUSPENSION = "30";
    public static final String ASEG_CAUSA_NOVEDAD_FALLECIDO = "31";
    public static final String ASEG_CAUSA_NOVEDAD_PENDIENTE_SOPORTE = "32";
    //Causa unica
    public static final String ASEG_CAUSA_NOVEDAD = "33";
    public static final String ASEG_EPS = "34";
    public static final String ASEG_SISBEN_CATEGORIA = "35";
    public static final String ASEG_SISBEN_SUBCATEGORIA = "36";
    public static final String ASEG_SISBEN_NIVEL = "37";
    
    public static final String ASEG_AFILIADO_TIPO = "280";
    public static final String ASEG_COTIZANTE_TIPO = "281";
    public static final String ASEG_COTIZANTE_PARENTEZCO = "282";
    public static final String ASEG_CATEGORIA_IBC = "283";
    public static final String ASEG_MODELO_LIQUIDACION = "284";
    public static final String ASEG_PORTABILIDAD_ORIGEN = "285";
    public static final String ASEG_PORTABILIDAD_TIPO = "286";
    public static final String ASEG_PORTABILIDAD_ESTADO = "287";
    public static final String ASEG_CONDICION_DISCAPACIDAD = "288";
        
    //Autorizaciones
    public static final String AU_A3_CAUSA_EXTERNA = "40";
    public static final String AU_A4_GUIA_MANEJO_INTEGRAL = "41";
    public static final String AU_A3_ESTADO_MOTIVO = "42";
    public static final String AU_A3_ADJUNTO_TIPO = "43";
    public static final String AU_RECH_CAUSA_RECHAZO = "44";
    public static final String AU_TIPO_DIAGNOSTICO = "45";
    public static final String AU_DIAGNOSTICO_FINALIDAD = "46";
    public static final String AU_MEDICAMENTO_VIA_ADMINISTRACION = "47";
    public static final String AU_A4_ESTADO_AUDITORIA = "48";
    public static final String AU_A3_DEVOL_CAUSA_DEVOLUCION = "49";
    public static final String AU_A3_ITEM_ESTADO_MOTIVO = "50";
    public static final String AU_A4_DIAS_VIGENCIA = "95";
    public static final String AU_ENTREGA_CAUSAS_NO_ENTREGA = "52";
    //Programas especiales
    public static final String PE_CAUSA_ESTADO_ACTIVO = "60";
    public static final String PE_CAUSA_ESTADO_INACTIVO = "61";
    public static final String PE_REGION_CORPORAL = "62";
    public static final String PE_ADJUNTO_TIPO = "63";
    public static final String PE_PROGRAMA_TIPO = "64";
    public static final String PE_GESTION_TIPO = "65";
    //Centro regulador
    public static final String CR_A9_CANAL_COMUNICACION = "80";
    public static final String CR_TRANSPORTE_CLASE = "81";
    public static final String CR_TRANSPORTE_TIPO = "82";
    public static final String CR_TRANSPORTE_INSUMO = "83";
    public static final String CR_TRANSPORTE_SEGUIMIENTO_TIPO_REPORTE = "84";
    public static final String CR_GESTION_TIPO = "85";
    public static final String CR_GESTION_MOTIVO = "86";
    public static final String CR_ADJUNTO_TIPO = "87";
    public static final String CR_A2_DESTINO_PACIENTE = "88";
    public static final String CR_A2_ESTADO = "89";
    public static final String CR_A9_ESTADO = "90";
    public static final String CR_TRANSPORTE_LIQUIDACION = "91";
    //Maestros
    public static final String MA_DIAGNOSTICO_CAPITULO = "100";
    public static final String MA_DIAGNOSTICO_CATEGORIA = "101";
    public static final String MA_TECNOLOGIA_TIPO_SERVICIO = "102";
    public static final String MA_MEDICAMENTO_TIPO = "103";
    public static final String MA_MEDICAMENTO_CONCENTRACION = "104";
    public static final String MA_MEDICAMENTO_PRINCIPO_ACTIVO = "105";
    public static final String MA_MEDICAMENTO_FROMA_FARMACEUTICA = "106";
    public static final String MA_MEDICAMENTO_TIPO_PPM = "107";
    public static final String MA_INSUMO_TIPO = "108";
    public static final String MA_TECNOLOGIA_GRUPO = "109";
    public static final String MA_TECNOLOGIA_TIPO_PAGO = "110";
    public static final String MA_MEDICAMENTO_GRUPO_ANATOMICO = "111";
    public static final String MA_MEDICAMENTO_GRUPO_TERAPEUTICO = "112";
    public static final String MA_MEDICAMENTO_ATC = "113";
    public static final String MA_MEDICAMENTO_ESTADO_REGISTRO_SANITARIO = "114";
    public static final String MA_MEDICAMENTO_VIA_ADMINISTRACION = "115";
    //Contratación
    public static final String CNT_MODALIDAD = "120";
    public static final String CNT_CLASE_PRESTADOR = "121";
    public static final String CNT_ESTADO = "122";
    public static final String CNT_DOCUMENTO_JURIDICO = "123";
    public static final String CNT_TIPO_DESCUENTO = "124";
    public static final String CNT_GRUPO_CAPACIDAD = "125";
    public static final String CNT_UNIDAD_CAPACIDAD = "126";
    //Cuentas médicas (RIPS)
    public static final String RIPS_US_TIPO_USUARIO = "200";
    public static final String RIPS_AC_FINALIDAD_CONSULTA = "201";
    public static final String RIPS_AC_CAUSA_EXTERNA = "202";
    public static final String RIPS_AC_TIPO_DIAGNOSTICO_PRINCIPAL = "203";
    public static final String RIPS_AP_AMBITO_REALIZA_PROCEDIMIENTO = "204";
    public static final String RIPS_AP_FINALIDAD_PROCEDIMIENTO = "205";
    public static final String RIPS_AP_PERSONA_ATIENDE = "206";
    public static final String RIPS_AP_FORMA_REALIZA_PROC_QUIRURURGICO = "207";
    public static final String RIPS_AU_CAUSA_EXTERNA = "208";
    public static final String RIPS_AU_DESTINO_SALIDA = "209";
    public static final String RIPS_AU_ESTADO_SALIDA = "210";
    public static final String RIPS_AH_VIA_INGRESO = "211";
    public static final String RIPS_AH_CAUSA_EXTERNA = "212";
    public static final String RIPS_AH_ESTADO_SALIDA = "213";
    public static final String RIPS_AN_CONTROL_PRENATAL = "214";
    public static final String RIPS_AM_TIPO_MEDICAMENTO = "215";
    public static final String RIPS_AT_TIPO_SERVICIO = "216";
    public static final String RIPS_US_UNIDAD_EDAD = "217";
    public static final String RIPS_ESTADO_RECHAZO = "218";
    //Cuentas Médicas (Autitoría evento)
    public static final String CM_CONCEPTO_CONTABLE = "220";
    public static final String CM_CENTRO_COSTO = "221";
    public static final String CM_MOTIVO_GLOSA = "222";
    public static final String CM_MOTIVO_GLOSA_ESPEFIFICO = "223";
    public static final String CM_DEVOLUCION_MOTIVO = "224";
    public static final String CM_AUDITORIA_MOTIVO_ESPECIFICO = "225";
    //Mipres
    public static final String MP_DISPOSITIVOS_MEDICOS = "240";
    public static final String MP_SERVICIOS_COMPLEMENTARIOS = "241";
    public static final String MP_PRODUCTOS_NUTRICIONALES = "242";
    //SIMSA
    public static final String AUS_SEGUIMIENTO_TIPO = "260";
    public static final String AUS_PATOLOGIA = "261";
    public static final String AUS_SERVICIO_MOTIVO = "262";
    public static final String AUS_SERVICIO_AMBITO = "263";
    public static final String AUS_SOLICITUD_ESTADO = "264";
    public static final String AUS_SOLICITUD_TIPO = "265";
    public static final String AUS_SOLICITUD_ORIGEN = "266";
    public static final String AUS_SOLICITUD_PRIORIDAD = "267";
    public static final String AUS_CANAL_SUPER_SALUD = "268";
    public static final String AUS_SOLICITUD_ENTE_CONTROL = "269";
    public static final String AUS_SOLICITUD_RIESGO_VIDA = "270";

    private String tipo;
    private String nombre;
    private boolean activo;
    List<MaestroTipo> maestroTipo;
    private Perfil perfil;

    public MaestroTipo() {
    }

    public MaestroTipo(String tipo) {
        this.tipo = tipo;
    }

    public MaestroTipo(String tipo, String nombre, boolean activo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getActivoStr() {
        return (activo) ? "SI" : "NO";
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<MaestroTipo> getMaestroTipo() {
        return maestroTipo;
    }

    public void setMaestroTipo(List<MaestroTipo> maestroTipo) {
        this.maestroTipo = maestroTipo;
    }

    public Perfil getPerfil() {
        if(perfil == null){
            perfil = new Perfil();
        }
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "MaestroTipo{" + "tipo=" + tipo + ", nombre=" + nombre + ", activo=" + activo + ", maestroTipo=" + maestroTipo + ", perfil=" + perfil + '}';
    }

}
