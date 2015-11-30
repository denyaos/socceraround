package com.socceraround.domain.repository;

import com.socceraround.domain.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Byte> {
    Authority findOneByName(String authorityName);
}
