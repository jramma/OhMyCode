package oh.mycode.ohmycode.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllError {

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "redirect:/?error";
    }
}