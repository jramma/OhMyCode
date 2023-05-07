package oh.mycode.ohmycode.repos;

import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends MongoRepository<Todo, String> {

    @Query("{ }")
    List<Todo> findTodosOrderedByUser();

    void deleteByUser(Usuario usuario);

    Todo findTodoById(int id);

    void deleteTodoById(int id);
}

