package com.telmex.demo.repository;

import com.telmex.demo.entity.Notificacion;
import com.telmex.demo.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Notificacion n SET n.leido = 1 WHERE n.idNotificacion = :idNotificacion")
    void updateStatusRead(@Param("idNotificacion") Long idNotificacion);

    Page<Notificacion> findAllByUsuario(Pageable page,UserInfo user);

}
