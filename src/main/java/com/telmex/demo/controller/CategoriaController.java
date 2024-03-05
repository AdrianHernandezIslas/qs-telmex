package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categoria")
public class CategoriaController extends BaseController{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/by/session")
    public ResponseEntity<CustomResponse> getAllCCategoriasBySession(Principal principal){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        UserSession session = getSession(principal);
        List data = categoriaRepository.findAllRol(session.getUsuario().getIdUser());
        customResponse.setData(data);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

}
