package com.telmex.demo.service;

import com.telmex.demo.dto.input.ComisionDTO;
import com.telmex.demo.entity.Comision;
import com.telmex.demo.views.VwComisioneCalculada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComisionService {

     Comision create(Comision comision);

     Page<Comision> getAll(Pageable page);

     Comision findById(Integer idComision);

     Comision update(Comision comision);

     void delete(Integer idComision);

     void procesarComicionesFrom(ComisionDTO comisionDTO);

     Page<VwComisioneCalculada> findAllComisionesCalculadas(Pageable page, Optional<String> idEstadoCuenta, Optional<String> pagoConcepto,Optional<String> idTipoEmpleado);
}
