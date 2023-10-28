package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowBooks;
import com.example.demo.repository.IBorrowBooksRepository;
import com.example.demo.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowBooksService implements IBorrowBooksService {
    @Autowired
    private IBorrowBooksRepository borrowBooksRepository;

    @Override
    public List<BorrowBooks> getAll() {
        return borrowBooksRepository.getAllByFlagDeleteIsFalse();
    }

    @Override
    public String addNewBorrow(Book book) {
        BorrowBooks borrowBooks = new BorrowBooks();
        int code = (int) Math.floor(((Math.random() * 8999) + 10000));
        borrowBooks.setCode(code);
        borrowBooks.setBorrowDate(LocalDateTime.now());
        borrowBooks.setFlagDelete(false);
        borrowBooks.setBook(book);
        borrowBooksRepository.save(borrowBooks);
        return "borrowed successfully!   Your loan code is:  " + borrowBooks.getCode();
    }

    @Override
    public void deleteBorrowBook(int id) {
        BorrowBooks borrowBooks = borrowBooksRepository.findAllByIdAndFlagDeleteIsFalse(id);
        borrowBooks.setFlagDelete(true);
        borrowBooksRepository.save(borrowBooks);
    }

    @Override
    public BorrowBooks findByIdAndFlagIsTrue(int id) {
        return borrowBooksRepository.findAllByIdAndFlagDeleteIsTrue(id);
    }

    @Override
    public boolean findByCode(int code) {
        return borrowBooksRepository.existsByCodeAndFlagDeleteIsFalse(code);
    }

    @Override
    public BorrowBooks getByCode(int code) {
        return borrowBooksRepository.getBorrowBooksByCodeAndFlagDeleteIsFalse(code);
    }
}
