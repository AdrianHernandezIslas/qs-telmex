package com.telmex.demo.dto.input;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ComisionDTO {

    @NotNull
    private Long idEstadoCuenta;
    //@NotNull
    private Integer idEmpleado;
    @NotNull
    private String vpAuditoria;

    public Long getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(Long idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getVpAuditoria() {
        return vpAuditoria;
    }

    public void setVpAuditoria(String vpAuditoria) {
        this.vpAuditoria = vpAuditoria;
    }
}
