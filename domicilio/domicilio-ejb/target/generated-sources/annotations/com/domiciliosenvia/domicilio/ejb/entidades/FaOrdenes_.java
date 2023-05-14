package com.domiciliosenvia.domicilio.ejb.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FaOrdenes.class)
public abstract class FaOrdenes_ {

	public static volatile SingularAttribute<FaOrdenes, String> descripcion;
	public static volatile SingularAttribute<FaOrdenes, Double> anticipo;
	public static volatile SingularAttribute<FaOrdenes, String> elaboro;
	public static volatile SingularAttribute<FaOrdenes, Integer> estado;
	public static volatile SingularAttribute<FaOrdenes, Integer> maeTipoOrden;
	public static volatile SingularAttribute<FaOrdenes, Double> porcentajeRetefuente;
	public static volatile SingularAttribute<FaOrdenes, String> plazo;
	public static volatile SingularAttribute<FaOrdenes, Double> subTotal;
	public static volatile SingularAttribute<FaOrdenes, Double> valorImpuesto;
	public static volatile SingularAttribute<FaOrdenes, Double> porcentajeIimpuesto;
	public static volatile SingularAttribute<FaOrdenes, Double> valorAdicional;
	public static volatile SingularAttribute<FaOrdenes, Double> valorRetefuente;
	public static volatile SingularAttribute<FaOrdenes, Double> total;
	public static volatile SingularAttribute<FaOrdenes, Double> valorIva;
	public static volatile SingularAttribute<FaOrdenes, Double> valorDescuento;
	public static volatile SingularAttribute<FaOrdenes, Double> subTotalSinIva;
	public static volatile SingularAttribute<FaOrdenes, Integer> id;
	public static volatile SingularAttribute<FaOrdenes, String> aprobo;
	public static volatile SingularAttribute<FaOrdenes, Date> fechaOrden;

	public static final String DESCRIPCION = "descripcion";
	public static final String ANTICIPO = "anticipo";
	public static final String ELABORO = "elaboro";
	public static final String ESTADO = "estado";
	public static final String MAE_TIPO_ORDEN = "maeTipoOrden";
	public static final String PORCENTAJE_RETEFUENTE = "porcentajeRetefuente";
	public static final String PLAZO = "plazo";
	public static final String SUB_TOTAL = "subTotal";
	public static final String VALOR_IMPUESTO = "valorImpuesto";
	public static final String PORCENTAJE_IIMPUESTO = "porcentajeIimpuesto";
	public static final String VALOR_ADICIONAL = "valorAdicional";
	public static final String VALOR_RETEFUENTE = "valorRetefuente";
	public static final String TOTAL = "total";
	public static final String VALOR_IVA = "valorIva";
	public static final String VALOR_DESCUENTO = "valorDescuento";
	public static final String SUB_TOTAL_SIN_IVA = "subTotalSinIva";
	public static final String ID = "id";
	public static final String APROBO = "aprobo";
	public static final String FECHA_ORDEN = "fechaOrden";

}

