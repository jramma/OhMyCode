package oh.mycode.ohmycode.controller;


import oh.mycode.ohmycode.dto.TodoDto;
import oh.mycode.ohmycode.model.Todo;
import oh.mycode.ohmycode.model.Usuario;
import oh.mycode.ohmycode.service.TodoService;
import oh.mycode.ohmycode.util.Increment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class TodoController {




}
