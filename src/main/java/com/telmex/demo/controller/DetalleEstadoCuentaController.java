package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.service.DetalleEstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/detalle_cuenta")
public class DetalleEstadoCuentaController extends BaseController {

    @Autowired
    private DetalleEstadoCuentaService detalleEstadoCuentaService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "cuenta/{idEstadoCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> getDetalle(@PathVariable(value = "idEstadoCuenta") Integer idEstadoCuenta,
                                                     @RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "10") int size,
                                                     @RequestParam(required = false) Optional<String[]> sort) {
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        PageRequest pr = PageRequest.of(page, size,buildSort(sort));
        Page dataPage = detalleEstadoCuentaService.getAllDetalleByCuenta(idEstadoCuenta, pr);
        customResponse.setData(Optional.ofNullable(dataPage));
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
