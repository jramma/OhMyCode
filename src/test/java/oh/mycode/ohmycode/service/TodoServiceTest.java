package oh.mycode.ohmycode.service;

import oh.mycode.ohmycode.dto.TodoDto;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.repos.TodoRepo;
import oh.mycode.ohmycode.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TodoServiceTest {

    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepo todoRepo;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testAllTodos() {
        List<Todo> todos = todoService.allTodos();
        assertNotNull(todos);
    }

    @Test
    public void testAllUser() {
        List<Usuario> users = todoService.allUser();
        assertNotNull(users);
    }


    @Test
    public void testAllTodosCity() {
        List<TodoDto> todos = todoService.allTodosCity();
        assertNull(todos);
    }


   @Test
    public void testDeleteTodo() {
        Todo todo = todoService.getToDoById(2);
        todoService.deleteTodo(2);
        Todo deletedTodo = todoRepo.findTodoById(1);
        assertNull(deletedTodo);
        todoService.saveTodo(todo);
    }


}


