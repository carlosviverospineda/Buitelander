/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.administracion;

import java.io.Serializable;

/**
 *
 * @author ripalacios
 */
public class MaestroAccion implements Serializable{
    
//    public static final int TIPO_PRODUCTO_PRODUCTO = 8;
//    public static final int TIPO_PRODUCTO_SERVICIO = 9;
    
    public static final int GN_SEXO_APLICA_MUJER = 1;
    public static final int GN_SEXO_APLICA_HOMBRE = 2;
    public static final int ASEG_ESTADO_AFILIACION_AFILIADO_ACTIVO = 3;
    public static final int ASEG_ESTADO_AFILIACION_AFILIADO_INACTIVO = 4;
    public static final int ASEG_PORTABILIDAD_ESTADO_PORTABILIDAD_VIGENTE = 5;
    public static final int ASEG_PORTABILIDAD_ESTADO_PORTABILIDAD_NO_VIGENTE = 6;

    private Integer id;
    private MaestroTipo maestrosTipo;
    private String nombre;
    private String descripcion;
    private Integer idGrupo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MaestroTipo getMaestrosTipo() {
        return maestrosTipo;
    }

    public void setMaestrosTipo(MaestroTipo maestrosTipo) {
        this.maestrosTipo = maestrosTipo;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    
    
}
