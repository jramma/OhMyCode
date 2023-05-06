package oh.mycode.ohmycode.controller;


import jakarta.servlet.http.HttpServletRequest;
import oh.mycode.ohmycode.dto.TodoDto;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import oh.mycode.ohmycode.util.Increment;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class TodoController {

    @Autowired
    TodoService todoService;


    @GetMapping("/")
    public String inicio(@RequestParam Map<String, Object> params, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String username = "null";
        if (userDetails != null) {
            username = userDetails.getUsername();
        }

        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<TodoDto> pageTodo = getTodoCityPage(pageRequest);

        int totalPage = pageTodo.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        model.addAttribute("username", username);
        model.addAttribute("todos", pageTodo.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        return "listado";
    }
// http://localhost:8080/


    public Page<TodoDto> getTodoCityPage(Pageable pageable) {
        List<TodoDto> list = todoService.allTodosCity();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<TodoDto> pageList;

        if (list.size() < startItem) {
            pageList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, list.size());
            pageList = list.subList(startItem, toIndex);
        }

        return new PageImpl<>(pageList, pageable, list.size());
    }

    @RequestMapping("/add")
    public String create(Model model) {
        model.addAttribute("todoNotSaved", new TodoDto());
        model.addAttribute("users", todoService.allUser());
        return "addTodo";
    }

    @PostMapping("/saveTodo")
    public String saveOrUpdate(@ModelAttribute TodoDto todoNotSaved) {
        Usuario user = todoService.findByUsername(todoNotSaved.getUsername());
        Todo todo = new Todo();
        todo.setTitle(todoNotSaved.getTitle());
        todo.setCompleted(todoNotSaved.isCompleted());
        todo.setUser(user);
        todo.setId(Increment.autoIncrement(todoService.allTodos()));
        todoService.saveTodo(todo);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("todo", todoService.getToDoById(id));
        return "edit";
    }

    @PostMapping("/updateTodo/{id}")
    public String updateTodo(@PathVariable(name = "id") int id, @ModelAttribute("todo") Todo todo, Model model) {
        Todo todoSaved = todoService.getToDoById(id);
        todoSaved.setId(id);
        todoSaved.setTitle(todo.getTitle());
        todoSaved.getUser();
        todo.setCompleted(todo.isCompleted());
        todoService.updateTodo(todoSaved);
        return "redirect:/";
    }

    @GetMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }


}
