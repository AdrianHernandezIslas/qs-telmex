package com.telmex.demo.service.implement;

import java.util.List;

import com.telmex.demo.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.telmex.demo.entity.Comision;
import com.telmex.demo.repository.ComisionRepository;

@Service
public class ComisionServiceImpl implements ComisionService {
	
	@Autowired
	private ComisionRepository comisionRepository;

	@Override
	public Comision create(Comision comision) {
		return comisionRepository.save(comision);
	}

	@Override
	public Page<Comision> getAll(Pageable page) {
		return comisionRepository.findAll(page);
	}

	@Override
	public Comision findById(Integer idComision) {
		return comisionRepository.findById(idComision).get();
	}

	@Override
	public Comision update(Comision comision) {
		return comisionRepository.save(comision);
	}

	@Override
	public void delete(Integer idComision) {
		comisionRepository.deleteById(idComision);
	}
}
