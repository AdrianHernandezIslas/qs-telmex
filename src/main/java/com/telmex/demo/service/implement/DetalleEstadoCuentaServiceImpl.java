package com.telmex.demo.service.implement;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import com.telmex.demo.repository.EstadoCuentaDetalleRepository;
import com.telmex.demo.service.DetalleEstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetalleEstadoCuentaServiceImpl implements DetalleEstadoCuentaService {

    @Autowired
    private EstadoCuentaDetalleRepository estadoCuentaDetalleRepository;

    @Override
    public Page<EstadoCuentaDetalle> getAllDetalleByCuenta(Integer idEstadoCuenta, Pageable page) {
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setIdEstadoCuenta(idEstadoCuenta);
        return estadoCuentaDetalleRepository.findEstadoCuentaDetalleByEstadoCuenta(estadoCuenta,page);
    }
}
