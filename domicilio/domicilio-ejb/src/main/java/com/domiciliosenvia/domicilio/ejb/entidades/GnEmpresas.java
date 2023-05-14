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
@Table(name = "gn_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnEmpresas.findAll", query = "SELECT g FROM GnEmpresas g"),
    @NamedQuery(name = "GnEmpresas.findById", query = "SELECT g FROM GnEmpresas g WHERE g.id = :id"),
    @NamedQuery(name = "GnEmpresas.findByRazonSocial", query = "SELECT g FROM GnEmpresas g WHERE g.razonSocial = :razonSocial"),
    @NamedQuery(name = "GnEmpresas.findByNit", query = "SELECT g FROM GnEmpresas g WHERE g.nit = :nit"),
    @NamedQuery(name = "GnEmpresas.findByNombreComercial", query = "SELECT g FROM GnEmpresas g WHERE g.nombreComercial = :nombreComercial"),
    @NamedQuery(name = "GnEmpresas.findByDescripcion", query = "SELECT g FROM GnEmpresas g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GnEmpresas.findByAdministradora", query = "SELECT g FROM GnEmpresas g WHERE g.administradora = :administradora"),
    @NamedQuery(name = "GnEmpresas.findByActiva", query = "SELECT g FROM GnEmpresas g WHERE g.activa = :activa"),
    @NamedQuery(name = "GnEmpresas.findByCodigoHabilitacion", query = "SELECT g FROM GnEmpresas g WHERE g.codigoHabilitacion = :codigoHabilitacion"),
    @NamedQuery(name = "GnEmpresas.findByContrasenaLongitudMinimo", query = "SELECT g FROM GnEmpresas g WHERE g.contrasenaLongitudMinimo = :contrasenaLongitudMinimo"),
    @NamedQuery(name = "GnEmpresas.findByContrasenaLongitudMaximo", query = "SELECT g FROM GnEmpresas g WHERE g.contrasenaLongitudMaximo = :contrasenaLongitudMaximo"),
    @NamedQuery(name = "GnEmpresas.findByContrasenaDiasVencimiento", query = "SELECT g FROM GnEmpresas g WHERE g.contrasenaDiasVencimiento = :contrasenaDiasVencimiento"),
    @NamedQuery(name = "GnEmpresas.findByContrasenaDiasNotificacion", query = "SELECT g FROM GnEmpresas g WHERE g.contrasenaDiasNotificacion = :contrasenaDiasNotificacion"),
    @NamedQuery(name = "GnEmpresas.findByContrasenaIntentos", query = "SELECT g FROM GnEmpresas g WHERE g.contrasenaIntentos = :contrasenaIntentos"),
    @NamedQuery(name = "GnEmpresas.findByReceptorUsuario", query = "SELECT g FROM GnEmpresas g WHERE g.receptorUsuario = :receptorUsuario"),
    @NamedQuery(name = "GnEmpresas.findByReceptorContrasena", query = "SELECT g FROM GnEmpresas g WHERE g.receptorContrasena = :receptorContrasena"),
    @NamedQuery(name = "GnEmpresas.findByUsuarioCrea", query = "SELECT g FROM GnEmpresas g WHERE g.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "GnEmpresas.findByTerminalCrea", query = "SELECT g FROM GnEmpresas g WHERE g.terminalCrea = :terminalCrea"),
    @NamedQuery(name = "GnEmpresas.findByFechaHoraCrea", query = "SELECT g FROM GnEmpresas g WHERE g.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "GnEmpresas.findByUsuarioModifica", query = "SELECT g FROM GnEmpresas g WHERE g.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "GnEmpresas.findByTerminalModifica", query = "SELECT g FROM GnEmpresas g WHERE g.terminalModifica = :terminalModifica"),
    @NamedQuery(name = "GnEmpresas.findByFechaHoraModifica", query = "SELECT g FROM GnEmpresas g WHERE g.fechaHoraModifica = :fechaHoraModifica")})
