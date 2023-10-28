package com.example.demo.configs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String get500Page(Exception ex, Model model){
        model.addAttribute("errorMsg", ex.getMessage());
        return "/500";
    }

}
