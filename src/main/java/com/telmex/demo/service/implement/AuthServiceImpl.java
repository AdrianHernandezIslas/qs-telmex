package com.telmex.demo.service.implement;

import com.telmex.demo.components.JwtService;
import com.telmex.demo.dto.AuthRequestDTO;
import com.telmex.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Authentication authenticate(AuthRequestDTO authRequestDTO) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
    }

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
}
