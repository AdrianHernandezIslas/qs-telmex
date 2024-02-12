package com.telmex.demo.controller;

import com.telmex.demo.components.JwtSecurity;
import com.telmex.demo.dto.AuthRequestDTO;
import com.telmex.demo.dto.CustomResponse;
import com.telmex.demo.dto.JwtResponseDTO;
import com.telmex.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtSecurity jwtSecurity;

    @PostMapping("/login")
    public ResponseEntity<CustomResponse> authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO, HttpServletResponse response) {
        CustomResponse customResponse = new CustomResponse.CustomResponseBuilder(HttpStatus.OK).builder();
        Authentication authentication = authService.authenticate(authRequestDTO);
        if (authentication.isAuthenticated()) {
            String accessToken = authService.generateToken(authRequestDTO.getUsername());
            ResponseCookie cookie = jwtSecurity.createCookie(accessToken);
            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            JwtResponseDTO jwtResponseDTO = JwtResponseDTO.builder()
                    .accessToken(accessToken)
                    .token(accessToken).build();
            customResponse.setData(jwtResponseDTO);
            return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);

        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
