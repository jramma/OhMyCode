package oh.mycode.ohmycode.controller;

import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerTodo {
    @Autowired
    TodoService todoService;

    @GetMapping("/getTodos")
    public List<Todo> getTo() {
        return todoService.allTodos();
    }

    @GetMapping("/getUsers")
    public List<Usuario> getUser() {
        return todoService.allUser();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        todoService.deleteTodo(id);
        //return "redirect:/?deleted";
    }

}
