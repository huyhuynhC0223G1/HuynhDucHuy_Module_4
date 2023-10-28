package com.example.spring_security.controller;


import com.example.spring_security.util.WebUtils;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;

@Controller
public class SpringSecurityController {
    @GetMapping("")
    public String getWelcom(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("massege", "Welcome page");
        return "/welcome";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model, Principal principal) {
        User loginUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model) {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogout(Model model) {
        model.addAttribute("title", "Logout");
        return "/logout";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "/user";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            model.addAttribute("message", "Hello" + principal.getName()
                    + "<br>You do not have permission to access this page!");
        }
        return "/403";
    }
}
