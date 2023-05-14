package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CntPrestadorSedes.class)
public abstract class CntPrestadorSedes_ {

	public static volatile SingularAttribute<CntPrestadorSedes, Integer> nivelAtencion;
	public static volatile SingularAttribute<CntPrestadorSedes, String> codigoPrestador;
	public static volatile SingularAttribute<CntPrestadorSedes, Boolean> interoperabilidad;
	public static volatile SingularAttribute<CntPrestadorSedes, Integer> maeRegionId;
	public static volatile SingularAttribute<CntPrestadorSedes, String> maeRegionCodigo;
	public static volatile SingularAttribute<CntPrestadorSedes, String> nombre;
	public static volatile SingularAttribute<CntPrestadorSedes, String> terminalModifica;
	public static volatile SingularAttribute<CntPrestadorSedes, String> maeClasePrestadorValor;
	public static volatile SingularAttribute<CntPrestadorSedes, String> usuarioCrea;
	public static volatile SingularAttribute<CntPrestadorSedes, CntPrestadores> cntPrestadoresId;
	public static volatile SingularAttribute<CntPrestadorSedes, String> terminalCrea;
	public static volatile SingularAttribute<CntPrestadorSedes, Date> fechaHoraCrea;
	public static volatile SingularAttribute<CntPrestadorSedes, Integer> id;
	public static volatile SingularAttribute<CntPrestadorSedes, String> fax;
	public static volatile SingularAttribute<CntPrestadorSedes, Integer> maeClasePrestadorId;
	public static volatile SingularAttribute<CntPrestadorSedes, String> zonaPrecedencia;
	public static volatile SingularAttribute<CntPrestadorSedes, String> codigoHabilitacion;
	public static volatile SingularAttribute<CntPrestadorSedes, String> codigo;
	public static volatile SingularAttribute<CntPrestadorSedes, String> maeRegionValor;
	public static volatile SingularAttribute<CntPrestadorSedes, String> telefonoCitas;
	public static volatile SingularAttribute<CntPrestadorSedes, String> maeClasePrestadorCodigo;
	public static volatile SingularAttribute<CntPrestadorSedes, String> direccion;
	public static volatile SingularAttribute<CntPrestadorSedes, Integer> ubicacionId;
	public static volatile SingularAttribute<CntPrestadorSedes, String> telefonoAdministrativo;
	public static volatile SingularAttribute<CntPrestadorSedes, Boolean> capitacion;
	public static volatile SingularAttribute<CntPrestadorSedes, Date> fechaHoraModifica;
	public static volatile SingularAttribute<CntPrestadorSedes, Boolean> estadoSede;
	public static volatile SingularAttribute<CntPrestadorSedes, String> correoElectronico;
	public static volatile SingularAttribute<CntPrestadorSedes, String> usuarioModifica;

	public static final String NIVEL_ATENCION = "nivelAtencion";
	public static final String CODIGO_PRESTADOR = "codigoPrestador";
	public static final String INTEROPERABILIDAD = "interoperabilidad";
	public static final String MAE_REGION_ID = "maeRegionId";
	public static final String MAE_REGION_CODIGO = "maeRegionCodigo";
	public static final String NOMBRE = "nombre";
	public static final String TERMINAL_MODIFICA = "terminalModifica";
	public static final String MAE_CLASE_PRESTADOR_VALOR = "maeClasePrestadorValor";
	public static final String USUARIO_CREA = "usuarioCrea";
	public static final String CNT_PRESTADORES_ID = "cntPrestadoresId";
	public static final String TERMINAL_CREA = "terminalCrea";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String ID = "id";
	public static final String FAX = "fax";
	public static final String MAE_CLASE_PRESTADOR_ID = "maeClasePrestadorId";
	public static final String ZONA_PRECEDENCIA = "zonaPrecedencia";
	public static final String CODIGO_HABILITACION = "codigoHabilitacion";
	public static final String CODIGO = "codigo";
	public static final String MAE_REGION_VALOR = "maeRegionValor";
	public static final String TELEFONO_CITAS = "telefonoCitas";
	public static final String MAE_CLASE_PRESTADOR_CODIGO = "maeClasePrestadorCodigo";
	public static final String DIRECCION = "direccion";
	public static final String UBICACION_ID = "ubicacionId";
	public static final String TELEFONO_ADMINISTRATIVO = "telefonoAdministrativo";
	public static final String CAPITACION = "capitacion";
	public static final String FECHA_HORA_MODIFICA = "fechaHoraModifica";
	public static final String ESTADO_SEDE = "estadoSede";
	public static final String CORREO_ELECTRONICO = "correoElectronico";
	public static final String USUARIO_MODIFICA = "usuarioModifica";

}

