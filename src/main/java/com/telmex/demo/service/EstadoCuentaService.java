package com.telmex.demo.service;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import com.telmex.demo.entity.EstatusCarga;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EstadoCuentaService {

    EstadoCuenta create(EstadoCuenta estadoCuenta);

    void updateStatusEstadoCuenta(Integer idEstadoCuenta,EstatusCarga estatusCarga);

    void addDetalle(Set<EstadoCuentaDetalle> estadoCuentaDetalleSet);

    Optional<EstadoCuenta> get(Integer idEstadoCuenta);

    Optional<EstatusCarga> ckeckEstatus(Integer idEstadoCuenta);


}