package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TodoRepo extends MongoRepository<Todo, String> {

    @Query("{ }")
    List<Todo> findTodosOrderedByUser();

}
