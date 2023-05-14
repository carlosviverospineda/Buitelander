/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.ejb.servicios.administracion;

import com.domiciliosenvia.domicilio.dominio.administracion.Ubicacion;
import com.domiciliosenvia.domicilio.dominio.generico.ParamConsulta;
import com.domiciliosenvia.domicilio.negocio.administracion.UbicacionRemoto;
import com.domiciliosenvia.domicilio.ejb.entidades.GnUbicaciones;
import com.domiciliosenvia.domicilio.ejb.utilidades.GenericoServicio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author raul-palacios
 */
@Stateless
@Remote(UbicacionRemoto.class)
public class UbicacionServicio extends GenericoServicio implements UbicacionRemoto {

    @Override
    public int consultarCantidadLista(ParamConsulta paramConsulta) throws Exception {
        int cant = 0;
        try {
            String strQuery = "SELECT COUNT(u) FROM GnUbicaciones u "
                    + "WHERE 1 = 1 ";
            if (paramConsulta.getFiltros() != null) {
                for (Map.Entry e : paramConsulta.getFiltros().entrySet()) {
                    switch ((String) e.getKey()) {
                        case "tipo":
                            strQuery += "AND u.tipo = " + (String) e.getValue() + " ";
                            break;
                        case "nombre":
                            strQuery += "AND u.nombre LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "ubicacionPadre.nombre":
                            strQuery += "AND u.gnUbicacionesId.nombre LIKE '" + (String) e.getValue() + "%' ";
                            break;
                    }
                }
            }
            cant = (int) (long) getEntityManager().createQuery(strQuery)
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
    public List<Ubicacion> consultarLista(ParamConsulta paramConsulta) throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        try {
            String strQuery = "FROM GnUbicaciones u "
                    + "WHERE 1 = 1 ";
            if (paramConsulta.getFiltros() != null) {
                for (Map.Entry e : paramConsulta.getFiltros().entrySet()) {
                    switch ((String) e.getKey()) {
                        case "tipo":
                            strQuery += "AND u.tipo = " + (String) e.getValue() + " ";
                            break;
                        case "nombre":
                            strQuery += "AND u.nombre LIKE '" + (String) e.getValue() + "%' ";
                            break;
                        case "ubicacionPadre.nombre":
                            strQuery += "AND u.gnUbicacionesId.nombre LIKE '" + (String) e.getValue() + "%' ";
                            break;
                    }
                }
            }
            strQuery += "ORDER BY ";
            if (paramConsulta.getOrden() != null) {
                strQuery += "u." + paramConsulta.getOrden() + " "
                        + (paramConsulta.isAscendente() ? "ASC" : "DESC");
            } else {
                strQuery += "u.nombre ASC ";
            }
            List<GnUbicaciones> list = getEntityManager().createQuery(strQuery)
                    .setFirstResult(paramConsulta.getPrimerRegistro())
                    .setMaxResults(paramConsulta.getRegistrosPagina())
                    .getResultList();
            for (GnUbicaciones per : list) {
                listResult.add(castEntidadNegocio(per));
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
    public Ubicacion consultar(int id) throws Exception {
        Ubicacion objRes = null;
        try {
            objRes = castEntidadNegocio((GnUbicaciones) getEntityManager().find(GnUbicaciones.class, id));
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
    public int insertar(Ubicacion obj) throws Exception {
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

    @Override
    public void actualizar(Ubicacion obj) throws Exception {
        try {
//            getEntityManager().merge(castNegocioEntidad(obj));
            GnUbicaciones per = castNegocioEntidad(obj);
            String hql = "UPDATE GnUbicaciones SET "
                    + "nombre = :nombre, "
                    + "maeRegionId = :maeRegionId, "
                    + "maeRegionCodigo = :maeRegionCodigo, "
                    + "maeRegionValor = :maeRegionValor, "
                    + "usuarioModifica = :usuarioModifica, "
                    + "terminalModifica = :terminalModifica, "
                    + "fechaHoraModifica = :fechaHoraModifica "
                    + "WHERE id = :id ";
            Session session = getEntityManager().unwrap(Session.class);
            org.hibernate.Query query = session.createQuery(hql);
            query.setProperties(per);
            query.executeUpdate();
        } catch (NoResultException e) {

        } catch (Exception e) {
            Exception(ACTUALIZAR, e);
        } finally {
            cerrarEntityManager();
        }
    }

    @Override
    public Ubicacion eliminar(int id) throws Exception {
        Ubicacion obj = null;
        try {
            GnUbicaciones ent = getEntityManager().find(GnUbicaciones.class, id);
            if (ent != null) {
                obj = castEntidadNegocio(ent);
                getEntityManager().remove(ent);
            }
        } catch (NoResultException e) {
            obj = null;
        } catch (Exception e) {
            Exception(ELIMINAR, e);
        } finally {
            cerrarEntityManager();
        }
        return obj;
    }

    @Override
    public List<Ubicacion> consultarActivas() throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones WHERE 1 = 1";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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
    public List<Ubicacion> consultarPorTipo(int tipo) throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones"
                + " WHERE tipo = " + tipo
                + " ORDER BY nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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
    public Ubicacion consultarPadre(int idHijo) throws Exception {
        Ubicacion per = null;
        String strQuery = "FROM GnUbicaciones hijo"
                + " INNER JOIN hijo.gnUbicacionesId padre"
                + " WHERE hijo.id = " + idHijo;
        try {
            Query query = getEntityManager().createQuery(strQuery);
            per = castEntidadNegocio((GnUbicaciones) query.getSingleResult());
        } catch (NoResultException e) {
            per = null;
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return per;
    }

    @Override
    public List<Ubicacion> consultarHijos(int idPadre) throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones"
                + " WHERE gnUbicacionesId.id = " + idPadre
                + " ORDER BY nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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
    public HashMap<Integer, Ubicacion> consultarDepartamentos() throws Exception {
        HashMap<Integer, Ubicacion> listCiudades = new HashMap();
        String strQuery = "FROM GnUbicaciones"
                + " WHERE tipo = " + Ubicacion.TIPO_DEPARTAMENTO
                + " ORDER BY nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                Ubicacion _municipio = castEntidadNegocio(obj);
                listCiudades.put(_municipio.getId(), _municipio);
            }
        } catch (NoResultException e) {
            listCiudades = new HashMap();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return listCiudades;
    }

    @Override
    public HashMap<Integer, Ubicacion> consultarMunicipios() throws Exception {
        HashMap<Integer, Ubicacion> listCiudades = new HashMap();
        String strQuery = "FROM GnUbicaciones"
                + " WHERE tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " ORDER BY nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                Ubicacion _municipio = castEntidadNegocio(obj);
//                if(_municipio.getUbicacionPadre()!=null){
//                    Ubicacion _departamento = consultarPadre(_municipio.getUbicacionPadre().getId());
//                    if(_departamento.getUbicacionPadre()!=null){
//                        Ubicacion _pais = consultarPadre(_departamento.getUbicacionPadre().getId());
//                        _departamento.setUbicacionPadre(_pais);
//                    }
//                    _municipio.setUbicacionPadre(_departamento);
//                }
                listCiudades.put(_municipio.getId(), _municipio);
            }
        } catch (NoResultException e) {
            listCiudades = new HashMap();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return listCiudades;
    }

    @Override
    public List<Ubicacion> consultarTodosMunicipios() throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "SELECT u FROM GnUbicaciones u"
                + " WHERE u.tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " ORDER BY nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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
    public HashMap<Integer, Ubicacion> consultarMunicipiosSegunIdPadre(int idPadre) throws Exception {
        HashMap<Integer, Ubicacion> listCiudades = new HashMap();
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " AND u.gnUbicacionesId.id = " + idPadre
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                Ubicacion _municipio = castEntidadNegocio(obj);
                listCiudades.put(_municipio.getId(), _municipio);
            }
        } catch (NoResultException e) {
            listCiudades = new HashMap();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return listCiudades;
    }

    /**
     * Metodo que permite encontrar listado municipios dado un padre
     *
     * @param idPadre
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<Ubicacion> consultarHijosSegunIdPadre(int idPadre) throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.gnUbicacionesId.id = " + idPadre
                + " ORDER BY nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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
    public Ubicacion consultarMunicipiosPorPrefijo(String departamentoPrefijo, String municipioPrefijo) throws Exception {
        Ubicacion municipio = null;
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " AND u.prefijo = '" + municipioPrefijo + "'"
                + " AND u.gnUbicacionesId.prefijo = '" + departamentoPrefijo + "'"
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                municipio = castEntidadNegocio(obj);
                break;
            }
        } catch (NoResultException e) {
            municipio = null;
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return municipio;
    }

    public static Ubicacion castEntidadNegocio(GnUbicaciones per) {
        Ubicacion obj = new Ubicacion();
        obj.setId(per.getId());
        GnUbicaciones padre = (GnUbicaciones) per.getGnUbicacionesId();
        try {
            if (padre != null && padre.getId() != null && padre.getId() != 0) {
                obj.setUbicacionPadre(castEntidadNegocio(padre));
            }
        } catch (Exception e) {
            obj.setUbicacionPadre(null);
        }
        obj.setTipo(per.getTipo());
        obj.setNombre(per.getNombre());
        obj.setDescripcion(per.getDescripcion());
        obj.setPrefijo(per.getPrefijo());
        obj.setMaeRegionId(per.getMaeRegionId());
        obj.setMaeRegionCodigo(per.getMaeRegionCodigo());
        obj.setMaeRegionValor(per.getMaeRegionValor());
        //Auditoría
        obj.setUsuarioCrea(per.getUsuarioCrea());
        obj.setTerminalCrea(per.getTerminalCrea());
        obj.setFechaHoraCrea(per.getFechaHoraCrea());
        obj.setUsuarioModifica(per.getUsuarioModifica());
        obj.setTerminalModifica(per.getTerminalModifica());
        obj.setFechaHoraModifica(per.getFechaHoraModifica());
        return obj;
    }

    public static GnUbicaciones castNegocioEntidad(Ubicacion obj) {
        GnUbicaciones per = new GnUbicaciones();
        per.setId(obj.getId());
        per.setGnUbicacionesId(obj.getUbicacionPadre() != null ? castNegocioEntidad(obj.getUbicacionPadre()) : null);
        per.setTipo(obj.getTipo());
        per.setNombre(obj.getNombre());
        per.setDescripcion(obj.getDescripcion());
        per.setPrefijo(obj.getPrefijo());
        per.setMaeRegionId(obj.getMaeRegionId());
        per.setMaeRegionCodigo(obj.getMaeRegionCodigo());
        per.setMaeRegionValor(obj.getMaeRegionValor());
        //Auditoria
        per.setUsuarioCrea(obj.getUsuarioCrea());
        per.setTerminalCrea(obj.getTerminalCrea());
        per.setFechaHoraCrea(obj.getFechaHoraCrea());
        per.setUsuarioModifica(obj.getUsuarioModifica());
        per.setTerminalModifica(obj.getTerminalModifica());
        per.setFechaHoraModifica(obj.getFechaHoraModifica());
        return per;
    }

    /**
     * Método para consultar la lista de municipios segun su idpadre y que
     * apliquen cobertura
     *
     * @param idPadre
     * @return
     * @throws Exception
     */
    @Override
    public HashMap<Integer, Ubicacion> consultarMunicipiosSegunIdPadreCobertura(int idPadre) throws Exception {
        HashMap<Integer, Ubicacion> listaCiudades = new HashMap();
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " AND u.gnUbicacionesId.id = " + idPadre
                + " AND u.cobertura = 1"
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                Ubicacion _municipio = castEntidadNegocio(obj);
                listaCiudades.put(_municipio.getId(), _municipio);
            }
        } catch (NoResultException e) {
            listaCiudades = new HashMap();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return listaCiudades;
    }

    /**
     * Metodo que permite encontrar listado municipios dado un padre y que
     * apliquen cobertura
     *
     * @param idPadre
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<Ubicacion> consultarHijosSegunIdPadreCobertura(int idPadre) throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.gnUbicacionesId.id = " + idPadre
                + " AND u.cobertura = 1"
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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

    /**
     * Metodo que permite encontrar hash ubicaciones apliquen cobertura
     *
     * @param idPadre
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public HashMap<Integer, Ubicacion> consultarHashHijosSegunIdPadreCobertura(int idPadre) throws Exception {
        HashMap<Integer, Ubicacion> hashPadres = new HashMap<>();
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.gnUbicacionesId.id = " + idPadre
                + " AND u.cobertura = 1"
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                hashPadres.put(obj.getId(), castEntidadNegocio(obj));
            }
        } catch (NoResultException e) {
            listResult = new ArrayList();
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return hashPadres;
    }

    @Override
    public Ubicacion consultarMunicipiosPorPrefijoCobertura(String departamentoPrefijo, String municipioPrefijo) throws java.lang.Exception {
        Ubicacion municipio = null;
        String strQuery = "FROM GnUbicaciones u"
                + " WHERE u.tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " AND u.prefijo = '" + municipioPrefijo + "'"
                + " AND u.gnUbicacionesId.prefijo = '" + departamentoPrefijo + "'"
                + " AND u.cobertura = 1 "
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
                municipio = castEntidadNegocio(obj);
                break;
            }
        } catch (NoResultException e) {
            municipio = null;
        } catch (Exception e) {
            Exception(CONSULTAR_TODOS, e);
        } finally {
            cerrarEntityManager();
        }
        return municipio;
    }

    @Override
    public List<Ubicacion> consultarMunicipiosCobertura() throws Exception {
        List<Ubicacion> listResult = new ArrayList();
        String strQuery = "FROM GnUbicaciones u "
                + " WHERE u.tipo = " + Ubicacion.TIPO_MUNICIPIO
                + " AND u.cobertura = 1 "
                + " ORDER BY u.nombre ";
        try {
            Query query = getEntityManager().createQuery(strQuery);
            List<GnUbicaciones> list = query.getResultList();
            for (GnUbicaciones obj : list) {
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

}
