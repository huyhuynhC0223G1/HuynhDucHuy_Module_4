package com.example.gio_hang.controller;

import com.example.gio_hang.model.Cart;
import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/home")
    public String showShop(Model model) {
        model.addAttribute("product", productService.findAll());
        return "/home";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        if (productService.findById(id) == null) {
            redirectAttributes.addAttribute("error", "id not found");
            return "redirect:/home";
        }
        Product product = this.productService.findById(id).get();
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cart, @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("reduce")) {
            cart.reduceProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("message", "Add to cart successfully!");
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id, @ModelAttribute Cart cart, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id).get();
        cart.deleteItem(product);
        redirectAttributes.addFlashAttribute("message", "Successful delete!");
        return "redirect:/shopping-cart";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "/success";
    }
}
