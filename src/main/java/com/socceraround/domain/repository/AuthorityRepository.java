package com.socceraround.domain.repository;

import com.socceraround.domain.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Byte> {
    Authority findOneByName(String authorityName);
}
