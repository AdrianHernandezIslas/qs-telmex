package com.telmex.demo.constants;

public class ComisionConstants {

    public static final String ID_ESTADO_CUENTA_PARAM = "idEstadoCuenta";

    public static final String ID_EMPLEADO_PARAM = "idEmpleado";

    public static final String FECHA_ALTA_PARAM = "fechaAlta";

    public static final String VP_AUDITORIA_PARAM = "auditoria";

    public static final String PAGO_CONCEPTO_PARAM = "pagoConcepto";

    public static final String ID_TIPO_EMPLEADO_PARAM = "idTipoEmpleado";
    public static final String CALCULAR_COMISIONES_SP = "CALL sp_calcular_comisiones(:"+ID_ESTADO_CUENTA_PARAM+",:"+ID_EMPLEADO_PARAM+",:"+FECHA_ALTA_PARAM+",:"+VP_AUDITORIA_PARAM+")";

    public static final String COMISIONES_CALCULADAS_QUERY = "SELECT v FROM VwComisioneCalculada v WHERE CONCAT(v.idEstadoCuenta,'') LIKE :"+ID_ESTADO_CUENTA_PARAM
            +" AND v.pagoconcepto LIKE :"+PAGO_CONCEPTO_PARAM
            +" AND CONCAT(v.idempleadotipo,'') LIKE :"+ID_TIPO_EMPLEADO_PARAM;
}
