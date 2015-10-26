package socceraround.domain.repository;

import socceraround.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByUsername(String username);

}
