package com.telmex.demo.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telmex.demo.components.sessions.JwtService;
import com.telmex.demo.dto.CustomUserDetails;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.service.implement.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    private final ObjectMapper mapper =  new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromCookie(request);
        if(token == null){
            filterChain.doFilter(request, response);
            return;
        }

        Optional<String> usernameOptional = Optional.ofNullable(jwtService.extractUsername(token));

        if(usernameOptional.isPresent()){
            CustomUserDetails userDetails = (CustomUserDetails) userDetailsServiceImpl.loadUserByUsername(usernameOptional.get());
            Optional<UserSession>  sessionOptional = validateSession(token,request,userDetails);
            sessionOptional.ifPresent(userSession -> addSession(request, userSession, userDetails));
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromCookie(HttpServletRequest request){
        String token = null;
        if(request.getCookies() != null){
            for(Cookie cookie: request.getCookies()){
                if(cookie.getName().equals("accessToken")){
                    token = cookie.getValue();
                    break;
                }
            }
        }
        return token;
    }

    private Optional<UserSession> validateSession(String token, HttpServletRequest request, CustomUserDetails userDetails){
        Optional<UserSession> session = Optional.ofNullable(null);
        if(jwtService.validateToken(token, userDetails)){
            Map<String,Object> payloadToken = jwtService.extractAllClaims(token);
            UserSession userSession = mapper.convertValue(payloadToken.get("session"),UserSession.class);
            session = Optional.of(userSession);
        }
        return session;
    }

    private void addSession(HttpServletRequest request,UserSession userSession,CustomUserDetails userDetails){
        userDetails.setSession(userSession);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}