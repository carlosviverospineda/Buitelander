package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GnCorreoEnvios.class)
public abstract class GnCorreoEnvios_ {

	public static volatile SingularAttribute<GnCorreoEnvios, Integer> estado;
	public static volatile SingularAttribute<GnCorreoEnvios, String> encabezado;
	public static volatile SingularAttribute<GnCorreoEnvios, Date> fechaHoraCrea;
	public static volatile SingularAttribute<GnCorreoEnvios, Integer> id;
	public static volatile SingularAttribute<GnCorreoEnvios, Integer> origen;
	public static volatile SingularAttribute<GnCorreoEnvios, Date> fechaHoraEnvio;
	public static volatile SingularAttribute<GnCorreoEnvios, String> detalle;

	public static final String ESTADO = "estado";
	public static final String ENCABEZADO = "encabezado";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String ID = "id";
	public static final String ORIGEN = "origen";
	public static final String FECHA_HORA_ENVIO = "fechaHoraEnvio";
	public static final String DETALLE = "detalle";

}

