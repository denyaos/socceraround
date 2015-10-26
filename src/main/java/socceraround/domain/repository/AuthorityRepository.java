package socceraround.domain.repository;

import socceraround.domain.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Byte> {
    Authority findOneByName(String authorityName);
}
