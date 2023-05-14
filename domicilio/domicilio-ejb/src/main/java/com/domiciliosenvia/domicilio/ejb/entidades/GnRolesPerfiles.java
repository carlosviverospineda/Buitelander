/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgramirez
 */
@Entity
@Table(name = "gn_roles_perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnRolesPerfiles.findAll", query = "SELECT g FROM GnRolesPerfiles g"),
    @NamedQuery(name = "GnRolesPerfiles.findById", query = "SELECT g FROM GnRolesPerfiles g WHERE g.id = :id")})
public class GnRolesPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "gn_perfiles_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GnPerfiles gnPerfilesId;
    @JoinColumn(name = "gn_roles_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GnRoles gnRolesId;

    public GnRolesPerfiles() {
    }

    public GnRolesPerfiles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GnPerfiles getGnPerfilesId() {
        return gnPerfilesId;
    }

    public void setGnPerfilesId(GnPerfiles gnPerfilesId) {
        this.gnPerfilesId = gnPerfilesId;
    }

    public GnRoles getGnRolesId() {
        return gnRolesId;
    }

    public void setGnRolesId(GnRoles gnRolesId) {
        this.gnRolesId = gnRolesId;
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
        if (!(object instanceof GnRolesPerfiles)) {
            return false;
        }
        GnRolesPerfiles other = (GnRolesPerfiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnRolesPerfiles[ id=" + id + " ]";
    }
    
}
