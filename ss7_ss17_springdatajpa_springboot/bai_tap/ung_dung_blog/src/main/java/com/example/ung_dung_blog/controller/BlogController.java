package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String getBlog(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/home";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setPostingTime(LocalDateTime.now());
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully Added New");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/blog";
        }else {
            blogService.update(blog);
            redirectAttributes.addFlashAttribute("message", "Successfully Update");
            return "redirect:/blog";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/blog";
        } else {
            blogService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Successfully Delete");
            return "redirect:/blog";
        }
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            return "/detail";
        }
    }

//    @GetMapping("/search")
//    public String getSeach(@RequestParam("search") String search, Model model, RedirectAttributes redirectAttributes) {
//        List<Blog> blogList = blogService.findById(search);
//        if (blogList.size() == 0) {
//            redirectAttributes.addFlashAttribute("notsearch", "Blog not found");
//            return "redirect:/blog";
//        } else {
//            model.addAttribute("blogList", productList);
//            return "/home";
//        }
//    }
}
