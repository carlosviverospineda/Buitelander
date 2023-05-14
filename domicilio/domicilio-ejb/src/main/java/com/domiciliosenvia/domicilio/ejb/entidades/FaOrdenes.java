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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhoan.ramirez_pragma
 */
@Entity
@Table(name = "fa_ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaOrdenes.findAll", query = "SELECT f FROM FaOrdenes f"),
    @NamedQuery(name = "FaOrdenes.findById", query = "SELECT f FROM FaOrdenes f WHERE f.id = :id"),
    @NamedQuery(name = "FaOrdenes.findByEstado", query = "SELECT f FROM FaOrdenes f WHERE f.estado = :estado"),
    @NamedQuery(name = "FaOrdenes.findByMaeTipoOrden", query = "SELECT f FROM FaOrdenes f WHERE f.maeTipoOrden = :maeTipoOrden"),
    @NamedQuery(name = "FaOrdenes.findByFechaOrden", query = "SELECT f FROM FaOrdenes f WHERE f.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "FaOrdenes.findBySubTotalSinIva", query = "SELECT f FROM FaOrdenes f WHERE f.subTotalSinIva = :subTotalSinIva"),
    @NamedQuery(name = "FaOrdenes.findByValorDescuento", query = "SELECT f FROM FaOrdenes f WHERE f.valorDescuento = :valorDescuento"),
    @NamedQuery(name = "FaOrdenes.findByValorAdicional", query = "SELECT f FROM FaOrdenes f WHERE f.valorAdicional = :valorAdicional"),
    @NamedQuery(name = "FaOrdenes.findBySubTotal", query = "SELECT f FROM FaOrdenes f WHERE f.subTotal = :subTotal"),
    @NamedQuery(name = "FaOrdenes.findByPorcentajeIimpuesto", query = "SELECT f FROM FaOrdenes f WHERE f.porcentajeIimpuesto = :porcentajeIimpuesto"),
    @NamedQuery(name = "FaOrdenes.findByValorImpuesto", query = "SELECT f FROM FaOrdenes f WHERE f.valorImpuesto = :valorImpuesto"),
    @NamedQuery(name = "FaOrdenes.findByPorcentajeRetefuente", query = "SELECT f FROM FaOrdenes f WHERE f.porcentajeRetefuente = :porcentajeRetefuente"),
    @NamedQuery(name = "FaOrdenes.findByValorRetefuente", query = "SELECT f FROM FaOrdenes f WHERE f.valorRetefuente = :valorRetefuente"),
    @NamedQuery(name = "FaOrdenes.findByValorIva", query = "SELECT f FROM FaOrdenes f WHERE f.valorIva = :valorIva"),
    @NamedQuery(name = "FaOrdenes.findByTotal", query = "SELECT f FROM FaOrdenes f WHERE f.total = :total"),
    @NamedQuery(name = "FaOrdenes.findByAnticipo", query = "SELECT f FROM FaOrdenes f WHERE f.anticipo = :anticipo"),
    @NamedQuery(name = "FaOrdenes.findByPlazo", query = "SELECT f FROM FaOrdenes f WHERE f.plazo = :plazo"),
    @NamedQuery(name = "FaOrdenes.findByElaboro", query = "SELECT f FROM FaOrdenes f WHERE f.elaboro = :elaboro"),
    @NamedQuery(name = "FaOrdenes.findByAprobo", query = "SELECT f FROM FaOrdenes f WHERE f.aprobo = :aprobo")})
public class FaOrdenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "mae_tipo_orden")
    private Integer maeTipoOrden;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sub_total_sin_iva")
    private Double subTotalSinIva;
    @Column(name = "valor_descuento")
    private Double valorDescuento;
    @Column(name = "valor_adicional")
    private Double valorAdicional;
    @Column(name = "sub_total")
    private Double subTotal;
    @Column(name = "porcentajeI_impuesto")
    private Double porcentajeIimpuesto;
    @Column(name = "valor_impuesto")
    private Double valorImpuesto;
    @Column(name = "porcentaje_retefuente")
    private Double porcentajeRetefuente;
    @Column(name = "valor_retefuente")
    private Double valorRetefuente;
    @Column(name = "valor_iva")
    private Double valorIva;
    @Column(name = "total")
    private Double total;
    @Column(name = "anticipo")
    private Double anticipo;
    @Size(max = 100)
    @Column(name = "plazo")
    private String plazo;
    @Size(max = 100)
    @Column(name = "elaboro")
    private String elaboro;
    @Size(max = 100)
    @Column(name = "aprobo")
    private String aprobo;

    public FaOrdenes() {
    }

    public FaOrdenes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getMaeTipoOrden() {
        return maeTipoOrden;
    }

    public void setMaeTipoOrden(Integer maeTipoOrden) {
        this.maeTipoOrden = maeTipoOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSubTotalSinIva() {
        return subTotalSinIva;
    }

    public void setSubTotalSinIva(Double subTotalSinIva) {
        this.subTotalSinIva = subTotalSinIva;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getPorcentajeIimpuesto() {
        return porcentajeIimpuesto;
    }

    public void setPorcentajeIimpuesto(Double porcentajeIimpuesto) {
        this.porcentajeIimpuesto = porcentajeIimpuesto;
    }

    public Double getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(Double valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    public Double getPorcentajeRetefuente() {
        return porcentajeRetefuente;
    }

    public void setPorcentajeRetefuente(Double porcentajeRetefuente) {
        this.porcentajeRetefuente = porcentajeRetefuente;
    }

    public Double getValorRetefuente() {
        return valorRetefuente;
    }

    public void setValorRetefuente(Double valorRetefuente) {
        this.valorRetefuente = valorRetefuente;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Double anticipo) {
        this.anticipo = anticipo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getElaboro() {
        return elaboro;
    }

    public void setElaboro(String elaboro) {
        this.elaboro = elaboro;
    }

    public String getAprobo() {
        return aprobo;
    }

    public void setAprobo(String aprobo) {
        this.aprobo = aprobo;
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
        if (!(object instanceof FaOrdenes)) {
            return false;
        }
        FaOrdenes other = (FaOrdenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.FaOrdenes[ id=" + id + " ]";
    }
    
}
