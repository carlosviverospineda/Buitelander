package com.domiciliosenvia.domicilio.ejb.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GnMaestroAcciones.class)
public abstract class GnMaestroAcciones_ {

	public static volatile SingularAttribute<GnMaestroAcciones, String> descripcion;
	public static volatile ListAttribute<GnMaestroAcciones, GnMaestros> gnMaestrosList;
	public static volatile SingularAttribute<GnMaestroAcciones, Integer> id;
	public static volatile SingularAttribute<GnMaestroAcciones, Integer> grupoId;
	public static volatile SingularAttribute<GnMaestroAcciones, String> nombre;
	public static volatile SingularAttribute<GnMaestroAcciones, GnMaestroTipos> maestrosTipo;

	public static final String DESCRIPCION = "descripcion";
	public static final String GN_MAESTROS_LIST = "gnMaestrosList";
	public static final String ID = "id";
	public static final String GRUPO_ID = "grupoId";
	public static final String NOMBRE = "nombre";
	public static final String MAESTROS_TIPO = "maestrosTipo";

}

