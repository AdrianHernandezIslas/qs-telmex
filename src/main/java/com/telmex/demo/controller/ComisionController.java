package com.telmex.demo.controller;

import java.util.Date;

import com.telmex.demo.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/comisiones")
public class ComisionController {

	@Autowired
	private ComisionService service;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getByCorresponsal(
			@PathVariable(value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {

		try {
			service.getFileFTP("Chargeback.xlsx");
		}catch(Exception ex) {
			return ResponseEntity.ok().body(ex.getMessage());
		}
		
		return ResponseEntity.ok().body("Ok");
	}

}
