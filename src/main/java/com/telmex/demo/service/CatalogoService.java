package com.telmex.demo.service;

import com.telmex.demo.entity.*;

import java.util.List;

public interface CatalogoService {


    List<TipoEmpleado> findAllTipoEmpleado();

    List<EstatusEmpleado> findAllEstatusEmpleado();

    List<PerfilEmpleado> findAllPerfil();

    List<Genero> findAllGenero();

    List<TipoCliente> findAllTipoCliente();
    List<TipoServicio> findAllTipoServicio();
    List<PorcentajeComision> findAllPorcentajeComision();

    List<PagoConcepto> findAllPagoConcepto();

    List<UserRole> findAllRoles();

}
