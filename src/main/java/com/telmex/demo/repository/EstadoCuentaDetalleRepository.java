package com.telmex.demo.repository;

import com.telmex.demo.entity.EstadoCuentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaDetalleRepository extends JpaRepository<EstadoCuentaDetalle,Integer> {
}
