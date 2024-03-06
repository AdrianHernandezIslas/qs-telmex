package com.telmex.demo.service;

import com.telmex.demo.entity.Notificacion;
import com.telmex.demo.entity.UserSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotificacionService {

    Notificacion create(Notificacion notificacion);

    Page<Notificacion> getAll(Pageable page, UserSession userSession, Optional<String> status);

    void updateIdRead(Long idNotificacion);
}
