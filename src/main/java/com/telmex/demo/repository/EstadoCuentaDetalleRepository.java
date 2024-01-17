package com.telmex.demo.repository;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaDetalleRepository extends JpaRepository<EstadoCuentaDetalle,Integer> {

    Page<EstadoCuentaDetalle> findEstadoCuentaDetalleByEstadoCuenta(EstadoCuenta estadoCuenta, Pageable pageable);
}
