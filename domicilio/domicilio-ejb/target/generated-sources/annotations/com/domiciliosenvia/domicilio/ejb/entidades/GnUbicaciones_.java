package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GnUbicaciones.class)
public abstract class GnUbicaciones_ {

	public static volatile SingularAttribute<GnUbicaciones, String> descripcion;
	public static volatile SingularAttribute<GnUbicaciones, Boolean> cobertura;
	public static volatile SingularAttribute<GnUbicaciones, Integer> tipo;
	public static volatile SingularAttribute<GnUbicaciones, GnUbicaciones> gnUbicacionesId;
	public static volatile SingularAttribute<GnUbicaciones, Integer> maeRegionId;
	public static volatile SingularAttribute<GnUbicaciones, String> maeRegionCodigo;
	public static volatile SingularAttribute<GnUbicaciones, String> nombre;
	public static volatile ListAttribute<GnUbicaciones, GnSedes> gnSedesList;
	public static volatile SingularAttribute<GnUbicaciones, String> indicativo;
	public static volatile SingularAttribute<GnUbicaciones, String> terminalModifica;
	public static volatile SingularAttribute<GnUbicaciones, String> usuarioCrea;
	public static volatile SingularAttribute<GnUbicaciones, String> terminalCrea;
	public static volatile SingularAttribute<GnUbicaciones, Date> fechaHoraCrea;
	public static volatile SingularAttribute<GnUbicaciones, Integer> id;
	public static volatile ListAttribute<GnUbicaciones, GnUbicaciones> gnUbicacionesList;
	public static volatile SingularAttribute<GnUbicaciones, GnZonasHorarias> gnZonasHorariasId;
	public static volatile ListAttribute<GnUbicaciones, GnDivisiones> gnDivisionesList;
	public static volatile SingularAttribute<GnUbicaciones, String> maeRegionValor;
	public static volatile SingularAttribute<GnUbicaciones, String> codigoPostal;
	public static volatile ListAttribute<GnUbicaciones, AusCasos> ausCasosList;
	public static volatile ListAttribute<GnUbicaciones, GnEmpresas> gnEmpresasList;
	public static volatile SingularAttribute<GnUbicaciones, String> prefijo;
	public static volatile SingularAttribute<GnUbicaciones, Integer> gpsProfundidad;
	public static volatile SingularAttribute<GnUbicaciones, String> gpsCoordenadas;
	public static volatile SingularAttribute<GnUbicaciones, Date> fechaHoraModifica;
	public static volatile SingularAttribute<GnUbicaciones, String> usuarioModifica;
	public static volatile ListAttribute<GnUbicaciones, AusPersonas> ausPersonasList;

	public static final String DESCRIPCION = "descripcion";
	public static final String COBERTURA = "cobertura";
	public static final String TIPO = "tipo";
	public static final String GN_UBICACIONES_ID = "gnUbicacionesId";
	public static final String MAE_REGION_ID = "maeRegionId";
	public static final String MAE_REGION_CODIGO = "maeRegionCodigo";
	public static final String NOMBRE = "nombre";
	public static final String GN_SEDES_LIST = "gnSedesList";
	public static final String INDICATIVO = "indicativo";
	public static final String TERMINAL_MODIFICA = "terminalModifica";
	public static final String USUARIO_CREA = "usuarioCrea";
	public static final String TERMINAL_CREA = "terminalCrea";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String ID = "id";
	public static final String GN_UBICACIONES_LIST = "gnUbicacionesList";
	public static final String GN_ZONAS_HORARIAS_ID = "gnZonasHorariasId";
	public static final String GN_DIVISIONES_LIST = "gnDivisionesList";
	public static final String MAE_REGION_VALOR = "maeRegionValor";
	public static final String CODIGO_POSTAL = "codigoPostal";
	public static final String AUS_CASOS_LIST = "ausCasosList";
	public static final String GN_EMPRESAS_LIST = "gnEmpresasList";
	public static final String PREFIJO = "prefijo";
	public static final String GPS_PROFUNDIDAD = "gpsProfundidad";
	public static final String GPS_COORDENADAS = "gpsCoordenadas";
	public static final String FECHA_HORA_MODIFICA = "fechaHoraModifica";
	public static final String USUARIO_MODIFICA = "usuarioModifica";
	public static final String AUS_PERSONAS_LIST = "ausPersonasList";

}

