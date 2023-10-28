package com.example.demo.repository;

import com.example.demo.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBorrowBooksRepository extends JpaRepository<BorrowBooks, Integer> {
    List<BorrowBooks> getAllByFlagDeleteIsFalse();

    BorrowBooks findAllByIdAndFlagDeleteIsFalse(int id);

    boolean existsByCodeAndFlagDeleteIsFalse(int code);

    boolean existsByCode(int code);

    BorrowBooks findAllByIdAndFlagDeleteIsTrue(int id);

    BorrowBooks getBorrowBooksByCodeAndFlagDeleteIsFalse(int code);
}

