package com.telmex.demo.controller;

import java.util.List;
import java.util.Optional;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.dto.input.ComisionDTO;
import com.telmex.demo.entity.Comision;
import com.telmex.demo.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/comision")
public class ComisionController{

	@Autowired
	private ComisionService comisionService;


	@PostMapping("/")
	public ResponseEntity<CustomResponse> create(@RequestBody Comision comision) {
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.CREATED).builder();
		Comision res = comisionService.create(comision);
		customResponse.setData(res);
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}

	@GetMapping("/")
	public ResponseEntity<CustomResponse> getAll(@RequestParam(defaultValue = "1") int page,
												 @RequestParam(defaultValue = "10") int size){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		PageRequest pr = PageRequest.of(page, size);
		Page<Comision> data = comisionService.getAll(pr);
		customResponse.setData(Optional.of(data));
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}

	@GetMapping("/{idComision}")
	public ResponseEntity<CustomResponse> findOne(@PathVariable Integer idComision){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		Comision comision = comisionService.findById(idComision);
		customResponse.setData(comision);
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}

	@PatchMapping("/{idComision}")
	public ResponseEntity<CustomResponse>  update(@RequestBody Comision comision, @PathVariable Integer idComision){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		comision.setIdComision(idComision);
		Comision updateComision = comisionService.update(comision);
		customResponse.setData(updateComision);
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}

	@DeleteMapping("/{idComision}")
	public ResponseEntity<CustomResponse> delete(@PathVariable Integer idComision){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		comisionService.delete(idComision);
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}

	@PatchMapping("/procesar")
	public ResponseEntity<CustomResponse> procesarComisiones(@Valid @RequestBody ComisionDTO comisionDTO){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		comisionService.procesarComicionesFrom(comisionDTO);
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}

	@GetMapping("/calculada")
	public ResponseEntity<CustomResponse> obtenerComisioneCalculadas(@RequestParam(defaultValue = "1") int page,
																	@RequestParam(defaultValue = "10") int size,
																	@RequestParam(required = false) String idEstadoCuenta,
																	@RequestParam(required = false) String conceptoPago,
																	@RequestParam(required = false) String idTipoEmpleado){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		PageRequest pr = PageRequest.of(page, size);
		Page data = comisionService.findAllComisionesCalculadas(pr,Optional.ofNullable(idEstadoCuenta),Optional.ofNullable(conceptoPago),Optional.ofNullable(idTipoEmpleado));
		customResponse.setData(data);
		return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
	}
}
