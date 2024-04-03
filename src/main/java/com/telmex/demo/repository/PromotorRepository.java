package com.telmex.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telmex.demo.entity.Promotor;

@Repository
public interface  PromotorRepository extends CrudRepository<Promotor, String> {

}
