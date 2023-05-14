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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgramirez
 */
@Entity
@Table(name = "cnt_prestador_sedes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CntPrestadorSedes.findAll", query = "SELECT c FROM CntPrestadorSedes c"),
    @NamedQuery(name = "CntPrestadorSedes.findById", query = "SELECT c FROM CntPrestadorSedes c WHERE c.id = :id"),
    @NamedQuery(name = "CntPrestadorSedes.findByCodigoPrestador", query = "SELECT c FROM CntPrestadorSedes c WHERE c.codigoPrestador = :codigoPrestador"),
    @NamedQuery(name = "CntPrestadorSedes.findByUbicacionId", query = "SELECT c FROM CntPrestadorSedes c WHERE c.ubicacionId = :ubicacionId"),
    @NamedQuery(name = "CntPrestadorSedes.findByMaeRegionId", query = "SELECT c FROM CntPrestadorSedes c WHERE c.maeRegionId = :maeRegionId"),
    @NamedQuery(name = "CntPrestadorSedes.findByMaeRegionCodigo", query = "SELECT c FROM CntPrestadorSedes c WHERE c.maeRegionCodigo = :maeRegionCodigo"),
    @NamedQuery(name = "CntPrestadorSedes.findByMaeRegionValor", query = "SELECT c FROM CntPrestadorSedes c WHERE c.maeRegionValor = :maeRegionValor"),
    @NamedQuery(name = "CntPrestadorSedes.findByDireccion", query = "SELECT c FROM CntPrestadorSedes c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "CntPrestadorSedes.findByNombre", query = "SELECT c FROM CntPrestadorSedes c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CntPrestadorSedes.findByCodigo", query = "SELECT c FROM CntPrestadorSedes c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CntPrestadorSedes.findByCodigoHabilitacion", query = "SELECT c FROM CntPrestadorSedes c WHERE c.codigoHabilitacion = :codigoHabilitacion"),
    @NamedQuery(name = "CntPrestadorSedes.findByZonaPrecedencia", query = "SELECT c FROM CntPrestadorSedes c WHERE c.zonaPrecedencia = :zonaPrecedencia"),
    @NamedQuery(name = "CntPrestadorSedes.findByEstadoSede", query = "SELECT c FROM CntPrestadorSedes c WHERE c.estadoSede = :estadoSede"),
    @NamedQuery(name = "CntPrestadorSedes.findByNivelAtencion", query = "SELECT c FROM CntPrestadorSedes c WHERE c.nivelAtencion = :nivelAtencion"),
    @NamedQuery(name = "CntPrestadorSedes.findByMaeClasePrestadorId", query = "SELECT c FROM CntPrestadorSedes c WHERE c.maeClasePrestadorId = :maeClasePrestadorId"),
    @NamedQuery(name = "CntPrestadorSedes.findByMaeClasePrestadorCodigo", query = "SELECT c FROM CntPrestadorSedes c WHERE c.maeClasePrestadorCodigo = :maeClasePrestadorCodigo"),
    @NamedQuery(name = "CntPrestadorSedes.findByMaeClasePrestadorValor", query = "SELECT c FROM CntPrestadorSedes c WHERE c.maeClasePrestadorValor = :maeClasePrestadorValor"),
    @NamedQuery(name = "CntPrestadorSedes.findByFax", query = "SELECT c FROM CntPrestadorSedes c WHERE c.fax = :fax"),
    @NamedQuery(name = "CntPrestadorSedes.findByTelefonoCitas", query = "SELECT c FROM CntPrestadorSedes c WHERE c.telefonoCitas = :telefonoCitas"),
    @NamedQuery(name = "CntPrestadorSedes.findByCorreoElectronico", query = "SELECT c FROM CntPrestadorSedes c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "CntPrestadorSedes.findByTelefonoAdministrativo", query = "SELECT c FROM CntPrestadorSedes c WHERE c.telefonoAdministrativo = :telefonoAdministrativo"),
    @NamedQuery(name = "CntPrestadorSedes.findByCapitacion", query = "SELECT c FROM CntPrestadorSedes c WHERE c.capitacion = :capitacion"),
    @NamedQuery(name = "CntPrestadorSedes.findByInteroperabilidad", query = "SELECT c FROM CntPrestadorSedes c WHERE c.interoperabilidad = :interoperabilidad"),
    @NamedQuery(name = "CntPrestadorSedes.findByUsuarioCrea", query = "SELECT c FROM CntPrestadorSedes c WHERE c.usuarioCrea = :usuarioCrea"),
    @NamedQuery(name = "CntPrestadorSedes.findByFechaHoraCrea", query = "SELECT c FROM CntPrestadorSedes c WHERE c.fechaHoraCrea = :fechaHoraCrea"),
    @NamedQuery(name = "CntPrestadorSedes.findByTerminalCrea", query = "SELECT c FROM CntPrestadorSedes c WHERE c.terminalCrea = :terminalCrea"),
    @NamedQuery(name = "CntPrestadorSedes.findByUsuarioModifica", query = "SELECT c FROM CntPrestadorSedes c WHERE c.usuarioModifica = :usuarioModifica"),
    @NamedQuery(name = "CntPrestadorSedes.findByFechaHoraModifica", query = "SELECT c FROM CntPrestadorSedes c WHERE c.fechaHoraModifica = :fechaHoraModifica"),
    @NamedQuery(name = "CntPrestadorSedes.findByTerminalModifica", query = "SELECT c FROM CntPrestadorSedes c WHERE c.terminalModifica = :terminalModifica")})
