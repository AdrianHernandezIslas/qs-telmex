package com.telmex.demo.repository;

import com.telmex.demo.entity.EstadoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta,Integer> {
}
