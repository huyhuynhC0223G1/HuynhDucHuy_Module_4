package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.IBorrowBooksRepository;
import com.example.demo.service.IBookService;
import com.example.demo.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BorrowBooksController {
    @Autowired
    private IBorrowBooksService borrowBooksService;

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String getAllBorrowBooks(Model model) {
        model.addAttribute("borrows", borrowBooksService.getAll());
        return "borrow";
    }
    @GetMapping("/borrow/{id}")
    public String showFormBorrow(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (bookService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Book is not exist!");
        }
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        if (book.getQuantity() > 0) {
            bookService.updateBook(book);
            redirectAttributes.addFlashAttribute("message", borrowBooksService.addNewBorrow(book));
            return "redirect:/book";
        }
        redirectAttributes.addFlashAttribute("error", "The book has been borrowed!");
        return "redirect:/book";
    }
}
