package com.telmex.demo.service;

import com.telmex.demo.entity.EstatusEmpleado;
import com.telmex.demo.entity.TipoEmpleado;

import java.util.List;

public interface CatalogoService {


    List<TipoEmpleado> findAllTipoEmpleado();

    List<EstatusEmpleado> findAllEstatusEmpleado();

}
