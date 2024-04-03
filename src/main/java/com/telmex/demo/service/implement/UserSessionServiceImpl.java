package com.telmex.demo.service.implement;

import com.telmex.demo.entity.UserSession;
import com.telmex.demo.repository.UserSessionRepository;
import com.telmex.demo.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public UserSession create(UserSession userSession) {
        return userSessionRepository.save(userSession);
    }

    @Override
    public void disableSessions(Long idUser) {
        userSessionRepository.disableSession(idUser);
    }
}
