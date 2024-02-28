package com.telmex.demo.service.implement;

import com.telmex.demo.components.sessions.JwtSecurity;
import com.telmex.demo.components.sessions.JwtService;
import com.telmex.demo.components.sessions.SessionSecurity;
import com.telmex.demo.dto.AuthRequestDTO;
import com.telmex.demo.dto.AuthSessionDTO;
import com.telmex.demo.dto.CustomUserDetails;
import com.telmex.demo.dto.JwtResponseDTO;
import com.telmex.demo.entity.UserInfo;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.service.AuthService;
import com.telmex.demo.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtSecurity jwtSecurity;

    @Autowired
    private SessionSecurity sessionSecurity;

    @Override
    public AuthSessionDTO authenticate(AuthRequestDTO authRequestDTO, HttpServletRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        UserSession session = saveSession(authentication,request);
        String accessToken = generateToken(authRequestDTO.getUsername(),session);
        ResponseCookie cookie = jwtSecurity.createCookie(accessToken);
        JwtResponseDTO jwtResponseDTO = JwtResponseDTO.builder().accessToken(accessToken).token(accessToken).build();
        return AuthSessionDTO.builder().responseCookie(cookie).jwtResponse(jwtResponseDTO).authentication(authentication).build();
    }

    public String generateToken(String username,UserSession session) {
        Map<String, Object> claims = new HashMap();
        claims.put("session",session);
        return jwtService.generateToken(username,claims);
    }

    private UserSession saveSession(Authentication authentication, HttpServletRequest request){
        String ip = sessionSecurity.getClientIp(request);
        CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
        userSessionService.disableSessions(user.getIdUser());
        UserSession session = createSession(user,ip);
        session = userSessionService.create(session);
        return session;
    }
    private UserSession createSession(UserInfo user,String ip){
        UserSession session = new UserSession();
        UserInfo userin= new UserInfo();
        userin.setIdUser(user.getIdUser());
        userin.setRoles(user.getRoles());
        userin.setUsername(user.getUsername());
        session.setIp(ip);
        session.setUsuario(userin);
        session.setFechaCreacion(new Date());
        session.setActiva(1);
        return session;
    }
}
