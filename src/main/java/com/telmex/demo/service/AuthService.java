package com.telmex.demo.service;

import com.telmex.demo.dto.AuthRequestDTO;
import org.springframework.security.core.Authentication;

public interface AuthService {

    Authentication authenticate(AuthRequestDTO authRequestDTO);

    String generateToken(String username);
}
