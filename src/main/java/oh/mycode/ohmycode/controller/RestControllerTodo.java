package oh.mycode.ohmycode.controller;

import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.User;
import oh.mycode.ohmycode.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerTodo {
    @Autowired
    TodoService todoService;

    @GetMapping("/getTodos")
    public List<Todo> getTo(){
        return todoService.allTodos();
    }
    @GetMapping("/getUsers")
    public List<User> getUser(){
        return todoService.allUser();
    }

}
