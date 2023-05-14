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
@Table(name = "gn_ubicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnUbicaciones.findAll", query = "SELECT g FROM GnUbicaciones g"),
    @NamedQuery(name = "GnUbicaciones.findById", query = "SELECT g FROM GnUbicaciones g WHERE g.id = :id"),
    @NamedQuery(name = "GnUbicaciones.findByNombre", query = "SELECT g FROM GnUbicaciones g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GnUbicaciones.findByTipo", query = "SELECT g FROM GnUbicaciones g WHERE g.tipo = :tipo"),
    @NamedQuery(name = "GnUbicaciones.findByCobertura", query = "SELECT g FROM GnUbicaciones g WHERE g.cobertura = :cobertura"),
    @NamedQuery(name = "GnUbicaciones.findByMaeRegionId", query = "SELECT g FROM GnUbicaciones g WHERE g.maeRegionId = :maeRegionId"),
    @NamedQuery(name = "GnUbicaciones.findByMaeRegionCodigo", query = "SELECT g FROM GnUbicaciones g WHERE g.maeRegionCodigo = :maeRegionCodigo"),
    @NamedQuery(name = "GnUbicaciones.findByMaeRegionValor", query = "SELECT g FROM GnUbicaciones g WHERE g.maeRegionValor = :maeRegionValor"),
    @NamedQuery(name = "GnUbicaciones.findByDescripcion", query = "SELECT g FROM GnUbicaciones g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GnUbicaciones.findByPrefijo", query = "SELECT g FROM GnUbicaciones g WHERE g.prefijo = :prefijo"),
    @NamedQuery(name = "GnUbicaciones.findByIndicativo", query = "SELECT g FROM GnUbicaciones g WHERE g.indicativo = :indicativo"),
    @NamedQuery(name = "GnUbicaciones.findByCodigoPostal", query = "SELECT g FROM GnUbicaciones g WHERE g.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "GnUbicaciones.findByGpsCoordenadas", query = "SELECT g FROM GnUbicaciones g WHERE g.gpsCoordenadas = :gpsCoordenadas"),
    @NamedQuery(name = "GnUbicaciones.findByGpsProfundidad", query = "SELECT g FROM GnUbicaciones g WHERE g.gpsProfundidad = :gpsProfundidad"),
    @NamedQuery(name = "GnUbicaciones.findByUsuarioCrea", query = "SELECT g FROM GnUbicaciones g WHERE g.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "GnUbicaciones.findByTerminalCrea", query = "SELECT g FROM GnUbicaciones g WHERE g.terminalCrea = :terminalCrea"),
    @NamedQuery(name = "GnUbicaciones.findByFechaHoraCrea", query = "SELECT g FROM GnUbicaciones g WHERE g.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "GnUbicaciones.findByUsuarioModifica", query = "SELECT g FROM GnUbicaciones g WHERE g.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "GnUbicaciones.findByTerminalModifica", query = "SELECT g FROM GnUbicaciones g WHERE g.terminalModifica = :terminalModifica"),
    @NamedQuery(name = "GnUbicaciones.findByFechaHoraModifica", query = "SELECT g FROM GnUbicaciones g WHERE g.fechaHoraModifica = :fechaHoraModifica")})
