/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgramirez
 */
@Entity
@Table(name = "gn_correo_envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnCorreoEnvios.findAll", query = "SELECT g FROM GnCorreoEnvios g"),
    @NamedQuery(name = "GnCorreoEnvios.findById", query = "SELECT g FROM GnCorreoEnvios g WHERE g.id = :id"),
    @NamedQuery(name = "GnCorreoEnvios.findByOrigen", query = "SELECT g FROM GnCorreoEnvios g WHERE g.origen = :origen"),
    @NamedQuery(name = "GnCorreoEnvios.findByEncabezado", query = "SELECT g FROM GnCorreoEnvios g WHERE g.encabezado = :encabezado"),
    @NamedQuery(name = "GnCorreoEnvios.findByDetalle", query = "SELECT g FROM GnCorreoEnvios g WHERE g.detalle = :detalle"),
    @NamedQuery(name = "GnCorreoEnvios.findByEstado", query = "SELECT g FROM GnCorreoEnvios g WHERE g.estado = :estado"),
    @NamedQuery(name = "GnCorreoEnvios.findByFechaHoraCrea", query = "SELECT g FROM GnCorreoEnvios g WHERE g.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "GnCorreoEnvios.findByFechaHoraEnvio", query = "SELECT g FROM GnCorreoEnvios g WHERE g.fechaHoraEnvio = :fechaHoraEnvio")})
public class GnCorreoEnvios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "origen")
    private int origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "encabezado")
    private String encabezado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2048)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCrea;
    @Column(name = "fecha_hora_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEnvio;

    public GnCorreoEnvios() {
    }

    public GnCorreoEnvios(Integer id) {
        this.id = id;
    }

    public GnCorreoEnvios(Integer id, int origen, String encabezado, String detalle, int estado, Date fechaHoraCrea) {
        this.id = id;
        this.origen = origen;
        this.encabezado = encabezado;
        this.detalle = detalle;
        this.estado = estado;
        this.fechaHoraCrea = fechaHoraCrea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaHoraCrea() {
        return fechaHoraCrea;
    }

    public void setFechaHoraCrea(Date fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }

    public Date getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Date fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GnCorreoEnvios)) {
            return false;
        }
        GnCorreoEnvios other = (GnCorreoEnvios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnCorreoEnvios[ id=" + id + " ]";
    }
    
}