public class CntPrestadorSedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "codigo_prestador")
    private String codigoPrestador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ubicacion_id")
    private int ubicacionId;
    @Column(name = "mae_region_id")
    private Integer maeRegionId;
    @Size(max = 8)
    @Column(name = "mae_region_codigo")
    private String maeRegionCodigo;
    @Size(max = 128)
    @Column(name = "mae_region_valor")
    private String maeRegionValor;
    @Size(max = 256)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 256)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 16)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 16)
    @Column(name = "codigo_habilitacion")
    private String codigoHabilitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "zona_precedencia")
    private String zonaPrecedencia;
    @Column(name = "estado_sede")
    private Boolean estadoSede;
    @Column(name = "nivel_atencion")
    private Integer nivelAtencion;
    @Column(name = "mae_clase_prestador_id")
    private Integer maeClasePrestadorId;
    @Size(max = 8)
    @Column(name = "mae_clase_prestador_codigo")
    private String maeClasePrestadorCodigo;
    @Size(max = 128)
    @Column(name = "mae_clase_prestador_valor")
    private String maeClasePrestadorValor;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "fax")
    private String fax;
    @Size(max = 64)
    @Column(name = "telefono_citas")
    private String telefonoCitas;
    @Size(max = 64)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 64)
    @Column(name = "telefono_administrativo")
    private String telefonoAdministrativo;
    @Column(name = "capitacion")
    private Boolean capitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interoperabilidad")
    private boolean interoperabilidad;
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
    @JoinColumn(name = "cnt_prestadores_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CntPrestadores cntPrestadoresId;

    public CntPrestadorSedes() {
    }

    public CntPrestadorSedes(Integer id) {
        this.id = id;
    }

    public CntPrestadorSedes(Integer id, String codigoPrestador, int ubicacionId, String zonaPrecedencia, boolean interoperabilidad, String usuarioCrea, Date fechaHoraCrea, String terminalCrea) {
        this.id = id;
        this.codigoPrestador = codigoPrestador;
        this.ubicacionId = ubicacionId;
        this.zonaPrecedencia = zonaPrecedencia;
        this.interoperabilidad = interoperabilidad;
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

    public String getCodigoPrestador() {
        return codigoPrestador;
    }

    public void setCodigoPrestador(String codigoPrestador) {
        this.codigoPrestador = codigoPrestador;
    }

    public int getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(int ubicacionId) {
        this.ubicacionId = ubicacionId;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoHabilitacion() {
        return codigoHabilitacion;
    }

    public void setCodigoHabilitacion(String codigoHabilitacion) {
        this.codigoHabilitacion = codigoHabilitacion;
    }

    public String getZonaPrecedencia() {
        return zonaPrecedencia;
    }

    public void setZonaPrecedencia(String zonaPrecedencia) {
        this.zonaPrecedencia = zonaPrecedencia;
    }

    public Boolean getEstadoSede() {
        return estadoSede;
    }

    public void setEstadoSede(Boolean estadoSede) {
        this.estadoSede = estadoSede;
    }

    public Integer getNivelAtencion() {
        return nivelAtencion;
    }

    public void setNivelAtencion(Integer nivelAtencion) {
        this.nivelAtencion = nivelAtencion;
    }

    public Integer getMaeClasePrestadorId() {
        return maeClasePrestadorId;
    }

    public void setMaeClasePrestadorId(Integer maeClasePrestadorId) {
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefonoCitas() {
        return telefonoCitas;
    }

    public void setTelefonoCitas(String telefonoCitas) {
        this.telefonoCitas = telefonoCitas;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoAdministrativo() {
        return telefonoAdministrativo;
    }

    public void setTelefonoAdministrativo(String telefonoAdministrativo) {
        this.telefonoAdministrativo = telefonoAdministrativo;
    }

    public Boolean getCapitacion() {
        return capitacion;
    }

    public void setCapitacion(Boolean capitacion) {
        this.capitacion = capitacion;
    }

    public boolean getInteroperabilidad() {
        return interoperabilidad;
    }

    public void setInteroperabilidad(boolean interoperabilidad) {
        this.interoperabilidad = interoperabilidad;
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

    public CntPrestadores getCntPrestadoresId() {
        return cntPrestadoresId;
    }

    public void setCntPrestadoresId(CntPrestadores cntPrestadoresId) {
        this.cntPrestadoresId = cntPrestadoresId;
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
        if (!(object instanceof CntPrestadorSedes)) {
            return false;
        }
        CntPrestadorSedes other = (CntPrestadorSedes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.domiciliosenvia.domicilio.ejb.entidades.CntPrestadorSedes[ id=" + id + " ]";
    }
    
}
