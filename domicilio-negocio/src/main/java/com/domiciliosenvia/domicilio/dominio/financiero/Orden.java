/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.dominio.financiero;

import com.domiciliosenvia.domicilio.dominio.administracion.Empresa;
import com.domiciliosenvia.domicilio.dominio.generico.Auditoria;
//import com.domiciliosenvia.domicilio.dominio.registro.Area;
//import com.domiciliosenvia.domicilio.dominio.registro.Proveedor;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rpalacios
 */
public class Orden extends Auditoria {

    public static final int ESTADO_SOLICITADO = 0;
    public static final int ESTADO_REVISADO = 1;
    public static final int ESTADO_APROBADO = 2;
    public static final int ESTADO_CONTABILIZADO = 3;
    public static final int ESTADO_PAGADO = 4;
    public static final int ESTADO_ANULADO = 5;

    private Integer id;
//    private Integer estadoAnt;
    private Integer estado;
    private int maeTipoOrden;
    private Date fechaOrden;
//    private Integer maeActaTipo;
//    private String actaNumero;
//    private Date actaFecha;
//    private String objeto;
    private String descripcion;
    private double subTotalSinIva;
    private double valorDescuento;
    private double valorAdicional;
    private double subTotal;
    private int porcentajeImpuestoConsumo;
    private double valorImpuestoConsumo;
    private int porcentajeRetefuente;
    private double valorRetefuente;
    private double valorIva;
    private double total;
    private double anticipo;
    private String plazo;
    private String solicito;
    private String aprobo;
//    private Area area;
//    private Empresa empresa;
//    private Proveedor proveedor;
//    private List<OrdenDetalle> listaOrdenDetalles;
//    private List<OrdenReporte> listaReporteOC;

    public Orden() {
    }

    public Orden(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEstado() {
        return estado;
    }

    public String getEstadoStr() {
        if (estado != null) {
            switch (estado) {
                case ESTADO_SOLICITADO:
                    return "Solicitado";
                case ESTADO_REVISADO:
                    return "Revisado";
                case ESTADO_APROBADO:
                    return "Aprobado";
                case ESTADO_CONTABILIZADO:
                    return "Contabilizado";
                case ESTADO_PAGADO:
                    return "Pagado";
                case ESTADO_ANULADO:
                    return "Anulado";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMaeTipoOrden() {
        return maeTipoOrden;
    }

    public void setMaeTipoOrden(int maeTipoOrden) {
        this.maeTipoOrden = maeTipoOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }


    public double getSubTotalSinIva() {
        return subTotalSinIva;
    }

    public void setSubTotalSinIva(double subTotalSinIva) {
        this.subTotalSinIva = subTotalSinIva;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }


    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getPorcentajeImpuestoConsumo() {
        return porcentajeImpuestoConsumo;
    }

    public void setPorcentajeImpuestoConsumo(int porcentajeImpuestoConsumo) {
        this.porcentajeImpuestoConsumo = porcentajeImpuestoConsumo;
    }

    public double getValorImpuestoConsumo() {
        return valorImpuestoConsumo;
    }

    public void setValorImpuestoConsumo(double valorImpuestoConsumo) {
        this.valorImpuestoConsumo = valorImpuestoConsumo;
    }

    public int getPorcentajeRetefuente() {
        return porcentajeRetefuente;
    }

    public void setPorcentajeRetefuente(int porcentajeRetefuente) {
        this.porcentajeRetefuente = porcentajeRetefuente;
    }

    public double getValorRetefuente() {
        return valorRetefuente;
    }

    public void setValorRetefuente(double valorRetefuente) {
        this.valorRetefuente = valorRetefuente;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getSolicito() {
        return solicito;
    }

    public void setSolicito(String solicito) {
        this.solicito = solicito;
    }


    public String getAprobo() {
        return aprobo;
    }

    public void setAprobo(String aprobo) {
        this.aprobo = aprobo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", estado=" + estado + ", maeTipoOrden=" + maeTipoOrden + ", fechaOrden=" + fechaOrden + ", descripcion=" + descripcion + ", subTotalSinIva=" + subTotalSinIva + ", valorDescuento=" + valorDescuento + ", valorAdicional=" + valorAdicional + ", subTotal=" + subTotal + ", porcentajeImpuestoConsumo=" + porcentajeImpuestoConsumo + ", valorImpuestoConsumo=" + valorImpuestoConsumo + ", porcentajeRetefuente=" + porcentajeRetefuente + ", valorRetefuente=" + valorRetefuente + ", valorIva=" + valorIva + ", total=" + total + ", anticipo=" + anticipo + ", plazo=" + plazo + ", solicito=" + solicito + ", aprobo=" + aprobo + '}';
    } 

}
