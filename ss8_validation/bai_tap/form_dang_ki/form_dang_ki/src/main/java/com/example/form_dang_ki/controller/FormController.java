package com.example.form_dang_ki.controller;

import com.example.form_dang_ki.dto.UserDto;
import com.example.form_dang_ki.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FormController {
    @GetMapping("")
    public String showUserForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/index";
    }

    @PostMapping("/result")
    public String result(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return "result";
    }
}
