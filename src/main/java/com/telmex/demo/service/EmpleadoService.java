package com.telmex.demo.service;

import com.telmex.demo.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    public Empleado create(Empleado empleado);

    public List<Empleado> getAll();

    public Empleado findById(Integer idEmpleado);

    public Empleado update(Empleado empleado);

    public void delete(Integer idEmpleado);

}
