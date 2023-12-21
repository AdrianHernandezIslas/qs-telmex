package com.telmex.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telmex.demo.entity.Comision;

@Repository
public interface ComisionRepository extends JpaRepository<Comision, Integer> {

}
