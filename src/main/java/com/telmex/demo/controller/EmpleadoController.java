package com.telmex.demo.controller;

import com.telmex.demo.entity.Empleado;
import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody Empleado empleado){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.CREATED).builder();
        Empleado nuevoEmpleado =  empleadoService.create(empleado);
        customResponse.setData(nuevoEmpleado);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @GetMapping("/")
    public ResponseEntity getAll(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int size){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        PageRequest pr = PageRequest.of(page, size);
        Page<Empleado> dataPage = empleadoService.getAll(pr);
        customResponse.setData(Optional.ofNullable(dataPage));
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity findOne(@PathVariable Integer idEmpleado){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        Empleado empleado = empleadoService.findById(idEmpleado);
        customResponse.setData(empleado);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @PatchMapping("/{idEmpleado}")
    public ResponseEntity  update(@RequestBody Empleado empleado,@PathVariable Integer idEmpleado){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        empleado.setIdEmpleado(idEmpleado);
        Empleado updateEmpleado = empleadoService.update(empleado);
        customResponse.setData(updateEmpleado);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity delete(@PathVariable Integer idEmpleado){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        empleadoService.delete(idEmpleado);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
