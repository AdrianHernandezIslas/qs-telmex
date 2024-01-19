package com.telmex.demo.service;

import com.telmex.demo.entity.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {

    public Empleado create(Empleado empleado);

    public Page<Empleado> getAll(Pageable page);

    public Empleado findById(Integer idEmpleado);

    public Empleado update(Empleado empleado);

    public void delete(Integer idEmpleado);

}
