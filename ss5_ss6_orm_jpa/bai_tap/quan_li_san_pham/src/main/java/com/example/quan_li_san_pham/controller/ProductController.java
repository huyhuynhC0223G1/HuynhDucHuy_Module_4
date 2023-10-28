package com.example.quan_li_san_pham.controller;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.service.IProductService;
import com.example.quan_li_san_pham.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getProduct(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productlist", productList);
        return "/home";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("message", "Successfully Added New");
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (productService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/product";
        } else {
            model.addAttribute("product", productService.findById(id));
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Successfully Update");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (productService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/product";
        } else {
            productService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Successfully Delete");
            return "redirect:/product";
        }
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (productService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/product";
        } else {
            model.addAttribute("product", productService.findById(id));
            return "/detail";
        }
    }

    @GetMapping("/search")
    public String getSeach(@RequestParam("search") String search, Model model, RedirectAttributes redirectAttributes) {
        List<Product> productList = productService.findSearch(search);
        if (productList.size() == 0) {
            redirectAttributes.addFlashAttribute("notsearch", "product not found");
            return "redirect:/product";
        } else {
            model.addAttribute("productlist", productList);
            return "/home";
        }
    }
}