package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<Usuario, String> {

    boolean existsByUsername(String username);
    Usuario findByUsername(String username);

    Optional<Usuario> findOneByUsername(String username);

    boolean existsByPassword(String encode);
}
