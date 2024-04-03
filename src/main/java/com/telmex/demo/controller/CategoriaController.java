package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.entity.UserCategory;
import com.telmex.demo.entity.UserRole;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/categoria")
public class CategoriaController extends BaseController{

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/by/session")
    public ResponseEntity<CustomResponse> getAllCCategoriasBySession(Principal principal){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        UserSession session = getSession(principal);
        List<Long> ids = session.getUsuario().getRoles().stream().map(UserRole::getIdRole).collect(Collectors.toList());
        List<UserCategory> data = categoriaService.findAllByRol(ids);
        customResponse.setData(data);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

}
