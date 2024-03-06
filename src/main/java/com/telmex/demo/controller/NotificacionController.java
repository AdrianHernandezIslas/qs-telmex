package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.entity.Notificacion;
import com.telmex.demo.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/notificacion")
public class NotificacionController extends BaseController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse> getAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(required = false) String status,
                                                 Principal principal) {
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        PageRequest pr = PageRequest.of(page, size);
        Page<Notificacion> dataPage = notificacionService.getAll(pr, getSession(principal),Optional.ofNullable(status));
        customResponse.setData(Optional.ofNullable(dataPage));
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @PatchMapping("/{idNotificacion}")
    public ResponseEntity<CustomResponse> read(@PathVariable Long idNotificacion) {
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        notificacionService.updateIdRead(idNotificacion);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

}
