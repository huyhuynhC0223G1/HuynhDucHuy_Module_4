package com.example.ung_dung_blog_mo_rong.controller;


import com.example.ung_dung_blog_mo_rong.model.Blog;
import com.example.ung_dung_blog_mo_rong.service.IBlogService;
import com.example.ung_dung_blog_mo_rong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getBlog(@PageableDefault(size = 3, direction = Sort.Direction.DESC)
                                  Pageable pageable, Model model) {
        model.addAttribute("blogList", blogService.findAllByStatusIsFalse(pageable));
        return "/blog/home";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/blog/create";
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
            model.addAttribute("categoryList", categoryService.findAll());
            return "/blog/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/blog";
        } else {
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
            return "/blog/detail";
        }
    }

    @GetMapping("/search")
    public String getSeach(@RequestParam("search") String search, @PageableDefault Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        Page<Blog> blogList = blogService.findByNameBlogContainingAndStatusIsFalse(search, pageable);
        if (blogList.getSize() == 0) {
            redirectAttributes.addFlashAttribute("notsearch", "Blog not found");
            return "redirect:/blog";
        } else {
            model.addAttribute("blogList", blogList);
            return "/blog/home";
        }
    }
}
