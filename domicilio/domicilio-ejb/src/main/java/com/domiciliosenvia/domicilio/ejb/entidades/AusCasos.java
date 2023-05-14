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
@Table(name = "aus_casos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AusCasos.findAll", query = "SELECT a FROM AusCasos a"),
    @NamedQuery(name = "AusCasos.findById", query = "SELECT a FROM AusCasos a WHERE a.id = :id"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudEstadoId", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudEstadoId = :maeSolicitudEstadoId"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudEstadoCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudEstadoCodigo = :maeSolicitudEstadoCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudEstadoValor", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudEstadoValor = :maeSolicitudEstadoValor"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudTipoId", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudTipoId = :maeSolicitudTipoId"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudTipoCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudTipoCodigo = :maeSolicitudTipoCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudTipoValor", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudTipoValor = :maeSolicitudTipoValor"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudOrigenId", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudOrigenId = :maeSolicitudOrigenId"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudOrigenCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudOrigenCodigo = :maeSolicitudOrigenCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudOrigenValor", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudOrigenValor = :maeSolicitudOrigenValor"),
    @NamedQuery(name = "AusCasos.findByMaeCanalSupersaludId", query = "SELECT a FROM AusCasos a WHERE a.maeCanalSupersaludId = :maeCanalSupersaludId"),
    @NamedQuery(name = "AusCasos.findByMaeCanalSupersaludCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeCanalSupersaludCodigo = :maeCanalSupersaludCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeCanalSupersaludValor", query = "SELECT a FROM AusCasos a WHERE a.maeCanalSupersaludValor = :maeCanalSupersaludValor"),
    @NamedQuery(name = "AusCasos.findByRadicado", query = "SELECT a FROM AusCasos a WHERE a.radicado = :radicado"),
    @NamedQuery(name = "AusCasos.findByPertinencia", query = "SELECT a FROM AusCasos a WHERE a.pertinencia = :pertinencia"),
    @NamedQuery(name = "AusCasos.findByMultireparto", query = "SELECT a FROM AusCasos a WHERE a.multireparto = :multireparto"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudPrioridadId", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudPrioridadId = :maeSolicitudPrioridadId"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudPrioridadCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudPrioridadCodigo = :maeSolicitudPrioridadCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudPrioridadValor", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudPrioridadValor = :maeSolicitudPrioridadValor"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudEnteControlId", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudEnteControlId = :maeSolicitudEnteControlId"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudEnteControlCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudEnteControlCodigo = :maeSolicitudEnteControlCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudEnteControValor", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudEnteControValor = :maeSolicitudEnteControValor"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudRiesgoVidalId", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudRiesgoVidalId = :maeSolicitudRiesgoVidalId"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudRiesgoVidalCodigo", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudRiesgoVidalCodigo = :maeSolicitudRiesgoVidalCodigo"),
    @NamedQuery(name = "AusCasos.findByMaeSolicitudRiesgoVidalValor", query = "SELECT a FROM AusCasos a WHERE a.maeSolicitudRiesgoVidalValor = :maeSolicitudRiesgoVidalValor"),
    @NamedQuery(name = "AusCasos.findByFechaNotificacion", query = "SELECT a FROM AusCasos a WHERE a.fechaNotificacion = :fechaNotificacion"),
    @NamedQuery(name = "AusCasos.findByFechaCiere", query = "SELECT a FROM AusCasos a WHERE a.fechaCiere = :fechaCiere"),
    @NamedQuery(name = "AusCasos.findByAfiliadoEdad", query = "SELECT a FROM AusCasos a WHERE a.afiliadoEdad = :afiliadoEdad"),
    @NamedQuery(name = "AusCasos.findByAccionanteEdad", query = "SELECT a FROM AusCasos a WHERE a.accionanteEdad = :accionanteEdad"),
    @NamedQuery(name = "AusCasos.findByParentesco", query = "SELECT a FROM AusCasos a WHERE a.parentesco = :parentesco"),
    @NamedQuery(name = "AusCasos.findByFechaVencimiento", query = "SELECT a FROM AusCasos a WHERE a.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "AusCasos.findByFechaHoraResponsable", query = "SELECT a FROM AusCasos a WHERE a.fechaHoraResponsable = :fechaHoraResponsable"),
    @NamedQuery(name = "AusCasos.findByMultiusuario", query = "SELECT a FROM AusCasos a WHERE a.multiusuario = :multiusuario"),
    @NamedQuery(name = "AusCasos.findByInstruccion", query = "SELECT a FROM AusCasos a WHERE a.instruccion = :instruccion"),
    @NamedQuery(name = "AusCasos.findByReabierto", query = "SELECT a FROM AusCasos a WHERE a.reabierto = :reabierto"),
    @NamedQuery(name = "AusCasos.findByFalloTutela", query = "SELECT a FROM AusCasos a WHERE a.falloTutela = :falloTutela"),
    @NamedQuery(name = "AusCasos.findByRedireccionado", query = "SELECT a FROM AusCasos a WHERE a.redireccionado = :redireccionado"),
    @NamedQuery(name = "AusCasos.findByUsuarioCrea", query = "SELECT a FROM AusCasos a WHERE a.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "AusCasos.findByTerminalCrea", query = "SELECT a FROM AusCasos a WHERE a.terminalCrea = :terminalCrea"),
    @NamedQuery(name = "AusCasos.findByFechaHoraCrea", query = "SELECT a FROM AusCasos a WHERE a.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "AusCasos.findByUsuarioModifica", query = "SELECT a FROM AusCasos a WHERE a.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "AusCasos.findByTerminalModifica", query = "SELECT a FROM AusCasos a WHERE a.terminalModifica = :terminalModifica"),
    @NamedQuery(name = "AusCasos.findByFechaHoraModifica", query = "SELECT a FROM AusCasos a WHERE a.fechaHoraModifica = :fechaHoraModifica")})
