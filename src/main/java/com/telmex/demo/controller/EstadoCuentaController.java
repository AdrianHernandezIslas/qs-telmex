package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstatusCarga;
import com.telmex.demo.service.EstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/cuenta")
public class EstadoCuentaController {

    @Autowired
    private EstadoCuentaService estadoCuentaService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "check/{idEstadoCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatusCarga> check(@PathVariable(value = "idEstadoCuenta") Integer idEstadoCuenta){
        return ResponseEntity.of(estadoCuentaService.ckeckEstatus(idEstadoCuenta));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> getAllEstadoCuenta(){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        List data = estadoCuentaService.getAll();
        customResponse.setData(data);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }


}
