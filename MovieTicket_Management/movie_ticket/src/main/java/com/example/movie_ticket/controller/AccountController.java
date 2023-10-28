package com.example.movie_ticket.controller;

import com.example.movie_ticket.model.Account;
import com.example.movie_ticket.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AccountController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/userAccountInfo")
    public String userIndex(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("message", "Đăng nhập thành công");
        return "home";
    }
    @GetMapping("/logoutSuccessful")
    public String logout(Model model){
        model.addAttribute("message","Đăng Xuất Thành Công");
        return "home";
    }
}
