package com.telmex.demo.service;

import com.telmex.demo.dto.AuthRequestDTO;
import com.telmex.demo.dto.AuthSessionDTO;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    AuthSessionDTO authenticate(AuthRequestDTO authRequestDTO, HttpServletRequest request);
}
