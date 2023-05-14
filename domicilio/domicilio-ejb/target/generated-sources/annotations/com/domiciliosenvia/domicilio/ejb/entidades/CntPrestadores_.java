package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CntPrestadores.class)
public abstract class CntPrestadores_ {

	public static volatile SingularAttribute<CntPrestadores, Integer> nivelAtencion;
	public static volatile SingularAttribute<CntPrestadores, String> nombreRepresentanteLegal;
	public static volatile SingularAttribute<CntPrestadores, String> maeTipoDocumentoCodigo;
	public static volatile SingularAttribute<CntPrestadores, String> terminalModifica;
	public static volatile SingularAttribute<CntPrestadores, String> razonSocial;
	public static volatile SingularAttribute<CntPrestadores, String> maeClasePrestadorValor;
	public static volatile SingularAttribute<CntPrestadores, Integer> categoriaPrestador;
	public static volatile SingularAttribute<CntPrestadores, String> usuarioCrea;
	public static volatile SingularAttribute<CntPrestadores, String> terminalCrea;
	public static volatile SingularAttribute<CntPrestadores, String> maeTipoDocumentoRepValor;
	public static volatile SingularAttribute<CntPrestadores, Integer> maeTipoDocumentoRepId;
	public static volatile SingularAttribute<CntPrestadores, Date> fechaHoraCrea;
	public static volatile SingularAttribute<CntPrestadores, Integer> id;
	public static volatile SingularAttribute<CntPrestadores, String> numeroDocumento;
	public static volatile SingularAttribute<CntPrestadores, Boolean> facturacionElectronica;
	public static volatile SingularAttribute<CntPrestadores, String> numeroDocumentoRep;
	public static volatile SingularAttribute<CntPrestadores, Integer> maeClasePrestadorId;
	public static volatile SingularAttribute<CntPrestadores, String> maeTipoDocumentoRepCodigo;
	public static volatile SingularAttribute<CntPrestadores, String> digitoVerificacion;
	public static volatile SingularAttribute<CntPrestadores, String> maeClasePrestadorCodigo;
	public static volatile SingularAttribute<CntPrestadores, String> codigoMinSalud;
	public static volatile ListAttribute<CntPrestadores, GnEmpresas> gnEmpresasList;
	public static volatile SingularAttribute<CntPrestadores, String> prefijo;
	public static volatile ListAttribute<CntPrestadores, CntPrestadorSedes> cntPrestadorSedesList;
	public static volatile SingularAttribute<CntPrestadores, String> naturalezaJuridica;
	public static volatile SingularAttribute<CntPrestadores, Date> fechaHoraModifica;
	public static volatile SingularAttribute<CntPrestadores, String> maeTipoDocumentoValor;
	public static volatile SingularAttribute<CntPrestadores, Integer> maeTipoDocumentoId;
	public static volatile SingularAttribute<CntPrestadores, String> usuarioModifica;
	public static volatile SingularAttribute<CntPrestadores, Boolean> activo;

	public static final String NIVEL_ATENCION = "nivelAtencion";
	public static final String NOMBRE_REPRESENTANTE_LEGAL = "nombreRepresentanteLegal";
	public static final String MAE_TIPO_DOCUMENTO_CODIGO = "maeTipoDocumentoCodigo";
	public static final String TERMINAL_MODIFICA = "terminalModifica";
	public static final String RAZON_SOCIAL = "razonSocial";
	public static final String MAE_CLASE_PRESTADOR_VALOR = "maeClasePrestadorValor";
	public static final String CATEGORIA_PRESTADOR = "categoriaPrestador";
	public static final String USUARIO_CREA = "usuarioCrea";
	public static final String TERMINAL_CREA = "terminalCrea";
	public static final String MAE_TIPO_DOCUMENTO_REP_VALOR = "maeTipoDocumentoRepValor";
	public static final String MAE_TIPO_DOCUMENTO_REP_ID = "maeTipoDocumentoRepId";
	public static final String FECHA_HORA_CREA = "fechaHoraCrea";
	public static final String ID = "id";
	public static final String NUMERO_DOCUMENTO = "numeroDocumento";
	public static final String FACTURACION_ELECTRONICA = "facturacionElectronica";
	public static final String NUMERO_DOCUMENTO_REP = "numeroDocumentoRep";
	public static final String MAE_CLASE_PRESTADOR_ID = "maeClasePrestadorId";
	public static final String MAE_TIPO_DOCUMENTO_REP_CODIGO = "maeTipoDocumentoRepCodigo";
	public static final String DIGITO_VERIFICACION = "digitoVerificacion";
	public static final String MAE_CLASE_PRESTADOR_CODIGO = "maeClasePrestadorCodigo";
	public static final String CODIGO_MIN_SALUD = "codigoMinSalud";
	public static final String GN_EMPRESAS_LIST = "gnEmpresasList";
	public static final String PREFIJO = "prefijo";
	public static final String CNT_PRESTADOR_SEDES_LIST = "cntPrestadorSedesList";
	public static final String NATURALEZA_JURIDICA = "naturalezaJuridica";
	public static final String FECHA_HORA_MODIFICA = "fechaHoraModifica";
	public static final String MAE_TIPO_DOCUMENTO_VALOR = "maeTipoDocumentoValor";
	public static final String MAE_TIPO_DOCUMENTO_ID = "maeTipoDocumentoId";
	public static final String USUARIO_MODIFICA = "usuarioModifica";
	public static final String ACTIVO = "activo";

}

