package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GnEmpresas.class)
public abstract class GnEmpresas_ {

	public static volatile SingularAttribute<GnEmpresas, String> descripcion;
	public static volatile SingularAttribute<GnEmpresas, GnUbicaciones> gnUbicacionesId;
	public static volatile SingularAttribute<GnEmpresas, Integer> contrasenaDiasNotificacion;
	public static volatile SingularAttribute<GnEmpresas, String> receptorContrasena;
	public static volatile SingularAttribute<GnEmpresas, Integer> contrasenaLongitudMaximo;
	public static volatile ListAttribute<GnEmpresas, GnSedes> gnSedesList;
	public static volatile SingularAttribute<GnEmpresas, String> terminalModifica;
	public static volatile SingularAttribute<GnEmpresas, String> razonSocial;
	public static volatile SingularAttribute<GnEmpresas, String> usuarioCrea;
	public static volatile SingularAttribute<GnEmpresas, CntPrestadores> cntPrestadoresId;
	public static volatile SingularAttribute<GnEmpresas, Boolean> administradora;
	public static volatile SingularAttribute<GnEmpresas, String> terminalCrea;
	public static volatile SingularAttribute<GnEmpresas, String> nit;
	public static volatile SingularAttribute<GnEmpresas, String> nombreComercial;
	public static volatile SingularAttribute<GnEmpresas, Date> fechaHoraCrea;
	public static volatile SingularAttribute<GnEmpresas, Integer> id;
	public static volatile ListAttribute<GnEmpresas, GnUsuarios> gnUsuariosList;
	public static volatile SingularAttribute<GnEmpresas, String> receptorUsuario;
	public static volatile SingularAttribute<GnEmpresas, String> codigoHabilitacion;
	public static volatile ListAttribute<GnEmpresas, AusCasos> ausCasosList;
	public static volatile SingularAttribute<GnEmpresas, Integer> contrasenaDiasVencimiento;
	public static volatile SingularAttribute<GnEmpresas, Boolean> activa;
	public static volatile SingularAttribute<GnEmpresas, Integer> contrasenaLongitudMinimo;
	public static volatile SingularAttribute<GnEmpresas, Integer> contrasenaIntentos;
	public static volatile SingularAttribute<GnEmpresas, Date> fechaHoraModifica;
	public static volatile SingularAttribute<GnEmpresas, String> usuarioModifica;

	public static final String DESCRIPCION = "descripcion";
	public static final String GN_UBICACIONES_ID = "gnUbicacionesId";
	public static final String CONTRASENA_DIAS_NOTIFICACION = "contrasenaDiasNotificacion";
	public static final String RECEPTOR_CONTRASENA = "receptorContrasena";
	public static final String CONTRASENA_LONGITUD_MAXIMO = "contrasenaLongitudMaximo";
	public static final String GN_SEDES_LIST = "gnSedesList";
	public static final String TERMINAL_MODIFICA = "terminalModifica";
	public static final String RAZON_SOCIAL = "razonSocial";
	public static final String USUARIO_CREA = "usuarioCrea";
	public static final String CNT_PRESTADORES_ID = "cntPrestadoresId";
	public static final String ADMINISTRADORA = "administradora";
	public static final String TERMINAL_CREA = "terminalCrea";
	public static final String NIT = "nit";
	public static final String NOMBRE_COMERCIAL = "nombreComercial";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String ID = "id";
	public static final String GN_USUARIOS_LIST = "gnUsuariosList";
	public static final String RECEPTOR_USUARIO = "receptorUsuario";
	public static final String CODIGO_HABILITACION = "codigoHabilitacion";
	public static final String AUS_CASOS_LIST = "ausCasosList";
	public static final String CONTRASENA_DIAS_VENCIMIENTO = "contrasenaDiasVencimiento";
	public static final String ACTIVA = "activa";
	public static final String CONTRASENA_LONGITUD_MINIMO = "contrasenaLongitudMinimo";
	public static final String CONTRASENA_INTENTOS = "contrasenaIntentos";
	public static final String FECHA_HORA_MODIFICA = "fechaHoraModifica";
	public static final String USUARIO_MODIFICA = "usuarioModifica";

}

