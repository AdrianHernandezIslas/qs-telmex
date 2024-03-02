package com.telmex.demo.controller;

import com.telmex.demo.dto.AuthRequestDTO;
import com.telmex.demo.dto.AuthSessionDTO;
import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<CustomResponse> authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO, HttpServletRequest request, HttpServletResponse response) {
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        AuthSessionDTO authentication = authService.authenticate(authRequestDTO,request);
        if (authentication.getAuthentication().isAuthenticated()) {
            response.addHeader(HttpHeaders.SET_COOKIE, authentication.getResponseCookie().toString());
            customResponse.setData(authentication.getJwtResponse());
            return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<CustomResponse> logout( HttpServletResponse response){
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        response.addHeader("accessToken",null);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
