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
@Table(name = "gn_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnUsuarios.findAll", query = "SELECT g FROM GnUsuarios g"),
    @NamedQuery(name = "GnUsuarios.findById", query = "SELECT g FROM GnUsuarios g WHERE g.id = :id"),
    @NamedQuery(name = "GnUsuarios.findByNombre", query = "SELECT g FROM GnUsuarios g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GnUsuarios.findByUsuario", query = "SELECT g FROM GnUsuarios g WHERE g.usuario = :usuario"),
    @NamedQuery(name = "GnUsuarios.findByCorreoElectronico", query = "SELECT g FROM GnUsuarios g WHERE g.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "GnUsuarios.findByContrasena", query = "SELECT g FROM GnUsuarios g WHERE g.contrasena = :contrasena"),
    @NamedQuery(name = "GnUsuarios.findByMaeTipoDocumentoId", query = "SELECT g FROM GnUsuarios g WHERE g.maeTipoDocumentoId = :maeTipoDocumentoId"),
    @NamedQuery(name = "GnUsuarios.findByMaeTipoDocumentoCodigo", query = "SELECT g FROM GnUsuarios g WHERE g.maeTipoDocumentoCodigo = :maeTipoDocumentoCodigo"),
    @NamedQuery(name = "GnUsuarios.findByMaeTipoDocumentoValor", query = "SELECT g FROM GnUsuarios g WHERE g.maeTipoDocumentoValor = :maeTipoDocumentoValor"),
    @NamedQuery(name = "GnUsuarios.findByDocumento", query = "SELECT g FROM GnUsuarios g WHERE g.documento = :documento"),
    @NamedQuery(name = "GnUsuarios.findByTelefono", query = "SELECT g FROM GnUsuarios g WHERE g.telefono = :telefono"),
    @NamedQuery(name = "GnUsuarios.findByCelular", query = "SELECT g FROM GnUsuarios g WHERE g.celular = :celular"),
    @NamedQuery(name = "GnUsuarios.findByActivo", query = "SELECT g FROM GnUsuarios g WHERE g.activo = :activo"),
    @NamedQuery(name = "GnUsuarios.findByFechaUltimoIngreso", query = "SELECT g FROM GnUsuarios g WHERE g.fechaUltimoIngreso = :fechaUltimoIngreso"),
    @NamedQuery(name = "GnUsuarios.findByIntentos", query = "SELECT g FROM GnUsuarios g WHERE g.intentos = :intentos"),
    @NamedQuery(name = "GnUsuarios.findByBloqueado", query = "SELECT g FROM GnUsuarios g WHERE g.bloqueado = :bloqueado"),
    @NamedQuery(name = "GnUsuarios.findByFechaInicio", query = "SELECT g FROM GnUsuarios g WHERE g.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "GnUsuarios.findByFechaFin", query = "SELECT g FROM GnUsuarios g WHERE g.fechaFin = :fechaFin"),
    @NamedQuery(name = "GnUsuarios.findByUsuarioCrea", query = "SELECT g FROM GnUsuarios g WHERE g.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "GnUsuarios.findByTerminalCrea", query = "SELECT g FROM GnUsuarios g WHERE g.terminalCrea = :terminalCrea"),
    @NamedQuery(name = "GnUsuarios.findByFechaHoraCrea", query = "SELECT g FROM GnUsuarios g WHERE g.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "GnUsuarios.findByUsuarioModifica", query = "SELECT g FROM GnUsuarios g WHERE g.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "GnUsuarios.findByTerminalModifica", query = "SELECT g FROM GnUsuarios g WHERE g.terminalModifica = :terminalModifica"),
    @NamedQuery(name = "GnUsuarios.findByFechaHoraModifica", query = "SELECT g FROM GnUsuarios g WHERE g.fechaHoraModifica = :fechaHoraModifica")})
public class GnUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "mae_tipo_documento_id")
    private Integer maeTipoDocumentoId;
    @Size(max = 8)
    @Column(name = "mae_tipo_documento_codigo")
    private String maeTipoDocumentoCodigo;
    @Size(max = 128)
    @Column(name = "mae_tipo_documento_valor")
    private String maeTipoDocumentoValor;
    @Size(max = 16)
    @Column(name = "documento")
    private String documento;
    @Size(max = 16)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 16)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fecha_ultimo_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoIngreso;
    @Column(name = "intentos")
    private Integer intentos;
    @Column(name = "bloqueado")
    private Boolean bloqueado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
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
    @Size(max = 16)
    @Column(name = "terminal_modifica")
    private String terminalModifica;
    @Column(name = "fecha_hora_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModifica;
    @JoinColumn(name = "gn_empresas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GnEmpresas gnEmpresasId;
    @JoinColumn(name = "gn_zonas_horarias_id", referencedColumnName = "id")
    @ManyToOne
    private GnZonasHorarias gnZonasHorariasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnUsuariosId")
    private List<GnRolesUsuario> gnRolesUsuarioList;
    @OneToMany(mappedBy = "gnUsuariosResponsableId")
    private List<AusCasos> ausCasosList;

    public GnUsuarios() {
    }

    public GnUsuarios(Integer id) {
        this.id = id;
    }

    public GnUsuarios(Integer id, String nombre, String usuario, String correoElectronico, String contrasena, boolean activo, Date fechaInicio, String usuarioCrea, String terminalCrea, Date fechaHoraCrea) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.activo = activo;
        this.fechaInicio = fechaInicio;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public Integer getMaeTipoDocumentoId() {
        return maeTipoDocumentoId;
    }

    public void setMaeTipoDocumentoId(Integer maeTipoDocumentoId) {
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean getActivo() {
        return activo;
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

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
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

    public GnEmpresas getGnEmpresasId() {
        return gnEmpresasId;
    }

    public void setGnEmpresasId(GnEmpresas gnEmpresasId) {
        this.gnEmpresasId = gnEmpresasId;
    }

    public GnZonasHorarias getGnZonasHorariasId() {
        return gnZonasHorariasId;
    }

    public void setGnZonasHorariasId(GnZonasHorarias gnZonasHorariasId) {
        this.gnZonasHorariasId = gnZonasHorariasId;
    }

    @XmlTransient
    public List<GnRolesUsuario> getGnRolesUsuarioList() {
        return gnRolesUsuarioList;
    }

    public void setGnRolesUsuarioList(List<GnRolesUsuario> gnRolesUsuarioList) {
        this.gnRolesUsuarioList = gnRolesUsuarioList;
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
        if (!(object instanceof GnUsuarios)) {
            return false;
        }
        GnUsuarios other = (GnUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnUsuarios[ id=" + id + " ]";
    }
    
}
