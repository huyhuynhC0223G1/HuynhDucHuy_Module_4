package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    @Override
    public void giveBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}
