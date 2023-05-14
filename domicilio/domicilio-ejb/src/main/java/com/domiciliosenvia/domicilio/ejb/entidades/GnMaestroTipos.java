/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jgramirez
 */
@Entity
@Table(name = "gn_maestro_tipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnMaestroTipos.findAll", query = "SELECT g FROM GnMaestroTipos g"),
    @NamedQuery(name = "GnMaestroTipos.findByTipo", query = "SELECT g FROM GnMaestroTipos g WHERE g.tipo = :tipo"),
    @NamedQuery(name = "GnMaestroTipos.findByNombre", query = "SELECT g FROM GnMaestroTipos g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GnMaestroTipos.findByActivo", query = "SELECT g FROM GnMaestroTipos g WHERE g.activo = :activo"),
    @NamedQuery(name = "GnMaestroTipos.findByFechaHoraCrea", query = "SELECT g FROM GnMaestroTipos g WHERE g.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "GnMaestroTipos.findByUsuarioModifica", query = "SELECT g FROM GnMaestroTipos g WHERE g.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "GnMaestroTipos.findByTerminalModifica", query = "SELECT g FROM GnMaestroTipos g WHERE g.terminalModifica = :terminalModifica"),
    @NamedQuery(name = "GnMaestroTipos.findByFechaHoraModifica", query = "SELECT g FROM GnMaestroTipos g WHERE g.fechaHoraModifica = :fechaHoraModifica")})
public class GnMaestroTipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fecha_hora_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCrea;
    @Size(max = 128)
    @Column(name = "usuario_modifica")
    private String usuarioModifica;
    @Size(max = 16)
    @Column(name = "terminal_modifica")
    private String terminalModifica;
    @Column(name = "fecha_hora_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<GnMaestros> gnMaestrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maestrosTipo")
    private List<GnMaestroAcciones> gnMaestroAccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnMaestroTiposTipoPadre")
    private List<GnMaestroTipoRelaciones> gnMaestroTipoRelacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnMaestroTiposTipoHijo")
    private List<GnMaestroTipoRelaciones> gnMaestroTipoRelacionesList1;
    @OneToMany(mappedBy = "gnMaestroTiposTipo")
    private List<GnMaestroTipos> gnMaestroTiposList;
    @JoinColumn(name = "gn_maestro_tipos_tipo", referencedColumnName = "tipo")
    @ManyToOne
    private GnMaestroTipos gnMaestroTiposTipo;
    @JoinColumn(name = "gn_perfiles_id", referencedColumnName = "id")
    @ManyToOne
    private GnPerfiles gnPerfilesId;

    public GnMaestroTipos() {
    }

    public GnMaestroTipos(String tipo) {
        this.tipo = tipo;
    }

    public GnMaestroTipos(String tipo, String nombre, boolean activo) {
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaHoraCrea() {
        return fechaHoraCrea;
    }

    public void setFechaHoraCrea(Date fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public String getTerminalModifica() {
        return terminalModifica;
    }

    public void setTerminalModifica(String terminalModifica) {
        this.terminalModifica = terminalModifica;
    }

    public Date getFechaHoraModifica() {
        return fechaHoraModifica;
    }

    public void setFechaHoraModifica(Date fechaHoraModifica) {
        this.fechaHoraModifica = fechaHoraModifica;
    }

    @XmlTransient
    public List<GnMaestros> getGnMaestrosList() {
        return gnMaestrosList;
    }

    public void setGnMaestrosList(List<GnMaestros> gnMaestrosList) {
        this.gnMaestrosList = gnMaestrosList;
    }

    @XmlTransient
    public List<GnMaestroAcciones> getGnMaestroAccionesList() {
        return gnMaestroAccionesList;
    }

    public void setGnMaestroAccionesList(List<GnMaestroAcciones> gnMaestroAccionesList) {
        this.gnMaestroAccionesList = gnMaestroAccionesList;
    }

    @XmlTransient
    public List<GnMaestroTipoRelaciones> getGnMaestroTipoRelacionesList() {
        return gnMaestroTipoRelacionesList;
    }

    public void setGnMaestroTipoRelacionesList(List<GnMaestroTipoRelaciones> gnMaestroTipoRelacionesList) {
        this.gnMaestroTipoRelacionesList = gnMaestroTipoRelacionesList;
    }

    @XmlTransient
    public List<GnMaestroTipoRelaciones> getGnMaestroTipoRelacionesList1() {
        return gnMaestroTipoRelacionesList1;
    }

    public void setGnMaestroTipoRelacionesList1(List<GnMaestroTipoRelaciones> gnMaestroTipoRelacionesList1) {
        this.gnMaestroTipoRelacionesList1 = gnMaestroTipoRelacionesList1;
    }

    @XmlTransient
    public List<GnMaestroTipos> getGnMaestroTiposList() {
        return gnMaestroTiposList;
    }

    public void setGnMaestroTiposList(List<GnMaestroTipos> gnMaestroTiposList) {
        this.gnMaestroTiposList = gnMaestroTiposList;
    }

    public GnMaestroTipos getGnMaestroTiposTipo() {
        return gnMaestroTiposTipo;
    }

    public void setGnMaestroTiposTipo(GnMaestroTipos gnMaestroTiposTipo) {
        this.gnMaestroTiposTipo = gnMaestroTiposTipo;
    }

    public GnPerfiles getGnPerfilesId() {
        return gnPerfilesId;
    }

    public void setGnPerfilesId(GnPerfiles gnPerfilesId) {
        this.gnPerfilesId = gnPerfilesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipo != null ? tipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GnMaestroTipos)) {
            return false;
        }
        GnMaestroTipos other = (GnMaestroTipos) object;
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnMaestroTipos[ tipo=" + tipo + " ]";
    }
    
}
