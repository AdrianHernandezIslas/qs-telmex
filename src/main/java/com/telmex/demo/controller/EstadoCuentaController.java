package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.entity.Comision;
import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstatusCarga;
import com.telmex.demo.service.EstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/cuenta")
public class EstadoCuentaController extends BaseController {

    @Autowired
    private EstadoCuentaService estadoCuentaService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "check/{idEstadoCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatusCarga> check(@PathVariable(value = "idEstadoCuenta") Integer idEstadoCuenta){
        return ResponseEntity.of(estadoCuentaService.ckeckEstatus(idEstadoCuenta));
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse> create(@RequestBody EstadoCuenta estadoCuenta) {
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.CREATED).builder();
        EstadoCuenta res = estadoCuentaService.create(estadoCuenta);
        customResponse.setData(res);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> getAllEstadoCuenta(@RequestParam(defaultValue = "1") int page,
                                                             @RequestParam(defaultValue = "10") int size,
                                                             @RequestParam(required = false) Optional<String[]> sort){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        PageRequest pr = PageRequest.of(page, size,buildSort(sort));
        Page<EstadoCuenta> data = estadoCuentaService.getAll(pr);
        customResponse.setData(Optional.of(data));
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @GetMapping("/{idEstadoCuenta}")
    public ResponseEntity<CustomResponse> findOne(@PathVariable Integer idEstadoCuenta){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        Optional<EstadoCuenta> estadoCuenta = estadoCuentaService.get(idEstadoCuenta);
        customResponse.setData(estadoCuenta);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @PatchMapping("/{idEstadoCuenta}")
    public ResponseEntity<CustomResponse>  update(@RequestBody EstadoCuenta estadoCuenta, @PathVariable Integer idEstadoCuenta){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        estadoCuenta.setIdEstadoCuenta(idEstadoCuenta);
        EstadoCuenta updateEstadoCuenta = estadoCuentaService.update(estadoCuenta);
        customResponse.setData(updateEstadoCuenta);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @DeleteMapping("/{idEstadoCuenta}")
    public ResponseEntity<CustomResponse> delete(@PathVariable Integer idEstadoCuenta){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        estadoCuentaService.delete(idEstadoCuenta);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
