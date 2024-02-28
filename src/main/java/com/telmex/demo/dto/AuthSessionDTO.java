package com.telmex.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthSessionDTO {
    private Authentication authentication;
    private ResponseCookie responseCookie;
    private JwtResponseDTO jwtResponse;
}
