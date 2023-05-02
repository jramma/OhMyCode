package oh.mycode.ohmycode.controller;


import ch.qos.logback.core.model.Model;
import oh.mycode.ohmycode.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @GetMapping("/inicio")
    public String inicio(Model model, @RequestParam(defaultValue = "0") int page) {
//        PageRequest pageable = PageRequest.of(page, 10); //recupera 10 elementos por página
//        Page<Todo> pagina = elementoRepository.findAll(pageable); //recupera la página actual de elementos
//        model.addAttribute("pagina", pagina); //agrega la página al modelo
//        model.addAttribute("currentPage", page); //agrega el número de página actual al modelo
        return "listado";
    }


}
