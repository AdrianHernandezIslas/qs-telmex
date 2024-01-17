package com.telmex.demo.service;

import com.telmex.demo.entity.EstadoCuentaDetalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DetalleEstadoCuentaService {

    Page<EstadoCuentaDetalle> getAllDetalleByCuenta(Integer idEstadoCuenta, Pageable page);
}
