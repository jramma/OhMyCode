package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepo extends MongoRepository<User, String> {


}
