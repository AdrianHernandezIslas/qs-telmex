package com.telmex.demo.repository;

import com.telmex.demo.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<UserCategory, Long> {

    @Query("SELECT c FROM UserCategory c INNER JOIN c.functions uf INNER JOIN uf.permissions p INNER JOIN p.rol ur WHERE ur.idRole = :idRol ORDER BY c.orden")
    List<UserCategory> findAllRol(@Param("idRol") Long idRol);
}
