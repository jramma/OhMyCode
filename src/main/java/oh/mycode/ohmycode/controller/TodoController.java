package oh.mycode.ohmycode.controller;


import oh.mycode.ohmycode.dto.TodoCityDto;
import oh.mycode.ohmycode.dto.TodoNotSaved;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.User;
import oh.mycode.ohmycode.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import oh.mycode.ohmycode.util.Increment;
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
    public String inicio(@RequestParam Map<String, Object> params, Model model) {

        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<TodoCityDto> pageTodo = getTodoCityPage(pageRequest);

        int totalPage = pageTodo.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        model.addAttribute("todos", pageTodo.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        return "listado";
    }
// http://localhost:8080/


    public Page<TodoCityDto> getTodoCityPage(Pageable pageable) {
        List<TodoCityDto> list = todoService.allTodosCity();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<TodoCityDto> pageList;

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
        model.addAttribute("todoNotSaved", new TodoNotSaved());
        model.addAttribute("users", todoService.allUser());
        return "addTodo";
    }
    @PostMapping("/saveTodo")
    public String saveTodo(@ModelAttribute TodoNotSaved todoNotSaved, @RequestParam("username") String username){
        List<Todo> alltodo =todoService.allTodos();
        int id= Increment.autoIncrement(alltodo);
        User user = todoService.findByUsername(username);
        Todo todo1= new Todo(id,todoNotSaved.getText(),false, user);
        if(todo1.getUser() !=null) {
            todoService.saveTodo(todo1);
        }
        return "redirect:/";
    }




    @PutMapping("/edit")
    public String edit() {
        return null;
    }


}
