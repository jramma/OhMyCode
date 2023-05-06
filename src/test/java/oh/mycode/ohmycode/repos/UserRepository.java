package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<Usuario, String> {


}
