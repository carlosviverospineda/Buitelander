package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GnUsuarios.class)
public abstract class GnUsuarios_ {

	public static volatile SingularAttribute<GnUsuarios, Boolean> bloqueado;
	public static volatile SingularAttribute<GnUsuarios, String> documento;
	public static volatile SingularAttribute<GnUsuarios, Date> fechaUltimoIngreso;
	public static volatile SingularAttribute<GnUsuarios, String> nombre;
	public static volatile SingularAttribute<GnUsuarios, String> maeTipoDocumentoCodigo;
	public static volatile SingularAttribute<GnUsuarios, String> terminalModifica;
	public static volatile SingularAttribute<GnUsuarios, String> usuarioCrea;
	public static volatile SingularAttribute<GnUsuarios, Date> fechaInicio;
	public static volatile SingularAttribute<GnUsuarios, String> terminalCrea;
	public static volatile SingularAttribute<GnUsuarios, String> celular;
	public static volatile SingularAttribute<GnUsuarios, Date> fechaHoraCrea;
	public static volatile SingularAttribute<GnUsuarios, String> contrasena;
	public static volatile SingularAttribute<GnUsuarios, Integer> id;
	public static volatile SingularAttribute<GnUsuarios, String> telefono;
	public static volatile SingularAttribute<GnUsuarios, GnEmpresas> gnEmpresasId;
	public static volatile SingularAttribute<GnUsuarios, GnZonasHorarias> gnZonasHorariasId;
	public static volatile ListAttribute<GnUsuarios, GnRolesUsuario> gnRolesUsuarioList;
	public static volatile ListAttribute<GnUsuarios, AusCasos> ausCasosList;
	public static volatile SingularAttribute<GnUsuarios, Date> fechaFin;
	public static volatile SingularAttribute<GnUsuarios, String> usuario;
	public static volatile SingularAttribute<GnUsuarios, Date> fechaHoraModifica;
	public static volatile SingularAttribute<GnUsuarios, String> correoElectronico;
	public static volatile SingularAttribute<GnUsuarios, String> maeTipoDocumentoValor;
	public static volatile SingularAttribute<GnUsuarios, Integer> maeTipoDocumentoId;
	public static volatile SingularAttribute<GnUsuarios, Integer> intentos;
	public static volatile SingularAttribute<GnUsuarios, String> usuarioModifica;
	public static volatile SingularAttribute<GnUsuarios, Boolean> activo;

	public static final String BLOQUEADO = "bloqueado";
	public static final String DOCUMENTO = "documento";
	public static final String FECHA_ULTIMO_INGRESO = "fechaUltimoIngreso";
	public static final String NOMBRE = "nombre";
	public static final String MAE_TIPO_DOCUMENTO_CODIGO = "maeTipoDocumentoCodigo";
	public static final String TERMINAL_MODIFICA = "terminalModifica";
	public static final String USUARIO_CREA = "usuarioCrea";
	public static final String FECHA_INICIO = "fechaInicio";
	public static final String TERMINAL_CREA = "terminalCrea";
	public static final String CELULAR = "celular";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String CONTRASENA = "contrasena";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String GN_EMPRESAS_ID = "gnEmpresasId";
	public static final String GN_ZONAS_HORARIAS_ID = "gnZonasHorariasId";
	public static final String GN_ROLES_USUARIO_LIST = "gnRolesUsuarioList";
	public static final String AUS_CASOS_LIST = "ausCasosList";
	public static final String FECHA_FIN = "fechaFin";
	public static final String USUARIO = "usuario";
	public static final String FECHA_HORA_MODIFICA = "fechaHoraModifica";
	public static final String CORREO_ELECTRONICO = "correoElectronico";
	public static final String MAE_TIPO_DOCUMENTO_VALOR = "maeTipoDocumentoValor";
	public static final String MAE_TIPO_DOCUMENTO_ID = "maeTipoDocumentoId";
	public static final String INTENTOS = "intentos";
	public static final String USUARIO_MODIFICA = "usuarioModifica";
	public static final String ACTIVO = "activo";

}

