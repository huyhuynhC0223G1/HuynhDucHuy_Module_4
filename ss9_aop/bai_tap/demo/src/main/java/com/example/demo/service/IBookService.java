package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    List<Book> getAll();

    Book findById(int id);

    void updateBook(Book book);

    void giveBook(Book book);
}
