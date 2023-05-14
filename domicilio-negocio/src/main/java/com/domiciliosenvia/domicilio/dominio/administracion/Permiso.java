package com.domiciliosenvia.domicilio.dominio.administracion;

import com.domiciliosenvia.domicilio.dominio.generico.Auditoria;
import java.util.Objects;

public class Permiso extends Auditoria {

    private Modulo modulo;
    private Perfil perfil;
    private String privilegios;
    private boolean listarPermiso;
    private boolean verPermiso;
    private boolean crearPermiso;
    private boolean editarPermiso;
    private boolean borrarPermiso;
    private boolean accionAdicional1Permiso;
    private boolean accionAdicional2Permiso;
    private boolean accionAdicional3Permiso;
    private boolean accionAdicional4Permiso;
    private boolean accionAdicional5Permiso;
    private boolean accionAdicional6Permiso;
    private boolean accionAdicional7Permiso;
    private boolean accionAdicional8Permiso;
    private boolean accionAdicional9Permiso;
    private boolean accionAdicional10Permiso;
    private boolean accionAdicional11Permiso;

    public Permiso() {
    }

    public Modulo getModulo() {
        return modulo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getPrivilegios() {
        return this.privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    public boolean isListarPermiso() {
        return listarPermiso;
    }

    public boolean isVerPermiso() {
        return verPermiso;
    }

    public boolean isCrearPermiso() {
        return crearPermiso;
    }

    public boolean isEditarPermiso() {
        return editarPermiso;
    }

    public boolean isBorrarPermiso() {
        return borrarPermiso;
    }

    public boolean isAccionAdicional1Permiso() {
        return accionAdicional1Permiso;
    }

    public boolean isAccionAdicional2Permiso() {
        return accionAdicional2Permiso;
    }

    public boolean isAccionAdicional3Permiso() {
        return accionAdicional3Permiso;
    }

    public boolean isAccionAdicional4Permiso() {
        return accionAdicional4Permiso;
    }

    public boolean isAccionAdicional5Permiso() {
        return accionAdicional5Permiso;
    }

    public boolean isAccionAdicional6Permiso() {
        return accionAdicional6Permiso;
    }

    public boolean isAccionAdicional7Permiso() {
        return accionAdicional7Permiso;
    }

    public boolean isAccionAdicional8Permiso() {
        return accionAdicional8Permiso;
    }

    public boolean isAccionAdicional9Permiso() {
        return accionAdicional9Permiso;
    }

    public boolean isAccionAdicional10Permiso() {
        return accionAdicional10Permiso;
    }

    public boolean isAccionAdicional11Permiso() {
        return accionAdicional11Permiso;
    }

    public void setListarPermiso(boolean listarPermiso) {
        this.listarPermiso = listarPermiso;
    }

    public void setVerPermiso(boolean verPermiso) {
        this.verPermiso = verPermiso;
    }

    public void setCrearPermiso(boolean crearPermiso) {
        this.crearPermiso = crearPermiso;
    }

    public void setEditarPermiso(boolean editarPermiso) {
        this.editarPermiso = editarPermiso;
    }

    public void setBorrarPermiso(boolean borrarPermiso) {
        this.borrarPermiso = borrarPermiso;
    }

    public void setAccionAdicional1Permiso(boolean accionAdicional1Permiso) {
        this.accionAdicional1Permiso = accionAdicional1Permiso;
    }

    public void setAccionAdicional2Permiso(boolean accionAdicional2Permiso) {
        this.accionAdicional2Permiso = accionAdicional2Permiso;
    }

    public void setAccionAdicional3Permiso(boolean accionAdicional3Permiso) {
        this.accionAdicional3Permiso = accionAdicional3Permiso;
    }

    public void setAccionAdicional4Permiso(boolean accionAdicional4Permiso) {
        this.accionAdicional4Permiso = accionAdicional4Permiso;
    }

    public void setAccionAdicional5Permiso(boolean accionAdicional5Permiso) {
        this.accionAdicional5Permiso = accionAdicional5Permiso;
    }

    public void setAccionAdicional6Permiso(boolean accionAdicional6Permiso) {
        this.accionAdicional6Permiso = accionAdicional6Permiso;
    }

    public void setAccionAdicional7Permiso(boolean accionAdicional7Permiso) {
        this.accionAdicional7Permiso = accionAdicional7Permiso;
    }

    public void setAccionAdicional8Permiso(boolean accionAdicional8Permiso) {
        this.accionAdicional8Permiso = accionAdicional8Permiso;
    }

    public void setAccionAdicional9Permiso(boolean accionAdicional9Permiso) {
        this.accionAdicional9Permiso = accionAdicional9Permiso;
    }

    public void setAccionAdicional10Permiso(boolean accionAdicional10Permiso) {
        this.accionAdicional10Permiso = accionAdicional10Permiso;
    }

    public void setAccionAdicional11Permiso(boolean accionAdicional11Permiso) {
        this.accionAdicional11Permiso = accionAdicional11Permiso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.modulo);
        hash = 97 * hash + Objects.hashCode(this.perfil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permiso other = (Permiso) obj;
        if (!Objects.equals(this.modulo, other.modulo)) {
            return false;
        }
        return Objects.equals(this.perfil, other.perfil);
    }
    

}
