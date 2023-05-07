package oh.mycode.ohmycode.repos;


import java.util.List;

import oh.mycode.ohmycode.dto.Address;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.assertions.Assertions.assertNull;
import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TodoRepoTest {

    @Autowired
    private TodoRepo todoRepo;
    @Test
    public void testFindTodosOrderedByUser() {
        List<Todo> todos = todoRepo.findTodosOrderedByUser();
        assertNotNull(todos);
    }

    @Test
    public void testDeleteByUser() {
        Usuario usuario = new Usuario();
        usuario.setUsername("test");
        usuario.setPassword("test");
        usuario.setAddress(new Address("test street", "test city", "test zip","test"));

        Todo todo = new Todo();
        todo.setTitle("test");
        todo.setUser(usuario);
        todo.setId(-1);
        todoRepo.save(todo);
        int id = todo.getId();
        todoRepo.deleteByUser(usuario);
        assertNull(todoRepo.findTodoById(id));
    }

}


