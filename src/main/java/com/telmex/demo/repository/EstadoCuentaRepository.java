package com.telmex.demo.repository;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstatusCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Integer> {
    @Query("SELECT ec.estatusCarga FROM EstadoCuenta ec where ec.idEstadoCuenta = :id")
    Optional<EstatusCarga> checkById(@Param("id") Integer id);
}
