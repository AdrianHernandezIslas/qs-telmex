package com.telmex.demo.controller;

import com.telmex.demo.dto.CustomUserDetails;
import com.telmex.demo.entity.BaseObject;
import com.telmex.demo.entity.UserSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;

public abstract class BaseController {

    protected UserSession getSession(Principal principal){
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        CustomUserDetails userDetails = (CustomUserDetails)token.getPrincipal();
        return userDetails.getSession();
    }

    protected void addSession(BaseObject baseObject,Principal principal){
        UserSession session = getSession(principal);
        baseObject.setSession(session);

    }
}
