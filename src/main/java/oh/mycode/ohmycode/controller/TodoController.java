package oh.mycode.ohmycode.controller;



import oh.mycode.ohmycode.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class TodoController {

    @Autowired
    TodoService todoService;


    @GetMapping("/inicio")
    public String inicio(Model model) {
        model.addAttribute("todos",todoService.allTodosCity());
        return "listado";
    }
// http://localhost:8080/inicio









}
