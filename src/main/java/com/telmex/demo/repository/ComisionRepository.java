package com.telmex.demo.repository;

import com.telmex.demo.views.VwComisioneCalculada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static com.telmex.demo.constants.ComisionConstants.*;

import com.telmex.demo.entity.Comision;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface ComisionRepository extends JpaRepository<Comision, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = CALCULAR_COMISIONES_SP )
    void procesarComicionesFrom(@Param(ID_ESTADO_CUENTA_PARAM) Long idEstadoCuenta,
                                @Param(ID_EMPLEADO_PARAM) Integer idEmpleado,
                                @Param(FECHA_ALTA_PARAM) Date fechaAlta,
                                @Param(VP_AUDITORIA_PARAM) String vpAuditoria);


    @Query(value = COMISIONES_CALCULADAS_QUERY)
    Page<VwComisioneCalculada> findAllComisionesCalculadas(Pageable pageable);
}
