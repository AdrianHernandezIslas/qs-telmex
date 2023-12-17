package com.telmex.demo.controller;

import com.telmex.demo.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/archivo")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "procesar/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void procesarArchivo(@PathVariable(value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha){
        archivoService.procesarArchivoEstadoCuenta(fecha);
    }
}
