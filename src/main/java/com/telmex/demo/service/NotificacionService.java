package com.telmex.demo.service;

import com.telmex.demo.entity.Notificacion;
import com.telmex.demo.entity.UserSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificacionService {

    Notificacion create(Notificacion notificacion);

    Page<Notificacion> getAll(Pageable page, UserSession userSession);

    void updateIdRead(Long idNotificacion);
}