public class GnEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Size(max = 512)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "administradora")
    private boolean administradora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa")
    private boolean activa;
    @Size(max = 13)
    @Column(name = "codigo_habilitacion")
    private String codigoHabilitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contrasena_longitud_minimo")
    private int contrasenaLongitudMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contrasena_longitud_maximo")
    private int contrasenaLongitudMaximo;
    @Column(name = "contrasena_dias_vencimiento")
    private Integer contrasenaDiasVencimiento;
    @Column(name = "contrasena_dias_notificacion")
    private Integer contrasenaDiasNotificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contrasena_intentos")
    private int contrasenaIntentos;
    @Size(max = 8)
    @Column(name = "receptor_usuario")
    private String receptorUsuario;
    @Size(max = 8)
    @Column(name = "receptor_contrasena")
    private String receptorContrasena;
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
    @JoinColumn(name = "cnt_prestadores_id", referencedColumnName = "id")
    @ManyToOne
    private CntPrestadores cntPrestadoresId;
    @JoinColumn(name = "gn_ubicaciones_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GnUbicaciones gnUbicacionesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnEmpresasId")
    private List<GnSedes> gnSedesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnEmpresasId")
    private List<GnUsuarios> gnUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gnEmpresasId")
    private List<AusCasos> ausCasosList;

    public GnEmpresas() {
    }

    public GnEmpresas(Integer id) {
        this.id = id;
    }

    public GnEmpresas(Integer id, String razonSocial, String nit, String nombreComercial, boolean administradora, boolean activa, int contrasenaLongitudMinimo, int contrasenaLongitudMaximo, int contrasenaIntentos, String usuarioCrea, String terminalCrea, Date fechaHoraCrea) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.nombreComercial = nombreComercial;
        this.administradora = administradora;
        this.activa = activa;
        this.contrasenaLongitudMinimo = contrasenaLongitudMinimo;
        this.contrasenaLongitudMaximo = contrasenaLongitudMaximo;
        this.contrasenaIntentos = contrasenaIntentos;
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getAdministradora() {
        return administradora;
    }

    public void setAdministradora(boolean administradora) {
        this.administradora = administradora;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getCodigoHabilitacion() {
        return codigoHabilitacion;
    }

    public void setCodigoHabilitacion(String codigoHabilitacion) {
        this.codigoHabilitacion = codigoHabilitacion;
    }

    public int getContrasenaLongitudMinimo() {
        return contrasenaLongitudMinimo;
    }

    public void setContrasenaLongitudMinimo(int contrasenaLongitudMinimo) {
        this.contrasenaLongitudMinimo = contrasenaLongitudMinimo;
    }

    public int getContrasenaLongitudMaximo() {
        return contrasenaLongitudMaximo;
    }

    public void setContrasenaLongitudMaximo(int contrasenaLongitudMaximo) {
        this.contrasenaLongitudMaximo = contrasenaLongitudMaximo;
    }

    public Integer getContrasenaDiasVencimiento() {
        return contrasenaDiasVencimiento;
    }

    public void setContrasenaDiasVencimiento(Integer contrasenaDiasVencimiento) {
        this.contrasenaDiasVencimiento = contrasenaDiasVencimiento;
    }

    public Integer getContrasenaDiasNotificacion() {
        return contrasenaDiasNotificacion;
    }

    public void setContrasenaDiasNotificacion(Integer contrasenaDiasNotificacion) {
        this.contrasenaDiasNotificacion = contrasenaDiasNotificacion;
    }

    public int getContrasenaIntentos() {
        return contrasenaIntentos;
    }

    public void setContrasenaIntentos(int contrasenaIntentos) {
        this.contrasenaIntentos = contrasenaIntentos;
    }

    public String getReceptorUsuario() {
        return receptorUsuario;
    }

    public void setReceptorUsuario(String receptorUsuario) {
        this.receptorUsuario = receptorUsuario;
    }

    public String getReceptorContrasena() {
        return receptorContrasena;
    }

    public void setReceptorContrasena(String receptorContrasena) {
        this.receptorContrasena = receptorContrasena;
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

    public CntPrestadores getCntPrestadoresId() {
        return cntPrestadoresId;
    }

    public void setCntPrestadoresId(CntPrestadores cntPrestadoresId) {
        this.cntPrestadoresId = cntPrestadoresId;
    }

    public GnUbicaciones getGnUbicacionesId() {
        return gnUbicacionesId;
    }

    public void setGnUbicacionesId(GnUbicaciones gnUbicacionesId) {
        this.gnUbicacionesId = gnUbicacionesId;
    }

    @XmlTransient
    public List<GnSedes> getGnSedesList() {
        return gnSedesList;
    }

    public void setGnSedesList(List<GnSedes> gnSedesList) {
        this.gnSedesList = gnSedesList;
    }

    @XmlTransient
    public List<GnUsuarios> getGnUsuariosList() {
        return gnUsuariosList;
    }

    public void setGnUsuariosList(List<GnUsuarios> gnUsuariosList) {
        this.gnUsuariosList = gnUsuariosList;
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
        if (!(object instanceof GnEmpresas)) {
            return false;
        }
        GnEmpresas other = (GnEmpresas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.GnEmpresas[ id=" + id + " ]";
    }
    
}
