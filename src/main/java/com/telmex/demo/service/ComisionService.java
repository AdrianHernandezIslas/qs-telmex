package com.telmex.demo.service;

import com.telmex.demo.entity.Comision;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ComisionService {

    public Comision create(Comision comision);

    public Page<Comision> getAll(Pageable page);

    public Comision findById(Integer idComision);

    public Comision update(Comision comision);

    public void delete(Integer idComision);
}
