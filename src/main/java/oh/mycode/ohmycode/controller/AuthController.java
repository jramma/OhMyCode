package oh.mycode.ohmycode.controller;

import oh.mycode.ohmycode.dto.LoginDto;
import org.springframework.ui.Model;
import oh.mycode.ohmycode.dto.UserNotRegistredDto;
import oh.mycode.ohmycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        UserNotRegistredDto usuarioNoRegistrado = new UserNotRegistredDto();
        model.addAttribute("usuarioNoRegistrado", usuarioNoRegistrado);
        return "signup";
    }

    @PostMapping("/login")
    public String signUp(@ModelAttribute("usuarioNoRegistrado") UserNotRegistredDto userDto){
        userService.save(userDto);
        return "redirect:/signup";
    }






}