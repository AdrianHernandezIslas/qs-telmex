package com.telmex.demo.constants;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class ArchivoContants {
    private final static String PATTERN_DATE = "yyyy-MM-dd";
    public final static String NAME_FILE_PREFIX ="EdoCta-";
    public final static String EXTENSION_FILE = ".xlsx";
    public final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(PATTERN_DATE);

    public final static String INSERT_SQL_PREFIX = "insert into lytestadocuentadetalle (area, cantidad, catalogo_empresas_proyecto, catalogo_estrategias_estatus, catalogo_estrategias_proyecto, comision3, concepton, confirmadas, dias, dif_dias, division, duplicado, empresa, es_conversion, id_estado_cuenta, estatus, estrategia, expediente, fecha, fechaibase, fechaicherge_bk, fechaiposteo, fecha_ib_com, fecha_ibcl, fecha_ibcm, fecha_ibe, fecha_iotros, fecha_navegacion, fecha_pago_cliente, folio, importebcom, importe_base, importe_bcl, importe_bcm, importe_be, importe_charge_bk, importe_charge_bk_pgo_cte, importe_navegacion, importe_otros, importe_pago_cliente, importe_posteo, linea_contratada, master, mes, mes_pisa, mes_sol, navega_dwh, observaciones, os_pago, os_pago_conversion, otra_cantidad, otras_ventas, otros_dias, pago2, pagobcom, pago_base, pago_base_descripcion, pago_bcl, pago_bcm, pago_be, pago_bono_zf, pago_charge_bk_descripcion, pago_cherge_bk, pago_navegacion, pago_otros, pago_pago_cliente, pago_pago_cliente_descripcion, pago_porta, pago_posteo, pago_posteo_descripcion, pago_total, paquete, pisae, pisaeconversion, porcentaje_comision, porcentaje_comision_trans, procede2, promotor, quincena, rango, rubro, servicios, servicios2, subdireccion, tel_pago, tel_pago_conversion, tipo_linea, ventas) values ";
}
