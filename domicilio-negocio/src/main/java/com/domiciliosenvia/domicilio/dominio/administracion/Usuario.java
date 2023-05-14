/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.administracion;

import com.domiciliosenvia.domicilio.dominio.generico.Auditoria;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rpalacic
 */
public class Usuario extends Auditoria {

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String usuario, String nombre) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    private Integer id;
    private Empresa empresa = null;
    private String usuario = "";
    private String nombre = "";
    private String correoElectronico = "";
    private String contrasena = "";
    private String contrasenaNueva1 = "";
    private String contrasenaNueva2 = "";
    private String celular = "";
    private String telefono = "";
    private Date fechaInicio = null;
    private Date fechaFin = null;
    private boolean activo = true;
    private Date fechaUltimoIngreso;

    private String correo = "";
    private String encabezado = "";
    private String mensaje = "";
    private List<UsuarioRol> listaRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarioNombre() {
        if ((usuario != null && !usuario.equals("")) && (nombre != null && !nombre.equals(""))) {
            return usuario + " (" + nombre + ")";
        } else if (usuario != null && !usuario.equals("")) {
            return " (" + nombre + ")";
        } else if (nombre != null && !nombre.equals("")) {
            return usuario;
        } else {
            return "";
        }
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasenaNueva1() {
        return contrasenaNueva1;
    }

    public void setContrasenaNueva1(String contrasenaNueva1) {
        this.contrasenaNueva1 = contrasenaNueva1;
    }

    public String getContrasenaNueva2() {
        return contrasenaNueva2;
    }

    public void setContrasenaNueva2(String contrasenaNueva2) {
        this.contrasenaNueva2 = contrasenaNueva2;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public Date getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }

    public void setFechaUltimoIngreso(Date fechaUltimoIngreso) {
        this.fechaUltimoIngreso = fechaUltimoIngreso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<UsuarioRol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<UsuarioRol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", empresa=" + empresa + ", usuario=" + usuario + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", celular=" + celular + ", telefono=" + telefono + ", activo=" + getActivoStr() + '}';
    }

}
