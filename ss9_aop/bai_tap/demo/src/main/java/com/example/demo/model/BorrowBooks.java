package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BorrowBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int code;
    private LocalDateTime borrowDate;
    @ManyToOne
    private Book book;
    private boolean flagDelete;

    public BorrowBooks() {
    }

    public BorrowBooks(int id, int code, LocalDateTime borrowDate, Book book, boolean flagDelete) {
        this.id = id;
        this.code = code;
        this.borrowDate = borrowDate;
        this.book = book;
        this.flagDelete = flagDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
