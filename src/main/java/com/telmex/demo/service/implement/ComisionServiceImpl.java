package com.telmex.demo.service.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.telmex.demo.dto.input.ComisionDTO;
import com.telmex.demo.service.ComisionService;
import com.telmex.demo.views.VwComisioneCalculada;
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

	@Override
	public void procesarComicionesFrom(ComisionDTO comisionDTO) {
		comisionRepository.procesarComicionesFrom(
				comisionDTO.getIdEstadoCuenta(),
				comisionDTO.getIdEmpleado(),
				new Date(),
				comisionDTO.getVpAuditoria()
		);
	}

	@Override
	public Page<VwComisioneCalculada> findAllComisionesCalculadas(Pageable page,Optional<String> idEstadoCuenta,Optional<String> pagoConcepto,Optional<String> idTipoEmpleado) {
		String idEstadoCuentaValue = idEstadoCuenta.orElse("%%");
		String pagoConceptoValue = pagoConcepto.orElse("%%");
		String idTipoEmpleadoValue = idTipoEmpleado.orElse("%%");
		return comisionRepository.findAllComisionesCalculadas(page,idEstadoCuentaValue,pagoConceptoValue,idTipoEmpleadoValue);
	}
}
