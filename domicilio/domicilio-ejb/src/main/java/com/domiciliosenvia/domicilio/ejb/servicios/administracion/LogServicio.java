/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.servicios.administracion;

import com.domiciliosenvia.domicilio.dominio.administracion.Log;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import com.domiciliosenvia.domicilio.negocio.administracion.LogRemoto;
import com.domiciliosenvia.domicilio.ejb.entidades.GnLogs;
import com.domiciliosenvia.domicilio.ejb.utilidades.GenericoServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author raul-palacios
 */
@Stateless
@Remote(LogRemoto.class)
public class LogServicio extends GenericoServicio implements LogRemoto {
    
    @Override
    public int consultarCantidadTodos(ParamConsulta paramConsulta) throws Exception {
        int cant = 0;
        try {
            String strQuery = "SELECT COUNT(l) FROM GnLogs l "
                    + "WHERE fechaHora BETWEEN :fh_inicio AND :fh_fin ";
            if (paramConsulta.getFiltros() != null) {
                for (Map.Entry e : paramConsulta.getFiltros().entrySet()) {
                    switch ((String) e.getKey()) {
                        case "usuario":
                            strQuery += "AND usuario LIKE '%" + (String) e.getValue() + "%' ";
                            break;
                        case "empresaUsuario":
                            strQuery += "AND empresaUsuario LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "empresaEjecucion":
                            strQuery += "AND empresaEjecucion LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "modulo":
                            strQuery += "AND modulo LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "accion":
                            strQuery += "AND accion LIKE '" + (String) e.getValue() + "%' ";
                            break;
                    }
                }
            }
            cant = (int) (long) getEntityManager().createQuery(strQuery)
                    .setParameter("fh_inicio", ((Date)paramConsulta.getParametroConsulta1()), TemporalType.TIMESTAMP)
                    .setParameter("fh_fin",((Date)paramConsulta.getParametroConsulta2()), TemporalType.TIMESTAMP)
                    .getSingleResult();
        } catch (NoResultException e) {
            cant = 0;
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return cant;
    }

    @Override
    public List<Log> consultarTodos(ParamConsulta paramConsulta) throws Exception {
        List<Log> listResult = new ArrayList();
        try {
            //Armado de HQL
            String strQuery = "FROM GnLogs "
                    + "WHERE fechaHora BETWEEN :fh_inicio AND :fh_fin ";
            if (paramConsulta.getFiltros() != null) {
                for (Map.Entry e : paramConsulta.getFiltros().entrySet()) {
                    switch ((String) e.getKey()) {
                        case "usuario":
                            strQuery += "AND usuario LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "empresaUsuario":
                            strQuery += "AND empresaUsuario LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "empresaEjecucion":
                            strQuery += "AND empresaEjecucion LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "modulo":
                            strQuery += "AND modulo LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "accion":
                            strQuery += "AND accion LIKE '" + (String) e.getValue() + "%' ";
                            break;
                    }
                }
            }
            if (paramConsulta.getOrden() != null) {
                strQuery += " ORDER BY " + paramConsulta.getOrden() + " "
                        + (paramConsulta.isAscendente() ? "ASC" : "DESC");
            } else {
                strQuery += "ORDER BY fechaHora DESC ";
            }
            List<GnLogs> list = getEntityManager().createQuery(strQuery)
                    .setFirstResult(paramConsulta.getPrimerRegistro())
                    .setMaxResults(paramConsulta.getRegistrosPagina())
                    .setParameter("fh_inicio", ((Date)paramConsulta.getParametroConsulta1()), TemporalType.TIMESTAMP)
                    .setParameter("fh_fin", ((Date)paramConsulta.getParametroConsulta2()), TemporalType.TIMESTAMP)
                    .getResultList();
            for (GnLogs obj : list) {
                listResult.add(castEntidadNegocio(obj));
            }
        } catch (NoResultException e) {
            listResult = new ArrayList();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return listResult;
    }

    @Override
    public Log consultar(int id) throws Exception {
        Log objRes = null;
        try {
            objRes = castEntidadNegocio((GnLogs) getEntityManager().find(GnLogs.class, id));
        } catch (NoResultException e) {
            objRes = null;
        } catch (Exception e) {
            Exception(CONSULTAR, e);
        } finally {
            cerrarEntityManager();
        }
        return objRes;
    }

    @Override
    public int insertar(Log obj) throws Exception {
        int _id = 0;
        try {
            _id = (int) getEntityManager().merge(castNegocioEntidad(obj)).getId();
            obj.setId(_id);
        } catch (NoResultException e) {
            _id = 0;
        } catch (Exception e) {
            Exception(INSERTAR, e);
        } finally {
            cerrarEntityManager();
        }
        return _id;
    }
    
    public static Log castEntidadNegocio(GnLogs _per) {
        Log _obj = new Log();
        _obj.setId(_per.getId());
        _obj.setAccion(_per.getAccion());
        _obj.setFechaHora(_per.getFechaHora());
        _obj.setDescripcion(_per.getDescripcion());
        _obj.setIpPrivada(_per.getIpPrivada());
        _obj.setIpPublica(_per.getIpPublica());
        //Módulo (Opción)
        _obj.setModulo(_per.getModulo());
        //Usuario
        _obj.setEmpresaEjecucion(_per.getEmpresaEjecucion());
        _obj.setUsuario(_per.getUsuario());
        _obj.setEmpresaUsuario(_per.getEmpresaUsuario());
        return _obj;
    }

    public static GnLogs castNegocioEntidad(Log _obj) {
        GnLogs _per = new GnLogs();
        _per.setId(_obj.getId());
        _per.setAccion(_obj.getAccion());
        _per.setFechaHora(_obj.getFechaHora());
        _per.setIpPrivada(_obj.getIpPrivada());
        _per.setIpPublica(_obj.getIpPublica());
        _per.setDescripcion(_obj.getDescripcion());
        //Módulo (Opción)
        _per.setModulo(_obj.getModulo());
        //Usuario
        _per.setEmpresaEjecucion(_obj.getEmpresaEjecucion());
        _per.setUsuario(_obj.getUsuario());
        _per.setEmpresaUsuario(_obj.getEmpresaUsuario());
        return _per;
    }

    @Override
    public List<Log> consultarUltimos(String empresa, int cant) {
        List<Log> lista = new ArrayList();
        String strQuery = "FROM GnLogs "
                + "WHERE empresaEjecucion = :empresa_ejecucion "
                + "ORDER BY fechaHora DESC";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnLogs> list = query
                    .setFirstResult(0)
                    .setMaxResults(cant)
                    .setParameter("empresa_ejecucion", empresa)
                    .getResultList();
            for (GnLogs obj : list) {
                lista.add(castEntidadNegocio(obj));
            }
        } catch (Exception e) {
            lista = new ArrayList();
        } finally {
            cerrarEntityManager();
        }
        return lista;
    }
    
}
