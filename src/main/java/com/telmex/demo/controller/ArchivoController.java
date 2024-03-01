package com.telmex.demo.controller;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/archivo")
public class ArchivoController extends BaseController  {

    @Autowired
    private ArchivoService archivoService;

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "procesar/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoCuenta> procesarArchivo(@PathVariable(value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha, Principal principal){
        UserSession session = getSession(principal);
        EstadoCuenta ec =archivoService.procesarArchivoEstadoCuenta(fecha,session);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ec);
    }

}
