package com.telmex.demo.service.implement;

import com.telmex.demo.entity.UserCategory;
import com.telmex.demo.repository.CategoriaRepository;
import com.telmex.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<UserCategory> findAllByRol(List<Long> idRol) {
        return categoriaRepository.findAllRol(idRol);
    }
}
