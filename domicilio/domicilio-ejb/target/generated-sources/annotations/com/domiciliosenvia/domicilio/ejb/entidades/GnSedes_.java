package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GnSedes.class)
public abstract class GnSedes_ {

	public static volatile SingularAttribute<GnSedes, String> descripcion;
	public static volatile SingularAttribute<GnSedes, GnUbicaciones> gnUbicacionesId;
	public static volatile ListAttribute<GnSedes, AusCasos> ausCasosList;
	public static volatile SingularAttribute<GnSedes, String> direccion;
	public static volatile SingularAttribute<GnSedes, String> nombre;
	public static volatile SingularAttribute<GnSedes, String> terminalModifica;
	public static volatile SingularAttribute<GnSedes, String> usuarioCrea;
	public static volatile SingularAttribute<GnSedes, String> terminalCrea;
	public static volatile SingularAttribute<GnSedes, Date> fechaHoraCrea;
	public static volatile SingularAttribute<GnSedes, Date> fechaHoraModifica;
	public static volatile SingularAttribute<GnSedes, Integer> id;
	public static volatile SingularAttribute<GnSedes, String> telefono;
	public static volatile SingularAttribute<GnSedes, String> usuarioModifica;
	public static volatile SingularAttribute<GnSedes, GnEmpresas> gnEmpresasId;

	public static final String DESCRIPCION = "descripcion";
	public static final String GN_UBICACIONES_ID = "gnUbicacionesId";
	public static final String AUS_CASOS_LIST = "ausCasosList";
	public static final String DIRECCION = "direccion";
	public static final String NOMBRE = "nombre";
	public static final String TERMINAL_MODIFICA = "terminalModifica";
	public static final String USUARIO_CREA = "usuarioCrea";
	public static final String TERMINAL_CREA = "terminalCrea";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String FECHA_HORA_MODIFICA = "fechaHoraModifica";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String USUARIO_MODIFICA = "usuarioModifica";
	public static final String GN_EMPRESAS_ID = "gnEmpresasId";

}

