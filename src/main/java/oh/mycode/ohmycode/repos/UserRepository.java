package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.security.dto.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Usuario, String> {

    boolean existsByUsername(String username);
    Usuario findByUsername(String username);
    List<Usuario> findByRoles(Rol rol);


}
