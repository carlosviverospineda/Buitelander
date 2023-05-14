/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jgramirez
 */
@Entity
@Table(name = "gn_validacion_campos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnValidacionCampos.findAll", query = "SELECT g FROM GnValidacionCampos g"),
    @NamedQuery(name = "GnValidacionCampos.findById", query = "SELECT g FROM GnValidacionCampos g WHERE g.id = :id"),
    @NamedQuery(name = "GnValidacionCampos.findByValidator", query = "SELECT g FROM GnValidacionCampos g WHERE g.validator = :validator"),
    @NamedQuery(name = "GnValidacionCampos.findByNombre", query = "SELECT g FROM GnValidacionCampos g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GnValidacionCampos.findByExpresionRegular", query = "SELECT g FROM GnValidacionCampos g WHERE g.expresionRegular = :expresionRegular")})
public class GnValidacionCampos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "validator")
    private String validator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 64)
    @Column(name = "expresion_regular")
    private String expresionRegular;
    @OneToMany(mappedBy = "gnValidacionCamposId")
    private List<GnMaestros> gnMaestrosList;

    public GnValidacionCampos() {
    }

    public GnValidacionCampos(Integer id) {
        this.id = id;
    }

    public GnValidacionCampos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    @XmlTransient
    public List<GnMaestros> getGnMaestrosList() {
        return gnMaestrosList;
    }

    public void setGnMaestrosList(List<GnMaestros> gnMaestrosList) {
        this.gnMaestrosList = gnMaestrosList;
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
        if (!(object instanceof GnValidacionCampos)) {
            return false;
        }
        GnValidacionCampos other = (GnValidacionCampos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnValidacionCampos[ id=" + id + " ]";
    }
    
}
