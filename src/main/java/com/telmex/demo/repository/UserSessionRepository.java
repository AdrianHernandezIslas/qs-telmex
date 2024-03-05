package com.telmex.demo.repository;

import com.telmex.demo.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE UserSession s SET s.activa=0, s.fechaFin=now() WHERE s.usuario.idUser = :idUsuario AND s.activa=1")
    void disableSession(@Param("idUsuario") long idUsuario);


}
