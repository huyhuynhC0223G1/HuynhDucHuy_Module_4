package com.example.gio_hang.controller;

import com.example.gio_hang.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "/cart";
    }
}
