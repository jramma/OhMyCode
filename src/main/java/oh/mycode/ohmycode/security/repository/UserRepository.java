package oh.mycode.ohmycode.security.repository;


import oh.mycode.ohmycode.security.domain.Usuario;
import oh.mycode.ohmycode.security.dto.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<Usuario, String> {
	Optional<Usuario> findByUsername(String username);
	boolean existsByUsername(String username);
	
	List<Usuario> findByRoles(Rol rol);

}
