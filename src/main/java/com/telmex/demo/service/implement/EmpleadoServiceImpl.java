package com.telmex.demo.service.implement;

import com.telmex.demo.entity.Empleado;
import com.telmex.demo.repository.EmpleadoRepository;
import com.telmex.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findById(Integer idEmpleado) {
        return empleadoRepository.findById(idEmpleado).get();
    }

    @Override
    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void delete(Integer idEmpleado) {
        empleadoRepository.deleteById(idEmpleado);
    }
}