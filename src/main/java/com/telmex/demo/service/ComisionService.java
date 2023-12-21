package com.telmex.demo.service;

import com.telmex.demo.entity.Comision;

import java.util.List;

public interface ComisionService {

    public Comision create(Comision comision);

    public List<Comision> getAll();

    public Comision findById(Integer idComision);

    public Comision update(Comision comision);

    public void delete(Integer idComision);
}
