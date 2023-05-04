package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    boolean existsByUsername(String username);
    User findByUsername(String username);

}
