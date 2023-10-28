package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBorrowBooksService {
    List<BorrowBooks> getAll();

    String addNewBorrow(Book book);

    void deleteBorrowBook(int id);

    BorrowBooks findByIdAndFlagIsTrue(int id);

    boolean findByCode(int code);

    BorrowBooks getByCode(int code);
}
