package com.telmex.demo.service;

import com.telmex.demo.entity.UserCategory;

import java.util.List;

public interface CategoriaService {
    List<UserCategory> findAllByRol();
}
