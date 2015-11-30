package com.socceraround.domain.repository;

import com.socceraround.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByUsername(String username);

}
