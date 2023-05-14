/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgramirez
 */
@Entity
@Table(name = "gn_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnPermisos.findAll", query = "SELECT g FROM GnPermisos g"),
    @NamedQuery(name = "GnPermisos.findByGnModulosId", query = "SELECT g FROM GnPermisos g WHERE g.gnPermisosPK.gnModulosId = :gnModulosId"),
    @NamedQuery(name = "GnPermisos.findByGnPerfilesId", query = "SELECT g FROM GnPermisos g WHERE g.gnPermisosPK.gnPerfilesId = :gnPerfilesId"),
    @NamedQuery(name = "GnPermisos.findByPrivilegios", query = "SELECT g FROM GnPermisos g WHERE g.privilegios = :privilegios")})
public class GnPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GnPermisosPK gnPermisosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "privilegios")
    private String privilegios;
    @JoinColumn(name = "gn_modulos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GnModulos gnModulos;
    @JoinColumn(name = "gn_perfiles_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GnPerfiles gnPerfiles;

    public GnPermisos() {
    }

    public GnPermisos(GnPermisosPK gnPermisosPK) {
        this.gnPermisosPK = gnPermisosPK;
    }

    public GnPermisos(GnPermisosPK gnPermisosPK, String privilegios) {
        this.gnPermisosPK = gnPermisosPK;
        this.privilegios = privilegios;
    }

    public GnPermisos(int gnModulosId, int gnPerfilesId) {
        this.gnPermisosPK = new GnPermisosPK(gnModulosId, gnPerfilesId);
    }

    public GnPermisosPK getGnPermisosPK() {
        return gnPermisosPK;
    }

    public void setGnPermisosPK(GnPermisosPK gnPermisosPK) {
        this.gnPermisosPK = gnPermisosPK;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    public GnModulos getGnModulos() {
        return gnModulos;
    }

    public void setGnModulos(GnModulos gnModulos) {
        this.gnModulos = gnModulos;
    }

    public GnPerfiles getGnPerfiles() {
        return gnPerfiles;
    }

    public void setGnPerfiles(GnPerfiles gnPerfiles) {
        this.gnPerfiles = gnPerfiles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gnPermisosPK != null ? gnPermisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GnPermisos)) {
            return false;
        }
        GnPermisos other = (GnPermisos) object;
        if ((this.gnPermisosPK == null && other.gnPermisosPK != null) || (this.gnPermisosPK != null && !this.gnPermisosPK.equals(other.gnPermisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnPermisos[ gnPermisosPK=" + gnPermisosPK + " ]";
    }
    
}
