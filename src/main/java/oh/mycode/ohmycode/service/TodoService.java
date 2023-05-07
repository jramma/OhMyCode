package oh.mycode.ohmycode.service;

import oh.mycode.ohmycode.dto.TodoDto;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.repos.TodoRepo;
import oh.mycode.ohmycode.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    @Autowired
    UserRepository userRepo;

    public List<Todo> allTodos() {
        return todoRepo.findAll();
    }
    public List<Usuario> allUser() {
        return userRepo.findAll();
    }
    public Todo saveTodo(Todo todo){
        return todoRepo.save(todo);

    }
    public List<TodoDto> allTodosCity() {

            return allTodos()
                    .stream()
                    .map(todo -> new TodoDto(
                            todo.getId(),
                            todo.getTitle(),
                            todo.getUser().getUsername(),
                            todo.getUser().getAddress().getCountry(),
                            todo.isCompleted()
                    ))
                    .collect(Collectors.toList());

    }

    public Usuario saveUser(Usuario user){
        return userRepo.save(user);
    }

    public Usuario findByUsername(String username){
        return userRepo.findByUsername(username);
    }
    public Todo getToDoById(int id){
        return todoRepo.findTodoById(id);
    }

    public void deleteTodo(int id) {
        todoRepo.deleteTodoById(id);
    }

    public Todo updateTodo(Todo todo){
        return todoRepo.save(todo);
    };


}
