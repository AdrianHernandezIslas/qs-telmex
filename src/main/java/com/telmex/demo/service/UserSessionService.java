package com.telmex.demo.service;

import com.telmex.demo.entity.UserSession;

public interface UserSessionService {

    UserSession create(UserSession userSession);

    void disableSessions(Long idUser);
}
