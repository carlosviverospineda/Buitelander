/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.administracion;

import java.io.Serializable;

/**
 *
 * @author Fabian Coronel
 */
public class GnConfiguracionObj implements Serializable {
    
    public static final int RUTA_HISTORICO = 1;
    
    private Integer id;
    private String nombre;
    private String valor;

    public GnConfiguracionObj() {
    }

    public GnConfiguracionObj(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GnConfiguracionObj{" + "id=" + id + ", nombre=" + nombre + ", valor=" + valor + '}';
    }

   
}
