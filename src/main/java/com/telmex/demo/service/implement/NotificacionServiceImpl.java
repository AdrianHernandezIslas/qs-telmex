package com.telmex.demo.service.implement;

import com.telmex.demo.entity.Notificacion;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.repository.NotificacionRepository;
import com.telmex.demo.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;
    @Override
    public Notificacion create(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Page<Notificacion> getAll(Pageable page, UserSession userSession) {
        return notificacionRepository.findAllByUsuario(page,userSession.getUsuario());
    }

    @Override
    public void updateIdRead(Long idNotificacion) {
        notificacionRepository.updateStatusRead(idNotificacion);
    }
}
