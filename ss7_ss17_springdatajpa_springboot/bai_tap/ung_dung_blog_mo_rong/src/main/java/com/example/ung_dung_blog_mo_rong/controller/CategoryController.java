package com.example.ung_dung_blog_mo_rong.controller;

import com.example.ung_dung_blog_mo_rong.model.Blog;
import com.example.ung_dung_blog_mo_rong.model.Category;
import com.example.ung_dung_blog_mo_rong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    private String getCategory(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "/category/index";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/save")
    public String createBlog(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("message", "Successfully Added New");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/category";
        } else {
            model.addAttribute("category", categoryService.findById(id));
            return "/category/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(category.getIdCategory()) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/category";
        } else {
            categoryService.update(category);
            redirectAttributes.addFlashAttribute("message", "Successfully Update");
            return "redirect:/category";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/category";
        } else {
            categoryService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Successfully Delete");
            return "redirect:/category";
        }
    }
}