public class GnUbicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Column(name = "cobertura")
    private Boolean cobertura;
    @Column(name = "mae_region_id")
    private Integer maeRegionId;
    @Size(max = 8)
    @Column(name = "mae_region_codigo")
    private String maeRegionCodigo;
    @Size(max = 128)
    @Column(name = "mae_region_valor")
    private String maeRegionValor;
    @Size(max = 512)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 5)
    @Column(name = "prefijo")
    private String prefijo;
    @Size(max = 5)
    @Column(name = "indicativo")
    private String indicativo;
    @Size(max = 8)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Size(max = 64)
    @Column(name = "gps_coordenadas")
    private String gpsCoordenadas;
    @Column(name = "gps_profundidad")
    private Integer gpsProfundidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "usuario_crea")
    private String usuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "terminal_crea")
    private String terminalCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCrea;
    @Size(max = 128)
    @Column(name = "usuario_modifica")
    private String usuarioModifica;
    @Size(max = 15)
    @Column(name = "terminal_modifica")
    private String terminalModifica;
    @Column(name = "fecha_hora_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnUbicacionesId")
    private List<GnEmpresas> gnEmpresasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnUbicacionesId")
    private List<GnSedes> gnSedesList;
    @OneToMany(mappedBy = "gnUbicacionesId")
    private List<GnUbicaciones> gnUbicacionesList;
    @JoinColumn(name = "gn_ubicaciones_id", referencedColumnName = "id")
    @ManyToOne
    private GnUbicaciones gnUbicacionesId;
    @JoinColumn(name = "gn_zonas_horarias_id", referencedColumnName = "id")
    @ManyToOne
    private GnZonasHorarias gnZonasHorariasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnUbicacionesId")
    private List<AusPersonas> ausPersonasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnUbicacionesId")
    private List<GnDivisiones> gnDivisionesList;
    @OneToMany(mappedBy = "gnUbicacionesId")
    private List<AusCasos> ausCasosList;

    public GnUbicaciones() {
    }

    public GnUbicaciones(Integer id) {
        this.id = id;
    }

    public GnUbicaciones(Integer id, String nombre, int tipo, String usuarioCrea, String terminalCrea, Date fechaHoraCrea) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.usuarioCrea = usuarioCrea;
        this.terminalCrea = terminalCrea;
        this.fechaHoraCrea = fechaHoraCrea;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Boolean getCobertura() {
        return cobertura;
    }

    public void setCobertura(Boolean cobertura) {
        this.cobertura = cobertura;
    }

    public Integer getMaeRegionId() {
        return maeRegionId;
    }

    public void setMaeRegionId(Integer maeRegionId) {
        this.maeRegionId = maeRegionId;
    }

    public String getMaeRegionCodigo() {
        return maeRegionCodigo;
    }

    public void setMaeRegionCodigo(String maeRegionCodigo) {
        this.maeRegionCodigo = maeRegionCodigo;
    }

    public String getMaeRegionValor() {
        return maeRegionValor;
    }

    public void setMaeRegionValor(String maeRegionValor) {
        this.maeRegionValor = maeRegionValor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getGpsCoordenadas() {
        return gpsCoordenadas;
    }

    public void setGpsCoordenadas(String gpsCoordenadas) {
        this.gpsCoordenadas = gpsCoordenadas;
    }

    public Integer getGpsProfundidad() {
        return gpsProfundidad;
    }

    public void setGpsProfundidad(Integer gpsProfundidad) {
        this.gpsProfundidad = gpsProfundidad;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getTerminalCrea() {
        return terminalCrea;
    }

    public void setTerminalCrea(String terminalCrea) {
        this.terminalCrea = terminalCrea;
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
    public List<GnEmpresas> getGnEmpresasList() {
        return gnEmpresasList;
    }

    public void setGnEmpresasList(List<GnEmpresas> gnEmpresasList) {
        this.gnEmpresasList = gnEmpresasList;
    }

    @XmlTransient
    public List<GnSedes> getGnSedesList() {
        return gnSedesList;
    }

    public void setGnSedesList(List<GnSedes> gnSedesList) {
        this.gnSedesList = gnSedesList;
    }

    @XmlTransient
    public List<GnUbicaciones> getGnUbicacionesList() {
        return gnUbicacionesList;
    }

    public void setGnUbicacionesList(List<GnUbicaciones> gnUbicacionesList) {
        this.gnUbicacionesList = gnUbicacionesList;
    }

    public GnUbicaciones getGnUbicacionesId() {
        return gnUbicacionesId;
    }

    public void setGnUbicacionesId(GnUbicaciones gnUbicacionesId) {
        this.gnUbicacionesId = gnUbicacionesId;
    }

    public GnZonasHorarias getGnZonasHorariasId() {
        return gnZonasHorariasId;
    }

    public void setGnZonasHorariasId(GnZonasHorarias gnZonasHorariasId) {
        this.gnZonasHorariasId = gnZonasHorariasId;
    }

    @XmlTransient
    public List<AusPersonas> getAusPersonasList() {
        return ausPersonasList;
    }

    public void setAusPersonasList(List<AusPersonas> ausPersonasList) {
        this.ausPersonasList = ausPersonasList;
    }

    @XmlTransient
    public List<GnDivisiones> getGnDivisionesList() {
        return gnDivisionesList;
    }

    public void setGnDivisionesList(List<GnDivisiones> gnDivisionesList) {
        this.gnDivisionesList = gnDivisionesList;
    }

    @XmlTransient
    public List<AusCasos> getAusCasosList() {
        return ausCasosList;
    }

    public void setAusCasosList(List<AusCasos> ausCasosList) {
        this.ausCasosList = ausCasosList;
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
        if (!(object instanceof GnUbicaciones)) {
            return false;
        }
        GnUbicaciones other = (GnUbicaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnUbicaciones[ id=" + id + " ]";
    }
    
}
