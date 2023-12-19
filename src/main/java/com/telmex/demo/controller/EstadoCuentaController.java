package com.telmex.demo.controller;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstatusCarga;
import com.telmex.demo.service.EstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/cuenta")
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
    @GetMapping(value = "detalle/{idEstadoCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoCuenta> getDetalle(@PathVariable(value = "idEstadoCuenta") Integer idEstadoCuenta){
        Optional<EstadoCuenta> estadoCuenta =estadoCuentaService.get(idEstadoCuenta);
        return ResponseEntity.of(estadoCuenta);
    }
}
