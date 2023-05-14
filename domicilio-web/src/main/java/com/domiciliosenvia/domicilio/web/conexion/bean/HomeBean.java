/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.conexion.bean;

//import com.domiciliosenvia.domicilio.web.administracion.bean.EmpresaBean;
import com.domiciliosenvia.domicilio.dominio.administracion.Empresa;
import com.domiciliosenvia.domicilio.dominio.administracion.Modulo;
import com.domiciliosenvia.domicilio.dominio.administracion.ModuloManual;
import com.domiciliosenvia.domicilio.dominio.administracion.ModuloVersion;
import com.domiciliosenvia.domicilio.dominio.administracion.Usuario;
import com.domiciliosenvia.domicilio.web.utilidades.Conexion;
import com.domiciliosenvia.domicilio.web.utilidades.Url;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.domiciliosenvia.domicilio.web.administracion.servicio.ConexionServicioIface;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import javax.annotation.PostConstruct;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author raul-palacios
 */
@ManagedBean
@RequestScoped
public class HomeBean extends Url {

    private Usuario usuario = new Usuario();
    private Empresa empresa = new Empresa();
    private ModuloVersion moduloVersion;
    private GregorianCalendar fechaHoraConexion = null;
//    private List<EmpresaBean> empresas = new ArrayList();
    private List<Empresa> empresasConFiltro;
    private int moduloAbierto;

    @PostConstruct
    public void init() {
        try {
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            moduloVersion = (ModuloVersion) sessionMap.get("version");
        } catch (Exception e) {
            moduloVersion = null;
        }
    }

    private ConexionServicioIface conexionServicio;

    public ConexionServicioIface getConexionServicio() {
        return conexionServicio;
    }

    public void setConexionServicio(ConexionServicioIface conexionServicio) {
        this.conexionServicio = conexionServicio;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public GregorianCalendar getFechaHoraConexion() {
        return fechaHoraConexion;
    }

    public void setFechaHoraConexion(GregorianCalendar fechaHoraConexion) {
        this.fechaHoraConexion = fechaHoraConexion;
    }

    public ModuloVersion getModuloVersion() {
        return moduloVersion;
    }

    public void setModuloVersion(ModuloVersion moduloVersion) {
        this.moduloVersion = moduloVersion;
    }

    public List<Empresa> getEmpresasActivas() {
        List<Empresa> list = new ArrayList();
        try {
            list = getConexionServicio().consultarEmpresasActivas();
        } catch (Exception ex) {
            addError("No fue posible cargar la lista de lista de Empresdas (" + ex.getMessage() + ")");
        }
        generarMensajes();
        return list;
    }

//    public List<EmpresaBean> getEmpresas() {
//        return empresas;
//    }
//
//    public void setEmpresas(List<EmpresaBean> empresas) {
//        this.empresas = empresas;
//    }

    public int getModuloAbierto() {
        return moduloAbierto;
    }

    public void setModuloAbierto(int moduloAbierto) {
        this.moduloAbierto = moduloAbierto;
    }

    public List<Empresa> getEmpresasConFiltro() {
        empresasConFiltro = new ArrayList();
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Conexion conexion = (Conexion) session.getAttribute("conexion");
        for (Empresa emp : conexion.getEmpresas()) {
            if (!Objects.equals(conexion.getEmpresa().getId(), emp.getId())) {
                empresasConFiltro.add(emp);
            }
        }
        return empresasConFiltro;
    }

    public String aperturaOpcion(String _url) {
        return _url;
    }

    public String aperturaOpcion(int _id) {
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Conexion conexion = (Conexion) session.getAttribute("conexion");

        for (Modulo _mod : conexion.getModulos()) {
            if (_mod.getId() == _id) {
                return _mod.getUrl() + "?faces-redirect=true";
            }
        }
        return "/home?faces-redirect=true";
    }

    public void construccion() {
        addMessage("En Construcción", "Opción en construcción");
        generarMensajes();
    }

    public String refrescar() {
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Conexion conexion = (Conexion) session.getAttribute("conexion");
        setEmpresa(conexion.getEmpresa());
        return "/home?faces-redirect=true";
    }

    public void cambioEmpresa() {
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Conexion conexion = (Conexion) session.getAttribute("conexion");
        for (Empresa _empresa : getConexion().getEmpresas()) {
            if (Objects.equals(_empresa.getId(), getEmpresa().getId())) {
                setEmpresa(_empresa);
                conexion.setEmpresa(_empresa);
                break;
            }
        }
//        conexion.setEmpresa(getEmpresa());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("conexion", conexion);
        try {
            externalContext.redirect("/savia/home.faces");
        } catch (IOException ex) {
            //TODO capturar error y mandar mensaje
        }
    }

    public String cambiarContrasena() {
        return "/contrasena?faces-redirect=true";
    }

    public String salir() {
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.removeAttribute("conexion");
        session.invalidate();
        return "/login?faces-redirect=true";
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public StreamedContent generarManual() {
        StreamedContent streamedContent = null;
        try {
            //Validar si es Usuario Interno o Externo
            ModuloManual moduloManual = null;
            if (super.getConexion().getEmpresa().getId() == 1) {
                moduloManual = getConexionServicio().consultarManual(moduloAbierto == 0 ? 1 : moduloAbierto, ModuloManual.TIPO_MANUAL_INTERNO);
            } else {
                moduloManual = getConexionServicio().consultarManual(moduloAbierto == 0 ? 1 : moduloAbierto, ModuloManual.TIPO_MANUAL_EXTERNO);
            }
            if (moduloManual.getArchivo() != null) {
                File manual = new File(moduloManual.getRuta().concat(moduloManual.getArchivo()));
                InputStream stream = new FileInputStream(manual);
                stream.mark(0); //remember to this position!
                streamedContent = new DefaultStreamedContent(stream, "application/pdf", moduloManual.getArchivo());
            } else {
                this.addError("No se encontró manual interno para descargar en esta opción");
                generarMensajes();
                return null;
            }
        } catch (Exception ex) {
            streamedContent = null;
            this.addError("Error al descargar el manual: " + ex.toString() + ex.getMessage());
            generarMensajes();
        }
        return streamedContent;
    }

    public String actionDone() {
        return "done?faces-redirect=true";
    }

    //bean
    public String navigate(String url) {
        return url + ".xhtml?faces-redirect=true";
    }

}
