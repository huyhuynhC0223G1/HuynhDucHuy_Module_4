package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowBooks;
import com.example.demo.repository.IBookRepository;
import com.example.demo.service.IBookService;
import com.example.demo.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBooksService borrowBooksService;

    @GetMapping("")
    public String getAllBook(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "list";
    }

    @PostMapping("/giveBack")
    public String giveBackBook(@RequestParam("code") int code,
                               RedirectAttributes redirectAttributes, Model model) {
        if (borrowBooksService.findByCode(code)) {
            model.addAttribute("checkcode", code);
            model.addAttribute("borrowDelete", borrowBooksService.getByCode(code));
            return "repay";
        } else {
            redirectAttributes.addFlashAttribute("error", "Code is not found!");
        }
        return "redirect:/book";
    }

    @PostMapping("/repay")
    public String deleteBorrow(@ModelAttribute BorrowBooks borrowBooks, @RequestParam int checkcode, RedirectAttributes redirectAttributes) {
        if (checkcode != borrowBooks.getCode()) {
            redirectAttributes.addFlashAttribute("error", "Code is not found!");
            return "redirect:/book";
        }
        borrowBooksService.deleteBorrowBook(borrowBooks.getId());
        bookService.giveBook(borrowBooksService.findByIdAndFlagIsTrue(borrowBooks.getId()).getBook());
        redirectAttributes.addFlashAttribute("message", "Repay success fully!");
        return "redirect:/book";
    }
}
