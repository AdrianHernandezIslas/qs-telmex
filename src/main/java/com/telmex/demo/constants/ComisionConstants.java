package com.telmex.demo.constants;

public class ComisionConstants {

    public static final String ID_ESTADO_CUENTA_PARAM = "idEstadoCuenta";

    public static final String ID_EMPLEADO_PARAM = "idEmpleado";

    public static final String FECHA_ALTA_PARAM = "fechaAlta";

    public static final String VP_AUDITORIA_PARAM = "auditoria";
    public static final String CALCULAR_COMISIONES_SP = "CALL sp_CalcularComisiones(:"+ID_ESTADO_CUENTA_PARAM+",:"+ID_EMPLEADO_PARAM+",:"+FECHA_ALTA_PARAM+",:"+VP_AUDITORIA_PARAM+")";
}
