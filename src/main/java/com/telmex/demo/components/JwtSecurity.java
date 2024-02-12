package com.telmex.demo.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class JwtSecurity {


    @Value("${jwt.cookieExpiry}")
    private int cookieExpiry;

    public ResponseCookie createCookie(String accessToken){
        return ResponseCookie.from("accessToken", accessToken)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(cookieExpiry)
                .build();
    }
}
