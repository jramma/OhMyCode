package oh.mycode.ohmycode.service;

import oh.mycode.ohmycode.dto.TodoCityDto;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.User;
import oh.mycode.ohmycode.repos.TodoRepo;
import oh.mycode.ohmycode.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    @Autowired
    UserRepo userRepo;

    public List<Todo> allTodos() {
        return todoRepo.findAll();
    }
    public List<User> allUser() {
        return userRepo.findAll();
    }
    public Todo saveTodo(Todo todo){
        return todoRepo.save(todo);

    }
    public List<TodoCityDto> allTodosCity() {
        return allTodos()
                .stream()
                .map(todo -> new TodoCityDto(
                        todo.getTitle(),
                        todo.getUser().getUsername(),
                        todo.getUser().getAddress().getCity(),
                        todo.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }



}
