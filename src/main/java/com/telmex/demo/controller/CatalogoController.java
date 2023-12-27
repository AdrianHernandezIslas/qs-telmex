package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/tipo_empleado")
    public ResponseEntity<CustomResponse> getAllTipoEmpleado(){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        List data = catalogoService.findAllTipoEmpleado();
        customResponse.setData(data);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @GetMapping("/estatus_empleado")
    public ResponseEntity<CustomResponse> getAllEstatusEmpleado(){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        List data = catalogoService.findAllEstatusEmpleado();
        customResponse.setData(data);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
