/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.administracion;

import com.domiciliosenvia.domicilio.dominio.generico.Auditoria;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author rpalacic
 */
public class Maestro extends Auditoria {

//    //General

    private Integer id;
    private String tipo = "";
    private MaestroTipo maestroTipo;
    private String valor = "";
    private String nombre = "";
    private String descripcion = "";
    private boolean activo = true;
    private MaestroAccion maestroAccion;
    private static LinkedHashMap<String, String> tipos = new LinkedHashMap<>();
    //2021-05-06 jyperez Adicionamos objeto de Maestro, que referencia a su padre
    private Maestro maestro;

    public Maestro() {
    }

    public Maestro(Integer id) {
        this.id = id;
    }

    public Maestro(Integer id, String nombre, String tipo, String valor, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

//    public String getTipoStr() {
//        String str = tipos.get(tipo);
//        return str;
////        return Maestro.getTipoStr(getTipo());
//    }
    public static String getTipoStr(String tipo) {
        return tipos.get(tipo);
    }

    public MaestroTipo getMaestroTipo() {
        if (maestroTipo == null) {
            maestroTipo = new MaestroTipo();
        }
        return maestroTipo;
    }

    public void setMaestroTipo(MaestroTipo maestroTipo) {
        this.maestroTipo = maestroTipo;
    }

    public static LinkedHashMap<String, String> getTipos() {
        return tipos;
    }

    public static LinkedHashMap<String, String> getTiposListar() {
        LinkedHashMap<String, String> tiposLista = new LinkedHashMap();
        for (Map.Entry<String, String> entry : tipos.entrySet()) {
            tiposLista.put(entry.getValue(), entry.getKey());
        }
        return tiposLista;
    }

    public static Map<String, String> getTipoDependencia() {
        Map<String, String> tipos = new LinkedHashMap<>();
//        tipos.put(Maestro.SOLICITUD_ESTADO, Maestro.SEGUIMIENTO_TIPO);
        return tipos;
    }

    public static Map<String, Integer> getTipoAcciones() {
        Map<String, Integer> tiposAcciones = new LinkedHashMap<>();
//          tiposAcciones.put(Maestro.getTipoAccionStr(Maestro.OPERACION_ACTIVAR_CRETERIO), 
//                    Maestro.OPERACION_ACTIVAR_CRETERIO);
        return tiposAcciones;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
        if (descripcion != null && descripcion.length() > 32) {
            return descripcion.substring(0, 32);
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

    public String getActivoStr() {
        return (isActivo()) ? "SI" : "NO";
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public MaestroAccion getMaestroAccion() {
        if (maestroAccion == null) {
            maestroAccion = new MaestroAccion();
        }
        return maestroAccion;
    }

    public void setMaestroAccion(MaestroAccion maestroAccion) {
        this.maestroAccion = maestroAccion;
    }

    /**
     * @return the maestro
     */
    public Maestro getMaestro() {
        if (maestro == null) {
            maestro = new Maestro();
        }
        return maestro;
    }

    /**
     * @param maestro the maestro to set
     */
    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    @Override
    public String toString() {
        return "Maestro{" + "id=" + id + ", tipo=" + getTipo() + ", valor=" + valor + ", nombre=" + nombre + ", descripcion=" + descripcion + ", activo=" + getActivoStr() + ", maestroAccion=" + maestroAccion + '}';
    }

}
