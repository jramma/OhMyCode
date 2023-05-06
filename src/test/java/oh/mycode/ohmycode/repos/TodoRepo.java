package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TodoRepo extends MongoRepository<Todo, String> {


}
