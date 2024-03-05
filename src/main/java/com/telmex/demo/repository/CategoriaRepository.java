package com.telmex.demo.repository;

import com.telmex.demo.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static com.telmex.demo.constants.CategoriaConstants.GET_CATEGORY_BY_ROL;
import static com.telmex.demo.constants.CategoriaConstants.ROL_PARAM_LIST;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<UserCategory, Long> {

    @Query(GET_CATEGORY_BY_ROL)
    List<UserCategory> findAllRol(@Param(ROL_PARAM_LIST) List<Long> idRol);
}