public class AusCasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mae_solicitud_estado_id")
    private Integer maeSolicitudEstadoId;
    @Size(max = 32)
    @Column(name = "mae_solicitud_estado_codigo")
    private String maeSolicitudEstadoCodigo;
    @Size(max = 512)
    @Column(name = "mae_solicitud_estado_valor")
    private String maeSolicitudEstadoValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mae_solicitud_tipo_id")
    private int maeSolicitudTipoId;
    @Size(max = 32)
    @Column(name = "mae_solicitud_tipo_codigo")
    private String maeSolicitudTipoCodigo;
    @Size(max = 512)
    @Column(name = "mae_solicitud_tipo_valor")
    private String maeSolicitudTipoValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mae_solicitud_origen_id")
    private int maeSolicitudOrigenId;
    @Size(max = 32)
    @Column(name = "mae_solicitud_origen_codigo")
    private String maeSolicitudOrigenCodigo;
    @Size(max = 512)
    @Column(name = "mae_solicitud_origen_valor")
    private String maeSolicitudOrigenValor;
    @Column(name = "mae_canal_supersalud_id")
    private Integer maeCanalSupersaludId;
    @Size(max = 32)
    @Column(name = "mae_canal_supersalud_codigo")
    private String maeCanalSupersaludCodigo;
    @Size(max = 512)
    @Column(name = "mae_canal_supersalud_valor")
    private String maeCanalSupersaludValor;
    @Size(max = 32)
    @Column(name = "radicado")
    private String radicado;
    @Column(name = "pertinencia")
    private Boolean pertinencia;
    @Column(name = "multireparto")
    private Boolean multireparto;
    @Column(name = "mae_solicitud_prioridad_id")
    private Integer maeSolicitudPrioridadId;
    @Size(max = 32)
    @Column(name = "mae_solicitud_prioridad_codigo")
    private String maeSolicitudPrioridadCodigo;
    @Size(max = 512)
    @Column(name = "mae_solicitud_prioridad_valor")
    private String maeSolicitudPrioridadValor;
    @Column(name = "mae_solicitud_ente_control_id")
    private Integer maeSolicitudEnteControlId;
    @Size(max = 32)
    @Column(name = "mae_solicitud_ente_control_codigo")
    private String maeSolicitudEnteControlCodigo;
    @Size(max = 512)
    @Column(name = "mae_solicitud_ente_contro_valor")
    private String maeSolicitudEnteControValor;
    @Column(name = "mae_solicitud_riesgo_vidal_id")
    private Integer maeSolicitudRiesgoVidalId;
    @Size(max = 32)
    @Column(name = "mae_solicitud_riesgo_vidal_codigo")
    private String maeSolicitudRiesgoVidalCodigo;
    @Size(max = 512)
    @Column(name = "mae_solicitud_riesgo_vidal_valor")
    private String maeSolicitudRiesgoVidalValor;
    @Column(name = "fecha_notificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotificacion;
    @Column(name = "fecha_ciere")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCiere;
    @Column(name = "afiliado_edad")
    private Short afiliadoEdad;
    @Column(name = "accionante_edad")
    private Boolean accionanteEdad;
    @Size(max = 32)
    @Column(name = "parentesco")
    private String parentesco;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Column(name = "fecha_hora_responsable")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraResponsable;
    @Size(max = 32)
    @Column(name = "multiusuario")
    private String multiusuario;
    @Column(name = "instruccion")
    private Boolean instruccion;
    @Column(name = "reabierto")
    private Boolean reabierto;
    @Column(name = "fallo_tutela")
    private Boolean falloTutela;
    @Column(name = "redireccionado")
    private Boolean redireccionado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ausCasosId")
    private List<AusSeguimientos> ausSeguimientosList;
    @JoinColumn(name = "aus_personas_id", referencedColumnName = "id")
    @ManyToOne
    private AusPersonas ausPersonasId;
    @JoinColumn(name = "aus_accionante_personas_id", referencedColumnName = "id")
    @ManyToOne
    private AusPersonas ausAccionantePersonasId;
    @JoinColumn(name = "gn_empresas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GnEmpresas gnEmpresasId;
    @JoinColumn(name = "gn_sedes_id", referencedColumnName = "id")
    @ManyToOne
    private GnSedes gnSedesId;
    @JoinColumn(name = "gn_ubicaciones_id", referencedColumnName = "id")
    @ManyToOne
    private GnUbicaciones gnUbicacionesId;
    @JoinColumn(name = "gn_usuarios_responsable_id", referencedColumnName = "id")
    @ManyToOne
    private GnUsuarios gnUsuariosResponsableId;

    public AusCasos() {
    }

    public AusCasos(Integer id) {
        this.id = id;
    }

    public AusCasos(Integer id, int maeSolicitudTipoId, int maeSolicitudOrigenId, String usuarioCrea, String terminalCrea, Date fechaHoraCrea) {
        this.id = id;
        this.maeSolicitudTipoId = maeSolicitudTipoId;
        this.maeSolicitudOrigenId = maeSolicitudOrigenId;
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

    public Integer getMaeSolicitudEstadoId() {
        return maeSolicitudEstadoId;
    }

    public void setMaeSolicitudEstadoId(Integer maeSolicitudEstadoId) {
        this.maeSolicitudEstadoId = maeSolicitudEstadoId;
    }

    public String getMaeSolicitudEstadoCodigo() {
        return maeSolicitudEstadoCodigo;
    }

    public void setMaeSolicitudEstadoCodigo(String maeSolicitudEstadoCodigo) {
        this.maeSolicitudEstadoCodigo = maeSolicitudEstadoCodigo;
    }

    public String getMaeSolicitudEstadoValor() {
        return maeSolicitudEstadoValor;
    }

    public void setMaeSolicitudEstadoValor(String maeSolicitudEstadoValor) {
        this.maeSolicitudEstadoValor = maeSolicitudEstadoValor;
    }

    public int getMaeSolicitudTipoId() {
        return maeSolicitudTipoId;
    }

    public void setMaeSolicitudTipoId(int maeSolicitudTipoId) {
        this.maeSolicitudTipoId = maeSolicitudTipoId;
    }

    public String getMaeSolicitudTipoCodigo() {
        return maeSolicitudTipoCodigo;
    }

    public void setMaeSolicitudTipoCodigo(String maeSolicitudTipoCodigo) {
        this.maeSolicitudTipoCodigo = maeSolicitudTipoCodigo;
    }

    public String getMaeSolicitudTipoValor() {
        return maeSolicitudTipoValor;
    }

    public void setMaeSolicitudTipoValor(String maeSolicitudTipoValor) {
        this.maeSolicitudTipoValor = maeSolicitudTipoValor;
    }

    public int getMaeSolicitudOrigenId() {
        return maeSolicitudOrigenId;
    }

    public void setMaeSolicitudOrigenId(int maeSolicitudOrigenId) {
        this.maeSolicitudOrigenId = maeSolicitudOrigenId;
    }

    public String getMaeSolicitudOrigenCodigo() {
        return maeSolicitudOrigenCodigo;
    }

    public void setMaeSolicitudOrigenCodigo(String maeSolicitudOrigenCodigo) {
        this.maeSolicitudOrigenCodigo = maeSolicitudOrigenCodigo;
    }

    public String getMaeSolicitudOrigenValor() {
        return maeSolicitudOrigenValor;
    }

    public void setMaeSolicitudOrigenValor(String maeSolicitudOrigenValor) {
        this.maeSolicitudOrigenValor = maeSolicitudOrigenValor;
    }

    public Integer getMaeCanalSupersaludId() {
        return maeCanalSupersaludId;
    }

    public void setMaeCanalSupersaludId(Integer maeCanalSupersaludId) {
        this.maeCanalSupersaludId = maeCanalSupersaludId;
    }

    public String getMaeCanalSupersaludCodigo() {
        return maeCanalSupersaludCodigo;
    }

    public void setMaeCanalSupersaludCodigo(String maeCanalSupersaludCodigo) {
        this.maeCanalSupersaludCodigo = maeCanalSupersaludCodigo;
    }

    public String getMaeCanalSupersaludValor() {
        return maeCanalSupersaludValor;
    }

    public void setMaeCanalSupersaludValor(String maeCanalSupersaludValor) {
        this.maeCanalSupersaludValor = maeCanalSupersaludValor;
    }

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public Boolean getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(Boolean pertinencia) {
        this.pertinencia = pertinencia;
    }

    public Boolean getMultireparto() {
        return multireparto;
    }

    public void setMultireparto(Boolean multireparto) {
        this.multireparto = multireparto;
    }

    public Integer getMaeSolicitudPrioridadId() {
        return maeSolicitudPrioridadId;
    }

    public void setMaeSolicitudPrioridadId(Integer maeSolicitudPrioridadId) {
        this.maeSolicitudPrioridadId = maeSolicitudPrioridadId;
    }

    public String getMaeSolicitudPrioridadCodigo() {
        return maeSolicitudPrioridadCodigo;
    }

    public void setMaeSolicitudPrioridadCodigo(String maeSolicitudPrioridadCodigo) {
        this.maeSolicitudPrioridadCodigo = maeSolicitudPrioridadCodigo;
    }

    public String getMaeSolicitudPrioridadValor() {
        return maeSolicitudPrioridadValor;
    }

    public void setMaeSolicitudPrioridadValor(String maeSolicitudPrioridadValor) {
        this.maeSolicitudPrioridadValor = maeSolicitudPrioridadValor;
    }

    public Integer getMaeSolicitudEnteControlId() {
        return maeSolicitudEnteControlId;
    }

    public void setMaeSolicitudEnteControlId(Integer maeSolicitudEnteControlId) {
        this.maeSolicitudEnteControlId = maeSolicitudEnteControlId;
    }

    public String getMaeSolicitudEnteControlCodigo() {
        return maeSolicitudEnteControlCodigo;
    }

    public void setMaeSolicitudEnteControlCodigo(String maeSolicitudEnteControlCodigo) {
        this.maeSolicitudEnteControlCodigo = maeSolicitudEnteControlCodigo;
    }

    public String getMaeSolicitudEnteControValor() {
        return maeSolicitudEnteControValor;
    }

    public void setMaeSolicitudEnteControValor(String maeSolicitudEnteControValor) {
        this.maeSolicitudEnteControValor = maeSolicitudEnteControValor;
    }

    public Integer getMaeSolicitudRiesgoVidalId() {
        return maeSolicitudRiesgoVidalId;
    }

    public void setMaeSolicitudRiesgoVidalId(Integer maeSolicitudRiesgoVidalId) {
        this.maeSolicitudRiesgoVidalId = maeSolicitudRiesgoVidalId;
    }

    public String getMaeSolicitudRiesgoVidalCodigo() {
        return maeSolicitudRiesgoVidalCodigo;
    }

    public void setMaeSolicitudRiesgoVidalCodigo(String maeSolicitudRiesgoVidalCodigo) {
        this.maeSolicitudRiesgoVidalCodigo = maeSolicitudRiesgoVidalCodigo;
    }

    public String getMaeSolicitudRiesgoVidalValor() {
        return maeSolicitudRiesgoVidalValor;
    }

    public void setMaeSolicitudRiesgoVidalValor(String maeSolicitudRiesgoVidalValor) {
        this.maeSolicitudRiesgoVidalValor = maeSolicitudRiesgoVidalValor;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Date getFechaCiere() {
        return fechaCiere;
    }

    public void setFechaCiere(Date fechaCiere) {
        this.fechaCiere = fechaCiere;
    }

    public Short getAfiliadoEdad() {
        return afiliadoEdad;
    }

    public void setAfiliadoEdad(Short afiliadoEdad) {
        this.afiliadoEdad = afiliadoEdad;
    }

    public Boolean getAccionanteEdad() {
        return accionanteEdad;
    }

    public void setAccionanteEdad(Boolean accionanteEdad) {
        this.accionanteEdad = accionanteEdad;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaHoraResponsable() {
        return fechaHoraResponsable;
    }

    public void setFechaHoraResponsable(Date fechaHoraResponsable) {
        this.fechaHoraResponsable = fechaHoraResponsable;
    }

    public String getMultiusuario() {
        return multiusuario;
    }

    public void setMultiusuario(String multiusuario) {
        this.multiusuario = multiusuario;
    }

    public Boolean getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(Boolean instruccion) {
        this.instruccion = instruccion;
    }

    public Boolean getReabierto() {
        return reabierto;
    }

    public void setReabierto(Boolean reabierto) {
        this.reabierto = reabierto;
    }

    public Boolean getFalloTutela() {
        return falloTutela;
    }

    public void setFalloTutela(Boolean falloTutela) {
        this.falloTutela = falloTutela;
    }

    public Boolean getRedireccionado() {
        return redireccionado;
    }

    public void setRedireccionado(Boolean redireccionado) {
        this.redireccionado = redireccionado;
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
    public List<AusSeguimientos> getAusSeguimientosList() {
        return ausSeguimientosList;
    }

    public void setAusSeguimientosList(List<AusSeguimientos> ausSeguimientosList) {
        this.ausSeguimientosList = ausSeguimientosList;
    }

    public AusPersonas getAusPersonasId() {
        return ausPersonasId;
    }

    public void setAusPersonasId(AusPersonas ausPersonasId) {
        this.ausPersonasId = ausPersonasId;
    }

    public AusPersonas getAusAccionantePersonasId() {
        return ausAccionantePersonasId;
    }

    public void setAusAccionantePersonasId(AusPersonas ausAccionantePersonasId) {
        this.ausAccionantePersonasId = ausAccionantePersonasId;
    }

    public GnEmpresas getGnEmpresasId() {
        return gnEmpresasId;
    }

    public void setGnEmpresasId(GnEmpresas gnEmpresasId) {
        this.gnEmpresasId = gnEmpresasId;
    }

    public GnSedes getGnSedesId() {
        return gnSedesId;
    }

    public void setGnSedesId(GnSedes gnSedesId) {
        this.gnSedesId = gnSedesId;
    }

    public GnUbicaciones getGnUbicacionesId() {
        return gnUbicacionesId;
    }

    public void setGnUbicacionesId(GnUbicaciones gnUbicacionesId) {
        this.gnUbicacionesId = gnUbicacionesId;
    }

    public GnUsuarios getGnUsuariosResponsableId() {
        return gnUsuariosResponsableId;
    }

    public void setGnUsuariosResponsableId(GnUsuarios gnUsuariosResponsableId) {
        this.gnUsuariosResponsableId = gnUsuariosResponsableId;
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
        if (!(object instanceof AusCasos)) {
            return false;
        }
        AusCasos other = (AusCasos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.AusCasos[ id=" + id + " ]";
    }
    
}
