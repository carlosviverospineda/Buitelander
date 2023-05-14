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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cnt_prestadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CntPrestadores.findAll", query = "SELECT c FROM CntPrestadores c"),
    @NamedQuery(name = "CntPrestadores.findById", query = "SELECT c FROM CntPrestadores c WHERE c.id = :id"),
    @NamedQuery(name = "CntPrestadores.findByCodigoMinSalud", query = "SELECT c FROM CntPrestadores c WHERE c.codigoMinSalud = :codigoMinSalud"),
    @NamedQuery(name = "CntPrestadores.findByActivo", query = "SELECT c FROM CntPrestadores c WHERE c.activo = :activo"),
    @NamedQuery(name = "CntPrestadores.findByMaeTipoDocumentoId", query = "SELECT c FROM CntPrestadores c WHERE c.maeTipoDocumentoId = :maeTipoDocumentoId"),
    @NamedQuery(name = "CntPrestadores.findByMaeTipoDocumentoCodigo", query = "SELECT c FROM CntPrestadores c WHERE c.maeTipoDocumentoCodigo = :maeTipoDocumentoCodigo"),
    @NamedQuery(name = "CntPrestadores.findByMaeTipoDocumentoValor", query = "SELECT c FROM CntPrestadores c WHERE c.maeTipoDocumentoValor = :maeTipoDocumentoValor"),
    @NamedQuery(name = "CntPrestadores.findByNumeroDocumento", query = "SELECT c FROM CntPrestadores c WHERE c.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "CntPrestadores.findByDigitoVerificacion", query = "SELECT c FROM CntPrestadores c WHERE c.digitoVerificacion = :digitoVerificacion"),
    @NamedQuery(name = "CntPrestadores.findByRazonSocial", query = "SELECT c FROM CntPrestadores c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "CntPrestadores.findByNaturalezaJuridica", query = "SELECT c FROM CntPrestadores c WHERE c.naturalezaJuridica = :naturalezaJuridica"),
    @NamedQuery(name = "CntPrestadores.findByPrefijo", query = "SELECT c FROM CntPrestadores c WHERE c.prefijo = :prefijo"),
    @NamedQuery(name = "CntPrestadores.findByFacturacionElectronica", query = "SELECT c FROM CntPrestadores c WHERE c.facturacionElectronica = :facturacionElectronica"),
    @NamedQuery(name = "CntPrestadores.findByMaeClasePrestadorId", query = "SELECT c FROM CntPrestadores c WHERE c.maeClasePrestadorId = :maeClasePrestadorId"),
    @NamedQuery(name = "CntPrestadores.findByMaeClasePrestadorCodigo", query = "SELECT c FROM CntPrestadores c WHERE c.maeClasePrestadorCodigo = :maeClasePrestadorCodigo"),
    @NamedQuery(name = "CntPrestadores.findByMaeClasePrestadorValor", query = "SELECT c FROM CntPrestadores c WHERE c.maeClasePrestadorValor = :maeClasePrestadorValor"),
    @NamedQuery(name = "CntPrestadores.findByCategoriaPrestador", query = "SELECT c FROM CntPrestadores c WHERE c.categoriaPrestador = :categoriaPrestador"),
    @NamedQuery(name = "CntPrestadores.findByNivelAtencion", query = "SELECT c FROM CntPrestadores c WHERE c.nivelAtencion = :nivelAtencion"),
    @NamedQuery(name = "CntPrestadores.findByMaeTipoDocumentoRepId", query = "SELECT c FROM CntPrestadores c WHERE c.maeTipoDocumentoRepId = :maeTipoDocumentoRepId"),
    @NamedQuery(name = "CntPrestadores.findByMaeTipoDocumentoRepCodigo", query = "SELECT c FROM CntPrestadores c WHERE c.maeTipoDocumentoRepCodigo = :maeTipoDocumentoRepCodigo"),
    @NamedQuery(name = "CntPrestadores.findByMaeTipoDocumentoRepValor", query = "SELECT c FROM CntPrestadores c WHERE c.maeTipoDocumentoRepValor = :maeTipoDocumentoRepValor"),
    @NamedQuery(name = "CntPrestadores.findByNumeroDocumentoRep", query = "SELECT c FROM CntPrestadores c WHERE c.numeroDocumentoRep = :numeroDocumentoRep"),
    @NamedQuery(name = "CntPrestadores.findByNombreRepresentanteLegal", query = "SELECT c FROM CntPrestadores c WHERE c.nombreRepresentanteLegal = :nombreRepresentanteLegal"),
    @NamedQuery(name = "CntPrestadores.findByUsuarioCrea", query = "SELECT c FROM CntPrestadores c WHERE c.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "CntPrestadores.findByFechaHoraCrea", query = "SELECT c FROM CntPrestadores c WHERE c.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "CntPrestadores.findByTerminalCrea", query = "SELECT c FROM CntPrestadores c WHERE c.terminalCrea = :terminalCrea"),
    @NamedQuery(name = "CntPrestadores.findByUsuarioModifica", query = "SELECT c FROM CntPrestadores c WHERE c.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "CntPrestadores.findByFechaHoraModifica", query = "SELECT c FROM CntPrestadores c WHERE c.fechaHoraModifica = :fechaHoraModifica"),
    @NamedQuery(name = "CntPrestadores.findByTerminalModifica", query = "SELECT c FROM CntPrestadores c WHERE c.terminalModifica = :terminalModifica")})
public class CntPrestadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 16)
    @Column(name = "codigo_min_salud")
    private String codigoMinSalud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mae_tipo_documento_id")
    private int maeTipoDocumentoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mae_tipo_documento_codigo")
    private String maeTipoDocumentoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "mae_tipo_documento_valor")
    private String maeTipoDocumentoValor;
    @Size(max = 32)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Size(max = 8)
    @Column(name = "digito_verificacion")
    private String digitoVerificacion;
    @Size(max = 256)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "naturaleza_juridica")
    private String naturalezaJuridica;
    @Size(max = 8)
    @Column(name = "prefijo")
    private String prefijo;
    @Column(name = "facturacion_electronica")
    private Boolean facturacionElectronica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mae_clase_prestador_id")
    private int maeClasePrestadorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mae_clase_prestador_codigo")
    private String maeClasePrestadorCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "mae_clase_prestador_valor")
    private String maeClasePrestadorValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria_prestador")
    private int categoriaPrestador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel_atencion")
    private int nivelAtencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mae_tipo_documento_rep_id")
    private int maeTipoDocumentoRepId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mae_tipo_documento_rep_codigo")
    private String maeTipoDocumentoRepCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "mae_tipo_documento_rep_valor")
    private String maeTipoDocumentoRepValor;
    @Size(max = 32)
    @Column(name = "numero_documento_rep")
    private String numeroDocumentoRep;
    @Size(max = 256)
    @Column(name = "nombre_representante_legal")
    private String nombreRepresentanteLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "usuario_crea")
    private String usuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "terminal_crea")
    private String terminalCrea;
    @Size(max = 64)
    @Column(name = "usuario_modifica")
    private String usuarioModifica;
    @Column(name = "fecha_hora_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModifica;
    @Size(max = 64)
    @Column(name = "terminal_modifica")
    private String terminalModifica;
    @OneToMany(mappedBy = "cntPrestadoresId")
    private List<GnEmpresas> gnEmpresasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cntPrestadoresId")
    private List<CntPrestadorSedes> cntPrestadorSedesList;

    public CntPrestadores() {
    }

    public CntPrestadores(Integer id) {
        this.id = id;
    }

    public CntPrestadores(Integer id, boolean activo, int maeTipoDocumentoId, String maeTipoDocumentoCodigo, String maeTipoDocumentoValor, String naturalezaJuridica, int maeClasePrestadorId, String maeClasePrestadorCodigo, String maeClasePrestadorValor, int categoriaPrestador, int nivelAtencion, int maeTipoDocumentoRepId, String maeTipoDocumentoRepCodigo, String maeTipoDocumentoRepValor, String usuarioCrea, Date fechaHoraCrea, String terminalCrea) {
        this.id = id;
        this.activo = activo;
        this.maeTipoDocumentoId = maeTipoDocumentoId;
        this.maeTipoDocumentoCodigo = maeTipoDocumentoCodigo;
        this.maeTipoDocumentoValor = maeTipoDocumentoValor;
        this.naturalezaJuridica = naturalezaJuridica;
        this.maeClasePrestadorId = maeClasePrestadorId;
        this.maeClasePrestadorCodigo = maeClasePrestadorCodigo;
        this.maeClasePrestadorValor = maeClasePrestadorValor;
        this.categoriaPrestador = categoriaPrestador;
        this.nivelAtencion = nivelAtencion;
        this.maeTipoDocumentoRepId = maeTipoDocumentoRepId;
        this.maeTipoDocumentoRepCodigo = maeTipoDocumentoRepCodigo;
        this.maeTipoDocumentoRepValor = maeTipoDocumentoRepValor;
        this.usuarioCrea = usuarioCrea;
        this.fechaHoraCrea = fechaHoraCrea;
        this.terminalCrea = terminalCrea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoMinSalud() {
        return codigoMinSalud;
    }

    public void setCodigoMinSalud(String codigoMinSalud) {
        this.codigoMinSalud = codigoMinSalud;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getMaeTipoDocumentoId() {
        return maeTipoDocumentoId;
    }

    public void setMaeTipoDocumentoId(int maeTipoDocumentoId) {
        this.maeTipoDocumentoId = maeTipoDocumentoId;
    }

    public String getMaeTipoDocumentoCodigo() {
        return maeTipoDocumentoCodigo;
    }

    public void setMaeTipoDocumentoCodigo(String maeTipoDocumentoCodigo) {
        this.maeTipoDocumentoCodigo = maeTipoDocumentoCodigo;
    }

    public String getMaeTipoDocumentoValor() {
        return maeTipoDocumentoValor;
    }

    public void setMaeTipoDocumentoValor(String maeTipoDocumentoValor) {
        this.maeTipoDocumentoValor = maeTipoDocumentoValor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNaturalezaJuridica() {
        return naturalezaJuridica;
    }

    public void setNaturalezaJuridica(String naturalezaJuridica) {
        this.naturalezaJuridica = naturalezaJuridica;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Boolean getFacturacionElectronica() {
        return facturacionElectronica;
    }

    public void setFacturacionElectronica(Boolean facturacionElectronica) {
        this.facturacionElectronica = facturacionElectronica;
    }

    public int getMaeClasePrestadorId() {
        return maeClasePrestadorId;
    }

    public void setMaeClasePrestadorId(int maeClasePrestadorId) {
        this.maeClasePrestadorId = maeClasePrestadorId;
    }

    public String getMaeClasePrestadorCodigo() {
        return maeClasePrestadorCodigo;
    }

    public void setMaeClasePrestadorCodigo(String maeClasePrestadorCodigo) {
        this.maeClasePrestadorCodigo = maeClasePrestadorCodigo;
    }

    public String getMaeClasePrestadorValor() {
        return maeClasePrestadorValor;
    }

    public void setMaeClasePrestadorValor(String maeClasePrestadorValor) {
        this.maeClasePrestadorValor = maeClasePrestadorValor;
    }

    public int getCategoriaPrestador() {
        return categoriaPrestador;
    }

    public void setCategoriaPrestador(int categoriaPrestador) {
        this.categoriaPrestador = categoriaPrestador;
    }

    public int getNivelAtencion() {
        return nivelAtencion;
    }

    public void setNivelAtencion(int nivelAtencion) {
        this.nivelAtencion = nivelAtencion;
    }

    public int getMaeTipoDocumentoRepId() {
        return maeTipoDocumentoRepId;
    }

    public void setMaeTipoDocumentoRepId(int maeTipoDocumentoRepId) {
        this.maeTipoDocumentoRepId = maeTipoDocumentoRepId;
    }

    public String getMaeTipoDocumentoRepCodigo() {
        return maeTipoDocumentoRepCodigo;
    }

    public void setMaeTipoDocumentoRepCodigo(String maeTipoDocumentoRepCodigo) {
        this.maeTipoDocumentoRepCodigo = maeTipoDocumentoRepCodigo;
    }

    public String getMaeTipoDocumentoRepValor() {
        return maeTipoDocumentoRepValor;
    }

    public void setMaeTipoDocumentoRepValor(String maeTipoDocumentoRepValor) {
        this.maeTipoDocumentoRepValor = maeTipoDocumentoRepValor;
    }

    public String getNumeroDocumentoRep() {
        return numeroDocumentoRep;
    }

    public void setNumeroDocumentoRep(String numeroDocumentoRep) {
        this.numeroDocumentoRep = numeroDocumentoRep;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaHoraCrea() {
        return fechaHoraCrea;
    }

    public void setFechaHoraCrea(Date fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }

    public String getTerminalCrea() {
        return terminalCrea;
    }

    public void setTerminalCrea(String terminalCrea) {
        this.terminalCrea = terminalCrea;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaHoraModifica() {
        return fechaHoraModifica;
    }

    public void setFechaHoraModifica(Date fechaHoraModifica) {
        this.fechaHoraModifica = fechaHoraModifica;
    }

    public String getTerminalModifica() {
        return terminalModifica;
    }

    public void setTerminalModifica(String terminalModifica) {
        this.terminalModifica = terminalModifica;
    }

    @XmlTransient
    public List<GnEmpresas> getGnEmpresasList() {
        return gnEmpresasList;
    }

    public void setGnEmpresasList(List<GnEmpresas> gnEmpresasList) {
        this.gnEmpresasList = gnEmpresasList;
    }

    @XmlTransient
    public List<CntPrestadorSedes> getCntPrestadorSedesList() {
        return cntPrestadorSedesList;
    }

    public void setCntPrestadorSedesList(List<CntPrestadorSedes> cntPrestadorSedesList) {
        this.cntPrestadorSedesList = cntPrestadorSedesList;
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
        if (!(object instanceof CntPrestadores)) {
            return false;
        }
        CntPrestadores other = (CntPrestadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.CntPrestadores[ id=" + id + " ]";
    }
    
}
