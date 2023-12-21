package com.telmex.demo.controller;

import java.util.List;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.entity.Comision;
import com.telmex.demo.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<CustomResponse> getAll(){
		CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
		List<Comision> data = comisionService.getAll();
		customResponse.setData(data);
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
}
