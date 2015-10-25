package com.company.domain.repository;

import com.company.domain.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Byte> {
    Authority findOneByName(String authorityName);
}
