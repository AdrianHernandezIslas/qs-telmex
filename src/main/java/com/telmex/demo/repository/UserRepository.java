package com.telmex.demo.repository;

import com.telmex.demo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
    UserInfo findFirstByIdUser(Long id);

}
