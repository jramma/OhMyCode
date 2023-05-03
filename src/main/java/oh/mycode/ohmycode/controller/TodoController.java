package oh.mycode.ohmycode.controller;


import oh.mycode.ohmycode.dto.TodoCityDto;
import oh.mycode.ohmycode.service.TodoService;
import oh.mycode.ohmycode.util.RenderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class TodoController {

    @Autowired
    TodoService todoService;


    @GetMapping("/inicio")
    public String inicio(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<TodoCityDto> pageTodo = getTodoCityPage(pageRequest);
        int totalPage = pageTodo.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);


        }
        List<TodoCityDto> list = todoService.allTodosCity();
        model.addAttribute("todos", list);

        return "listado";
    }
// http://localhost:8080/inicio


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


}
