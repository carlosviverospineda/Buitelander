package com.domiciliosenvia.domicilio.web.utilidades;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.primefaces.model.FilterMeta;

/*
* Realiza las transformaciones para compatibilidad PF8
 */
public class CompatibilidadPF {

    //Date a LocalDateTime
    public static LocalDateTime convertirDateToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    //Hash String FilterMeta to Filter String Obj
    public static HashMap<String, Object> ConvertirFiltroMetaToHash(Map<String, FilterMeta> filtros) {
        HashMap<String, Object> filtroObj = new HashMap<>();
        filtros.entrySet().forEach(filtroMeta -> {
            if (filtroMeta.getValue().getFilterValue() != null) {
                filtroObj.put(filtroMeta.getValue().getFilterField(), filtroMeta.getValue().getFilterValue());
            }
        });
        return filtroObj;
    }

}
